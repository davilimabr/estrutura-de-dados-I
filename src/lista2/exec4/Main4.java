package lista2.exec4;

import lista2.FilaGenerica.FilaGenerica;

public class Main4 {
    public static void main(String[] args){
        FilaGenerica<Integer> fila = new FilaGenerica<>(10);

        for(int i = 0; i < 10; i++){
            fila.insere(i+1);
        }
        //fila original
        System.out.println(fila);

        FilaDuplaGenerica<Integer> filaDupla = FilaGenerica.FilaParaFilaDupla(fila);
        filaDupla.removeFim();
        filaDupla.insereIni(0);


        //deveria printar de 0 a 9
        System.out.println(filaDupla);
    }
}
