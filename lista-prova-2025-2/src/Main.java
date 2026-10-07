public class Main {
    // QUESTÃO UM
    public static int uniao(int[] a, int tamA, int[] b, int tamB, int[] u) {
        int tamU = 0;
        for (int i = 0; i < tamA; i++) {
            if (!existeNoVetor(u, tamU, a[i])) { // Aplicação da boa prática (!existeNoVetor(u, tamU, a[i])
                u[tamU] = a[i];
                tamU += 1;
            }
        }

        for (int i = 0; i < tamB; i++) {
            if (!existeNoVetor(u, tamU, b[i])) { // Aplicação da boa prática (!existeNoVetor(u, tamU, a[i])
                u[tamU] = b[i];
                tamU += 1;
            }
        }
        return tamU;
    }

    public static boolean existeNoVetor(int[] v, int tamV, int x) {
        for (int i = 0; i < tamV; i++) {
            if (v[i] == x) {
                return true;
            }
        } // Fechamento do loop corretamente
        return false;
    }

    // QUESTÃO DOIS
    public static void ordenar(int[] v, int n) {
        int chave;
        int j;

        for (int i = 1; i < n; i+=1) { // Iniciando do índice correto
            chave = v[i];
            j = i-1;

            while(j >= 0 && v[j] > chave) {
                v[j+1] = v[j];
                j -= 1;
            }
            v[j+1] = chave;
        }
    }

    // QUESTÃO TRÊS
    public static int gerarVetorSemRepeticao(int[] v, int tamV, int[] vsr) {
        int tamVsr = 0;

        for (int i = 0; i < tamV; i+=1) {
            if (!existeNoVetor(vsr, tamVsr, v[i])) {
                vsr[tamVsr] = v[i];
                tamVsr += 1;
            }
        }
        return tamVsr;
    }

//    public static boolean existeNoVetor(int[] v, int tamV, int x) { // Correção do tipo da função
//        for (int i = 0; i < tamV; i+=1) {
//            if (v[i] == x) {
//                return true; // Lógica corrigida
//            }
//        }
//        return false;
//    }

    // QUESTAO QUATRO
    public static void rotacionar(int[] v, int tam, int k) {
        if (tam <= 0) {
            return;
        }
        // Cumprimento do enunciado sobre verificar a disposição de k
        k = k % tam;

        if (k < 0) {
            k = k + tam;
        }

        for (int j = 0; j < k; j++) {
            int primeiro = v[0];
            for (int i = 0; i < tam - 1; i++) { // Correção da indexação
                v[i] = v[i + 1];
            }
            v[tam - 1] = primeiro;
        }
    }

}
