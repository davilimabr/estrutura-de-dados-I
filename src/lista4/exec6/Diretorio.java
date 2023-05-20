package lista4.exec6;

import lista4.Listas.ListaGenerica;

import java.util.Objects;

public class Diretorio {
    private String nome;
    private ListaGenerica conteudo;

    public Diretorio(String nome){
        this.nome = nome;
        this.conteudo = new ListaGenerica<>();
    }


    // Complexidade O(1)
    public boolean insere(Object arquivoOuDir){
        if(arquivoOuDir.getClass() == this.getClass())
            this.conteudo.insere((Diretorio) arquivoOuDir);
        else if(arquivoOuDir.getClass() == Arquivo.class)
            this.conteudo.insere((Arquivo) arquivoOuDir);
        else
            return false;

        return true;
    }

    // Complexidade O(n)
    public boolean remove(Object arquivoOuDir){
        if(arquivoOuDir.getClass() == this.getClass())
            this.conteudo.remove((Diretorio) arquivoOuDir);
        else if(arquivoOuDir.getClass() == Arquivo.class)
            this.conteudo.remove((Arquivo) arquivoOuDir);
        else
            return false;

        return true;
    }

    /*
    Complexidade O(n*m), pois como podem ser armazenados outros Diretórios dentro de um diretório, temos N sendo a quantidade de elos da lista de conteudo do diretorio corrente
    e M sendo a quantidade de elos da lista de conteudo dos subdiretorios
     */
    @Override
    public String toString(){
        if(this.conteudo.vazia())
            return this.nome + "\n\t" + "(Pasta Vazia)";

        String string = this.nome + "\n\t";
        String conteudo = this.conteudo.toString("\n");
        string += conteudo.replace("\n", "\n\t");

        return string;
    }
}
