package lista2.exec3;

import lista2.FilaGenerica.FilaGenerica;

public class Main3 {
    public static void main(String[] args){
        testeFilaDeFilas();
        testeFilaDePilhas();
        testePilhaDeFilas();
    }

    public static void testeFilaDeFilas(){
        FilaDeFilasGenericas<Integer> filaDeFilas = new FilaDeFilasGenericas();
        for(int i = 0; i < 10; i++){
            FilaGenerica<Integer> fila = new FilaGenerica<>();
            for(int j = 0; j < 5; j++){
                fila.insere(j+1);
            }
            filaDeFilas.insere(fila);
        }

        System.out.println(filaDeFilas);
    }

    public static void testeFilaDePilhas(){
        FilaDePilhasGenericas<Integer> filaDePilhas = new FilaDePilhasGenericas();
        for(int i = 0; i < 10; i++){
            PilhaGenerica<Integer> pilha = new PilhaGenerica<>();
            for(int j = 0; j < 5; j++){
                pilha.push(j+1);
            }
            filaDePilhas.insere(pilha);
        }

        System.out.println(filaDePilhas);
    }

    public static void testePilhaDeFilas(){
        PilhaDeFilasGenericas<Integer> pilhaDeFilas = new PilhaDeFilasGenericas<>();
        for(int i = 0; i < 10; i++){
            FilaGenerica<Integer> fila = new FilaGenerica<>();
            for(int j = 0; j < 5; j++){
                fila.insere(j+1);
            }
            pilhaDeFilas.push(fila);
        }

        System.out.println(pilhaDeFilas);
    }
}
