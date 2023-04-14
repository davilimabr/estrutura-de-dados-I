package lista1.exec3;

import java.util.Scanner;

public class MenuPilhas {
    private final int TAMANHO_PILHA_DUPLA = 5;
    private PilhaDuplaDeInteiros pilhaDupla;
    private Scanner scanner;

    public MenuPilhas(){
        pilhaDupla = new PilhaDuplaDeInteiros(TAMANHO_PILHA_DUPLA);
        scanner = new Scanner(System.in);
    }

    public void mostrar(){
        int opcao;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("----- Menu de Pilhas -----");
            System.out.println("1. Push (inserir) na Pilha1");
            System.out.println("2. Pop (remover) da Pilha1");
            System.out.println("3. Push (inserir) na Pilha2");
            System.out.println("4. Pop (remover) da Pilha2");
            System.out.println("5. Mostrar conteúdo das Pilhas");
            System.out.println("6. Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> pushPilha1();
                case 2 -> popPilha1();
                case 3 -> pushPilha2();
                case 4 -> popPilha2();
                case 5 -> System.out.println("Conteúdo das Pilhas: \n" + pilhaDupla.toString());
                case 6 -> System.out.println("Saindo do programa...");
                default ->System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 6);

        scanner.close();
    }

    private void pushPilha1(){
        System.out.print("Digite o valor a ser inserido na Pilha1: ");

        int valorPilha1 = scanner.nextInt();
        boolean resultado = pilhaDupla.pushPilha1(valorPilha1);

        if(resultado)
            System.out.println("Valor " + valorPilha1 + " inserido na Pilha1.");
        else
            System.out.println("Pilhas cheias");
    }

    private void popPilha1(){
        int valorRemovido = pilhaDupla.popPilha1();

        if(valorRemovido > Integer.MIN_VALUE)
            System.out.println("Valor " + valorRemovido + " removido da Pilha1.");
        else
            System.out.println("Pilha1 está vazia.");
    }

    private void pushPilha2(){
        System.out.print("Digite o valor a ser inserido na Pilha2: ");
        int valorPilha2 = scanner.nextInt();
        boolean resultado = pilhaDupla.pushPilha2(valorPilha2);
        if(resultado)
            System.out.println("Valor " + valorPilha2 + " inserido na Pilha2.");
        else
            System.out.println("Pilhas cheias");
    }

    private void popPilha2(){
        int valorRemovido = pilhaDupla.popPilha2();

        if(valorRemovido > Integer.MIN_VALUE)
            System.out.println("Valor " + valorRemovido + " removido da Pilha2.");
        else
            System.out.println("Pilha2 está vazia.");
    }
}


