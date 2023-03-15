import java.util.Scanner;

public class TimeDuendes2 {
    public static class Duende {
        String nome;
        int idade;
    }

    public static void swap(Duende duendes[], int a, int b) {
        Duende temp = duendes[a];
        duendes[a] = duendes[b];
        duendes[b] = temp;
    }

    public static void ordenar(Duende[] duendes, int tamanhoArray) {
        for (int i = 0; i < (tamanhoArray - 1); i++) {
            int maior = i;
            for (int j = (i + 1); j < tamanhoArray; j++) {
                if (duendes[maior].idade < duendes[j].idade) {
                    maior = j;
                }
            }
            swap(duendes, maior, i);
        }

    }

    public static void imprimirTimes(int numDuendes, Duende[] duendes) {

        int tercaParte = numDuendes / 3;

        Duende[] lideres = new Duende[tercaParte];

        for (int i = 0; i < tercaParte; i++) {
            lideres[i] = duendes[i];
        }

        Duende[] entregadores = new Duende[tercaParte];

        for (int i = 0, j = tercaParte; i < tercaParte; i++, j++) {
            entregadores[i] = duendes[j];
        }

        Duende[] pilotos = new Duende[tercaParte];

        for (int i = 0, j = (tercaParte) * 2; i < tercaParte; i++, j++) {
            pilotos[i] = duendes[j];
        }

        for (int i = 0; i < numDuendes / 3; i++) {
            int numeroDeTimes = i + 1;
            MyIO.println("Time " + numeroDeTimes);
            MyIO.println(lideres[i].nome + " " + lideres[i].idade);
            MyIO.println(entregadores[i].nome + " " + entregadores[i].idade);
            MyIO.println(pilotos[i].nome + " " + pilotos[i].idade);
            MyIO.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numDuendes;
        numDuendes = Integer.parseInt(sc.nextLine());

        Duende[] duendes = new Duende[numDuendes];

        for (int i = 0; i < numDuendes; i++) {
            String linha = sc.nextLine();
            String[] nomeIdade = linha.split(" ");

            duendes[i] = new Duende();
            duendes[i].nome = nomeIdade[0];
            duendes[i].idade = Integer.parseInt(nomeIdade[1]);
        }
        ordenar(duendes, numDuendes);

        imprimirTimes(numDuendes, duendes);
    }
}
