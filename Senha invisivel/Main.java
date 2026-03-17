import java.io.Console;

public class senha {
    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.out.println("No console available");
            return;
        }
        char[] password = console.readPassword("Digite a senha: ");
        String pwd = new String(password);
        // Supondo que a senha correta seja "1234" para validação
        if (pwd.equals("1234")) {
            System.out.println("Senha correta!");
        } else {
            System.out.println("Senha incorreta!");
        }
    }
}
