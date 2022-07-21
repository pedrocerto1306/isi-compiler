import Token
from IsiScanner import *
from Token import *
from numpy import chararray

class IsiScanner():
    
    content = ''
    estado = 0
    posicao = 0

    def __init__(self, filename):
        try:
            txtConteudo = ""
            with open(filename) as isiProgram:
                self.content = isiProgram.read()
                # txtConteudo = isiProgram.read()
                # for char in txtConteudo:
                #     self.content = char
        except:
            raise Exception("Erro léxico!")


    def nextToken(self):

        currChar = ""
        term = ""

        if self.isEOF():
            return None

        self.estado = 0

        while True:
            currChar = self.nextChar()
            self.executeState(self.estado, currChar, term)
            if(self.estado == 2 or self.estado == 4 or self.estado == 6 or self.estado == 7):
                break



    def executeState(self, state, currChar, term):
        switcher = {
            0: self.stateZero(currChar, term),
            1: self.stateOne(currChar, term),
            2: self.stateTwo(term),
            3: self.stateThree(currChar, term),
            4: self.stateFour(term),
            5: self.stateFive(currChar, term),
            6: self.stateSix(term),
            7: self.stateSeven(term)
        }
        return switcher.get(state, "Invalid State!")

#Funções de estado
    def stateZero(self, currChar, term):
        if(self.isChar(currChar)):
            self.term += currChar
            self.estado = 1
        elif(self.isDigit(currChar)):
            term += currChar
            self.estado = 3
        elif(self.isSpace(currChar)):
            self.estado = 0
        elif(self.isOperator(currChar)):
            self.estado = 5
        else:
            raise Exception("Unrecognized Symbol")

    def stateOne(self, currChar, term):
        if(self.isChar(currChar) or self.isDigit(currChar)):
            self.estado = 1
            term += currChar
        elif(self.isSpace(currChar) or self.isOperator(currChar)):
            self.estado = 2
        else:
            raise Exception("Malformed Identifier")

    def stateTwo(self, term):
        self.back()
        token = Token()
        token.setTipo(Token.TK_IDENT)
        token.setText(term)
        return token

    def stateThree(self, currChar, term):
        if(self.isDigit(currChar)):
            term += currChar
            self.estado = 3
        elif(not self.isDigit(currChar)):
            self.estado = 4
        else:
            raise Exception("Unrecognized NUMBER")

    def stateFour(self, term):
        token = Token()
        token.setTipo(Token.TK_NUMBER)
        token.setText(term)
        self.back()
        return token

    def stateFive(self, currChar, term):
        term += currChar
        if(self.isOperator(currChar)):
            self.estado = 7
        elif(not self.isOperator(currChar)):
            self.estado = 6
        else:
            raise Exception("Unrecognized OPERATOR")

    def stateSix(self, term):
        self.back()
        token = Token()
        token.setTipo(Token.TK_ASSIGN)
        token.setText(term)
        return token

    def stateSeven(self, term):
        self.back()
        token = Token()
        token.setTipo(Token.TK_OPERATOR)
        token.setText(term)
        return token
        
#Funções auxiliares
    def nextChar(self):
        return self.content[self.posicao + 1]

    def lastChar(self):
        return self.content[self.posicao - 1]

    def isEOF(self):
        return self.posicao == len(self.content)

    def isChar(char):
        return (char >= 'a' and char <= 'z') or (char >= 'A' and char <= 'Z')

    def isDigit(char):
        return char >= '0' and char <= '9'

    def isOperator(char):
        return (char == '>')or(char == '<')or(char == '=')or(char == '!')
    
    def isSpace(char):
        return (char == ' ')or(char == '\n')or(char == '\t')or(char == '\r')

    def back(self):
        self.posicao = self.posicao - 1