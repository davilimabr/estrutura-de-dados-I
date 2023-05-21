package lista5.Listas;
public class ListaDuplamenteGenerica<T>
{
    protected Elo<T> prim;
    protected int quantidadeElos;

    protected class Elo<T>{
        protected T dado;
        protected Elo<T> ant;
        protected Elo<T> prox;

        public Elo() {
            ant = null;
            prox = null;
        }

        public Elo(T elem) {
            dado = elem;
            ant = null;
            prox = null;
        }

        public Elo(T elem, Elo<T> antElem, Elo<T> proxElem) {
            dado = elem;
            ant = antElem;
            prox = proxElem;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Elo<T> elo = (Elo<T>) o;
            return dado == elo.dado;
        }
    }

    public ListaDuplamenteGenerica(){
        prim = null;
        quantidadeElos = 0;
    }

    public boolean vazia() {
        return prim == null;
    }

    public void insere(T novo){
        Elo<T> p;

        p = new Elo(novo);

        p.prox = prim;

        p.ant = null;

        if (prim != null)
            prim.ant = p;

        prim = p;
        quantidadeElos++;
    }

    //Complexidade O(n)
    private Elo<T> busca(T elem){
        Elo<T> p = null;

        for( p = prim; ((p != null) && (p.dado.equals(elem))); p = p.prox);

        return p;
    }

    public boolean remove(T elem){
        Elo<T> p = null;
        p = busca(elem);

        if (p == null) return false;

        /* Retira primeiro elemento */
        if (p == prim)
            prim = prim.prox;
        else
            /* Retira elemento do meio */
            p.ant.prox = p.prox;

        /* Testa se � ultimo elemento */
        if (p.prox != null)
            p.prox.ant = p.ant;

        p = null;

        quantidadeElos--;
        return true;
    }

    @Override
    public String toString(){
        String string = "";

        for(Elo<T> p = prim; p != null; p = p.prox)
            string += p.dado.toString() + "\n";

        return string;
    }
}
