package lista8.exec4;

import lista7.Classes.Arvbin;
import lista8.Classes.HeapBinariaMaxima;

public class Main4 {
    public static void main(String[] args){
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(3);

        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(2 );//qualquer altura
        heapMax.transformaHeapMaxima(arvore);

        arvore.imprimePreOrdem();
        System.out.println("");
        heapMax.imprime();
    }
}
