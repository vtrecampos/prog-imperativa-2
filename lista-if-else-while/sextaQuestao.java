import java.util.Scanner;

public class sextaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número positivo: ");
        int num = scanner.nextInt();

        int contador = num;
        int fatorial = 1;

        while (contador > 0) {
            fatorial *= contador;
            contador -= 1;
        }
        System.out.printf("Número %d! = %d", num, fatorial);
    }
}
