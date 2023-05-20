package lista4.exec4;

import lista4.Listas.ListaGenerica;

public class Frase {
    private ListaGenerica<String> palavras;

    public Frase(){
        this.palavras = new ListaGenerica<>();
    }

    public void insere(String palavra){
        this.palavras.insere(palavra);
    }

    public void remove(String palavra){
        this.palavras.remove(palavra);
    }

    public String toString(){
        return this.palavras.toStringInvertida();
    }


    /*
        A complexidade do método toString da classe Frase é O(n).

        Ele chama o método toStringInvertida da classe ListaGenética que também possui complexidade O(n). Como é possível verificar na sua implementação,
        esse método possui um loop que percorre todos os N elos da lista e por fim chama o método toString, também da classe ListaGenerica, que também possui complexidade O(n),
        por fim, chegamos a complexidade O(2n) para o método toStringInvertida, que ignorando as constantes multiplicativas, ficamos com a complexidade citada inicialmente.

     */
}
