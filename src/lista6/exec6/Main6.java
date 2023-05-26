package lista6.exec6;

import lista6.Classes.ConjGenerico;

import java.util.Random;

public class Main6 {
    public static void main(String[] args){
        teste1();
        teste2();
        teste3();
        teste4();
        teste5();
    }

    public static void teste1(){
        int tam = 13;
        int[] numeros1 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
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

        System.out.println("\nEhIgual: " + conjunto1.eIgualRecursivo(conjunto2) + "\n\n");
    }

    public static void teste2(){
        int tam = 13;
        int[] numeros1 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 10;
        int[] numeros2 = {4,5,6,4,5,1,2,3,4,0};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("\nEhIgual: " + conjunto1.eIgualRecursivo(conjunto2)+ "\n\n");
    }

    public static void teste3(){
        int tam = 13;
        int[] numeros1 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 10;
        int[] numeros2 = {4,5,6,4,5,1,2,3,4,0};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        conjunto2.imprime();
        conjunto1.imprime();

        // a diferença desse teste para o anterior é que o segundo conjunto é o que chama o método
        System.out.println("\nEhIgual: " + conjunto2.eIgualRecursivo(conjunto1)+ "\n\n");
    }

    public static void teste4(){
        int tam = 1;
        int[] numeros1 = {4};
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

        System.out.println("\nEhIgual: " + conjunto1.eIgualRecursivo(conjunto2)+ "\n\n");
    }

    public static void teste5(){
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        conjunto1.imprime();
        conjunto2.imprime();

        System.out.println("\nEhIgual: " + conjunto1.eIgualRecursivo(conjunto2)+ "\n\n");
    }
}
