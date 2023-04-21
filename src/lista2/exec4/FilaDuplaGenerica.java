package lista2.exec4;

import lista2.FilaGenerica.FilaGenerica;

public class FilaDuplaGenerica<T> extends FilaGenerica {
    public FilaDuplaGenerica(int tamanho){
        super(tamanho);
    }
    public FilaDuplaGenerica(){
        super();
    }
    public boolean insereIni(int elemento){
        int prec;
        if ( !cheia() ) {
            /* Insere na posição precedente ao início */prec = (ini -1 + tamanho) % tamanho;
            vetor.add(prec, elemento);
            ini = prec; /* Atualiza índice para início */n++;
            return true;
        }
        else
            return false;
    }
    public T removeFim(){
        int ult;
        if ( ! vazia()) {
            /* Retira o último elemento */
            ult = (ini + n - 1) % tamanho;
            n--;
            return (T) vetor.get(ult);
        }
        else
            return null;
    }
}
