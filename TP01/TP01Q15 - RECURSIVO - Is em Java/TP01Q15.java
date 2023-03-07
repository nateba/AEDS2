/**
 * TP01Q15
 */
public class TP01Q15 {

    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static int vogal(String str, int i) {

        if (i < str.length()) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
                    || str.charAt(i) == 'o' || str.charAt(i) == 'u' || str.charAt(i) == 'A'
                    || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
                    || str.charAt(i) == 'U') {
                return 0 + vogal(str, i + 1);
            } else {
                return 1;
            }
        }

        return 0;
    }

    public static int consoante(String str, int i) {

        if (i < str.length()) {
            if (((str.charAt(i) >= 'B' && str.charAt(i) <= 'Z')
                    || (str.charAt(i) >= 'b' && str.charAt(i) <= 'z')) && str.charAt(i) != 'e'
                    && str.charAt(i) != 'i'
                    && str.charAt(i) != 'o' && str.charAt(i) != 'u' && str.charAt(i) != 'E'
                    && str.charAt(i) != 'I' && str.charAt(i) != 'O'
                    && str.charAt(i) != 'U') {
                return 0 + consoante(str, i + 1);
            } else {
                return 1;
            }
        }

        return 0;
    }

    public static int inteiro(String str, int i) {

        if (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                return 0 + inteiro(str, i + 1);
            } else {
                return 1;
            }
        }

        return 0;
    }

    public static int real(String str, int i, int cont) {

        if (i < str.length()) {
            if (((str.charAt(i) >= '0' && str.charAt(i) <= '9') || str.charAt(i) == '.'
                    || str.charAt(i) == ',') && cont <= 1) {

                if (str.charAt(i) == '.'
                        || str.charAt(i) == ',') {
                    return 0 + real(str, i + 1, cont + 1);
                }

                return 0 + real(str, i + 1, cont + 0);

            } else {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String str = MyIO.readLine();

        while (isFim(str) == false) {
            if (vogal(str, 0) == 0) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (consoante(str, 0) == 0) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (inteiro(str, 0) == 0) {
                MyIO.print("SIM ");
            } else {
                MyIO.print("NAO ");
            }
            if (real(str, 0, 0) == 0) {
                MyIO.println("SIM ");
            } else {
                MyIO.println("NAO ");
            }
            str = MyIO.readLine();
        }

    }
}