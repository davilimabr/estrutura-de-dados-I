package lista2.exec3;

import lista1.exec4.PilhaGenerica;
import lista2.exec2.FilaGenerica;

import java.util.Vector;

public class FilaDePilhasGenericas<T> extends FilaGenerica {
    public FilaDePilhasGenericas(){
        this.inicializarAtributos(super.TAMANHO_DEFAULT);
    }
    public FilaDePilhasGenericas(int tamanho){
        this.inicializarAtributos(tamanho);
    }
    @Override
    protected void inicializarAtributos(int tamanho){
        super.tamanho = tamanho;
        super.vetor = new Vector<PilhaGenerica<T>>(tamanho);
        super.ini = 0;
        super.n = 0;
    }
}
