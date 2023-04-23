package lista2.exec5;

import lista2.FilaGenerica.FilaGenerica;

public class FilaCaixa {
    private final int TAMANAHO_MAX_FILA_PRIORITARIA = 50;
    private final int TAMANAHO_MAX_FILA_COMUM = 50;
    private FilaGenerica<Cliente> filaPrioritaria;
    private FilaGenerica<Cliente> filaComum;

    public FilaCaixa(){
        this.filaPrioritaria = new FilaGenerica<>(TAMANAHO_MAX_FILA_PRIORITARIA);
        this.filaComum = new FilaGenerica<>(TAMANAHO_MAX_FILA_COMUM);
    }

    public boolean vazia(){
        return (this.filaPrioritaria.vazia() && this.filaComum.vazia());
    }

    public boolean inserirCliente(Cliente cliente){
        if(cliente.getFaixaEtaria() == Cliente.FaixaEtaria.Idoso)
            return this.filaPrioritaria.insere(cliente);
        else
            return this.filaComum.insere(cliente);
    }

    public Cliente removerCliente(){
        if(!this.filaPrioritaria.vazia())
            return this.filaPrioritaria.remove();
        else if(!this.filaComum.vazia())
            return this.filaComum.remove();
        else
            return null;
    }

    @Override
    public String toString(){
        return this.filaPrioritaria.toString() + this.filaComum.toString();
    }
}
