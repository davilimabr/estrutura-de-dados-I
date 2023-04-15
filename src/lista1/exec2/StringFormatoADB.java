package lista1.exec2;
import lista1.StringFormato.StringFormato;
import lista1.exec1.StringFormatoXCY;
import lista1.exec4.PilhaGenerica;

public class StringFormatoADB{
    private static final char SEPARADOR = 'd';
    public static boolean verificaFormato(String str) {
        if(!str.contains(""+SEPARADOR))
            return false;

        str = StringFormato.trataTexto(str);
        PilhaGenerica<String> pilhaCadeias = StringFormato.splitParaPilha(str, ""+SEPARADOR);

        while(!pilhaCadeias.vazia()){
            String aux = pilhaCadeias.pop();

            if(!StringFormatoXCY.verificaFormato(aux))
                return false;
        }

        return true;
    }
}
