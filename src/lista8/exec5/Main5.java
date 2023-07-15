package lista8.exec5;

import lista7.Classes.Arvbin;
import lista8.Classes.HeapBinariaMaxima;
import lista8.Classes.HeapBinariaMinima;

public class Main5 {
    public static void main(String[] args){
         teste1(); // é heap max
         teste2(); // NAO é heap max
    }

    public static void teste1(){
        int tam = 7;
        int[] arvore = new int[tam+1];
        arvore[1] = 77;
        arvore[2] = 71;
        arvore[3] = 55;
        arvore[4] = 40;
        arvore[5] = 30;
        arvore[6] = 23;
        arvore[7] = 16;

        if(HeapBinariaMaxima.verificaPropriedadeHeap(arvore))
            System.out.println("E uma heap max");
        else
            System.out.println("NAO é uma heap max");
    }

    public static void teste2(){
        int tam = 7;
        int[] arvore = new int[tam+1];
        arvore[1] = 77;
        arvore[2] = 71;
        arvore[3] = 55;
        arvore[4] = 9999999;
        arvore[5] = 30;
        arvore[6] = 23;
        arvore[7] = 16;

        if(HeapBinariaMaxima.verificaPropriedadeHeap(arvore))
            System.out.println("E uma heap max");
        else
            System.out.println("NAO é uma heap max");
    }
}
