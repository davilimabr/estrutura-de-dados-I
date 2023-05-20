package lista4.Listas;

import lista4.exec7.Inimigo;

public class ListaDeInimigos extends ListaGenerica<Inimigo> {
    //Complexidade O(n), podendo variar de acordo com a implementação de equals
    public Inimigo localizar(Inimigo inimigo){
        for(Elo<Inimigo> p = prim; p != null; p = p.prox)
            if(inimigo.equals(p.dado))
                return p.dado;

        return null;
    }

    //Complexidade O(n), pois chama o método remove que é O(n) e o restante do código é constante
    public int efetuarDano(Inimigo inimigo, double dano){
        Double vidaRestante = inimigo.getVida() - dano;

        if(vidaRestante <= 0){
            inimigo.setVida(0);
            remove(inimigo);
        }
        else
            inimigo.setVida(vidaRestante.intValue());

        return vidaRestante.intValue();
    }

    //Complexidade O(n), pois o loop percorre todos os elos da lista
    @Override
    public String toString() {
        String resultado = "";
        // O(n)
        for (Elo<Inimigo> p = prim; p != null; p = p.prox) {
            resultado += p.dado.toString() + "\n";
        }
        return resultado;
    }
}
