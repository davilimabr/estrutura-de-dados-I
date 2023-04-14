package lista1.exec1;
import org.junit.Assert;

public class Main01 {
    public static void main(String[] args) {
        String teste1 = "PLAPWLDPAWLD C WAKDKOPAWKODAWOK";
        boolean esperado1 = false;

        String teste2 = "ABABABBBBABABABABABA";
        boolean esperado2 = false;

        String teste3 = "C ABABABABBABABAB";
        boolean esperado3 = false;

        String teste4 = "abbabbcbbabba";
        boolean esperado4 = true;

        String teste5 = "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA";
        boolean esperado5 = true;

        Assert.assertEquals(esperado1, StringFormatoXCY.verificaFormato(teste1));
        Assert.assertEquals(esperado2, StringFormatoXCY.verificaFormato(teste2));
        Assert.assertEquals(esperado3, StringFormatoXCY.verificaFormato(teste3));
        Assert.assertEquals(esperado4, StringFormatoXCY.verificaFormato(teste4));
        Assert.assertEquals(esperado5, StringFormatoXCY.verificaFormato(teste5));
    }
}
