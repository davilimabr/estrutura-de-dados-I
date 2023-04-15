package lista1.exec6;

import lista1.exec1.StringFormatoXCY;
import org.junit.Assert;

public class Main06 {
    public static void main(String[] args){
        String teste1 = "a maçã está podre";
        String esperado1 = "a ãçam átse erdop";

        String teste2 = "amaçãestápodre";
        String esperado2 = "erdopátseãçama";

        String teste3 = "faala dev";
        String esperado3 = "alaaf ved";

        Assert.assertEquals(esperado1, LetrasInvertidasDePalavrasNaFrase.inverterMantendoOrdemPalavras(teste1));
        Assert.assertEquals(esperado2, LetrasInvertidasDePalavrasNaFrase.inverterMantendoOrdemPalavras(teste2));
        Assert.assertEquals(esperado3, LetrasInvertidasDePalavrasNaFrase.inverterMantendoOrdemPalavras(teste3));

    }
}