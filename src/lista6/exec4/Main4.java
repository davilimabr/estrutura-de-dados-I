package lista6.exec4;

import lista6.Classes.ConjGenerico;

public class Main4 {
    public static void main(String[] args){

        teste1();
        teste2();
        teste3();
        teste4();
        teste5();

    }

    public static void teste1(){
        int tam = 3;
        int[] numeros1 = {73,9,6};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 13;
        int[] numeros2 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("EhSubconjunto: " + conjunto1.eSubconjunto(conjunto2) + "\n\n");
    }

    public static void teste2(){
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("EhSubconjunto: " + conjunto1.eSubconjunto(conjunto2) + "\n\n");
    }

    public static void teste3(){
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        int tam = 13;
        int[] numeros2 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("EhSubconjunto: " + conjunto1.eSubconjunto(conjunto2) + "\n\n");
    }

    public static void teste4(){
        int tam = 4;
        int[] numeros1 = {9999,99999,9999,0};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 13;
        int[] numeros2 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("EhSubconjunto: " + conjunto1.eSubconjunto(conjunto2) + "\n\n");
    }

    public static void teste5(){
        int tam = 4;
        int[] numeros1 = {9999,99999,9999,0};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 1;
        int[] numeros2 = {4};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("EhSubconjunto: " + conjunto1.eSubconjunto(conjunto2) + "\n\n");
    }
}
