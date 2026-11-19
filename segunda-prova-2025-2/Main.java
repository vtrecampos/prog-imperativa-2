import java.util.Scanner;

class Conta {
    int id;
    String cliente;
    double saldo;
    double limite;
}

class Operacao {
    int id;
    int idConta;
    char tipo; // {‘‘D’, ‘S, ‘T’}
    double valor;
}

public class Main {
    public static final Scanner SC = new Scanner(System.in);
    public static final int TAM_CONTAS = 50;
    public static final int TAM_OP = 1000;

    public static int buscaId(Conta[] v, int tam, int x) {
        for (int i = 0; i < tam; i++) {
            if (v[i].id == x) {
                return i;
            }
        }
        return -1;
    }

    // Questão 1
    public static int cadastrarConta(Conta[] v, int tam) {
        if (tam >= TAM_CONTAS) { // Correção: verificação para o topo
            System.out.println("Limite atingido");
            return tam;
        } else {
            Conta novoUsuario = new Conta();

            System.out.print("Digite seu ID: ");
            int novoId = SC.nextInt();
            SC.nextLine(); // Correção: consome o que Enter do buffer
            if (buscaId(v, tam, novoId) == -1) {
                novoUsuario.id = novoId;
            } else {
                System.out.println("O ID informado já existe.");
                return tam;
            }

            System.out.print("Digite seu nome: ");
            novoUsuario.cliente = SC.nextLine();
            System.out.print("Digite seu saldo: R$");
            double novoSaldo = SC.nextDouble();
            System.out.print("Digite seu limite: R$");
            double novoLimite = SC.nextDouble();
            if (novoSaldo < 0 || novoLimite < 0) {
                System.out.println("Saldo ou limite inválido. Tente novamente.");
                return tam;
            } else {
                novoUsuario.saldo = novoSaldo;
                novoUsuario.limite = novoLimite;
            }

            System.out.println("Conta cadastrada!");

            v[tam] = novoUsuario;
            tam += 1; // Correção: iteração após a atribuição da Conta em sua posição
        }

        return tam;
    }

    // Questão 2
    public static int buscaBinariaCliente(Conta[] v, int tam, String x) {
        int inicio = 0, fim = tam-1, meio, compara;

        while(inicio <= fim) {
            meio = (inicio+fim)/2;
            compara = x.compareToIgnoreCase(v[meio].cliente);
            if (compara == 0) {
                return meio;
            } else if (compara < 0) {
                fim = meio -1;
            } else {
                inicio = meio + 1;
            }
        }
        return -1;
    }

    // Questão 3
    public static int insertionSortCliente(Conta[] v, int tam) {
        int j;
        Conta aux;
        for (int i = 1; i < tam; i++) {
            j = i - 1;
            aux = v[i];
            // A comparação deve ser feita dentro do while para que atualize a cada passo, além da
            // comparação ser com o 'aux.cliente'
            while (j >= 0 && v[j].cliente.compareToIgnoreCase(aux.cliente) > 0) {
                v[j + 1] = v[j];
                j -= 1;
            }
            v[j + 1] = aux;
        }
        return tam;
    }

    // Questão 4
    public static int filtraOperacao(Operacao[] vOp, int tamOp, Operacao[] vOpFiltrado, int x) {
        int tamFiltrado = 0;
        for (int i = 0; i < tamOp; i++) {
            if (vOp[i].idConta == x) {
                vOpFiltrado[tamFiltrado] = vOp[i];
                tamFiltrado += 1;
            }
        }
        return tamFiltrado;
    }

    // Questão 5
    // Criação das funções auxiliares
    public static String formatarValor(double valor) {
        if (valor >= 0) {
            return String.format("%.2fC", valor);
        } else {
            // Multiplica por -1 (-valor) para remover o sinal negativo antes de pôr 'D'
            return String.format("%.2fD", -valor);
        }
    }
    public static String nomeOperacao(char tipo) {
        if (tipo == 'D') return "Depósito";
        if (tipo == 'S') return "Saque";
        return "Transferência";
    }

    public static void extrato(Conta[] vContas, int tamConta, Operacao[] vOp, int tamOp) {
        System.out.print("Digite o ID da conta: ");
        int idBusca = SC.nextInt();

        // CORREÇÃO 7: Salvar o índice retornado em 'posConta' para acessar os dados depois
        int posConta = buscaId(vContas, tamConta, idBusca);
        if (posConta == -1) {
            System.out.println("Conta não encontrada.");
            return;
        }

        Operacao[] vOpFiltrado = new Operacao[TAM_OP];
        int tamFiltrado = filtraOperacao(vOp, tamOp, vOpFiltrado, idBusca);

        // CORREÇÃO 8: Definir onde começam as 5 últimas operações, protegendo
        // contra índice negativo caso a conta tenha menos de 5 movimentações.
        int inicio = tamFiltrado - 5;
        if (inicio < 0) {
            inicio = 0;
        }

        // CORREÇÃO 9: Acumular apenas as operações anteriores às 5 últimas (0 até inicio - 1)
        // para descobrir o Saldo Anterior exato sem causar NullPointerException.
        double saldo = 0.0;
        for (int i = 0; i < inicio; i++) {
            saldo += vOpFiltrado[i].valor;
        }

        System.out.println("CONTA N. " + vContas[posConta].id);
        System.out.println("CLIENTE: " + vContas[posConta].cliente);
        System.out.println("ID | OPERAÇÃO | VALOR | SALDO");
        // CORREÇÃO 10: Exibir a linha obrigatória do Saldo Anterior formatado
        System.out.println("Saldo Anterior: " + formatarValor(saldo));

        // CORREÇÃO 11: Começar o laço em 'inicio' (apenas as 5 últimas) e usar as funções
        // auxiliares para imprimir o nome da operação por extenso e valores sem sinal com C/D.
        for (int i = inicio; i < tamFiltrado; i++) {
            Operacao op = vOpFiltrado[i];
            saldo += op.valor;

            System.out.printf("%d | %s | %s | %s\n",
                    op.id,
                    nomeOperacao(op.tipo),
                    formatarValor(op.valor),
                    formatarValor(saldo));
        }

        System.out.println("Saldo Atual: " + formatarValor(saldo));
    }
}