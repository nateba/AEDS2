public class TP01Q05 {
    public static void main(String[] args) {
        int letras = MyIO.readInt();
        int A = 0, B = 0, C = 0;
        int aberturaPar = 0, fechamentoPar = 0;
        String expressaoCrua = new String();
        String expressaoLimpa = new String();

        while (letras != 0) {
            // caso de duas ou três variáveis
            if (letras == 2) {
                A = MyIO.readInt();
                B = MyIO.readInt();

                // limpar os espaços da expressão
                expressaoCrua = MyIO.readLine().replaceAll(" ", "");

                // colocar valores nas variáveis da string
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

                // limpar os espaços da expressão
                expressaoCrua = MyIO.readLine().replaceAll(" ", "");

                // colocar valores nas variáveis da string
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

            ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            while (expressaoCrua.length() > 1) {
                for (int i = 0; i < expressaoCrua.length(); i++) {
                    if (expressaoCrua.charAt(i) == '(') {
                        aberturaPar = i;
                    }
                    if (expressaoCrua.charAt(i) == ')') {
                        fechamentoPar = i;
                        i = expressaoCrua.length();
                    }
                }

                // chamar a função dependendo do caso
                if (expressaoCrua.charAt(aberturaPar - 1) == 'd') {

                    // CALCULA AND

                    expressaoLimpa = new String();

                    // trocar os valores e limpar a expressão
                    for (int i = 0; i < expressaoCrua.length(); i++) {
                        if (i == (aberturaPar - 3)) {
                            // redundância na localização do termo para abranger dois ou três variáveis
                            if (expressaoCrua.charAt(aberturaPar + 1) == '1'
                                    && expressaoCrua.charAt(aberturaPar + 3) == '1'
                                    && expressaoCrua.charAt(fechamentoPar - 1) == '1') {
                                expressaoLimpa += '1';
                            } else {
                                expressaoLimpa += '0';
                            }
                        } else if (i > (aberturaPar - 3) && i <= fechamentoPar) {
                            expressaoLimpa += "";
                        } else {
                            expressaoLimpa += expressaoCrua.charAt(i);
                        }
                    }
                } else if (expressaoCrua.charAt(aberturaPar - 1) == 'r') {

                    // CALCULA OR

                    expressaoLimpa = new String();

                    // trocar os valores e limpar a expressão
                    for (int i = 0; i < expressaoCrua.length(); i++) {
                        if (i == (aberturaPar - 2)) {
                            // redundância na localização do termo para abranger dois ou três variáveis
                            if (expressaoCrua.charAt(aberturaPar + 1) == '1'
                                    || expressaoCrua.charAt(aberturaPar + 3) == '1'
                                    || expressaoCrua.charAt(fechamentoPar - 1) == '1') {
                                expressaoLimpa += '1';
                            } else {
                                expressaoLimpa += '0';
                            }
                        } else if (i > (aberturaPar - 2) && i <= fechamentoPar) {
                            expressaoLimpa += "";
                        } else {
                            expressaoLimpa += expressaoCrua.charAt(i);
                        }
                    }

                } else if (expressaoCrua.charAt(aberturaPar - 1) == 't') {

                    // CALCULA NOT

                    expressaoLimpa = new String();

                    // trocar os valores e limpar a expressão
                    for (int i = 0; i < expressaoCrua.length(); i++) {
                        if (i == (aberturaPar - 3)) {
                            if (expressaoCrua.charAt(aberturaPar + 1) == '0') {
                                expressaoLimpa += '1';
                            } else {
                                expressaoLimpa += '0';
                            }
                        } else if (i > (aberturaPar - 3) && i <= fechamentoPar) {
                            expressaoLimpa += "";
                        } else {
                            expressaoLimpa += expressaoCrua.charAt(i);
                        }
                    }
                }

                expressaoCrua = expressaoLimpa;
            }

            // exibe o resultado
            MyIO.println(expressaoCrua);

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            letras = MyIO.readInt();
        }
    }
}
