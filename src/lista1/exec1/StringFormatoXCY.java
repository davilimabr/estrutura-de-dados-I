package lista1.exec1;

import lista1.StringFormato.StringFormato;
import lista1.exec4.PilhaGenerica;


public class StringFormatoXCY{
    public static final char SEPARADOR = 'c';
    public static boolean verificaFormato(String texto){
        texto = StringFormato.trataTexto(texto);
        if(!letrasPermitidas(texto) || !texto.contains(""+SEPARADOR))
            return false;

        PilhaGenerica<Character> pilhaEntrada = StringFormato.converterStringParaPilha(texto);
        PilhaGenerica<Character> pilhaAuxiliar = new PilhaGenerica<>(texto.length());

        boolean continua = true;
        while (continua){
            Character ch = pilhaEntrada.pop();

            if(ch == SEPARADOR)
                continua = false;
            else
                pilhaAuxiliar.push(ch);
        }

        return pilhaEntrada.equals(pilhaAuxiliar);
    }

    private static boolean letrasPermitidas(String str){
        for(int i = 0; i < str.length();i++)
            if(str.charAt(i) != 'a' &&
                    str.charAt(i) != 'b' &&
                    str.charAt(i) != 'c' &&
                    str.charAt(i) != ' ')
                return false;

        return  true;
    }
}

