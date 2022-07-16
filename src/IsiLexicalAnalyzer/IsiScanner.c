#include <stdio.h>
#include <stdlib.h>

// #include <token.h>

int main()
{
    FILE *programa;
    char linha[255];

    programa = fopen("./HelloWorld.isi", "r");

    while (!feof(programa))
    {
        fgets(linha, 255, programa);
        puts(linha);
    }

    fclose(programa);

    return 0;
}