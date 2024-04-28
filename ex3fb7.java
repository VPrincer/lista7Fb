import java.util.Scanner;

public class JogoDaVelha {
    private char[][] tabuleiro;
    private char jogadorAtual;

    public JogoDaVelha() {
        tabuleiro = new char[3][3];
        jogadorAtual = 'X'; // Começa com o jogador X
        inicializarTabuleiro();
    }

    // Método para inicializar o tabuleiro com espaços em branco
    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    // Método para imprimir o tabuleiro
    public void imprimirTabuleiro() {
        System.out.println("  1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Método para verificar se houve um vencedor ou se o jogo empatou
    public char verificarVencedor() {
        // Verificar linhas
        for (int i = 0; i < 3; i++) {
            if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2] && tabuleiro[i][0] != ' ') {
                return tabuleiro[i][0];
            }
        }
        // Verificar colunas
        for (int j = 0; j < 3; j++) {
            if (tabuleiro[0][j] == tabuleiro[1][j] && tabuleiro[1][j] == tabuleiro[2][j] && tabuleiro[0][j] != ' ') {
                return tabuleiro[0][j];
            }
        }
        // Verificar diagonal principal
        if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != ' ') {
            return tabuleiro[0][0];
        }
        // Verificar diagonal secundária
        if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != ' ') {
            return tabuleiro[0][2];
        }
        // Verificar empate
        boolean empate = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    empate = false;
                    break;
                }
            }
            if (!empate) {
                break;
            }
        }
        if (empate) {
            return 'E'; // Empate
        }
        // Nenhum vencedor ainda
        return ' ';
    }

    // Método para realizar uma jogada
    public boolean fazerJogada(int linha, int coluna) {
        if (linha < 0 || linha >= 3 || coluna < 0 || coluna >= 3 || tabuleiro[linha][coluna] != ' ') {
            return false; // Jogada inválida
        }
        tabuleiro[linha][coluna] = jogadorAtual;
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X'; // Alternar jogador
        return true; // Jogada válida
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JogoDaVelha jogo = new JogoDaVelha();

        System.out.println("Bem-vindo ao Jogo da Velha!");

        char vencedor = ' ';
        while (vencedor == ' ') {
            // Imprimir tabuleiro
            jogo.imprimirTabuleiro();

            // Solicitar jogada do jogador atual
            int linha, coluna;
            do {
                System.out.print("Jogador " + jogo.jogadorAtual + ", digite a linha (1-3) e coluna (1-3) da sua jogada separadas por espaço: ");
                linha = scanner.nextInt() - 1;
                coluna = scanner.nextInt() - 1;
            } while (!jogo.fazerJogada(linha, coluna));

            // Verificar se houve um vencedor
            vencedor = jogo.verificarVencedor();
        }

        // Imprimir tabuleiro final
        jogo.imprimirTabuleiro();

        // Imprimir resultado
        if (vencedor == 'E') {
            System.out.println("O jogo empatou!");
        } else {
            System.out.println("O jogador " + vencedor + " venceu!");
        }

        scanner.close();
    }
}
