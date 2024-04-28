public class Matriz {
    private double[][] matriz;
    private int linhas;
    private int colunas;

    public Matriz(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        matriz = new double[linhas][colunas];
    }

    public void preencherMatriz(Scanner scanner) {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Digite o valor para a posição [" + (i + 1) + "][" + (j + 1) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }
    }

    public void exibirDiagonalPrincipal() {
        System.out.println("Valores da diagonal principal:");
        for (int i = 0; i < Math.min(linhas, colunas); i++) {
            System.out.println(matriz[i][i]);
        }
    }

    public void exibirDiagonalSecundaria() {
        System.out.println("Valores da diagonal secundária:");
        for (int i = 0; i < Math.min(linhas, colunas); i++) {
            System.out.println(matriz[i][colunas - i - 1]);
        }
    }

    public void exibirMatrizTransposta() {
        System.out.println("Matriz transposta:");
        for (int j = 0; j < colunas; j++) {
            for (int i = 0; i < linhas; i++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
