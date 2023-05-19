package lista_conjuntos;

public class Conjunto {
    private final int TAMANHO_CONJUNTO = 100;
    private boolean[] elementos;

    public Conjunto(){
        elementos = new boolean[TAMANHO_CONJUNTO+1];
    }

    public Conjunto(int tamanho){
        elementos = new boolean[tamanho+1];
    }

    public void adiciona(int i){
        this.elementos[i] = true;
    }

    public void remove(int i){
        this.elementos[i] = false;
    }

    public boolean pertence(int i){
        return this.elementos[i];
    }

    public int menorElemento() {
        for (int i = 0; i < this.elementos.length; i++)
            if (this.elementos[i])
                return i;

        return -1;
    }

    public int maiorElemento() {
        for (int i = this.elementos.length -1; i > 0 ; i--)
            if (this.elementos[i])
                return i;

        return -1;
    }

    public boolean isVazio() {
        for (boolean elemento : this.elementos)
            if (elemento)
                return false;
        return true;
    }

    public boolean isUniverso() {
        for (boolean elemento : this.elementos) {
            if (!elemento)
                return false;
        }
        return true;
    }

    public int cardinalidade() {
        int quantidade = 0;
        for (boolean bool : this.elementos)
            if (bool) quantidade++;

        return quantidade;
    }

    public Conjunto uniao(Conjunto conjunto) {
        Conjunto uniao = new Conjunto(this.elementos.length + conjunto.elementos.length);

        for (int i = 0; i < this.elementos.length; i++)
            if(this.elementos[i] || uniao.elementos[i])
                uniao.adiciona(i);

        for (int i = 0; i < conjunto.elementos.length; i++)
            if(conjunto.elementos[i] || uniao.elementos[i])
                uniao.adiciona(i);

        return uniao;
    }

    public Conjunto interseccao(Conjunto conjunto) {
        Conjunto interseccao = new Conjunto(conjunto.elementos.length);

        for (int i = 0; i < conjunto.elementos.length; i++)
            if(this.elementos[i] && conjunto.elementos[i])
                interseccao.adiciona(i);

        return interseccao;
    }

    public boolean isSubConjunto(Conjunto subConjunto) {
        for (int i = 0; i < subConjunto.elementos.length; i++)
            if (subConjunto.elementos[i] && !this.elementos[i])
                return false;

        return true;
    }

    public boolean iguais(Conjunto conjunto) {
        for (int i = 0; i < conjunto.elementos.length; i++)
            if (this.elementos[i] != conjunto.elementos[i])
                return false;

        return true;
    }

    public boolean isSubconjuntoProprio(Conjunto subConjunto) {
        return isSubConjunto(subConjunto) && !iguais(subConjunto);
    }

    @Override
    public String toString(){
        String string = "";

        for(int i = 0; i < this.elementos.length; i++)
            if(this.elementos[i])
                string += i + " ";

        return string;
    }
}