package lista9.exec5;

import lista9.classes.ArvBinBusca;

public class Main5 extends ArvBinBusca {
    public static void main(String[] args) {
        ArvBinBusca<Integer, Integer> arvBinBusca = new ArvBinBusca<>();
        arvBinBusca.put(5, 0);
        arvBinBusca.put(60, 0);
        arvBinBusca.put(32, 0);
        arvBinBusca.put(99, 0);
        arvBinBusca.put(11, 0);
        arvBinBusca.put(1, 0);
        arvBinBusca.put(3, 0);
        arvBinBusca.put(61, 0);
        arvBinBusca.put(62, 0);

        arvBinBusca.mostra();
        //arvBinBusca.obtemAncestralComum(new No(62, 0));

        System.out.println("\n");
        arvBinBusca.mostra();
    }
}
