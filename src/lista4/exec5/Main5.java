package lista4.exec5;

import lista4.Listas.FraseCaracteresEPalavrasInvertidas;
import org.junit.Assert;

public class Main5 {
    public static void main(String[] args){
        String[] palavras = {"eu", "vou", "estudar", "para", "a", "prova", "de", "estrutura", "de", "dados", "!"};
        FraseCaracteresEPalavrasInvertidas frase = new FraseCaracteresEPalavrasInvertidas();

        for(String palavra : palavras)
            frase.insereString(palavra);

        System.out.println(frase);

        /*

        O método que realiza a tarefa do exercício é o toString, da classe FraseCaracteresEPalavrasInvertidas que é herdado de ListaGenerica.
        Isso porque como o método inserir, da classe ListaGenerica, adiciona sempre um elo ao começo da lista, naturalmente a lista já fica na sua ordem invertida.
        A classe FraseCaracteresEPalavrasInvertidas se aproveita disso, herdando de uma ListaGenerica de ListasGenericas do tipo Caractere.

        A complexidade do método toString, na classe FraseCaracteresEPalavrasInvertidas herddado de ListaGenerica,  é O(n*m), pois percorre todos os N elos da lista, e para cada elo,
        percorre os M elos que os compõe.

        */
    }
}
