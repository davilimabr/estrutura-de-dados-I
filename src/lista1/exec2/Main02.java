package lista1.exec2;

import org.junit.Assert;

public class Main02 {
    public static void main(String[] args){
        String teste1 = "ABABBA C ABBABA" +
                " d " +
                "aaabbb C bbbaaa" +
                " d " +
                "abbabb C bbabba";
        boolean esperado1 = true;

        String teste2 = "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA" +
                "d" +
                "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA";
        boolean esperado2 = true;

        String teste3 = "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA";
        boolean esperado3 = false;

        String teste4 = "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA" +
                "d" +
                "AAAAAAAAAAasasasasaAAAAAABB C BBAAAAAAAAAAAAAAAA" +
                "d" +
                "awdawdawdwadawdawd" +
                "AAAAAAAAAAAAAAAABB C BBAAAAAAAAAAAAAAAA";
        boolean esperado4 = false;


        Assert.assertEquals(esperado1, StringFormatoADB.verificaFormato(teste1));
        Assert.assertEquals(esperado2, StringFormatoADB.verificaFormato(teste2));
        Assert.assertEquals(esperado3, StringFormatoADB.verificaFormato(teste3));
        Assert.assertEquals(esperado4, StringFormatoADB.verificaFormato(teste4));
    }
}
/*

*/