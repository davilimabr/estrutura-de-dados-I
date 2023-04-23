package lista1.exec7;

import org.junit.Assert;

public class Main07 {
    public static void main(String[] args){
        String teste1 = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        boolean esperado1 = true;

        String teste2 = "()+6))";
        boolean esperado2 = false;

        String teste3 = "( 1 *+ 5)";
        boolean esperado3 = false;

        // deveria ser falso pois só admite um digito
        String teste4 = "( 12 + 3)";
        boolean esperado4 = false;

        String teste5 = "1 + 1";
        boolean esperado5 = true;

        Assert.assertEquals(esperado1, Interpretador.checarExpressao(teste1));
        Assert.assertEquals(esperado2, Interpretador.checarExpressao(teste2));
        Assert.assertEquals(esperado3, Interpretador.checarExpressao(teste3));
        Assert.assertEquals(esperado4, Interpretador.checarExpressao(teste4));
        Assert.assertEquals(esperado5, Interpretador.checarExpressao(teste5));
    }
}
