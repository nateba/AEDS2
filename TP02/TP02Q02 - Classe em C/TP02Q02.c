#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Definição do registro do personagem
typedef struct Bobo
{
    char nome[50];
    int altura;
    double peso;
    char corDoCabelo[50];
    char corDaPele[50];
    char corDosOlhos[50];
    char anoNascimento[50];
    char genero[50];
    char homeworld[50];
} Bobo;

// Função para retornar o resto da divisão com double
double fmod(double x, double y)
{
    return x - (int)(x / y) * y;
}

// Capturar o atributo entre aspas simples
void leituraAtributo(char atributo[], char descricaoBobo[], int index)
{
    int i = 0;

    while (descricaoBobo[index] != '\'')
    {
        atributo[i] = descricaoBobo[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

// Imprimir os resultados
void imprimir(Bobo bobo)
{
    double peso = bobo.peso;

    // Consertar a exibição para garantir a mesma quantidade de casas decimais solicitadas
    if (fmod(peso, 1) == 0)
    {
        printf(" ## %s ## %d ## %.0lf ## %s ## %s ## %s ## %s ## %s ## %s ## \n", bobo.nome, bobo.altura, bobo.peso, bobo.corDoCabelo, bobo.corDaPele, bobo.corDosOlhos, bobo.anoNascimento, bobo.genero, bobo.homeworld);
    }
    else
    {
        printf(" ## %s ## %d ## %.1lf ## %s ## %s ## %s ## %s ## %s ## %s ## \n", bobo.nome, bobo.altura, bobo.peso, bobo.corDoCabelo, bobo.corDaPele, bobo.corDosOlhos, bobo.anoNascimento, bobo.genero, bobo.homeworld);
    }
}

// Função para isr o fim do arquivo
bool isFim(char palavra[])
{
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        teste = true;
    }

    return teste;
}

int main(void)
{
    char pubin[120];

    scanf("%[^\n]s", pubin);
    getchar();

    // is o fim do arquivo
    while (isFim(pubin) == false)
    {
        FILE *leiturinha = fopen(pubin, "r");

        char descricaoBobo[1000];

        fscanf(leiturinha, "%[^\n]s", descricaoBobo);

        Bobo bobo; // Cria a variável struct

        int contador = 0;

        for (int i = 0; i < strlen(descricaoBobo); i++)
        {
            if (descricaoBobo[i] == ':')
            {
                char atributo[50];
                contador++;

                switch (contador)
                {
                case 1:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.nome, atributo);
                    break;
                case 2:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    bobo.altura = atoi(atributo);
                    break;
                case 3:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    for (int i = 0; i < strlen(atributo); i++)
                    {
                        if (atributo[i] == ',')
                        {
                            atributo[i] = atributo[i - 1];
                            atributo[i - 1] = '0';
                        }
                    }
                    bobo.peso = atof(atributo);
                    break;
                case 4:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.corDoCabelo, atributo);
                    break;
                case 5:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.corDaPele, atributo);
                    break;
                case 6:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.corDosOlhos, atributo);
                    break;
                case 7:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.anoNascimento, atributo);
                    break;
                case 8:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.genero, atributo);
                    break;
                case 9:
                    leituraAtributo(atributo, descricaoBobo, i + 3);
                    strcpy(bobo.homeworld, atributo);

                    i = strlen(descricaoBobo); // Encerra os ciclos de repetição desnecessários

                    imprimir(bobo); // Imprimir os resultados
                    break;
                default:
                    break;
                }
            }
        }

        fclose(leiturinha);

        scanf("%[^\n]s", pubin);
        getchar();
    }

    return 0;
}