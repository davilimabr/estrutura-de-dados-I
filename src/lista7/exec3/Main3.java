package lista7.exec3;

import lista7.Classes.Arvbin;

public class Main3 {
    public static void main(String[] args) {
        teste1();
        teste2();
        teste3();
    }

    public static void teste1() {
        // arvore balanceada
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(4);

        // arvore degenerada
        Arvbin<Integer> no1 = new Arvbin<>(54);
        Arvbin<Integer> no2 = new Arvbin<>(66);
        Arvbin<Integer> no3 = new Arvbin<>(88, no1,no2);
        Arvbin<Integer> no4 = new Arvbin<>(63);
        Arvbin<Integer> no5 = new Arvbin<>(46, no4, null);

        Arvbin<Integer> raiz = new Arvbin<>(13, no3, no5);

        arvore.mostra();
        System.out.println("");
        raiz.mostra();
        boolean resultado = arvore.eSimilar(raiz);
        System.out.println("\nTeste 1 - Resultado: " + resultado);
    }

    public static void teste2() {
        // arvore balanceada
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(4);

        // arvore balanceada
        Arvbin<Integer> arvore2 = Arvbin.criarArvoreDeInteirosDeAltura(4);

        arvore.mostra();
        System.out.println("");

        arvore2.mostra();
        boolean resultado = arvore.eSimilar(arvore2);
        System.out.println("\neste 2 - Resultado: " + resultado);
    }

    public static void teste3() {
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(4);

        arvore.mostra();
        boolean resultado = arvore.eSimilar(null);
        System.out.println("\nTeste 3 - Resultado: " + resultado);
    }
}
