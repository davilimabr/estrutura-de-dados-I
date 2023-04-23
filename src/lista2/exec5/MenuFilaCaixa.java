package lista2.exec5;
import java.util.Scanner;

public class MenuFilaCaixa {
    private FilaCaixa filaCaixa;
    private Scanner scanner;

    public MenuFilaCaixa() {
        this.filaCaixa = new FilaCaixa();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcao = -1;
        while (opcao != 0) {
            exibirMenu();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarCliente();
                case 2 -> removerCliente();
                case 3 -> exibirFila();
                case 0 -> System.out.println("Saindo do programa...");
                default -> System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private void exibirMenu() {
        System.out.println();
        System.out.println("--- Fila de Caixa ---");
        System.out.println("1. Inserir cliente");
        System.out.println("2. Remover próximo cliente");
        System.out.println("3. Exibir fila");
        System.out.println("0. Encerrar");
        System.out.print("Opção: ");
    }

    private void adicionarCliente() {
        System.out.println("Informe o nome do cliente:");
        String nome = scanner.next();

        System.out.println("Informe a idade do cliente:");
        int idade = scanner.nextInt();

        Cliente cliente = new Cliente(nome, idade);

        if (filaCaixa.inserirCliente(cliente))
            System.out.println("Cliente adicionado à fila com sucesso!");
        else
            System.out.println("Não foi possível adicionar o cliente à fila.");
    }

    private void removerCliente() {
        Cliente cliente = filaCaixa.removerCliente();

        if (cliente != null)
            System.out.println("Cliente removido da fila: " + cliente.getNome() + " ("
                    + cliente.getFaixaEtaria().toString().toLowerCase() + ")");
        else
            System.out.println("Não há clientes na fila.");
    }

    private void exibirFila() {
        System.out.println("Clientes na Fila: ");
        System.out.println(filaCaixa.toString());
    }
}
