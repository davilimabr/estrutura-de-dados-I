package lista5.exec3;

import lista5.Listas.ListaCircular;

public class Main3 {
    public static void main(String[] args){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        ListaCircular lista1 = new ListaCircular();

        for(int num : l1)
            lista1.insere(num);

        System.out.printf("Lista: %s\n",lista1);
        System.out.printf("Lista Invertida: %s",lista1.inverteLista());
    }
}
