package lista1.exec2;
import lista1.StringFormato.StringFormato;
import lista1.exec1.StringFormatoXCY;
import lista1.exec4.PilhaGenerica;

public class StringFormatoADB extends StringFormato {
    private static final char SEPARADOR = 'd';
    public static boolean verificaFormato(String str) {
        if(!str.contains(""+SEPARADOR))
            return false;

        str = trataTexto(str);
        PilhaGenerica<String> pilhaCadeias = splitParaPilha(str, ""+SEPARADOR);

        while(!pilhaCadeias.vazia()){
            String aux = pilhaCadeias.pop();

            if(!StringFormatoXCY.verificaFormato(aux))
                return false;
        }

        return true;
    }
}
