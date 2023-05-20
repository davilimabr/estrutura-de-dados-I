package lista4.exec3;

import lista4.Listas.ListaGenericaOrdenada;

import java.util.Scanner;

public class Menu {
    private ListaGenericaOrdenada<String> lista;

    public Menu(){
        this.lista = new ListaGenericaOrdenada<>();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> inserirElemento(scanner);
                case 2 -> removerElemento(scanner);
                case 3 -> listarElementos();
                case 4 -> System.out.println("Saindo do programa.");
                default -> System.out.println("Opção inválida. Digite novamente.");
            }
        } while (opcao != 4);
    }

    private void exibirMenu() {
        System.out.println("------ MENU ------");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Listar elementos");
        System.out.println("4. Sair");
        System.out.println("Digite o número da opção desejada: ");
    }

    private void inserirElemento(Scanner scanner) {
        System.out.println("Digite a string a ser inserida:");
        String novo = scanner.nextLine();
        lista.insere(novo);
        System.out.println("Elemento inserido com sucesso.");
    }

    private void removerElemento(Scanner scanner) {
        System.out.println("Digite a string a ser removida:");
        String elem = scanner.nextLine();
        boolean removido = lista.remove(elem);

        if (removido) {
            System.out.println("Elemento removido com sucesso.");
        } else {
            System.out.println("Elemento não encontrado na lista.");
        }
    }

    private void listarElementos() {
        System.out.println("------ ELEMENTOS DA LISTA ------");
        System.out.println(lista.toString());
    }
}