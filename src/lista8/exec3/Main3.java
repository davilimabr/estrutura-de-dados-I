package lista8.exec3;

import lista8.Classes.HeapBinariaMaxima;
import lista8.Classes.HeapBinariaMinima;

public class Main3 {
    public static void main(String[] args){
        int tam = 7;
        int[] vetor = {16,30, 23, 40, 71, 77, 55};

        HeapBinariaMinima heapMin = new HeapBinariaMinima(tam, vetor);
        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(heapMin);

        heapMax.imprime();
    }
}
