package lista5.exec5;

import lista5.Listas.ListaDuplamente;
import org.junit.Assert;

public class Main5 {
    public static void main(String[] args){
        teste1();
        teste2();
        teste3();
        teste4();
    }

    public static void teste1(){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        int[] l2 = {1,2323,3,44,5,666,9,123,456,786,78,234};

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        for(int num : l1)
            lista1.insere(num);

        for(int num : l2)
            lista2.insere(num);

        boolean esperado = false;
        Assert.assertEquals(esperado, lista1.verificaIgualdade(lista2));
    }

    public static void teste2(){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        int[] l2 = {1,2,3,4,5,6,7,8,9};

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        for(int num : l1)
            lista1.insere(num);

        for(int num : l2)
            lista2.insere(num);

        boolean esperado = true;
        Assert.assertEquals(esperado, lista1.verificaIgualdade(lista2));
    }

    public static void teste3(){
        int[] l1 = {1,2,3,4,5,6,7,8,9};
        int[] l2 = null;

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        for(int num : l1)
            lista1.insere(num);

        boolean esperado = false;
        Assert.assertEquals(esperado, lista1.verificaIgualdade(lista2));
    }

    public static void teste4(){
        int[] l1 = {1};
        int[] l2 = {1};

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        for(int num : l1)
            lista1.insere(num);

        for(int num : l2)
            lista2.insere(num);

        boolean esperado = true;
        Assert.assertEquals(esperado, lista1.verificaIgualdade(lista2));
    }
}
