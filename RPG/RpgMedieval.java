import java.util.Random;
import java.util.Scanner;

public class RpgMedieval {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        System.out.println("BEM-VINDO AO RPG MEDIEVAL");
        System.out.print("Digite o nome do seu heroi: ");
        String nomeHeroi = scanner.nextLine();

        int vidaHeroi = 100;
        int vidaInimigo = 80;
        int pocoes = 3;

        System.out.println("\nUm inimigo apareceu no campo de batalha!");
        System.out.println("Prepare-se, " + nomeHeroi + "!\n");

        while (vidaHeroi > 0 && vidaInimigo > 0) {

            System.out.println("Sua vida: " + vidaHeroi);
            System.out.println("Vida do inimigo: " + vidaInimigo);
            System.out.println("Pocoes restantes: " + pocoes);

            System.out.println("\nEscolha uma acao:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar pocao");

            int escolha = scanner.nextInt();

            if (escolha == 1) {
                int dano = random.nextInt(15) + 5;
                vidaInimigo -= dano;
                System.out.println("\nVoce atacou e causou " + dano + " de dano!");
            } else if (escolha == 2 && pocoes > 0) {
                int cura = random.nextInt(20) + 10;
                vidaHeroi += cura;
                pocoes--;
                System.out.println("\nVoce usou uma pocao e recuperou " + cura + " de vida!");
            } else {
                System.out.println("\nAcao invalida!");
            }

            if (vidaInimigo > 0) {
                int danoInimigo = random.nextInt(12) + 5;
                vidaHeroi -= danoInimigo;
                System.out.println("O inimigo atacou e causou " + danoInimigo + " de dano!");
            }

            System.out.println("\n-----------------------------\n");
        }

        if (vidaHeroi > 0) {
            System.out.println("PARABENS, " + nomeHeroi + "!");
            System.out.println("Voce venceu a batalha e salvou o reino!");
        } else {
            System.out.println("Voce foi derrotado...");
            System.out.println("O reino caiu nas sombras.");
        }
    }
}
