import java.io.*;
import java.net.*;
import java.util.Arrays;

public class TP01Q08 {

    public static String getHtml(String endereco) {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String resp = "", line;

        try {
            url = new URL(endereco);
            is = url.openStream(); // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {
                resp += line + "\n";
            }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        try {
            is.close();
        } catch (IOException ioe) {
            // nothing to see here

        }

        return resp;
    }

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

    public static boolean eLetra(char c) {
        return ((c >= 'a' && c <= 'z'));
    }

    public static boolean eVogal(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U');
    }

    public static boolean eConsoante(char c) {
        return (eLetra(c) && !eVogal(c));
    }

    public static boolean eTabla(String s, int i) {
        boolean resp = true;
        String table = "<table>";
        for (int j = 0; j < 7; j++) {
            if (s.charAt(i + j) != table.charAt(j)) {
                resp = false;
                j = 7;
            }
        }
        return resp;
    }

    public static boolean eBr(String s, int i) {
        boolean resp = true;
        String br = "<br>";
        for (int j = 0; j < 4; j++) {
            if (s.charAt(i + j) != br.charAt(j)) {
                resp = false;
                j = 7;
            }
        }
        return resp;
    }

    public static void main(String[] args) {

        MyIO.setCharset("ISO-8859-1");

        int[] vetor = new int[200000];
        int[] vetor2 = new int[3];

        String titulo = new String(); // titulo da serie
        String url = new String(); // html

        titulo = MyIO.readLine();

        while (!isFim(titulo)) {
            Arrays.fill(vetor2, 0);
            Arrays.fill(vetor, 0);
            url = MyIO.readLine();
            String nome = getHtml(url);
            for (int j = 0; j < nome.length(); j++) {

                vetor[((int) nome.charAt(j))]++;

                if (eConsoante(nome.charAt(j))) {
                    vetor2[0]++;
                }
                if (eBr(nome, j)) {
                    vetor2[1]++;
                }
                if (eTabla(nome, j)) {
                    vetor2[2]++;
                }

            }

            MyIO.println("a(" + vetor[97] + ") " + "e(" + vetor[101] + ") " + "i(" + vetor[105] + ") " + "o("
                    + vetor[111] + ") "
                    + "u(" + vetor[117] + ") " + "\u00e1(" + vetor[161] + ") " + "\u00e9(" + vetor[169] + ") "
                    + "\u00ed(" + vetor[173]
                    + ") " + "\u00f3("
                    + vetor[179] + ") " + "\u00fa(" + vetor[186] + ") " + "\u00e0(" + vetor[160] + ") " + "\u00e8("
                    + vetor[168] + ") "
                    + "\u00ec(" + vetor[172]
                    + ") " + "\u00f2(" + vetor[178] + ") " + "\u00f9(" + vetor[185] + ") " + "\u00e3(" + vetor[163]
                    + ") " + "\u00f5("
                    + vetor[181] + ") "
                    + "\u00e2("
                    + vetor[162] + ") " + "\u00ea(" + vetor[170] + ") " + "\u00ee(" + vetor[174] + ") "
                    + "\u00f4("
                    + vetor[180]
                    + ") " + "\u00fb(" + vetor[187] + ") " + "consoante(" + vetor2[0] + ") " + "<br>(" + vetor2[1]
                    + ") "
                    + "<table>("
                    + vetor2[2] + ") " + titulo);
            titulo = MyIO.readLine();
        }

    }
}