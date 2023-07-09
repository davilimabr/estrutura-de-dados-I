package lista9.exec3;

import lista7.Classes.Arvbin;
import lista9.classes.ArvBinBusca;

public class Main3 {
    public static void main(String[] args) {
        Arvbin<Integer> arvore = Arvbin.criarArvoreDeInteirosDeAltura(2);

        ArvBinBusca<Integer, Integer> arvBinBusca = new ArvBinBusca<>();
        arvBinBusca.transformaArvBinBusca(arvore);

        arvore.mostra();
        System.out.println("\n");
        arvBinBusca.mostra();
    }
}
