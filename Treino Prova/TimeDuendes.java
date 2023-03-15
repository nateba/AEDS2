
/**
 * TimeDuendes
 */
import java.util.Scanner;

public class TimeDuendes {
    public static void swap(int vetorIdade[], int a, int b) {
        int temp = vetorIdade[a];
        vetorIdade[a] = vetorIdade[b];
        vetorIdade[b] = temp;
    }

    public static void swap2(String vetor[], int a, int b) {
        String temp = vetor[a];
        vetor[a] = vetor[b];
        vetor[b] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDuendes;
        numDuendes = Integer.parseInt(sc.nextLine());
        int tamanhoVetor = numDuendes;
        int numTimes = numDuendes / 3;

        String vetor[] = new String[numDuendes];
        int vetorIdade[] = new int[numDuendes];

        while (numDuendes > 0) {
            String linha = new String();
            linha = sc.nextLine();
            String idadestring = new String();

            for (int i = 0; i < linha.length(); i++) {

                if (Character.isDigit(linha.charAt(i))) {

                    idadestring += linha.charAt(i);

                }
            }
            int idade = (Integer.parseInt(idadestring));
            vetorIdade[numDuendes - 1] = idade;

            vetor[numDuendes - 1] = linha;
            numDuendes--;
        }

        for (int i = 0; i < tamanhoVetor - 1; i++) {
            int menor = i;
            for (int j = (i + 1); j < tamanhoVetor; j++) {
                if (vetorIdade[menor] > vetorIdade[j]) {
                    menor = j;

                }
            }
            swap2(vetor, menor, i);
            swap(vetorIdade, menor, i);
        }

        MyIO.println("Time 1");

        for (int i = tamanhoVetor - 1; i > -1; i -= numTimes) {

            MyIO.println(vetor[i]);

        }
        MyIO.println("");

        MyIO.println("Time 2");

        for (int i = tamanhoVetor - 2; i > -1; i -= numTimes) {

            MyIO.println(vetor[i]);

        }
        if (numTimes > 2) {
            MyIO.println("");

            MyIO.println("Time 3");

            for (int i = tamanhoVetor - 3; i > -1; i -= numTimes) {

                MyIO.println(vetor[i]);

            }
        }

    }
}
