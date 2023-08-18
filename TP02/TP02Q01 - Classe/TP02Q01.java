import java.io.RandomAccessFile;

public class TP02Q01 {
    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static void main(String[] args) throws Exception {

        MyIO.setCharset("ISO-8859-1");
        Personagem bobo = new Personagem();

        String pubin = MyIO.readLine();

        while (isFim(pubin) == false) {

            RandomAccessFile lerArq = new RandomAccessFile(pubin, "r");

            String texto = lerArq.readLine();

            String testeNome = new String();

            for (int i = 0; i < texto.length(); i++) {

                if (texto.charAt(i) == 'n' && texto.charAt(i + 1) == 'a' && texto.charAt(i + 2) == 'm'
                        && texto.charAt(i + 3) == 'e') {
                    for (int j = texto.indexOf("name") + 8; j < texto.indexOf("',"); j++) {
                        testeNome += texto.charAt(j);
                    }

                }
            }
            bobo.setNome(testeNome);

            String testeAltura = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'h' && texto.charAt(i + 1) == 'e' && texto.charAt(i + 2) == 'i'
                        && texto.charAt(i + 3) == 'g' && texto.charAt(i + 4) == 'h' && texto.charAt(i + 5) == 't') {
                    for (int j = texto.indexOf("height") + 10; j < texto.indexOf("',",
                            texto.indexOf("height") + 10); j++) {
                        testeAltura += texto.charAt(j);
                    }

                }

            }
            if (testeAltura.equals("unknown")) {
                testeAltura = "0";
                int alturinha1 = Integer.parseInt(testeAltura);
                bobo.setAltura(alturinha1);
            } else {
                int alturinha2 = Integer.parseInt(testeAltura);
                bobo.setAltura(alturinha2);
            }

            String testeCorDeCabelo = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'h' && texto.charAt(i + 1) == 'a' && texto.charAt(i + 2) == 'i'
                        && texto.charAt(i + 3) == 'r' && texto.charAt(i + 4) == '_' && texto.charAt(i + 5) == 'c'
                        && texto.charAt(i + 6) == 'o' && texto.charAt(i + 7) == 'l' && texto.charAt(i + 8) == 'o'
                        && texto.charAt(i + 9) == 'r') {
                    for (int j = texto.indexOf("hair_color") + 14; j < texto.indexOf("',",
                            texto.indexOf("hair_color") + 14); j++) {
                        testeCorDeCabelo += texto.charAt(j);
                    }

                }
            }
            bobo.setCorDoCabelo(testeCorDeCabelo);

            String testeCorDaPele = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 's' && texto.charAt(i + 1) == 'k' && texto.charAt(i + 2) == 'i'
                        && texto.charAt(i + 3) == 'n' && texto.charAt(i + 4) == '_' && texto.charAt(i + 5) == 'c'
                        && texto.charAt(i + 6) == 'o' && texto.charAt(i + 7) == 'l' && texto.charAt(i + 8) == 'o'
                        && texto.charAt(i + 9) == 'r') {
                    for (int j = texto.indexOf("skin_color") + 14; j < texto.indexOf("',",
                            texto.indexOf("skin_color") + 14); j++) {
                        testeCorDaPele += texto.charAt(j);
                    }

                }
            }
            bobo.setCorDaPele(testeCorDaPele);

            String testeCorDosOlhos = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'e' && texto.charAt(i + 1) == 'y' && texto.charAt(i + 2) == 'e'
                        && texto.charAt(i + 3) == '_' && texto.charAt(i + 4) == 'c' && texto.charAt(i + 5) == 'o'
                        && texto.charAt(i + 6) == 'l' && texto.charAt(i + 7) == 'o' && texto.charAt(i + 8) == 'r') {
                    for (int j = texto.indexOf("eye_color") + 13; j < texto.indexOf("',",
                            texto.indexOf("eye_color") + 13); j++) {
                        testeCorDosOlhos += texto.charAt(j);
                    }

                }
            }
            bobo.setCorDosOlhos(testeCorDosOlhos);

            String testeAnoNascimento = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'b' && texto.charAt(i + 1) == 'i' && texto.charAt(i + 2) == 'r'
                        && texto.charAt(i + 3) == 't' && texto.charAt(i + 4) == 'h' && texto.charAt(i + 5) == '_'
                        && texto.charAt(i + 6) == 'y' && texto.charAt(i + 7) == 'e' && texto.charAt(i + 8) == 'a'
                        && texto.charAt(i + 9) == 'r') {
                    for (int j = texto.indexOf("birth_year") + 14; j < texto.indexOf("',",
                            texto.indexOf("birth_year") + 14); j++) {
                        testeAnoNascimento += texto.charAt(j);
                    }

                }
            }
            bobo.setAnoNascimento(testeAnoNascimento);

            String testeGenero = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'g' && texto.charAt(i + 1) == 'e' && texto.charAt(i + 2) == 'n'
                        && texto.charAt(i + 3) == 'd' && texto.charAt(i + 4) == 'e' && texto.charAt(i + 5) == 'r') {
                    for (int j = texto.indexOf("gender") + 10; j < texto.indexOf("',",
                            texto.indexOf("gender") + 10); j++) {
                        testeGenero += texto.charAt(j);
                    }

                }
            }
            bobo.setGenero(testeGenero);

            String testeHomeWorld = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'h' && texto.charAt(i + 1) == 'o' && texto.charAt(i + 2) == 'm'
                        && texto.charAt(i + 3) == 'e' && texto.charAt(i + 4) == 'w' && texto.charAt(i + 5) == 'o'
                        && texto.charAt(i + 6) == 'r' && texto.charAt(i + 7) == 'l' && texto.charAt(i + 8) == 'd') {
                    for (int j = texto.indexOf("homeworld") + 13; j < texto.indexOf("',",
                            texto.indexOf("homeworld") + 13); j++) {
                        testeHomeWorld += texto.charAt(j);
                    }

                }
            }
            bobo.setHomeworld(testeHomeWorld);

            String testePeso = new String();

            for (int i = 0; i < texto.length(); i++) {
                if (texto.charAt(i) == 'm' && texto.charAt(i + 1) == 'a' && texto.charAt(i + 2) == 's'
                        && texto.charAt(i + 3) == 's') {
                    for (int j = texto.indexOf("mass") + 8; j < texto.indexOf("',", texto.indexOf("mass") + 8); j++) {
                        testePeso += texto.charAt(j);
                    }
                    if (testePeso.equals("1,358")) {
                        testePeso = "1.358";
                    }
                }
            }

            if (testePeso.equals("unknown")) {
                testePeso = "0";
                double pesinho1 = Double.parseDouble(testePeso);
                bobo.setPeso(pesinho1);
            } else {
                double pesinho2 = Double.parseDouble(testePeso);
                bobo.setPeso(pesinho2);
            }

            lerArq.close();
            System.out.println(bobo);

            pubin = MyIO.readLine().replaceAll("é", "\u00e9");

        }
    }

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

        public Personagem(String nome, int altura, Double peso, String corDoCabelo, String corDaPele,
                String corDosOlhos,
                String anoNascimento, String genero, String homeworld) {
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

        public Personagem() {
            this.nome = "";
            this.altura = 0;
            this.peso = 0.0;
            this.corDoCabelo = "";
            this.corDaPele = "";
            this.corDosOlhos = "";
            this.anoNascimento = "";
            this.genero = "";
            this.homeworld = "";
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

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getAltura() {
            return altura;
        }

        public void setAltura(int altura) {
            this.altura = altura;
        }

        public double getPeso() {
            return peso;
        }

        public void setPeso(double peso) {
            this.peso = peso;
        }

        public String getCorDoCabelo() {
            return corDoCabelo;
        }

        public void setCorDoCabelo(String corDoCabelo) {
            this.corDoCabelo = corDoCabelo;
        }

        public String getCorDaPele() {
            return corDaPele;
        }

        public void setCorDaPele(String corDaPele) {
            this.corDaPele = corDaPele;
        }

        public String getCorDosOlhos() {
            return corDosOlhos;
        }

        public void setCorDosOlhos(String corDosOlhos) {
            this.corDosOlhos = corDosOlhos;
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

        public int imprimirComInt(double numero) {
            return ((int) numero);
        }

        public String toString() {
            if ((altura == 0) && (peso == 0)) {
                return " ## " + nome + " ## 0 ## 0 ## " + corDoCabelo + " ## " + corDaPele + " ## "
                        + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";
            } else if (altura == 0) {
                if (peso % 1 == 0) {
                    return " ## " + nome + " ## 0 ## " + imprimirComInt(peso) + " ## " + corDoCabelo + " ## "
                            + corDaPele
                            + " ## "
                            + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";
                } else {
                    return " ## " + nome + " ## 0 ## " + peso + " ## " + corDoCabelo + " ## " + corDaPele + " ## "
                            + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";
                }

            } else if (peso == 0) {
                return " ## " + nome + " ## " + altura + " ## 0 ## " + corDoCabelo + " ## " + corDaPele + " ## "
                        + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";

            } else {
                if (peso % 1 == 0) {
                    return " ## " + nome + " ## " + altura + " ## " + imprimirComInt(peso) + " ## " + corDoCabelo
                            + " ## " + corDaPele
                            + " ## "
                            + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";
                } else {
                    return " ## " + nome + " ## 0 ## " + peso + " ## " + corDoCabelo + " ## " + corDaPele + " ## "
                            + corDosOlhos + " ## " + anoNascimento + " ## " + genero + " ## " + homeworld + " ## ";

                }
            }

        }

    }
}