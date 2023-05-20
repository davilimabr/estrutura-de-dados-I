package lista4.Listas;

public class FraseCaracteresEPalavrasInvertidas extends ListaGenerica<ListaGenerica<Character>> {
    // Complexidade O(n)
    public void insereString(String string){
        ListaGenerica<Character> palavra = stringParaListaCharacter(string);

        this.insere(palavra);
    }

    // Complexidade O(n)
    public boolean removeString(String string){
        ListaGenerica<Character> palavra = stringParaListaCharacter(string);

        return this.remove(palavra);
    }

    // Complexidade O(n)
    private ListaGenerica<Character> stringParaListaCharacter(String string){
        ListaGenerica<Character> lista = new ListaGenerica<>();

        for(int i = 0; i < string.length(); i++)
            lista.insere(string.charAt(i));

        return lista;
    }
}