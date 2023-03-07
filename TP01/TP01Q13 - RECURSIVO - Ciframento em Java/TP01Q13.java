/**
 * TP01Q13
 */
public class TP01Q13 {
    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static void main(String[] args) {

        String str = MyIO.readLine();

        while (isFim(str) == false) {
            MyIO.println(decifrar(str, 0));
            str = MyIO.readLine();
        }
    }

    public static String decifrar(String str, int i) {
        String cifrada = new String();

        if (i == str.length() - 1) {
            cifrada += (char) (str.charAt(i) + 3);
        } else {
            cifrada += ((char) (str.charAt(i) + 3)) + decifrar(str, i + 1);
        }

        return cifrada;
    }
}