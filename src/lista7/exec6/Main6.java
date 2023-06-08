package lista7.exec6;

import lista7.Classes.Arvbin;

public class Main6 {
    public static void main(String[] args){
        teste1();
        teste2();
    }

    public static void teste1(){
        Arvbin<Integer> no1 = new Arvbin<>(4);
        Arvbin<Integer> no2 = new Arvbin<>(2, null, no1);

        Arvbin<Integer> no3 = new Arvbin<>(7);
        Arvbin<Integer> no4 = new Arvbin<>(8);
        Arvbin<Integer> no5 = new Arvbin<>(5, no3, no4);
        Arvbin<Integer> no6 = new Arvbin<>(6);
        Arvbin<Integer> no7 = new Arvbin<>(3, no5, no6);

        Arvbin<Integer> raiz = new Arvbin<>(1, no2, no7);

        raiz.mostra();

        System.out.println("E balanciada: " + raiz.eBalanceada());
    }

    public static void teste2(){
        Arvbin<Integer> no1 = new Arvbin<>(6);
        Arvbin<Integer> no2 = new Arvbin<>(7);
        Arvbin<Integer> no3 = new Arvbin<>(4, no1, no2);

        Arvbin<Integer> no4 = new Arvbin<>(5);

        Arvbin<Integer> no5 = new Arvbin<>(3, no3, no4);

        Arvbin<Integer> no6 = new Arvbin<>(2);
        Arvbin<Integer> raiz = new Arvbin<>(1, no6, no5);

        raiz.mostra();

        System.out.println("E balanciada: " + raiz.eBalanceada());
    }
}
