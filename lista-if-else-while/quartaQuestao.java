import java.util.Scanner;

public class quartaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o salário bruto: R$");
        double salario = scanner.nextDouble();

        double aliquota, desconto;

        if (salario < 2428.81) {
            aliquota = 0;
            desconto = 0;
        } else if (salario < 2826.66) {
            aliquota = 0.075;
            desconto = 182.16;
        } else if (salario < 3751.06) {
            aliquota = 0.15;
            desconto = 394.16;
        } else if (salario < 4664.69) {
            aliquota = 0.225;
            desconto = 675.49;
        } else {
            aliquota = 0.275;
            desconto = 908.73;
        }

        double imposto = (salario * aliquota) - desconto;
        System.out.printf("Valor descontado: R$%.2f", imposto);
    }
}
