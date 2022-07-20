from calendar import c
from logging import raiseExceptions
import Token

from numpy import chararray

class IsiScanner(object):
    
    content = chararray()
    estado = 0
    posicao = 0

    def __init__(self, filename):
        try:
            txtConteudo = ""
            with open(filename, "r") as isiProgram:
                txtConteudo = isiProgram.read()
                print("DEBUG============")
                print(txtConteudo)
                print("=================")

                self.content = isiProgram.extend()
        except:
            raise Exception("Erro léxico!")


    def nextToken(self):
        token = Token()

        currChar = ""
        term = ""

        if self.isEOF():
            return None

        self.estado = 0
        while True:
            currChar = self.nextChar()



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

    def isChar(c):
        return (c >= 'a' and c <= 'z') or (c >= 'A' and c <= 'Z')

    def isDigit(c):
        return c >= '0' and c <= '9'

    def isOperator(c):
        return (c == '>')or(c == '<')or(c == '=')or(c == '!')
    
    def isSpace(c):
        return (c == ' ')or(c == '\n')or(c == '\t')or(c == '\r')

    def back(self):
        self.posicao = self.posicao - 1