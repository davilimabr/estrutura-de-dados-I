package lista1.exec4;

import java.util.Objects;
import java.util.Vector;


public class PilhaGenerica<T>
{
    private final int TAMANHO_DEFAULT = 50;
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho)
    {
        n = tamanho;
        vetor = new Vector<T>(tamanho);
        topo = -1;
    }

    public PilhaGenerica()
    {
        n = TAMANHO_DEFAULT;
        vetor = new Vector<T>(TAMANHO_DEFAULT);
        topo = -1;
    }


    public boolean vazia()
    {
        return topo == -1;
    }

    public boolean cheia()
    {
        return topo == n - 1;
    }

    public T pop()
    {
        T elemento;

        if (!this.vazia()){
            elemento = vetor.get(topo--);
            return elemento;
        }
        else{
            //Impress�o para fins did�ticos
            System.out.println("Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento)
    {
        if (!this.cheia())
        {
            vetor.add(++topo, elemento);
            return true;
        }
        else
        {
            //Impress�o para fins did�ticos
            System.out.println("Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }

    public boolean retornaTopo(T elemento)
    {
        if(!this.vazia()){
            elemento = vetor.get(topo);
            return true;
        }
        else
            return false;
    }


    //MÉTODO DA QUESTÃO 4
    public T retornaPosicao(int posicao){
        if(posicao < 0 || posicao > topo){
            System.out.println("posicao invalida\n");
            return null;
        }

        PilhaGenerica<T> pilhaAuxiliar = new PilhaGenerica<>(this.n);

        T objeto = null;
        while(this.topo >= posicao){ // 29 28
            objeto = this.pop();    // 30 29

            pilhaAuxiliar.push(objeto);
        }

        while(!pilhaAuxiliar.vazia()){
            this.push(pilhaAuxiliar.pop());
        }

        return objeto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PilhaGenerica aux = (PilhaGenerica) o;

        if(this.topo != aux.topo)
            return false;

        for(int i = 0; i <= topo; i++)
            if(this.vetor.get(i) != aux.vetor.get(i))
                return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(vetor);
    }
}
