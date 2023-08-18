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

void criarLog(time_t inicio, int numeroComparacoes, int numeroMovimentacoes)
{
    float tempo;
    time_t final = time(NULL);

    tempo = difftime(final, inicio);

    FILE *log = fopen("matricula_quicksort2.txt", "w");

    fprintf(log, "Matricula: 292421\tNumero Comparacoes: %d\tNumero Movimentacoes: %d\tTempo Execucao: %fs\n", numeroComparacoes, numeroMovimentacoes, tempo);

    fclose(log);
}

typedef struct CelulaDupla
{
    Personagem elemento;
    struct CelulaDupla *prox;
    struct CelulaDupla *ant;
} CelulaDupla;

CelulaDupla *novaCelulaDupla(Personagem elemento)
{
    CelulaDupla *nova = (CelulaDupla *)malloc(sizeof(CelulaDupla));
    nova->elemento = elemento;
    nova->ant = nova->prox = NULL;

    return nova;
}

CelulaDupla *primeiro;
CelulaDupla *ultimo;

void start()
{
    Personagem personagem;

    primeiro = novaCelulaDupla(personagem);
    ultimo = primeiro;
}

void inserirFim(Personagem personagem)
{
    ultimo->prox = novaCelulaDupla(personagem);
    ultimo->prox->ant = ultimo;
    ultimo = ultimo->prox;
}

int tamanho()
{
    int tamanho = 0;
    CelulaDupla *i;
    for (i = primeiro; i != ultimo; i = i->prox, tamanho++)
        ;
    return tamanho;
}

void mostrar()
{
    CelulaDupla *i;

    for (i = primeiro->prox; i != NULL; i = i->prox)
    {
        printf(" ## %s", i->elemento.nome);
        printf(" ## %d", i->elemento.altura);
        if (fmod(i->elemento.peso, 1) == 0)
            printf(" ## %.0lf", i->elemento.peso);
        else
            printf(" ## %.1lf", i->elemento.peso);
        printf(" ## %s", i->elemento.corDoCabelo);
        printf(" ## %s", i->elemento.corDaPele);
        printf(" ## %s", i->elemento.corDosOlhos);
        printf(" ## %s", i->elemento.anoNascimento);
        printf(" ## %s", i->elemento.genero);
        printf(" ## %s", i->elemento.homeworld);
        printf(" ## \n");
    }
}

void trocaElementos(CelulaDupla *i, CelulaDupla *j, int *ptrMov)
{
    Personagem personagemTemporario = i->elemento;
    i->elemento = j->elemento;
    j->elemento = personagemTemporario;

    *ptrMov += 3;
}

void ordenaPorQuicksort(CelulaDupla *esq, CelulaDupla *dir, int esqInt, int dirInt, int *ptrComp, int *ptrMov)
{
    CelulaDupla *i = esq;
    CelulaDupla *j = dir;
    CelulaDupla *p = i->prox;

    int iCont = esqInt;
    int jCont = dirInt;

    Personagem pivo = p->elemento;

    while (iCont <= jCont)
    {
        while (strcmp(i->elemento.corDoCabelo, pivo.corDoCabelo) < 0)
        {
            i = i->prox;
            iCont++;
        }

        while (strcmp(j->elemento.corDoCabelo, pivo.corDoCabelo) > 0)
        {
            j = j->ant;
            jCont--;
        }

        if (iCont <= jCont)
        {
            trocaElementos(i, j, ptrMov);

            i = i->prox;
            iCont++;

            j = j->ant;
            jCont--;
        }
    }

    if (esqInt < jCont)
    {
        *ptrComp += 1;

        ordenaPorQuicksort(esq, j, esqInt, jCont, ptrComp, ptrMov);
    }
    if (iCont < dirInt)
    {
        *ptrComp += 1;

        ordenaPorQuicksort(i, dir, iCont, dirInt, ptrComp, ptrMov);
    }
}

void ordenaPorInsercao(int *ptrComp, int *ptrMov)
{
    for (CelulaDupla *i = primeiro->prox->prox; i->prox != NULL; i = i->prox)
    {
        Personagem personagemTemporario = i->elemento;
        CelulaDupla *j = i->ant;
        while ((j->ant != NULL) && ((strcmp(j->elemento.corDoCabelo, personagemTemporario.corDoCabelo) == 0) && (strcmp(j->elemento.nome, personagemTemporario.nome) > 0)))
        {
            *ptrComp += 3;
            *ptrMov += 1;
            j->prox->elemento = j->elemento;
            j = j->ant;
        }

        j->prox->elemento = personagemTemporario;

        *ptrMov += 1;
    }
}

int main(void)
{
    char caminhoArquivo[100], nomePersonagem[100];
    int contadorTamanho = 0, numeroComparacoes = 0, numeroMovimentacoes = 0;
    int *ptrComp = &numeroComparacoes, *ptrMov = &numeroMovimentacoes;
    time_t inicio = time(NULL);
    start();

    scanf(" %[^\n]s", caminhoArquivo);
    getchar();

    while (testaFim(caminhoArquivo) == false)
    {
        inserirFim(montaPersonagem(caminhoArquivo));
        contadorTamanho += 1;

        scanf(" %[^\n]s", caminhoArquivo);
        getchar();
    }

    ordenaPorQuicksort(primeiro->prox, ultimo, 0, (tamanho() - 1), ptrComp, ptrMov);

    ordenaPorInsercao(ptrComp, ptrMov);

    mostrar();

    criarLog(inicio, numeroComparacoes, numeroMovimentacoes);

    return 0;
}