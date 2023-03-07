class TP01Q01 {
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
            if (metodo(str) == true) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
            str = MyIO.readLine();
        }

    }

    public static boolean metodo(String palavra) {
        boolean teste = true;
        for (int i = 0, j = palavra.length() - 1; i < palavra.length() - 1; i++, j--) {

            if (palavra.charAt(i) != palavra.charAt(j)) {
                teste = false;
            }
        }

        return teste;

    }
}