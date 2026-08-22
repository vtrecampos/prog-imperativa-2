import java.util.Scanner;

public class quintaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        int numUm = scanner.nextInt();
        System.out.print("Digite o segundo número: ");
        int numDois = scanner.nextInt();

        System.out.println("Números pares: ");
        for (int i = numUm; i <= numDois; i += 1) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        System.out.println("Números ímpares: ");
        for (int i = numUm; i <= numDois; i += 1) {
            if (i % 2 != 0) {
                System.out.println(i);
            }
        }

    }
}
