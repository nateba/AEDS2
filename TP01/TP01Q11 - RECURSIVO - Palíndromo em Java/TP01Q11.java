/**
 * TP01Q11
 */
public class TP01Q11 {
    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static void main(String[] args) {
        MyIO.setCharset("ISO-8859-1");

        String str = MyIO.readLine();

        while (isFim(str) == false) {
            if (metodo(str, 0, (str.length() - 1)) == 0) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = MyIO.readLine();
        }
    }

    public static int metodo(String palavra, int esq, int dir) {
        int resp = 0;

        while (esq <= dir) {
            if (palavra.charAt(esq) == palavra.charAt(dir)) {
                return 0 + metodo(palavra, esq + 1, dir - 1);
            } else {
                return 1;
            }
        }

        return resp;
    }
}