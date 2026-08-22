import java.util.Scanner;

public class terceiraQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor do seu salário bruto: R$");
        double salarioBruto = scanner.nextDouble();

        double aliquota, desconto;

        if (salarioBruto < 1621.01) {
            aliquota = 0.075;
            desconto = 0;
        } else if (salarioBruto < 2902.85) {
            aliquota = 0.9;
            desconto = 24.32;
        } else if (salarioBruto < 4354.28) {
            aliquota = 0.12;
            desconto = 111.40;
        } else {
            aliquota = 0.14;
            desconto = 198.49;
        }

        double contribuicao = (salarioBruto * aliquota) - desconto;
        double salarioLiquido = salarioBruto - contribuicao;

        System.out.printf("Contribuição: R$%.2f%n", contribuicao);
        System.out.printf("Salário líquido: R$%.2f", salarioLiquido);
    }
}
