package lista2.exec6;

import lista2.FilaGenerica.FilaGenerica;

public class RepresentacaoBinaria {
    public static void gerar(int numero){
        FilaGenerica<Integer> fila = new FilaGenerica<>();

        int num = 1;
        fila.insere(num);

        while(num < numero){
            num = fila.remove();
            fila.insere(num+1);

            System.out.println(Integer.toBinaryString(num));
        }
    }
}
