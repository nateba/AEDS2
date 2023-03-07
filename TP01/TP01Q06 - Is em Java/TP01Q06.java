class TP01Q06 {
    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static boolean vogal(String str) {
        boolean teste = true;
        for (int i = 0; i < str.length(); i++) {
            if (!(str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'U' || str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u')) {
                teste = false;
            }
        }
        return teste;
    }

    public static boolean consoante(String str) {
        boolean resp = true;

        for (int i = 0; i < str.length(); i++) {

            if (!(((str.charAt(i) >= 'b' && str.charAt(i) <= 'z')
                    && (str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u'))
                    || ((str.charAt(i) >= 'B' && str.charAt(i) <= 'Z') && (str.charAt(i) != 'E' && str.charAt(i) != 'I'
                            && str.charAt(i) != 'O' && str.charAt(i) != 'U')))) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean inteiro(String str) {
        boolean resp = true;

        for (int i = 0; i < str.length(); i++) {

            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                resp = false;
            }
        }
        return resp;
    }

    public static boolean real(String str) {
        boolean resp = true;
        int contador = 0;
        for (int i = 0; i < str.length(); i++) {

            if (Character.isDigit(str.charAt(i)) || (str.charAt(i) == '.') || (str.charAt(i) == ',')) {
                if ((str.charAt(i) == '.') || (str.charAt(i) == ',')) {
                    contador += 1;
                    if (contador > 1) {
                        resp = false;
                        i = str.length();
                    } else {
                        resp = true;
                    }
                } else {
                    resp = true;

                }

            } else {
                resp = false;
                i = str.length();
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        String str = MyIO.readLine();

        while (isFim(str) == false) {
            if (vogal(str) == true) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (consoante(str) == true) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (inteiro(str) == true) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (real(str) == true) {
                MyIO.println("SIM ");
            } else {
                MyIO.println("NAO ");
            }
            str = MyIO.readLine();
        }

    }
}