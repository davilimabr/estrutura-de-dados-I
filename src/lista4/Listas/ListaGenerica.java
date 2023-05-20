package lista4.Listas;

import java.util.Objects;

public class ListaGenerica<T>{
    protected Elo<T> prim;
    protected int quantidadeElos;

    protected class Elo<T>{
        protected T dado;
        protected Elo<T> prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(T elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(T elem, Elo<T> proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public ListaGenerica(){
        prim = null;
        quantidadeElos = 0;
    }

    public boolean vazia()
    {
        return prim == null;
    }

    //Complexidade O(1), constante.
    public void insere(T novo){
        Elo<T> p = new Elo(novo);
        p.prox = prim;
        prim = p;
        this.quantidadeElos++;
    }

    //Complexidade O(n), pois, no pior dos casos, o loop repete n vezes. Sendo n a quantidade de elos presente na lista.
    public boolean remove(T elem){
        Elo<T> p;
        Elo<T> ant = null;

        for(p = prim; ((p != null) && (!p.dado.equals(elem))); p = p.prox)
            ant = p;

        if (p == null)
            return false;

        if (p == prim)
            prim = prim.prox;
        else
            ant.prox = p.prox;

        p = null;

        this.quantidadeElos--;
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

        for(Elo<T> p = prim; p != null; p = p.prox)
            string += p.dado.toString() + " ";

        return string;
    }

    public String toString(String separador){
        String string = "";

        for(Elo<T> p = prim; p != null; p = p.prox)
            string += p.dado.toString() + separador;

        return string;
    }

    // Complexidade O(n). Percorre todos os N elos da lista e depois chama o método toString, que tembém possui complexidade O(n), obtendo assim, complexidade O(2n), que ignorando
    // a constante multiplicativa, temos O(n).
    public String toStringInvertida(){
       ListaGenerica<T> listaAuxiliar = new ListaGenerica<>();

       for(Elo<T> p = prim; p != null; p = p.prox)
           listaAuxiliar.insere(p.dado);

       return listaAuxiliar.toString();
    }

    // O(1), constante
    public int tamanho()
    {
        return quantidadeElos;
    }
}
