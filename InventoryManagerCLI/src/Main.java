import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== SISTEMA DE CONTROLE DE ESTOQUE ===");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Estoque");
            System.out.println("4. Buscar Produto");
            System.out.println("5. Remover Produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    estoque.adicionarProduto(new Produto(nome, quantidade, preco));
                    System.out.println("Produto adicionado!");
                    break;

                case 2:
                    estoque.listarProdutos();
                    break;

                case 3:
                    System.out.print("Nome do Produto para atualizar: ");
                    String nomeAtualizar = scanner.nextLine();
                    Produto p = estoque.buscarProduto(nomeAtualizar);
                    if (p != null) {
                        System.out.print("Nova Quantidade: ");
                        int novaQuantidade = scanner.nextInt();
                        System.out.print("Novo Preço: ");
                        double novoPreco = scanner.nextDouble();
                        p.setQuantidade(novaQuantidade);
                        p.setPreco(novoPreco);
                        System.out.println("Produto atualizado!");
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Nome do Produto para buscar: ");
                    String nomeBuscar = scanner.nextLine();
                    Produto produto = estoque.buscarProduto(nomeBuscar);
                    if (produto != null) {
                        System.out.println(produto);
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 5:
                    System.out.print("Nome do Produto para remover: ");
                    String nomeRemover = scanner.nextLine();
                    estoque.removerProduto(nomeRemover);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
