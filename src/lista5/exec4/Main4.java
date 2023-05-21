package lista5.exec4;

import lista5.Listas.ListaDuplamente;

public class Main4 {
    public static void main(String[] args){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        ListaDuplamente lista1 = new ListaDuplamente();

        for(int num : l1)
            lista1.insere(num);

        lista1.trocaElos(3,6);
        System.out.println(lista1);
    }
}
