package lista2.exec1;

import lista2.exec2.FilaGenerica;

public class SistemaOperacional {
    private final int QUANTIDADE_MAXIMA_PROCESSOS = 500;
    private FilaGenerica<Processo> processos;

    public SistemaOperacional(){
        processos = new FilaGenerica<>(QUANTIDADE_MAXIMA_PROCESSOS);
    }

    public boolean incluirProcesso(Processo processo){
        return this.processos.insere(processo);
    }

    public Processo removeProcesso(){
        return this.processos.remove();
    }

    @Override
    public String toString(){
         return this.processos.toString();
    }
}
