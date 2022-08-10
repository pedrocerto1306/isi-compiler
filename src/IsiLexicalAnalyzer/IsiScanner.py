from Token import *

class IsiScanner():
    
    content = ''
    state = 0
    posicao = 0
    currChar = ""
    term = ""

    def __init__(self, filename):
        try:
            with open(filename) as isiProgram:
                self.content = isiProgram.read()
                self.currChar = self.content[0]
                self.state = 0
        except:
            raise Exception("Erro léxico!")


    def nextToken(self):

        if self.isEOF():
            return None

        self.state = 0

        while True:
            self.executeState()
            self.currChar = self.nextChar()
            if(self.state == 2 or self.state == 4 or self.state == 6 or self.state == 7):
                token = self.executeReturnTokenStates()
                self.term = ""
                return token

    def executeReturnTokenStates(self) -> Token:
        if self.state == 2:
            return self.stateTwo()
        elif self.state == 4:
            self.stateFour()
        elif self.state == 6:
            return self.stateSix()
        elif self.state == 7:
            return self.stateSeven()
        else:
            raise Exception("invalid state to return a token!")
        

    #Funções correpondentes aos nós internos do automato do scanner
    def executeState(self):
        if self.state == 0:
            self.stateZero()
        elif self.state == 1:
            self.stateOne()
        elif self.state == 3:
            self.stateThree()
        elif self.state == 5:
            self.stateFive()
        else:
            raise Exception("Invalid scanner state!")

#Funções de estado
    def stateZero(self):
        if(self.isChar(self.currChar)):
            self.term += self.currChar
            self.state = 1
        elif(self.isDigit(self.currChar)):
            self.term += self.currChar
            self.state = 3
        elif(self.isSpace(self.currChar)):
            self.state = 0
        elif(self.isPrimaryOperator()):
            self.state = 5
        else:
            raise Exception("Unrecognized Symbol")

    def stateOne(self):
        if(self.isChar(self.currChar) or self.isDigit(self.currChar)):
            self.state = 1
            self.term += self.currChar
        elif(self.isSpace(self.currChar) or self.isOperator(self.currChar)):
            self.state = 2
        else:
            raise Exception("Malformed Identifier")

    def stateTwo(self) -> Token:
        self.back()
        tk_identificador = Token(Token.TK_IDENT, self.term)
        return tk_identificador

    def stateThree(self):
        if(self.isDigit(self.currChar)):
            self.term += self.currChar
            self.state = 3
        elif(not self.isDigit(self.currChar)):
            self.state = 4
        else:
            raise Exception("Unrecognized NUMBER")

    def stateFour(self):
        self.back()
        return Token(Token.TK_NUMBER, self.term)

    def stateFive(self):
        self.term += self.currChar
        self.currChar = self.nextChar()
        if(self.isOperator(self.currChar)):
            self.term += self.currChar
            self.state = 7
        elif(not self.isOperator(self.currChar)):
            self.state = 6
        else:
            raise Exception("Unrecognized OPERATOR")

    def stateSix(self):
        self.back()
        return Token(Token.TK_ASSIGN, self.term)

    def stateSeven(self):
        self.back()
        return Token(Token.TK_OPERATOR, self.term)
        
#Funções auxiliares
    def nextChar(self):
        self.posicao = self.posicao + 1
        return self.content[self.posicao]

    def lastChar(self):
        return self.content[self.posicao - 1]

    def isEOF(self):
        return self.posicao == len(self.content)

    def isChar(self, char):
        return (char >= 'a' and char <= 'z') or (char >= 'A' and char <= 'Z')

    def isDigit(self, char):
        return char >= '0' and char <= '9'

    def isPrimaryOperator(self):
        return (self.currChar == ':')

    def isOperator(self, char):
        return (char == '>')or(char == '<')or(char == '=')or(char == '!')
    
    def isSpace(self, char):
        return (char == ' ')or(char == '\n')or(char == '\t')or(char == '\r')

    def back(self):
        self.posicao = self.posicao - 1