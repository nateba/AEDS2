#include <stdio.h>
#include <string.h>
#include <stdbool.h>

bool ePalin(char palavra[])
{
    bool resp = true;

    for (int i = 0, j = strlen(palavra) - 1; i <= strlen(palavra) - 1; i++, j--)
    {
        if (palavra[i] != palavra[j])
        {
            resp = false;
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

        if (ePalin(palavra) == true)
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