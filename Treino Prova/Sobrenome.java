import java.util.Scanner;

public class Sobrenome {

    public static boolean eVogal(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U');
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            int contador = 0;

            String sobrenome = sc.nextLine();
            for (int i = 0; i < sobrenome.length(); i++) {
                if (i < sobrenome.length() - 2) {
                    if (!(eVogal(sobrenome.charAt(i))) && !(eVogal(sobrenome.charAt(i + 1)))
                            && !(eVogal(sobrenome.charAt(i + 2)))) {
                        contador++;
                    }
                }

            }
            if (contador > 0) {
                MyIO.println(sobrenome + " nao eh facil");
            } else {
                MyIO.println(sobrenome + " eh facil");
            }

        }
    }
}
