import java.util.Scanner;

public class setimaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= 10; i += 1) {
            System.out.printf("%d * %d = %d%n", num, i, num * i);
        }
    }
}
