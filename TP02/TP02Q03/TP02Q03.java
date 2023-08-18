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

class Lista {
    static Personagem[] listaBobos = new Personagem[100];
    int conTam = 0;

    public void inserirInicio(Personagem personagem) throws Exception {
        if (conTam >= listaBobos.length) {
            throw new Exception("Erro!");
        }

        for (int i = conTam; i > 0; i--) {
            listaBobos[i] = listaBobos[i - 1];
        }

        listaBobos[0] = personagem;

        conTam++;
    }

    public void inserir(Personagem personagem, int posicao) throws Exception {
        if (conTam >= listaBobos.length || posicao < 0 || posicao > conTam) {
            throw new Exception("Erro!");
        }

        for (int i = conTam; i > posicao; i--) {
            listaBobos[i] = listaBobos[i - 1];
        }

        listaBobos[posicao] = personagem;

        conTam++;
    }

    public void inserirFim(Personagem personagem) throws Exception {
        if (conTam >= listaBobos.length) {
            throw new Exception("Erro!");
        }

        listaBobos[conTam] = personagem;

        conTam++;
    }

    public void removerInicio() throws Exception {
        if (conTam == 0) {
            throw new Exception("Erro!");
        }

        MyIO.println("(R) " + listaBobos[0].getNome());

        conTam--;

        for (int i = 0; i < conTam; i++) {
            listaBobos[i] = listaBobos[i + 1];
        }
    }

    public void remover(int posicao) throws Exception {
        if (conTam == 0 || posicao < 0 || posicao >= conTam) {
            throw new Exception("Erro!");
        }

        MyIO.println("(R) " + listaBobos[posicao].getNome());

        conTam--;

        for (int i = posicao; i < conTam; i++) {
            listaBobos[i] = listaBobos[i + 1];
        }
    }

    public void removerFim() throws Exception {
        if (conTam == 0) {
            throw new Exception("Erro!");
        }

        conTam--;

        MyIO.println("(R) " + listaBobos[conTam].getNome());
    }

    public void imprimeResultados() {
        for (int i = 0; i < conTam; i++) {
            MyIO.print("[" + i + "]  ## " + listaBobos[i].getNome());
            MyIO.print(" ## " + listaBobos[i].getAltura());
            if (listaBobos[i].getPeso() % 1 == 0) {
                MyIO.print(" ## " + (int) listaBobos[i].getPeso());
            } else {
                MyIO.print(" ## " + listaBobos[i].getPeso());
            }
            MyIO.print(" ## " + listaBobos[i].getCorDoCabelo());
            MyIO.print(" ## " + listaBobos[i].getCorDaPele());
            MyIO.print(" ## " + listaBobos[i].getCorDosOlhos());
            MyIO.print(" ## " + listaBobos[i].getAnoNascimento());
            MyIO.print(" ## " + listaBobos[i].getGenero());
            MyIO.print(" ## " + listaBobos[i].getHomeworld());
            MyIO.println(" ## ");
        }
    }
}

public class TP02Q03 {
    public static void main(String[] args) throws Exception {
        MyIO.setCharset("ISO-8859-1");

        Lista listaBobos = new Lista();

        String caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");

        while (testaFim(caminhoArquivo) == false) {

            listaBobos.inserirFim(montaPersonagem(caminhoArquivo));

            caminhoArquivo = MyIO.readLine().replaceAll("é", "\u00e9");
        }

        int quantidadeRegistros = MyIO.readInt();

        analisaOperacoes(quantidadeRegistros, listaBobos);

        listaBobos.imprimeResultados();
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

    public static void analisaOperacoes(int quantidadeRegistros, Lista listaPersonagens) throws Exception {

        for (int i = 0; i < quantidadeRegistros; i++) {
            String comandoOperacao = MyIO.readString();
            int numeroOperacao;
            String caminhoOperacao = new String();

            switch (comandoOperacao) {
                case "II":
                    caminhoOperacao = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.inserirInicio(montaPersonagem(caminhoOperacao));
                    break;
                case "I*":
                    numeroOperacao = MyIO.readInt();
                    caminhoOperacao = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.inserir(montaPersonagem(caminhoOperacao), numeroOperacao);
                    break;
                case "IF":
                    caminhoOperacao = MyIO.readString().replaceAll("é", "\u00e9");
                    listaPersonagens.inserirFim(montaPersonagem(caminhoOperacao));
                    break;
                case "RI":
                    listaPersonagens.removerInicio();
                    break;
                case "R*":
                    numeroOperacao = MyIO.readInt();
                    listaPersonagens.remover(numeroOperacao);
                    break;
                case "RF":
                    listaPersonagens.removerFim();
                    break;
                default:
                    i = quantidadeRegistros;
                    break;
            }
        }
    }
}