class Token():
    TK_IDENT        = 0
    TK_NUMBER       = 1
    TK_OPERATOR     = 2
    TK_PONCTUATION  = 3
    TK_ASSIGN       = 4

    tipo = 0
    text = ""

    #Tokens definidos para a IsiLanguage
    def __init__(self, tipo, text):
        self.tipo = tipo
        self.text = text

    def getTipo(self):
        return self.tipo

    def getText(self):
        return self.text

    def setTipo(self, tipo):
        self.tipo = tipo

    def setText(self, text):
        self.text = text

    def toString(self):
        return "Token [type={}, text={}]".format(self.tipo,self.text)