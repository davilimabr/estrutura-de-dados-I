package lista1.exec3;

public class PilhaDuplaDeInteiros {
    private int n;
    private int[] vetor;
    private int topo1;
    private int topo2;

    public PilhaDuplaDeInteiros(int tamanho){
        this.n = tamanho;
        this.vetor = new int[tamanho];
        this.topo1 = -1;
        this.topo2 = tamanho;
    }

    public boolean pilha1Vazia() { return topo1 <= -1; }
    public boolean pilha2Vazia() { return topo2 >= this.n; }
    private boolean cheia() { return topo1 == topo2 - 1;}

    public boolean pushPilha1(int elemento){
        if(cheia())
            return false;

        this.vetor[++topo1] = elemento;
        return true;
    }

    public boolean pushPilha2(int elemento){
        if(cheia())
            return false;

        this.vetor[--topo2] = elemento;
        return true;
    }

    public int popPilha1(){
        if(pilha1Vazia()){
            return Integer.MIN_VALUE;
        }
        return this.vetor[topo1--];
    }

    public int popPilha2(){
        if(pilha2Vazia()){
            System.out.println("Pilhas 2 vazia");
            return Integer.MIN_VALUE;
        }
        return this.vetor[topo2++];
    }

    @Override
    public String toString() {
        String strPilha1 = "";
        String strPilha2 = "";

        if(!pilha1Vazia()){
            for(int i = 0; i <= topo1; i++)
                strPilha1 += "[" + this.vetor[i] + "] ";
        }

        if(!pilha2Vazia()){
            for(int i = n-1; i >= topo2; i--)
                strPilha2 += "[" + this.vetor[i] + "]";
        }

        return "Pilha1: " + strPilha1 +
                "\nPilha2: " + strPilha2;
    }

}
