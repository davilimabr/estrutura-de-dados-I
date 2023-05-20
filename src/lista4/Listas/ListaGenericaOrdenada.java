package lista4.Listas;

public class ListaGenericaOrdenada<T extends Comparable<T>> extends ListaGenericaComparavel<T> {
    /*
         Complexidade O(n), pois, no pior dos casos, o loop repete n vezes. Sendo n a quantidade de elos presente na lista.
         OBS: A depender da implementação do métodos compareTo (do tipo de objeto especificado no generics), a complexidade pode ser maior.
     */
    @Override
    public void insere(T novo)
    {
        Elo p, q;
        Elo ant = null;
        q = new Elo(novo);

        for (p = prim; ((p != null) && (p.dado.compareTo(novo) < 0)); p = p.prox)
            ant = p;

        if (ant == null)
            prim = q;
        else
            ant.prox = q;

        q.prox = p;
    }

    //Complexidade O(n), a explicação e observação anteriores são válidas aqui
    @Override
    public boolean remove(T elem)
    {
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado.compareTo(elem) < 0)); p = p.prox)
            ant = p;

        if ((p == null) || (!p.dado.equals(elem)))
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    }

    //Complexidade O(n²+m²)
    public ListaGenericaOrdenada intercalaListasOrdenadas(ListaGenericaOrdenada lista) {
        ListaGenericaOrdenada<T> resultado = new ListaGenericaOrdenada();

        for (Elo<T> p = prim; p != null; p = p.prox)
            resultado.insere(p.dado);

        for (Elo<T> p = lista.prim; p != null; p = p.prox)
            resultado.insere(p.dado);

        return resultado;
    }
}