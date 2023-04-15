package lista1.exec6;

import lista1.StringFormato.StringFormato;
import lista1.exec4.PilhaGenerica;


public class LetrasInvertidasDePalavrasNaFrase {
    public static String inverterMantendoOrdemPalavras(String frase){
        PilhaGenerica<Character> pilhaFrase = StringFormato.converterStringParaPilha(frase);
        PilhaGenerica<String> pilhaPalavras = new PilhaGenerica<>(StringFormato.contarOcorrencia(frase, ' ')+1);

        String palavra = "";

        while(!pilhaFrase.vazia()){
            Character ch = pilhaFrase.pop();

            if(ch == ' '){
                pilhaPalavras.push(palavra);
                palavra = "";
            }
            else if(pilhaFrase.vazia()){
                palavra += ch;
                pilhaPalavras.push(palavra);
            }
            else
                palavra += ch;
         }
        pilhaPalavras.inverter();

        return pilhaPalavras.toString();
    }
}

