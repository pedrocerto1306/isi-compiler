#ifndef TOKEN
#define TOKEN

typedef enum
{
    TK_IDENT,
    TK_NUMBER,
    TK_OPERATOR,
    TK_ATTRIBUITION,
    TK_PONCTUATION
} TokenType;

typedef struct
{
    TokenType tipo;
    char *texto
} Token;

// toString(Token tk)
// {
//     printf("Token [type=" + tk.tipo + ", text=" + tk->texto + "]");
// }

#endif