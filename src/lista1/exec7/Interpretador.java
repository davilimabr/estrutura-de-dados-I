package lista1.exec7;

import lista1.StringFormato.StringFormato;
import lista1.exec4.PilhaGenerica;
import lista1.exec5.StringBalanceada;

public class Interpretador {
    public static boolean checarExpressao(String expressao){
        expressao = StringFormato.trataTexto(expressao);

        if(!StringBalanceada.balanceada(expressao))
            return false;

        PilhaGenerica<Character> pilhaExpressao = StringFormato.converterStringParaPilha(expressao);

        while(!pilhaExpressao.vazia()){
            Character ch = pilhaExpressao.pop();

            if(ehNumerico(ch)){
                ch = pilhaExpressao.pop();

                if(ch != null){
                    if(parenteseFechado(ch) || ehNumerico(ch))
                    return false;

                    pilhaExpressao.push(ch);
                }
            }
            else if (ehOperador(ch)){
                ch = pilhaExpressao.pop();

                if(ch != null){
                    if(parenteseAberto(ch) || ehOperador(ch))
                        return false;

                    pilhaExpressao.push(ch);
                }

            }
        }
        return true;
    }
    public static boolean parenteseAberto(char ch){
        return ch == '(';
    }

    public static boolean parenteseFechado(char ch){
        return ch == ')';
    }
    public static boolean ehOperador(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    public static boolean ehNumerico(char ch){
        return ch == '0' || ch == '1' || ch == '2' ||
                ch == '3' || ch == '4' || ch == '5' ||
                ch == '6' || ch == '7' || ch == '8' || ch == '9';
    }
}
