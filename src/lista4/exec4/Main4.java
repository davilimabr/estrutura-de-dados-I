package lista4.exec4;

public class Main4 {
    public static void main(String[] args){
        String[] palavras = {"eu", "vou", "estudar", "para", "a", "prova", "de", "estrutura", "de", "dados"};
        Frase frase = new Frase();

        for(String palavra : palavras)
            frase.insere(palavra);

        System.out.println(frase);
    }
}
