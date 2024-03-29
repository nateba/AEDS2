import java.io.RandomAccessFile;

public class TP02Q08 {

    public static class Personagem {
        private String nome;
        private int altura;
        private double peso;
        private String corDoCabelo;
        private String corDaPele;
        private String corDosOlhos;
        private String anoNascimento;
        private String genero;
        private String homeworld;

        Personagem(String nome, int altura, double peso, String corDoCabelo, String corDaPele,
                String corDosOlhos, String anoNascimento, String genero, String homeworld) {
            setNome(nome);
            setAltura(altura);
            setPeso(peso);
            setCorDoCabelo(corDoCabelo);
            setCorDaPele(corDaPele);
            setCorDosOlhos(corDosOlhos);
            setAnoNascimento(anoNascimento);
            setGenero(genero);
            setHomeworld(homeworld);
        }

        Personagem() {
            setNome("");
            setAltura(0);
            setPeso(0.0);
            setCorDoCabelo("");
            setCorDaPele("");
            setCorDosOlhos("");
            setAnoNascimento("");
            setGenero("");
            setHomeworld("");
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

        public void setAnoNascimento(String anoNascimento) {
            this.anoNascimento = anoNascimento;
        }

        public String getAnoNascimento() {
            return anoNascimento;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getGenero() {
            return genero;
        }

        public void setHomeworld(String homeworld) {
            this.homeworld = homeworld;
        }

        public String getHomeworld() {
            return homeworld;
        }

        public void Ler(String filePath) throws Exception {

            RandomAccessFile file = new RandomAccessFile(filePath, "r");

            String jsonString = file.readLine();
            file.close();

            String[] pairs = jsonString.substring(1, jsonString.length() - 1).split(", '");
            for (String pair : pairs) {
                String[] keyValue = pair.split(":");
                String key = keyValue[0].replaceAll("\'", "");
                String value = keyValue[1].replaceAll("\'", "").trim();

                if (key.equals("name")) {
                    setNome(value);
                } else if (key.equals("height")) {
                    if (value.equals("unknown")) {
                        setAltura(0);
                        continue;
                    }
                    setAltura(Integer.parseInt(value));
                } else if (key.equals("mass")) {
                    if (value.equals("unknown")) {
                        setPeso(0);
                        continue;
                    }
                    setPeso(Double.parseDouble(value.replaceAll(",", "")));
                } else if (key.equals("hair_color")) {
                    setCorDoCabelo(value);
                } else if (key.equals("skin_color")) {
                    setCorDaPele(value);
                } else if (key.equals("eye_color")) {
                    setCorDosOlhos(value);
                } else if (key.equals("birth_year")) {
                    setAnoNascimento(value);
                } else if (key.equals("gender")) {
                    setGenero(value);
                } else if (key.equals("homeworld")) {
                    setHomeworld(value);
                } else {
                    break;
                }
            }
        }

        public void Imprimir() {
            MyIO.print(" ## " + this.nome);
            MyIO.print(" ## " + this.altura);
            if (this.peso % 1.0 != 0) {
                MyIO.print(" ## " + String.format("%s", this.peso));
            } else {
                MyIO.print(" ## " + String.format("%.0f", this.peso));
            }
            MyIO.print(" ## " + this.corDoCabelo);
            MyIO.print(" ## " + this.corDaPele);
            MyIO.print(" ## " + this.corDosOlhos);
            MyIO.print(" ## " + this.anoNascimento);
            MyIO.print(" ## " + this.genero);
            MyIO.print(" ## " + this.homeworld);
            MyIO.print(" ## ");
            MyIO.println("");
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

    public static boolean ehMenorQueAString(String primeiraString, String segundaString) {
        boolean resposta = false;
        int c = 0;
        while (c < primeiraString.length()) {
            if (primeiraString.charAt(c) == segundaString.charAt(c)) {
                c++;
            } else if (primeiraString.charAt(c) < segundaString.charAt(c)) {
                resposta = true;
                c = primeiraString.length();
            } else {
                c = primeiraString.length();
            }
        }
        return resposta;
    }

    public static String ordenaPorSelecao(Personagem[] arrayDePersonagens, int posicaoFinalDoArray) {
        int contadorPosicao = 0;
        int contadorComparacao = 0;
        long inicioTempo = System.nanoTime();

        for (int c = 0; c < posicaoFinalDoArray - 1; c++) {
            int posicaoMenor = c;
            Personagem auxiliar = new Personagem();
            for (int i = c + 1; i < posicaoFinalDoArray; i++) {
                contadorComparacao += 1;
                if (ehMenorQueAString(arrayDePersonagens[i].nome, arrayDePersonagens[posicaoMenor].nome)) {
                    posicaoMenor = i;
                }
            }
            auxiliar = arrayDePersonagens[c];
            arrayDePersonagens[c] = arrayDePersonagens[posicaoMenor];
            arrayDePersonagens[posicaoMenor] = auxiliar;
            contadorPosicao += 2;
        }
        long fimTempo = System.nanoTime();
        String tempoDecorrido = " , tempo decorrido em nanosegundos :" + (fimTempo - inicioTempo);
        String conteudoArquivo = "Número de comparações " + contadorComparacao + ", número de troca de posições "
                + contadorPosicao + tempoDecorrido;
        return conteudoArquivo;
    }

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("ISO-8859-1");
        Personagem arrayDePersonagens[] = new Personagem[100];
        String input = MyIO.readLine();
        int posicaoArray = 0;

        while (!input.equals("FIM")) {
            arrayDePersonagens[posicaoArray] = new Personagem();
            arrayDePersonagens[posicaoArray].Ler(input);
            input = MyIO.readLine().replaceAll("é", "\u00e9");
            posicaoArray++;
        }
        String nomeDoArquivo = "SELECAOZINHA.txt";
        Arq.openWriteClose(nomeDoArquivo, ordenaPorSelecao(arrayDePersonagens, posicaoArray));

        for (int c = 0; c < posicaoArray; c++) {
            arrayDePersonagens[c].Imprimir();
        }

    }

    public static void print(String format, Object... args) {
        System.out.printf(format, args);
    }

    public static void printf(String format, Object... args) {
        System.out.printf(format, args);
        System.out.println();
    }

}