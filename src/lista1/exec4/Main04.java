package lista1.exec4;

import org.junit.Assert;

public class Main04 {
    public static void main(String[] args){
        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(100);

        for(int i = 1; i <= 100; i++){
            pilha.push(i);
        }

        int esperado = 29;
        int resultado = pilha.retornaPosicao(esperado-1);

        Assert.assertEquals(esperado, resultado);

    }
}
