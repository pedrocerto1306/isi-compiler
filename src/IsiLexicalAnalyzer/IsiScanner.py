import Token

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
        except:
            raise Exception("Erro léxico!")


    def nextToken(self):

        if self.isEOF():
            return None

        self.state = 0
        self.currChar = self.content[0]

        while True:
            self.executeState()
            self.currChar = self.nextChar()
            if(self.state == 2 or self.state == 4 or self.state == 6 or self.state == 7):
                break



    def executeState(self):

        if self.state == 0:
            self.stateZero()
        elif self.state == 1:
            self.stateOne()
        elif self.state == 2:
            self.stateTwo()
        elif self.state == 3:
            self.stateThree()
        elif self.state == 4:
            self.stateFour()
        elif self.state == 5:
            self.stateFive()
        elif self.state == 6:
            self.stateSix()
        elif self.state == 7:
            self.stateSeven()
        else:
            raise Exception("Invalid State!")

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
        elif(self.isOperator(self.currChar)):
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

    def stateTwo(self):
        self.back()
        token = Token()
        token.setTipo(Token.TK_IDENT)
        token.setText(self.term)
        return token

    def stateThree(self):
        if(self.isDigit(self.currChar)):
            self.term += self.currChar
            self.state = 3
        elif(not self.isDigit(self.currChar)):
            self.state = 4
        else:
            raise Exception("Unrecognized NUMBER")

    def stateFour(self):
        token = Token()
        token.setTipo(Token.TK_NUMBER)
        token.setText(self.term)
        self.back()
        return token

    def stateFive(self):
        self.term += self.currChar
        if(self.isOperator(self.currChar)):
            self.state = 7
        elif(not self.isOperator(self.currChar)):
            self.state = 6
        else:
            raise Exception("Unrecognized OPERATOR")

    def stateSix(self):
        self.back()
        token = Token()
        token.setTipo(Token.TK_ASSIGN)
        token.setText(self.term)
        return token

    def stateSeven(self):
        self.back()
        token = Token()
        token.setTipo(Token.TK_OPERATOR)
        token.setText(self.term)
        return token
        
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

    def isOperator(self, char):
        return (char == '>')or(char == '<')or(char == '=')or(char == '!')
    
    def isSpace(self, char):
        return (char == ' ')or(char == '\n')or(char == '\t')or(char == '\r')

    def back(self):
        self.posicao = self.posicao - 1