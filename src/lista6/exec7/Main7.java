package lista6.exec7;

import lista6.Classes.ConjGenerico;

public class Main7 {
    public static void main(String[] args) throws Exception {
        teste1();
    }
    public static void teste1() throws Exception{
        int tam = 4;
        int[] numeros1 = {1,2,5,6};
        ConjGenerico<Integer> conjunto1 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto1.insere(numeros1[i]);

        tam = 4;
        int[] numeros2 = {3,7,9,10};
        ConjGenerico<Integer> conjunto2 = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            conjunto2.insere(numeros2[i]);

        tam = 10;
        int[] numeros3 = {1,2,3,4,5,6,7,8,9,10};
        ConjGenerico<Integer> universo = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++)
            universo.insere(numeros3[i]);


        conjunto1.imprime();
        conjunto2.imprime();
        universo.imprime();

        System.out.println("\nLei de Morgan: ");
        ConjGenerico.aplicaDeMorgan(universo,conjunto1,conjunto2).imprime();
    }
}

