public class TP01Q14 {
    public static void main(String[] args) {
        int letras = MyIO.readInt();
        int A = 0, B = 0, C = 0;
        String expressaoCrua = new String();

        while (letras != 0) {

            if (letras == 2) {
                A = MyIO.readInt();
                B = MyIO.readInt();

                expressaoCrua = MyIO.readLine().replaceAll(" ", "");

                if (A == 0) {
                    expressaoCrua = expressaoCrua.replaceAll("A", "0");
                } else {
                    expressaoCrua = expressaoCrua.replaceAll("A", "1");
                }
                if (B == 0) {
                    expressaoCrua = expressaoCrua.replaceAll("B", "0");
                } else {
                    expressaoCrua = expressaoCrua.replaceAll("B", "1");
                }
            } else if (letras == 3) {
                A = MyIO.readInt();
                B = MyIO.readInt();
                C = MyIO.readInt();

                expressaoCrua = MyIO.readLine().replaceAll(" ", "");

                if (A == 0) {
                    expressaoCrua = expressaoCrua.replaceAll("A", "0");
                } else {
                    expressaoCrua = expressaoCrua.replaceAll("A", "1");
                }
                if (B == 0) {
                    expressaoCrua = expressaoCrua.replaceAll("B", "0");
                } else {
                    expressaoCrua = expressaoCrua.replaceAll("B", "1");
                }
                if (C == 0) {
                    expressaoCrua = expressaoCrua.replaceAll("C", "0");
                } else {
                    expressaoCrua = expressaoCrua.replaceAll("C", "1");
                }
            }

            calculaAlgebra(expressaoCrua);

            letras = MyIO.readInt();
        }
    }

    public static void calculaAlgebra(String expressao) {
        int aberturaPar = 0, fechamentoPar = 0;

        if (expressao.length() > 1) {
            for (int i = 0; i < expressao.length(); i++) {
                if (expressao.charAt(i) == '(') {
                    aberturaPar = i;
                }
                if (expressao.charAt(i) == ')') {
                    fechamentoPar = i;
                    i = expressao.length();
                }
            }

            // chamar a função dependendo do caso
            if (expressao.charAt(aberturaPar - 1) == 'd') {
                calculaAnd(expressao, aberturaPar, fechamentoPar);
            } else if (expressao.charAt(aberturaPar - 1) == 'r') {
                calculaOr(expressao, aberturaPar, fechamentoPar);
            } else if (expressao.charAt(aberturaPar - 1) == 't') {
                calculaNot(expressao, aberturaPar, fechamentoPar);
            }
        } else {
            MyIO.println(expressao); // exibir na tela quando a expressão for apenas um número
        }
    }

    public static void calculaNot(String expressao, int posAbre, int posFecha) {
        String expressaoFinal = new String();

        // trocar os valores e limpar a expressão
        for (int i = 0; i < expressao.length(); i++) {
            if (i == (posAbre - 3)) {
                if (expressao.charAt(posAbre + 1) == '0') {
                    expressaoFinal += '1';
                } else {
                    expressaoFinal += '0';
                }
            } else if (i > (posAbre - 3) && i <= posFecha) {
                expressaoFinal += "";
            } else {
                expressaoFinal += expressao.charAt(i);
            }
        }

        calculaAlgebra(expressaoFinal);
    }

    public static void calculaAnd(String expressao, int posAbre, int posFecha) {
        String expressaoFinal = new String();

        // trocar os valores e limpar a expressão
        for (int i = 0; i < expressao.length(); i++) {
            if (i == (posAbre - 3)) {
                // redundância na localização do termo para abranger dois ou três variáveis
                if (expressao.charAt(posAbre + 1) == '1' && expressao.charAt(posAbre + 3) == '1'
                        && expressao.charAt(posFecha - 1) == '1') {
                    expressaoFinal += '1';
                } else {
                    expressaoFinal += '0';
                }
            } else if (i > (posAbre - 3) && i <= posFecha) {
                expressaoFinal += "";
            } else {
                expressaoFinal += expressao.charAt(i);
            }
        }

        calculaAlgebra(expressaoFinal);
    }

    public static void calculaOr(String expressao, int posAbre, int posFecha) {
        String expressaoFinal = new String();

        // trocar os valores e limpar a expressão
        for (int i = 0; i < expressao.length(); i++) {
            if (i == (posAbre - 2)) {
                // redundância na localização do termo para abranger dois ou três variáveis
                if (expressao.charAt(posAbre + 1) == '1' || expressao.charAt(posAbre + 3) == '1'
                        || expressao.charAt(posFecha - 1) == '1') {
                    expressaoFinal += '1';
                } else {
                    expressaoFinal += '0';
                }
            } else if (i > (posAbre - 2) && i <= posFecha) {
                expressaoFinal += "";
            } else {
                expressaoFinal += expressao.charAt(i);
            }
        }

        calculaAlgebra(expressaoFinal);
    }
}