package lista5.Listas;

public class ListaCircular extends Lista {
    //O(n)
    public void insere(int novo){
        Elo p, q;
        q = new Elo(novo);
        p = prim;

        if (p != null)
        {
            while (p.prox != prim)
            {
                p = p.prox;
            }

            p.prox = q;
            q.prox = prim;
        }
        else
        {
            prim = q;
            prim.prox = q;
        }
    }

    public boolean remove(int elem){
        Elo p = null;
        Elo ant = null;

        if (prim == null) return false;

        for( p = prim; ( (p.prox != prim ) && (p.dado != elem) ); p = p.prox)
            ant = p;

        /* Achou */
        if ( p.dado == elem )
        {
            /* � o primeiro */
            if ( p == prim )
            {
                /* � o �nico */
                if ( prim == prim.prox )
                {
                    prim = null;
                }
                else
                {
                    /* Guarda o anterior ao primeiro */
                    for( ant = prim; ( ant.prox != prim ); ant = ant.prox);

                    ant.prox = prim.prox;
                    prim = prim.prox;
                }
            }
            else
            {
                /* No meio */
                ant.prox = p.prox;
            }

            /* Remove a �ltima refer�ncia para o elo a ser removido. Dessa forma,
             * o Garbage Collector ir� liberar essa mem�ria. */
            p = null;

            return true;
        }
        else
            return false;
    }

    public Lista separa(int n){
        Lista l2 = new Lista();

        Elo p = prim;

        /* Loop para encontrar o elo cujo atributo dado tenha valor "n". */
        do
        {
            /* Encontrou o elemento desejado. */
            if(p.dado == n)
                break;

            p = p.prox;

        } while (p != prim);

        /* Caso tenha percorrido a lista sem encontrar o elemento. */
        if(p.dado != n)
            return null;

        /* O "prim" da nova lista � o pr�ximo do elo apontado por p. */
        l2.prim = p.prox;

        /* O pr�ximo do elo apontado por p tem que apontar para o prim da
         * lista original. */
        p.prox = prim;

        Elo q;

        /* Anda at� o �ltimo elemento da lista 2. */
        for(q = l2.prim; q.prox != prim; q = q.prox);

        /* O pr�ximo do �ltimo elemento da lista 2 aponta para o primeiro. */
        q.prox = l2.prim;

        /* Retorna a nova lista constru�da. */
        return l2;
    }

    @Override
    public String toString(){
        String string = "";

        Elo p = prim;
        do{
            string += p.dado + " ";
            p = p.prox;
        }while(p != prim);

        return string;
    }

    /* QUESTÃO 2
    A complexidade desse método é O(n).
    temos: O(n) + O(n) = O(2n), que podemos dizer que possui crescimento assintótico equivalente a O(n).
     */
    public ListaCircular merge(ListaCircular lista2) {
        if (prim == null || lista2.prim == null) return null;
        ListaCircular merge = new ListaCircular();

        Elo p = prim;
        Elo q = lista2.prim;

        do{
            merge.insere(p.dado);
            merge.insere(q.dado);
            p = p.prox;
            q = q.prox;
        }while(p != prim && q != lista2.prim);

        if(p != prim)
            while (p != prim) {
                merge.insere(p.dado);
                p = p.prox;
            }

        if(q != lista2.prim)
            while (q != lista2.prim) {
                merge.insere(q.dado);
                q = q.prox;
            }

        return merge;
    }

    /* QUESTÃO 3
     A complexidade desse método é O(n²), sendo n a quantidade de elos da lista.
     Isso porque a complexidade do método insere é O(n) e está dentro de um loop.
     temos: O(n) * O(n) = O(n²)
      */
    public ListaCircular inverteLista() {
        if (prim == null) return null;
        ListaCircular listaInvertida = new ListaCircular();

        Elo p = prim;
        do{
            listaInvertida.insere(p.dado);
            p = p.prox;
        }while(p != prim);

        return listaInvertida;
    }
}
