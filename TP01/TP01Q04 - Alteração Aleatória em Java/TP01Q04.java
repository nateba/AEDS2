import java.util.Random;

class TP01Q04 {
    public static String decifrar(String str, Random gerador) {

        String cifrada = new String();
        char char1 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));
        char char2 = (char) ('a' + (Math.abs(gerador.nextInt()) % 26));

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == char1) {
                cifrada += char2;
            } else {
                cifrada += str.charAt(i);
            }

        }
        return cifrada;
    }

    public static boolean isFim(String str) {
        boolean resp = false;
        if (str.equals("FIM")) {
            resp = true;
        }

        return resp;
    }

    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);

        String str = MyIO.readLine();
        while (isFim(str) == false) {
            MyIO.println(decifrar(str, gerador));
            str = MyIO.readLine();
        }
    }

}