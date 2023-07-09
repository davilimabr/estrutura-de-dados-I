package lista9.exec4;

import lista7.Classes.Arvbin;
import lista9.classes.ArvBinBusca;

public class Main4 {
    public static void main(String[] args) {
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(2);

        ArvBinBusca<Integer, Integer> arvBinBusca = new ArvBinBusca<>();
        arvBinBusca.transformaArvBinBusca(arvore);

        arvBinBusca.mostra();
        boolean removeu = arvBinBusca.removeForaIntervalo(-999, 999); // nao remove ninguem

        System.out.println("\nFoi removido algum elemento? " + removeu+ "\n");
        arvBinBusca.mostra();

        System.out.println("\n");

        arvBinBusca.mostra();
        removeu = arvBinBusca.removeForaIntervalo(999, 1000); // remove todo mundo

        System.out.println("\nFoi removido algum elemento? " + removeu+ "\n");
        arvBinBusca.mostra();
    }
}
