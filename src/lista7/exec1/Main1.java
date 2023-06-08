package lista7.exec1;

import lista7.Classes.Arvbin;

import java.util.Random;

public class Main1 {
    public static void main(String[] args){
        Random random = new Random();

        Arvbin<Integer> no1 = new Arvbin<>(random.nextInt(100));
        Arvbin<Integer> no2 = new Arvbin<>(random.nextInt(100));
        Arvbin<Integer> no3 = new Arvbin<>(random.nextInt(100));
        Arvbin<Integer> no4 = new Arvbin<>(random.nextInt(100));
        Arvbin<Integer> no5 = new Arvbin<>(random.nextInt(100));

        no1.defineEsq(no2);
        no1.defineDir(no3);
        no2.defineEsq(no4);
        no2.defineDir(no5);

        Arvbin<Integer> no6 = new Arvbin<>(random.nextInt(100));
        Arvbin<Integer> no7 = new Arvbin<>(random.nextInt(100));

        no3.defineEsq(no6);
        no3.defineDir(no7);

        no1.mostra();


        System.out.println("\n");
        no1.imprimePreOrdem();
        System.out.println("\n");
        no1.imprimeEmOrdem();
        System.out.println("\n");
        no1.imprimePosOrdem();
    }

}
