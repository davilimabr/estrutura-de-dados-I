package lista1.exec8;

import lista1.exec4.PilhaGenerica;

public class Main08 {
    public static void main(String[] args) {
        int numeroMaximoDaSequencia = 10;

        SequenciaNumerica sequencia = new SequenciaNumerica(numeroMaximoDaSequencia);

        printarParesUnicos(sequencia.obterParesUnicos());
    }
    public static void printarParesUnicos(PilhaGenerica<PilhaGenerica<Integer>> paresUnicos) {
        while (!paresUnicos.vazia()) {
            PilhaGenerica<Integer> subSequences = paresUnicos.pop();
            System.out.printf("(%d, %d)   ", subSequences.pop(), subSequences.pop());
        }

        System.out.printf("\nexistem %d pares unicos que satisfazem os critérios definidos", paresUnicos.quantidadeElementos());
    }
}
