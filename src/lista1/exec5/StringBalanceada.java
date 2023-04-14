package lista1.exec5;

import lista1.exec4.PilhaGenerica;

public class StringBalanceada {
    public static boolean balanceada(String string){
        PilhaGenerica<Character> pilhaCaracter = new PilhaGenerica<Character>();

        for(int i = 0; i < string.length(); i++) {
            char chari = string.charAt(i);

            if(chari == '(' || chari == '[' || chari == '{')
                pilhaCaracter.push(chari);
            else if(chari == ')' || chari == ']' || chari == '}'){
                if(pilhaCaracter.vazia())
                    return false;

                char ultimoCaracter = pilhaCaracter.pop();
                if((chari == ')' && ultimoCaracter != '(') ||
                        (chari == ']' && ultimoCaracter != '[') ||
                        (chari == '}' && ultimoCaracter != '{'))
                    return false;
            }
        }
        return pilhaCaracter.vazia();
    }
}
