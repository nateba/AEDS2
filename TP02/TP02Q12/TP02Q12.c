#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

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

void insercaoPorCor(Personagem listaPersonagem[], int tamanhoVetor, int cor, int h, int *ptrComp, int *ptrMov)
{
    for (int i = (h + cor); i < tamanhoVetor; i += h)
    {
        Personagem personagemTemporario = listaPersonagem[i];
        int j = i - h;
        while ((j >= 0) && (listaPersonagem[j].peso > personagemTemporario.peso))
        {
            *ptrComp += 2;
            *ptrMov += 1;

            listaPersonagem[j + h] = listaPersonagem[j];
            j -= h;
        }

        *ptrComp += 1;
        *ptrMov += 1;

        listaPersonagem[j + h] = personagemTemporario;
    }

    *ptrComp += 1;
}

void ordenaPorShellsort(Personagem listaPersonagem[], int tamanhoVetor, int *ptrComp, int *ptrMov)
{
    int h = 1;
    do
    {
        h = (h * 3) + 1;

        *ptrComp += 1;
    } while (h < tamanhoVetor);

    do
    {
        h /= 3;

        *ptrComp += 1;

        for (int cor = 0; cor < h; cor++)
        {
            *ptrComp += 1;

            insercaoPorCor(listaPersonagem, tamanhoVetor, cor, h, ptrComp, ptrMov);
        }
    } while (h != 1);

    *ptrComp += 1;
}

void ordenaPorInsercao(Personagem listaPersonagem[], int tamanhoVetor, int *ptrComp, int *ptrMov)
{
    for (int i = 1; i < tamanhoVetor; i += 1)
    {
        Personagem personagemTemporario = listaPersonagem[i];
        int j = i - 1;
        while ((j >= 0) && ((listaPersonagem[j].peso > personagemTemporario.peso) || ((listaPersonagem[j].peso == personagemTemporario.peso) && (strcmp(listaPersonagem[j].nome, personagemTemporario.nome) > 0))))
        {
            *ptrComp += 4;
            *ptrMov += 1;
            listaPersonagem[j + 1] = listaPersonagem[j];
            j -= 1;
        }

        *ptrComp += 1;
        *ptrMov += 1;

        listaPersonagem[j + 1] = personagemTemporario;
    }

    *ptrComp += 1;
}

void imprimirAtributos(Personagem listaPersonagens[], int tamanhoTotal)
{
    for (int i = 0; i < tamanhoTotal; i++)
    {
        printf(" ## %s", listaPersonagens[i].nome);
        printf(" ## %d", listaPersonagens[i].altura);
        if (fmod(listaPersonagens[i].peso, 1) == 0)
            printf(" ## %.0lf", listaPersonagens[i].peso);
        else
            printf(" ## %.1lf", listaPersonagens[i].peso);
        printf(" ## %s", listaPersonagens[i].corDoCabelo);
        printf(" ## %s", listaPersonagens[i].corDaPele);
        printf(" ## %s", listaPersonagens[i].corDosOlhos);
        printf(" ## %s", listaPersonagens[i].anoNascimento);
        printf(" ## %s", listaPersonagens[i].genero);
        printf(" ## %s", listaPersonagens[i].homeworld);
        printf(" ## \n");
    }
}

void criarLog(time_t inicio, int numeroComparacoes, int numeroMovimentacoes)
{
    float tempo;
    time_t final = time(NULL);

    tempo = difftime(final, inicio);

    FILE *log = fopen("matricula_shellsort.txt", "w");

    fprintf(log, "Matricula: 790052\tNumero Comparacoes: %d\tNumero Movimentacoes: %d\tTempo Execucao: %fs\n", numeroComparacoes, numeroMovimentacoes, tempo);

    fclose(log);
}

int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int *ptrComp = &numeroComparacoes, *ptrMov = &numeroMovimentacoes;
    time_t inicio = time(NULL);
    Personagem listaPersonagem[100];

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (testaFim(caminhoArquivo) == false)
    {
        listaPersonagem[contadorTamanho] = montaPersonagem(caminhoArquivo);
        contadorTamanho += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }

    ordenaPorShellsort(listaPersonagem, contadorTamanho, ptrComp, ptrMov);

    ordenaPorInsercao(listaPersonagem, contadorTamanho, ptrComp, ptrMov);

    imprimirAtributos(listaPersonagem, contadorTamanho);

    criarLog(inicio, numeroComparacoes, numeroMovimentacoes);

    return 0;
}