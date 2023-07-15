package lista8.exec6;

import lista8.Classes.HeapBinariaMaxima;
import lista8.Classes.HeapBinariaMinima;

public class Main6 {
    public static void main(String[] args){
        int tam = 7;
        int[] vetor = {77, 71,55,40,30,23,16};

        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(tam, vetor);
        heapMax.imprime();

        System.out.println("Foi revomido: " + heapMax.remove(3));
        heapMax.imprime();

        System.out.println("Foi revomido: " + heapMax.remove(1));
        heapMax.imprime();

        System.out.println("Foi revomido: " + heapMax.remove(5));
        heapMax.imprime();
    }
}
