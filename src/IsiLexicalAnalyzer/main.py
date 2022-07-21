from pandas import isnull
import IsiScanner

from IsiScanner import *
from Token import *

try:
    sc = IsiScanner("HelloWorld.isi")
    while True:
        print("Fetching next token...")
        token = sc.nextToken()
        if(token):
            token.toString()
        else:
            break
except:
    raise Exception("Lexical ERROR")
finally:
    print("End of Lexical Analysis")