import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaAgendamento {

    static List<Agendamento> agendamentos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        System.out.println("Bem-vindos ao Sistema de Agendamento Salon!");

        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Novo agendamento");
            System.out.println("2 - Listar agendamentos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine(); // limpar buffer

                    System.out.print("Nome do cliente: ");
                    String cliente = scanner.nextLine();

                    System.out.print("Serviço: ");
                    String servico = scanner.nextLine();

                    System.out.print("Data (dd/mm/aaaa): ");
                    String data = scanner.nextLine();

                    System.out.print("Horário (hh:mm): ");
                    String horario = scanner.nextLine();

                    if (horarioJaExiste(data, horario)) {
                        System.out.println(" Horário indisponível para essa data.");
                    } else {
                        Agendamento novo = new Agendamento(cliente, servico, data, horario);
                        agendamentos.add(novo);
                        System.out.println(" Agendamento realizado com sucesso!");
                    }
                    break;

                case 2:
                    if (agendamentos.isEmpty()) {
                        System.out.println("Nenhum agendamento cadastrado.");
                    } else {
                        System.out.println("\nAgendamentos:");
                        for (Agendamento a : agendamentos) {
                            System.out.println(a);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Encerrando sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 3);

        scanner.close();
    }

    private static boolean horarioJaExiste(String data, String horario) {
        for (Agendamento a : agendamentos) {
            if (a.getData().equals(data) && a.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }
}
