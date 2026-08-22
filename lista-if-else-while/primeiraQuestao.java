import java.util.Scanner;

public class primeiraQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numUm = scanner.nextInt();
        System.out.print("Digite outro número: ");
        int numDois = scanner.nextInt();

        System.out.printf("Adição: %d + %d = %d%n", numUm, numDois, (numUm + numDois));
        System.out.printf("Subtração: %d - %d = %d%n", numUm, numDois, (numUm - numDois));
        System.out.printf("Multiplicação: %d * %d = %d%n", numUm, numDois, (numUm * numDois));
        if (numDois == 0) {
            System.out.println("Não é possível dividir um número por zero.");
        } else {
            System.out.printf("Divisão: %d / %d = %.2f%n", numUm, numDois, (double) numUm / (double) numDois);
        }
    }
}
