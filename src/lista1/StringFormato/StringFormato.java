package lista1.StringFormato;

import lista1.exec4.PilhaGenerica;

public class StringFormato {
    protected static String trataTexto(String texto){
        return texto.toLowerCase().replace(" ", "");
    }

    protected static PilhaGenerica<Character> converterStringParaPilha(String str){
        PilhaGenerica<Character> pilhaStr = new PilhaGenerica<Character>(str.length());

        for(int i = 0; i < str.length(); i++)
            pilhaStr.push(str.charAt(i));

        return pilhaStr;
    }

    protected static PilhaGenerica<String> splitParaPilha(String str, String separador){
        int qtdSeparador = contarOcorrencia(str, 'd');
        PilhaGenerica<String> pilhaCadeia = new PilhaGenerica<>(qtdSeparador+1);

        String[] vetorStrings = str.split(separador);

        for(String string : vetorStrings)
            pilhaCadeia.push(string);

        return pilhaCadeia;
    }

    protected static int contarOcorrencia(String str, char ch){
        return str.replace(ch, ' ').length();
    }
}
