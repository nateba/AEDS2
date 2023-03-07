#include <stdio.h>
#include <string.h>
#include <stdbool.h>

int ePalin(char palavra[], int esq, int dir)
{
    int resp = 0;

    while (esq <= dir)
    {
        if (palavra[esq] == palavra[dir])
        {
            return 0 + ePalin(palavra, esq + 1, dir - 1);
        }
        else
        {
            return 1;
        }
    }

    return resp;
}
bool isFim(char palavra[])
{
    bool resp = false;
    if (strlen(palavra) == 3 && palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        resp = true;
    }
    return resp;
}
int main(void)
{

    char palavra[300];

    scanf("%[^\n]s", palavra);
    getchar();

    while (isFim(palavra) == false)
    {

        if (ePalin(palavra, 0, (strlen(palavra) - 1)) == 0)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }

        scanf("%[^\n]s", palavra);
        getchar();
    }

    return 0;
}