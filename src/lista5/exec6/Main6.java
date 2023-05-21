package lista5.exec6;

import lista5.Listas.FilaChamadas;
import lista5.Listas.ListaDuplamente;

public class Main6 {
    public static void main(String[] args){
        Chamada[] chamadas = {
                new Chamada(1, 12),
                new Chamada(2, 2),
                new Chamada(3, 8),
                new Chamada(4, 17),
                new Chamada(5, 8)
        };

        FilaChamadas lista1 = new FilaChamadas();

        for(Chamada chamada : chamadas)
            lista1.insere(chamada);

        System.out.println(lista1);
    }
}
