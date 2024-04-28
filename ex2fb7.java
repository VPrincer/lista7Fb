import java.util.Scanner;

public class QuadradoMagico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Criando a matriz 3x3
        int[][] matriz = new int[3][3];
        
        // Preenchendo a matriz
        System.out.println("Digite os valores da matriz 3x3:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Digite o valor para a posição [" + (i+1) + "][" + (j+1) + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }
        
        // Verificando se é um quadrado mágico
        if (verificarQuadradoMagico(matriz)) {
            System.out.println("A matriz é um quadrado mágico!");
        } else {
            System.out.println("A matriz NÃO é um quadrado mágico.");
        }
        
        scanner.close();
    }
    
    public static boolean verificarQuadradoMagico(int[][] matriz) {
        int somaPrincipal = 0;
        int somaSecundaria = 0;
        
        // Calculando a soma da diagonal principal e secundária
        for (int i = 0; i < 3; i++) {
            somaPrincipal += matriz[i][i];
            somaSecundaria += matriz[i][2 - i];
        }
        
        // Verificando se a soma da diagonal principal e secundária são iguais
        if (somaPrincipal != somaSecundaria) {
            return false;
        }
        
        // Verificando as somas das linhas e colunas
        for (int i = 0; i < 3; i++) {
            int somaLinha = 0;
            int somaColuna = 0;
            for (int j = 0; j < 3; j++) {
                somaLinha += matriz[i][j];
                somaColuna += matriz[j][i];
            }
            if (somaLinha != somaPrincipal || somaColuna != somaPrincipal) {
                return false;
            }
        }
        
        return true;
    }
}
