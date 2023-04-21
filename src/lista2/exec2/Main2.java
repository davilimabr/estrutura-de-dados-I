
package lista2.exec2;

import lista2.FilaGenerica.FilaGenerica;

public class Main2 {
    public static void main(String[] args){
        int tamFilas = 20;
        FilaGenerica<Integer> fila1 = new FilaGenerica<>(tamFilas);
        FilaGenerica<Integer> fila2 = new FilaGenerica<>(tamFilas);

        int tamFilasCombinadas = tamFilas * 2;
        FilaGenerica<Integer> filasCombinadas = new FilaGenerica<>(tamFilasCombinadas);

        //preenche as filas
        for(int i = 1; i <= tamFilas; i++)
            fila1.insere(i);

        for(int i = tamFilas; i <= tamFilasCombinadas; i++)
            fila2.insere(i);


        System.out.println(fila1.toString() + "\n");
        System.out.println(fila2.toString()+ "\n");

        filasCombinadas.combinaFilas(fila1, fila2);

        System.out.println(filasCombinadas.toString());
    }
}
