package lista1.exec4;

import org.junit.Assert;

public class Main04 {
    public static void main(String[] args){
        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(100);

        for(int i = 1; i <= 100; i++){
            pilha.push(i);
        }

        int elementoRetirar = 29;
        int resultado = pilha.removerElemento(elementoRetirar);

        Assert.assertEquals(elementoRetirar, resultado);

    }
}
