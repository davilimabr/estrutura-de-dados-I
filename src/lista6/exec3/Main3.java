package lista6.exec3;

import lista6.Classes.ConjGenerico;

public class Main3 {
    public static void main(String[] args) throws Exception {
        teste1();
        teste2(); // lança uma exceção pq o universo é vazio
        teste3(); // lança uma exceção pq o conjunto que chama o método possui elementos fora do universo é vazio
        teste4();
        teste5(); // lança uma exceção pq o conjunto que chama o método possui elementos fora do universo é vazio
    }

    public static void teste1() throws Exception {
        int tam = 3;
        int[] numeros1 = {4,5,6};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 11;
        int[] numeros2 = {4,5,6,73,5,1,2,3,8,9,0};
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            universo.insere(numeros2[i]);

        conjunto1.imprime();
        universo.imprime();

        ConjGenerico<Integer> complementar = conjunto1.complementar(universo);
        complementar.imprime();
    }

    public static void teste2() throws Exception {
        int tam = 3;
        int[] numeros1 = {4,5,6};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        ConjGenerico<Integer> universo = new ConjGenerico<>();

        conjunto1.imprime();
        universo.imprime();

        ConjGenerico<Integer> complementar = conjunto1.complementar(universo);
        complementar.imprime();
    }

    public static void teste3() throws Exception {
        int tam = 4;
        int[] numeros1 = {4,5,6,999};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 13;
        int[] numeros2 = {4,5,6,73,4,5,1,2,3,4,8,9,0};
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            universo.insere(numeros2[i]);

        conjunto1.imprime();
        universo.imprime();

        ConjGenerico<Integer> complementar = conjunto1.complementar(universo);
        complementar.imprime();
    }

    public static void teste4() throws Exception {
        int tam = 1;
        int[] numeros1 = {2};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 2;
        int[] numeros2 = {1,2};
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            universo.insere(numeros2[i]);

        conjunto1.imprime();
        universo.imprime();

        ConjGenerico<Integer> complementar = conjunto1.complementar(universo);
        complementar.imprime();
    }

    public static void teste5() throws Exception {
        int tam = 3;
        int[] numeros1 = {0,1,2};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 2;
        int[] numeros2 = {1,2};
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            universo.insere(numeros2[i]);

        conjunto1.imprime();
        universo.imprime();

        ConjGenerico<Integer> complementar = conjunto1.complementar(universo);
        complementar.imprime();
    }
}
