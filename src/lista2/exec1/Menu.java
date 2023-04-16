
package lista2.exec1;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private SistemaOperacional so;

    public Menu(){
        scanner = new Scanner(System.in);
        so = new SistemaOperacional();
    }

    public void exibirMenu(){
        int opcao;
        do {
            System.out.println("----- Menu de processos -----");
            System.out.println("1. Adicionar processo a fila de execução do SO");
            System.out.println("2. Executar processo (Remover da fila de execução)");
            System.out.println("3. Imprimir fila de processos do SO");
            System.out.println("4. Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> adicionarProcesso();
                case 2 -> executarProcesso();
                case 3 -> imprimirFilaProcessos();
                case 4 -> System.out.println("Saindo do programa...");
                default ->System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }

    private void executarProcesso(){
        Processo processo = so.removeProcesso();

        if (processo != null)
            System.out.println("Processo executado e removido da fila de execução do SO: " + processo);
        else
            System.out.println("Não há processos na fila de execução do SO.");
    }

    private void imprimirFilaProcessos(){
        System.out.println("Fila de processos do SO: " + so.toString());
    }

    private void adicionarProcesso(){
        Processo processo = criarProcessoDoUsuario();

        if (so.incluirProcesso(processo))
            System.out.println("Processo adicionado à fila de execução do SO: " + processo);
        else
            System.out.println("Não foi possível adicionar o processo à fila de execução do SO.");
    }

    private Processo criarProcessoDoUsuario(){
        System.out.print("Digite o ID do processo: ");
        int id = scanner.nextInt();

        System.out.print("Digite o nome do processo: ");
        String nome = scanner.next();

        return new Processo(id, nome);
    }
}

