package lista4.exec1;
/*
Uma forma de diminuir a complexidade desse método, podendo alternar a classe, seria criando um atributo "quantidadeElos". Esse atributo seria incrementado no método
"insere" e decrementado no método "remove", dessa forma, manteria sempre a quantidade atualizada de elos da lista.

Esse é um exemplo básico de implementação da classe Lista, utilizando as alterações sugeridas ao exercicio:
*/
public class Lista
{
    protected Elo prim;
    protected int quantidadeElos;

    protected class Elo{
        protected int dado;
        protected Elo prox;

        public Elo()
        {
            prox = null;
        }

        public Elo(int elem)
        {
            dado = elem;
            prox = null;
        }

        public Elo(int elem, Elo proxElem)
        {
            dado = elem;
            prox = proxElem;
        }
    }

    public Lista(){
        prim = null;
        quantidadeElos = 0;
    }

    public void insere(int novo){
        Elo p = new Elo(novo);
        p.prox = prim;
        prim = p;
        this.quantidadeElos++;
    }

    public boolean remove(int elem){
        Elo p;
        Elo ant = null;

        for(p = prim; ((p != null) && (p.dado != elem)); p = p.prox)
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
    ANTIGA IMPLEMENTAÇÃO
     A complexidade do método é O(n), pois o laço de repitição, no pior dos casos, repete n vezes, sendo n a quantidade de elos que essa lista encadeada possui.

    public int tamanho()
    {
        int tam = 0;
        Elo p = prim;

        while(p != null)
        {
            tam++;
            p = p.prox;
        }

        return tam;
    }


    NOVA IMPLEMENTAÇÃO
    Esse método possui complexidade O(1):
    */
    public int tamanho()
    {
        return this.quantidadeElos;
    }
}