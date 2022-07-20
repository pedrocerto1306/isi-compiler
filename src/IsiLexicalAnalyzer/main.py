import IsiScanner
import Token

def main():
    try:
        sc = IsiScanner(r'./HelloWorld.isi')
        token = Token()
        while True:
            token = sc.nextToken()
            if(token != None):
                print(token)
                break
    except:
        raise Exception("Lexical ERROR")
    finally:
        print("End of Lexical Analysis")
