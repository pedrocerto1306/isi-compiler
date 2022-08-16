from IsiScanner import *
from Token import *

try:
    sc = IsiScanner("HelloWorld.isi")
    token = sc.nextToken()
    while token != None:
        print(token.__str__())
        token = sc.nextToken()
except:
    raise Exception("Lexical ERROR")
finally:
    print("End of Lexical Analysis")

#C:\Users\Pedro Certo\IdeaProjects\AnalisadorLexico