from pandas import isnull
import IsiScanner

from IsiScanner import *
from Token import *

try:
    sc = IsiScanner("HelloWorld.isi")
    token = sc.nextToken()
    while token != None:
        token = sc.nextToken()
        print(token.toString())
except:
    raise Exception("Lexical ERROR")
finally:
    print("End of Lexical Analysis")