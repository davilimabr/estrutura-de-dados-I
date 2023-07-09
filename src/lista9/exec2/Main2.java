package lista9.exec2;

import lista9.classes.ArvBinBusca;

public class Main2 {
    public static void main(String[] args) {
        int[] vetor = {6, 2, 7, 1, 3, 4, 8,10,9,55};

        ArvBinBusca arvore = new ArvBinBusca();
        arvore.constroiArvore(vetor);

        arvore.mostra();
    }
}
