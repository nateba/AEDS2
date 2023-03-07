#include <stdbool.h>
#include <stdio.h>
#include <string.h>

bool isFim(char entrada[])
{
    bool resp = false;
    if (entrada[0] == 'F' && entrada[1] == 'I' && entrada[2] == 'M')
    {
        resp = true;
    }
    return resp;
}

bool vogal(char string[])
{
    bool resp = true;

    for (int i = 0; i < strlen(string); i++)
    {

        if (!(string[i] == 'A' || string[i] == 'E' || string[i] == 'I' || string[i] == 'O' || string[i] == 'U' ||
              string[i] == 'a' || string[i] == 'e' || string[i] == 'i' || string[i] == 'o' || string[i] == 'u'))
        {
            resp = false;
        }
    }
    return resp;
}

bool consoante(char string[])
{
    bool resp = true;

    for (int i = 0; i < strlen(string); i++)
    {

        if (!(((string[i] >= 'b' && string[i] <= 'z') &&
               (string[i] != 'e' && string[i] != 'i' && string[i] != 'o' && string[i] != 'u')) ||
              ((string[i] >= 'B' && string[i] <= 'Z') &&
               (string[i] != 'E' && string[i] != 'I' && string[i] != 'O' && string[i] != 'U'))))
        {
            resp = false;
        }
    }
    return resp;
}

bool inteiro(char string[])
{
    bool resp = true;

    for (int i = 0; i < strlen(string); i++)
    {

        if (!(string[i] >= '0' && string[i] <= '9'))
        {
            resp = false;
        }
    }
    return resp;
}

bool real(char string[])
{
    bool resp = true;
    int contador = 0;
    for (int i = 0; i < strlen(string); i++)
    {
        if ((string[i] >= '0' && string[i] <= '9') || (string[i] == '.') || (string[i] == ','))
        {
            if ((string[i] == '.') || (string[i] == ','))
            {
                contador += 1;
                if (contador > 1)
                {
                    resp = false;
                    i = strlen(string);
                }
                else
                {
                    resp = true;
                }
            }
            else
            {
                resp = true;
            }
        }
        else
        {
            resp = false;
            i = strlen(string);
        }
    }
    return resp;
}

int main(void)
{
    char palavrinha[650];

    scanf("%[^\n]s", palavrinha);
    getchar();

    while (isFim(palavrinha) == false)
    {
        if (vogal(palavrinha) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (consoante(palavrinha) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (inteiro(palavrinha) == true)
        {
            printf("SIM ");
        }
        else
        {
            printf("NAO ");
        }
        if (real(palavrinha) == true)
        {
            printf("SIM\n");
        }
        else
        {
            printf("NAO\n");
        }
        scanf("%[^\n]s", palavrinha);
        getchar();
    }
    return 0;
}