package lista6.exec5;

import lista6.Classes.ConjGenerico;

public class Main5 {
    public static void main(String[] args){
        teste1();
        teste2();
        teste3();
        teste4();
        teste5();
    }
    public static void teste1(){
        int tam = 6;
        int[] numeros1 = {10000,999999,1, 8,3,4};
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

        ConjGenerico<Integer> diferenca = conjunto1.diferenca(conjunto2);
        diferenca.imprime();
        System.out.println("\n\n");
    }

    public static void teste2(){
        int tam = 3;
        int[] numeros1 = {1,2,3};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 3;
        int[] numeros2 = {1,2,3};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        ConjGenerico<Integer> diferenca = conjunto1.diferenca(conjunto2);
        diferenca.imprime();
        System.out.println("\n\n");

    }

    public static void teste3(){
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        int tam = 3;
        int[] numeros2 = {1,2,3};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        ConjGenerico<Integer> diferenca = conjunto1.diferenca(conjunto2);
        diferenca.imprime();
        System.out.println("\n\n");
    }

    public static void teste4(){
        int tam = 6;
        int[] numeros1 = {10000,999999,1, 8,3,4};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        conjunto1.imprime();
        conjunto2.imprime();

        ConjGenerico<Integer> diferenca = conjunto1.diferenca(conjunto2);
        diferenca.imprime();
        System.out.println("\n\n");
    }

    public static void teste5(){
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        conjunto1.imprime();
        conjunto2.imprime();

        ConjGenerico<Integer> diferenca = conjunto1.diferenca(conjunto2);
        diferenca.imprime();
        System.out.println("\n\n");
    }
}
