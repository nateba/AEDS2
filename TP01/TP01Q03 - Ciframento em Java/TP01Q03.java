class TP01Q03 {
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
            MyIO.println(decifrar(str));
            str = MyIO.readLine();
        }
    }

    public static String decifrar(String str) {
        String cifrada = new String();
        for (int i = 0; i < str.length(); i++) {

            cifrada += (char) (str.charAt(i) + 3);

        }
        return cifrada;
    }
}