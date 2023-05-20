package lista4.exec2;

import lista4.Listas.ListaGenericaOrdenada;

public class Main2 {
    public static void main(String[] args){
        ListaGenericaOrdenada<Integer> lista1 = new ListaGenericaOrdenada();
        lista1.insere(231);
        lista1.insere(-1);
        lista1.insere(235);
        lista1.insere(9);
        System.out.printf("Lista encadeada 1: %s\n",lista1);

        ListaGenericaOrdenada<Integer> lista2= new ListaGenericaOrdenada();
        lista2.insere(-32);
        lista2.insere(11);
        lista2.insere(0);
        lista2.insere(1);
        lista2.insere(-9999);
        System.out.printf("Lista encadeada 2: %s\n", lista2);

        ListaGenericaOrdenada<Integer> listasIntercaladas = lista1.intercalaListasOrdenadas(lista2);
        System.out.println(listasIntercaladas);
    }

    /*
    A complexidade do método que intercala as listas ordenadas é o intercalaListasOrdenadas, da classe ListaGenericaOrdenada, e possui complexidade O(n²+m²)
    sendo N a quantidadde de elos de uma das listas e M a quantidade de elos da outra lista, pois existem dois loops que percorrem cada um dos elos das duas listas e em cada um dos
    loops é chamado o método insere, que possui complexidade O(n).

    então temos: O(n) * O(n) + O(m) * O(m) = O(n²+m²)
     */
}
