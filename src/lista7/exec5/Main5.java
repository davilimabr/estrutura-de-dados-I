package lista7.exec5;

import lista7.Classes.Arvbin;

import java.util.Random;

public class Main5 {
    public static void main(String[] args){
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(3);
        arvore.mostra();

        int num = 0;
        while(true){
            num = new Random().nextInt(100);

            if(arvore.busca(num) != null)
                break;
        }

        System.out.println("\n torna em raiz: " + num);

        arvore.tornaRaiz(num);

        System.out.println("\n");
        arvore.mostra();
    }

}
