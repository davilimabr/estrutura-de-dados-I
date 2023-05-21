package lista5.exec2;

import lista5.Listas.ListaCircular;

public class Main2 {
    public static void main(String[] args){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        int[] l2 = {1,2323,3,44,5,666,9,123,456,786,78,234};

        ListaCircular lista1 = new ListaCircular();
        ListaCircular lista2 = new ListaCircular();

        for(int num : l1)
            lista1.insere(num);

        for(int num : l2)
            lista2.insere(num);

        System.out.println(lista1.merge(lista2));
    }
}
