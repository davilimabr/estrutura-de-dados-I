package lista2.exec3;

import java.util.Vector;

public class PilhaDeFilasGenericas<T> extends PilhaGenerica {
    public PilhaDeFilasGenericas(int tamanho){
        inicializarAtributos(tamanho);
    }

    public PilhaDeFilasGenericas(){
        inicializarAtributos(TAMANHO_DEFAULT);
    }

    @Override
    protected void inicializarAtributos(int tamanho){
        super.n = TAMANHO_DEFAULT;
        super.vetor = new Vector<T>(TAMANHO_DEFAULT);
        super.topo = -1;
    }

}
