package lista7.exec4;

import lista7.Classes.Arvbin;

import java.util.Random;

public class Main4 {
    public static void main(String[] args){
        //testeArvDegenerada();
        testeArvAleatoria();
    }

    public static void testeArvDegenerada(){
        Arvbin<Integer> no1 = new Arvbin<>(54);
        Arvbin<Integer> no2 = new Arvbin<>(66);
        Arvbin<Integer> no3 = new Arvbin<>(88, no1,no2);
        Arvbin<Integer> no4 = new Arvbin<>(63);
        Arvbin<Integer> no5 = new Arvbin<>(46, no4, null);

        Arvbin<Integer> raiz = new Arvbin<>(13, no3, no5);

        raiz.mostra();
        raiz.delete(46);
        System.out.println("Foi removido o nó de valor: 46");

        raiz.mostra();
    }

    public static void testeArvAleatoria(){
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(2);
        arvore.mostra();

        int num = 0;
        while(true){
            num = new Random().nextInt(100);

            if(arvore.busca(num) != null)
                break;
        }

        arvore.delete(num);

        System.out.println("Foi removido o nó de valor: " + num);

        arvore.mostra();
    }
}