package lista8.exec2;

import lista8.Classes.HeapBinariaMaxima;
import lista8.Classes.HeapBinariaMinima;

public class Main2 {
    public static void main(String[] args){
        int tam = 7;
        int[] vetor = {77, 71,55,40,30,23,16};

        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(tam, vetor);
        HeapBinariaMinima heapMin = new HeapBinariaMinima(heapMax);

        heapMin.imprime();
    }
}
