package lista7.exec2;

import lista7.Classes.Arvbin;

import java.util.Random;

public class Main2 {
    public static void main(String[] args){
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(4);

        arvore.mostra();

        System.out.println("\n" + Arvbin.retornaSomaSubArvore(arvore));
    }


}
