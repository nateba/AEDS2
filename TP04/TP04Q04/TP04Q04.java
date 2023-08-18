import java.io.*;

class Personagem {
    private String nome;
    private int altura;
    private double peso;
    private String corDoCabelo;
    private String corDaPele;
    private String corDosOlhos;
    private String anoNascimento;
    private String genero;
    private String homeworld;

    public Personagem() {
    }

    public Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
            String corDosOlhos, String anoNascimento, String genero, String homeworld) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
        this.corDoCabelo = corDoCabelo;
        this.corDaPele = corDaPele;
        this.corDosOlhos = corDosOlhos;
        this.anoNascimento = anoNascimento;
        this.genero = genero;
        this.homeworld = homeworld;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPeso() {
        return peso;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }

    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }

    public String getCorDaPele() {
        return corDaPele;
    }

    public void setCorDosOlhos(String corDosOlhos) {
        this.corDosOlhos = corDosOlhos;
    }

    public String getCorDosOlhos() {
        return corDosOlhos;
    }

    public String getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(String anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public Personagem clone() {
        Personagem cloned = new Personagem();

        cloned.nome = this.nome;
        cloned.altura = this.altura;
        cloned.peso = this.peso;
        cloned.corDoCabelo = this.corDoCabelo;
        cloned.corDaPele = this.corDaPele;
        cloned.corDosOlhos = this.corDosOlhos;
        cloned.anoNascimento = this.anoNascimento;
        cloned.genero = this.genero;
        cloned.homeworld = this.homeworld;

        return cloned;
    }
}

class NozinAN {
    public boolean cor;
    public Personagem elemento;
    public NozinAN esq, dir;

    public NozinAN() {
        this(new Personagem());
    }

    public NozinAN(Personagem elemento) {
        this(elemento, false, null, null);
    }

    public NozinAN(Personagem elemento, boolean cor) {
        this(elemento, cor, null, null);
    }

    public NozinAN(Personagem elemento, boolean cor, NozinAN esq, NozinAN dir) {
        this.cor = cor;
        this.elemento = elemento;
        this.esq = esq;
        this.dir = dir;
    }
}

class Alvinegra {
    private NozinAN raiz;
    int numeroComparacoes = 0;

    public Alvinegra() {
        raiz = null;
    }

    public boolean pesquisar(String nome) {
        return pesquisar(nome, raiz);
    }

    private boolean pesquisar(String nome, NozinAN i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (nome.equals(i.elemento.getNome())) {
            numeroComparacoes++;

            resp = true;
        } else if (nome.compareTo(i.elemento.getNome()) < 0) {
            MyIO.print("esq ");
            numeroComparacoes++;

            resp = pesquisar(nome, i.esq);
        } else {
            MyIO.print("dir ");
            numeroComparacoes++;

            resp = pesquisar(nome, i.dir);
        }
        return resp;
    }

    public void inserir(Personagem elemento) throws Exception {

        if (raiz == null) {
            raiz = new NozinAN(elemento);

        } else if (raiz.esq == null && raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                numeroComparacoes++;

                raiz.esq = new NozinAN(elemento);
            } else {
                raiz.dir = new NozinAN(elemento);
            }

        } else if (raiz.esq == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) < 0) {
                numeroComparacoes++;

                raiz.esq = new NozinAN(elemento);

            } else if (elemento.getNome().compareTo(raiz.dir.elemento.getNome()) < 0) {
                numeroComparacoes++;

                raiz.esq = new NozinAN(raiz.elemento);
                raiz.elemento = elemento;

            } else {
                raiz.esq = new NozinAN(raiz.elemento);
                raiz.elemento = raiz.dir.elemento;
                raiz.dir.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;

        } else if (raiz.dir == null) {
            if (elemento.getNome().compareTo(raiz.elemento.getNome()) > 0) {
                numeroComparacoes++;

                raiz.dir = new NozinAN(elemento);

            } else if (elemento.getNome().compareTo(raiz.esq.elemento.getNome()) > 0) {
                numeroComparacoes++;

                raiz.dir = new NozinAN(raiz.elemento);
                raiz.elemento = elemento;

            } else {
                raiz.dir = new NozinAN(raiz.elemento);
                raiz.elemento = raiz.esq.elemento;
                raiz.esq.elemento = elemento;
            }
            raiz.esq.cor = raiz.dir.cor = false;

        } else {
            inserir(elemento, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void balancear(NozinAN bisavo, NozinAN avo, NozinAN pai, NozinAN i) {
        if (pai.cor == true) {
            if (pai.elemento.getNome().compareTo(avo.elemento.getNome()) > 0) {
                numeroComparacoes++;

                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) > 0) {
                    numeroComparacoes++;

                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            } else {
                if (i.elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                    numeroComparacoes++;

                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.elemento.getNome().compareTo(bisavo.elemento.getNome()) < 0) {
                numeroComparacoes++;

                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }
            avo.cor = false;
            avo.esq.cor = avo.dir.cor = true;
        }
    }

    private void inserir(Personagem elemento, NozinAN bisavo, NozinAN avo, NozinAN pai, NozinAN i) throws Exception {
        if (i == null) {
            if (elemento.getNome().compareTo(pai.elemento.getNome()) < 0) {
                numeroComparacoes++;

                i = pai.esq = new NozinAN(elemento, true);
            } else {
                i = pai.dir = new NozinAN(elemento, true);
            }
            if (pai.cor == true) {
                balancear(bisavo, avo, pai, i);
            }
        } else {
            if (i.esq != null && i.dir != null && i.esq.cor == true && i.dir.cor == true) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (elemento.getNome().compareTo(i.elemento.getNome()) < 0) {
                inserir(elemento, avo, pai, i, i.esq);
            } else if (elemento.getNome().compareTo(i.elemento.getNome()) > 0) {
                inserir(elemento, avo, pai, i, i.dir);
            } else {
                throw new Exception("Erro inserir (elemento repetido)!");
            }
        }
    }

    private NozinAN rotacaoDir(NozinAN no) {
        NozinAN noEsq = no.esq;
        NozinAN noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private NozinAN rotacaoEsq(NozinAN no) {
        NozinAN noDir = no.dir;
        NozinAN noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;
        return noDir;
    }

    private NozinAN rotacaoDirEsq(NozinAN no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private NozinAN rotacaoEsqDir(NozinAN no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }

    public void criarLog(long tempoInicial) {
        long tempoFinal = System.currentTimeMillis();

        Arq.openWrite("matricula_avinegra.txt");
        Arq.println(
                "Matricula: 792421\t" + "Numero Comparacoes: " + numeroComparacoes + "\t" + "Tempo Execucao: "
                        + (tempoFinal - tempoInicial) + "ms");
        Arq.close();
    }
}

public class TP04Q04 {
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");
        long tempoInicial = System.currentTimeMillis();

        Alvinegra arvorePersonagens = new Alvinegra();

        String caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");

        while (testaFim(caminhoArquivo) == false) {

            arvorePersonagens.inserir(montaPersonagem(caminhoArquivo));

            caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        String nomeConsultaPersonagem = MyIO.readLine().replaceAll("é", "\u00e9");

        while (testaFim(nomeConsultaPersonagem) == false) {
            MyIO.print(nomeConsultaPersonagem + " raiz ");

            if (arvorePersonagens.pesquisar(nomeConsultaPersonagem)) {
                MyIO.println("SIM");
            } else {
                MyIO.println("NÃO");
            }

            nomeConsultaPersonagem = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        arvorePersonagens.criarLog(tempoInicial);
    }

    public static boolean testaFim(String palavra) {
        boolean teste = false;

        if (palavra.equals("FIM")) {
            teste = true;
        }

        return teste;
    }

    public static Personagem montaPersonagem(String caminhoArquivo) throws Exception {
        RandomAccessFile leitura = new RandomAccessFile(caminhoArquivo, "r");

        String descricaoPersonagem = leitura.readLine().replaceAll("é", "\u00e9");

        Personagem personagem = new Personagem();
        int contadorDoisPontos = 0;

        for (int i = 0; i < descricaoPersonagem.length(); i++) {
            if (descricaoPersonagem.charAt(i) == ':') {
                contadorDoisPontos++;

                switch (contadorDoisPontos) {
                    case 1:
                        personagem.setNome(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 2:
                        String atributoInteiro = leituraAtributo(descricaoPersonagem, i + 3);
                        if (atributoInteiro.equals("unknown")) {
                            personagem.setAltura(0);
                        } else {
                            personagem.setAltura(Integer.parseInt(atributoInteiro));
                        }
                        break;
                    case 3:
                        String atributoDouble = leituraAtributo(descricaoPersonagem, i + 3).replaceAll(",", ".");
                        if (atributoDouble.equals("unknown")) {
                            personagem.setPeso(0);
                        } else {
                            personagem.setPeso(Double.parseDouble(atributoDouble));
                        }
                        break;
                    case 4:
                        personagem.setCorDoCabelo(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 5:
                        personagem.setCorDaPele(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 6:
                        personagem.setCorDosOlhos(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 7:
                        personagem.setAnoNascimento(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 8:
                        personagem.setGenero(leituraAtributo(descricaoPersonagem, i + 3));
                        break;
                    case 9:
                        personagem.setHomeworld(leituraAtributo(descricaoPersonagem, i + 3));
                        i = descricaoPersonagem.length();
                        break;
                    default:
                        break;
                }
            }
        }

        leitura.close();

        return personagem;
    }

    public static String leituraAtributo(String descricaoPersonagem, int index) {
        String atributo = new String();

        while (descricaoPersonagem.charAt(index) != '\'') {
            atributo += descricaoPersonagem.charAt(index);

            index++;
        }

        return atributo;
    }
}