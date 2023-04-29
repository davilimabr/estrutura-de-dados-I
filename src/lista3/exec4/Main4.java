package lista3.exec4;

import lista1.exec4.PilhaGenerica;

public class Main4 {
    public static void main(String[] args){
        PilhaGenerica<Integer> pilha = new PilhaGenerica<>(99999);

        for(int i = 0; i < 99999; i++){
            pilha.push(i+1);
        }

        int result = contarQuantidadeDePares(pilha);
        System.out.println(result);
    }

    public static int contarQuantidadeDePares(PilhaGenerica<Integer> pilhaNumerica){
        PilhaGenerica<Integer> pilhaAuxiliar = new PilhaGenerica<>(pilhaNumerica.quantidadeElementos());
        int qtdPares = 0;

        while(!pilhaNumerica.vazia()){ // O(n)
            Integer num = pilhaNumerica.pop();

            if(num % 2 == 0)
                qtdPares++;

            pilhaAuxiliar.push(num);
        }

        while(!pilhaAuxiliar.vazia()){  // O(n)
            pilhaNumerica.push(pilhaAuxiliar.pop());
        }
        return qtdPares;

        // O(n) + O(n) = O(2n)
        // Iginorando a constante multiplicativa, temos que possui crescimento assintótico proporcional a: O(n)
        // Complexidade desse trecho de código: O(n)
    }
}
