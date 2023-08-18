#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Personagem
{
    char nome[40];
    int altura;
    double peso;
    char corDoCabelo[40];
    char corDaPele[40];
    char corDosOlhos[40];
    char anoNascimento[40];
    char genero[40];
    char homeworld[40];
} Personagem;

double fmod(double x, double y)
{
    return x - (int)(x / y) * y;
}

void leituraAtributo(char atributo[], char descricaoPersonagem[], int index)
{
    int i = 0;

    while (descricaoPersonagem[index] != '\'')
    {
        atributo[i] = descricaoPersonagem[index];

        i++;
        index++;
    }

    atributo[i] = '\0';
}

void imprimir(Personagem listaBobos[], int *ptrTamanho)
{
    int tamanhoTotal = *ptrTamanho;

    for (int i = 0; i < tamanhoTotal; i++)
    {
        printf("[%d]  ## %s", i, listaBobos[i].nome);
        printf(" ## %d", listaBobos[i].altura);
        if (fmod(listaBobos[i].peso, 1) == 0)
            printf(" ## %.0lf", listaBobos[i].peso);
        else
            printf(" ## %.1lf", listaBobos[i].peso);
        printf(" ## %s", listaBobos[i].corDoCabelo);
        printf(" ## %s", listaBobos[i].corDaPele);
        printf(" ## %s", listaBobos[i].corDosOlhos);
        printf(" ## %s", listaBobos[i].anoNascimento);
        printf(" ## %s", listaBobos[i].genero);
        printf(" ## %s", listaBobos[i].homeworld);
        printf(" ## \n");
    }
}

bool testaFim(char palavra[])
{
    bool teste = false;

    if (palavra[0] == 'F' && palavra[1] == 'I' && palavra[2] == 'M')
    {
        teste = true;
    }

    return teste;
}

Personagem montaPersonagem(char caminhoArquivo[])
{
    FILE *leitura = fopen(caminhoArquivo, "r");

    char descricaoPersonagem[1000];

    fscanf(leitura, " %[^\n]s", descricaoPersonagem);

    Personagem personagem;

    int contador = 0;

    for (int i = 0; i < strlen(descricaoPersonagem); i++)
    {
        if (descricaoPersonagem[i] == ':')
        {
            char atributo[50];
            contador++;

            switch (contador)
            {
            case 1:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.nome, atributo);
                break;
            case 2:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                personagem.altura = atoi(atributo);
                break;
            case 3:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                for (int i = 0; i < strlen(atributo); i++)
                {
                    if (atributo[i] == ',')
                    {
                        atributo[i] = atributo[i - 1];
                        atributo[i - 1] = '0';
                    }
                }
                personagem.peso = atof(atributo);
                break;
            case 4:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDoCabelo, atributo);
                break;
            case 5:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDaPele, atributo);
                break;
            case 6:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.corDosOlhos, atributo);
                break;
            case 7:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.anoNascimento, atributo);
                break;
            case 8:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.genero, atributo);
                break;
            case 9:
                leituraAtributo(atributo, descricaoPersonagem, i + 3);
                strcpy(personagem.homeworld, atributo);

                i = strlen(descricaoPersonagem);
                break;
            default:
                break;
            }
        }
    }

    fclose(leitura);

    return personagem;
}

void inserirInicio(Personagem listaBobos[], Personagem personagem, int *contador)
{
    int index = *contador;

    for (int i = index; i > 0; i--)
    {
        listaBobos[i] = listaBobos[i - 1];
    }

    listaBobos[0] = personagem;

    *contador += 1;
}

void inserir(Personagem listaBobos[], Personagem personagem, int posicao, int *contador)
{
    int index = *contador;

    for (int i = index; i > posicao; i--)
    {
        listaBobos[i] = listaBobos[i - 1];
    }

    listaBobos[posicao] = personagem;

    *contador += 1;
}

void inserirFimzin(Personagem listaBobos[], Personagem personagem, int *contador)
{
    int index = *contador;

    listaBobos[index] = personagem;

    *contador += 1;
}

void removerInicio(Personagem listaBobos[], int *contador)
{
    printf("(R) %s\n", listaBobos[0].nome);

    *contador -= 1;

    int index = *contador;

    for (int i = 0; i < index; i++)
    {
        listaBobos[i] = listaBobos[i + 1];
    }
}

void remover(Personagem listaBobos[], int posicao, int *contador)
{
    printf("(R) %s\n", listaBobos[posicao].nome);

    *contador -= 1;

    int index = *contador;

    for (int i = posicao; i < index; i++)
    {
        listaBobos[i] = listaBobos[i + 1];
    }
}

void removeFimzin(Personagem listaBobos[], int *contador)
{
    *contador -= 1;

    int index = *contador;

    printf("(R) %s\n", listaBobos[index].nome);
}

int main(void)
{
    char caminhoArquivo[100];
    int i = 0, contadorTamanho = 0;
    int *ptrContador = &contadorTamanho;
    Personagem listaBobo[100];

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (testaFim(caminhoArquivo) == false)
    {
        listaBobo[i] = montaPersonagem(caminhoArquivo);
        i++;
        *ptrContador += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }

    int quantidadeRegistros;
    scanf("%d", &quantidadeRegistros);

    for (int i = 0; i < quantidadeRegistros; i++)
    {
        char comandoOperacao[5];
        scanf(" %s", comandoOperacao);
        getchar();

        int numeroOperacao;
        char caminhoOperacao[100];

        if (comandoOperacao[0] == 'I' && comandoOperacao[1] == 'I')
        {
            scanf(" %[^\n]s", caminhoOperacao);
            getchar();

            inserirInicio(listaBobo, montaPersonagem(caminhoOperacao), ptrContador);
        }
        else if (comandoOperacao[0] == 'I' && comandoOperacao[1] == '*')
        {
            scanf("%d", &numeroOperacao);
            scanf(" %[^\n]s", caminhoOperacao);
            getchar();

            inserir(listaBobo, montaPersonagem(caminhoOperacao), numeroOperacao, ptrContador);
        }
        else if (comandoOperacao[0] == 'I' && comandoOperacao[1] == 'F')
        {
            scanf(" %[^\n]s", caminhoOperacao);
            getchar();

            inserirFimzin(listaBobo, montaPersonagem(caminhoOperacao), ptrContador);
        }
        else if (comandoOperacao[0] == 'R' && comandoOperacao[1] == 'I')
        {
            removerInicio(listaBobo, ptrContador);
        }
        else if (comandoOperacao[0] == 'R' && comandoOperacao[1] == '*')
        {
            scanf("%d", &numeroOperacao);

            remover(listaBobo, numeroOperacao, ptrContador);
        }
        else if (comandoOperacao[0] == 'R' && comandoOperacao[1] == 'F')
        {
            removeFimzin(listaBobo, ptrContador);
        }
    }

    imprimir(listaBobo, ptrContador);

    return 0;
}