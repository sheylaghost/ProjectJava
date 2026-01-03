import java.util.Scanner;

class Loja {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Produto p = new Produto();

        System.out.print("Nome do produto: ");
        p.nome = sc.nextLine();

        System.out.print("Preço do produto: ");
        p.preco = sc.nextDouble();

        System.out.print("Quantidade em estoque: ");
        p.quantidade = sc.nextInt();

        System.out.println();
        System.out.println("Dados do produto: " + p);

        System.out.println();
        System.out.print("Digite o número de produtos a adicionar no estoque: ");
        int add = sc.nextInt();
        p.adicionarProdutos(add);

        System.out.println("Dados atualizados: " + p);

        System.out.println();
        System.out.print("Digite o número de produtos a remover do estoque: ");
        int remove = sc.nextInt();
        p.removerProdutos(remove);

        System.out.println("Dados atualizados: " + p);

        sc.close();
    }
}

public class Produto {
    String nome;
    double preco;
    int quantidade;

    double valorTotalEmEstoque() {
        return preco * quantidade;
    }

    void adicionarProdutos(int quantidade) {
        this.quantidade += quantidade;
    }

    void removerProdutos(int quantidade) {
        this.quantidade -= quantidade;
    }

    public String toString() {
        return nome
                + ", R$ "
                + String.format("%.2f", preco)
                + ", "
                + quantidade
                + " unidades, Total: R$ "
                + String.format("%.2f", valorTotalEmEstoque());
    }
}