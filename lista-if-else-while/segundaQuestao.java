import java.util.Scanner;

public class segundaQuestao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Insira seu peso: ");
        float peso = scanner.nextFloat();
        System.out.print("Insira sua altura: ");
        float altura = scanner.nextFloat();

        double imc = peso / (altura * altura);
        System.out.println("Seu IMC é: " + imc);

        if (imc < 18.5) {
            System.out.print("Classificação: Abaixo do peso");
        } else if (imc < 25) {
            System.out.print("Classificação: Peso normal");
        } else if (imc < 30) {
            System.out.print("Classificação: Excesso de peso");
        } else {
            System.out.print("Classificação: Obesidade");
        }
    }
}
