import java.util.Scanner;

public class Agenda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] agenda = new String[31][24]; // Matriz para armazenar os compromissos do mês

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Adicionar compromisso");
            System.out.println("2 - Consultar compromisso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCompromisso(agenda, scanner);
                    break;
                case 2:
                    consultarCompromisso(agenda, scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    public static void adicionarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1-31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora do compromisso (0-23): ");
        int hora = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do teclado
        System.out.print("Digite o compromisso: ");
        String compromisso = scanner.nextLine();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            agenda[dia - 1][hora] = compromisso;
            System.out.println("Compromisso adicionado com sucesso!");
        } else {
            System.out.println("Dia ou hora inválida.");
        }
    }

    public static void consultarCompromisso(String[][] agenda, Scanner scanner) {
        System.out.print("Digite o dia do mês (1-31): ");
        int dia = scanner.nextInt();
        System.out.print("Digite a hora do compromisso (0-23): ");
        int hora = scanner.nextInt();

        if (dia >= 1 && dia <= 31 && hora >= 0 && hora <= 23) {
            String compromisso = agenda[dia - 1][hora];
            if (compromisso != null) {
                System.out.println("Compromisso encontrado: " + compromisso);
            } else {
                System.out.println("Nenhum compromisso agendado para essa hora.");
            }
        } else {
            System.out.println("Dia ou hora inválida.");
        }
    }
}
