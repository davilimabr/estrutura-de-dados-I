package lista1.exec5;
import org.junit.Assert;

public class Main05 {
    public static void main(String[] args){
        String teste1 = "{ab}[cde]";
        boolean esperado1 = true;

        String teste2 = "{ab[cd]efg}";
        boolean esperado2 = true;

        String teste3 = "[abcde{efg]}";
        boolean esperado3 = false;

        Assert.assertEquals(esperado1, StringBalanceada.balanceada(teste1));
        Assert.assertEquals(esperado2, StringBalanceada.balanceada(teste2));
        Assert.assertEquals(esperado3, StringBalanceada.balanceada(teste3));
    }
}
