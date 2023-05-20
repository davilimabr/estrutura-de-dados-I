package lista4.Listas;

public class ListaGenericaComparavel<T extends Comparable<T>>{
    protected Elo prim;

    protected class Elo<T extends Comparable<T>>{
        protected T dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public ListaGenericaComparavel(){
        prim = null;
    }

    //Complexidade O(1), constante.
    public void insere(T novo){
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
    }

    //Complexidade O(n), pois, no pior dos casos, o loop repete n vezes. Sendo n a quantidade de elos presente na lista.
    public boolean remove(T elem){
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado.equals(elem))); p = p.prox)
            ant = p;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        return true;
    }

    /*
        Complexidade O(n), pois o loop sempre se repete n vezes. Sendo n a quantidade de elos presente na lista.
        OBS: Essa complexidade leva em consideração que o toString da Classe do dado, seja constante, caso essa complexidade seja diferente, a complexidade do método abaixo será
        diferente também. Sendo: O(n*x), x = complexidade do toString da classe dado.
     */
    @Override
    public String toString(){
        String string = "";

        for(Elo p = prim; p != null; p = p.prox)
            string += p.dado.toString() + " ";

        return string;
    }
}
