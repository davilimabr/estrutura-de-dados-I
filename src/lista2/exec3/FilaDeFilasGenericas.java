package lista2.exec3;

import lista2.FilaGenerica.FilaGenerica;

import java.util.Vector;

public class FilaDeFilasGenericas<T> extends FilaGenerica {
    public FilaDeFilasGenericas(){
        this.inicializarAtributos(super.TAMANHO_DEFAULT);
    }
    public FilaDeFilasGenericas(int tamanho){
        this.inicializarAtributos(tamanho);
    }
    @Override
    protected void inicializarAtributos(int tamanho){
        super.tamanho = tamanho;
        super.vetor = new Vector<FilaGenerica<T>>(tamanho);
        super.ini = 0;
        super.n = 0;
    }
}
