package lista6.exec1;

import lista6.Classes.ConjGenerico;

import java.util.Random;

public class Main1 {
    public static void main(String[] args){
        int tam = 20;
        int[] numeros = new int[tam];
        ConjGenerico<Integer> conjunto = new ConjGenerico<>();

        for(int i = 0 ; i < tam; i++){
            numeros[i] = new Random().nextInt(100);
            conjunto.insere(numeros[i]);
        }

        // removendo o maior e menor valor para verificar se o método remove esta atualizando os atributos corretamente
        conjunto.remove(conjunto.obterMaiorElemento());
        conjunto.remove(conjunto.obterMenorElemento());

        conjunto.imprime();
        System.out.println("\nMaior: " + conjunto.obterMaiorElemento());
        System.out.println("Menor: " + conjunto.obterMenorElemento());
    }
}
