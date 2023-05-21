package lista5.Listas;

import lista5.exec6.Chamada;

public class FilaChamadas extends ListaDuplamenteGenerica<Chamada> {

    //A complexidade do método é O(n)
    @Override
    public void insere(Chamada chamada) {
        Elo<Chamada> novo = new Elo(chamada);

        if (prim == null) {
            prim = novo;
            return;
        }

        Elo<Chamada> p = prim;
        for (; p != null; p = p.prox) {
            if (p.dado.obterCustoTotal() < chamada.obterCustoTotal()) {
                if (p.ant != null)
                    p.ant.prox = novo;
                else
                    prim = novo;

                novo.prox = p;
                novo.ant = p.ant;
                p.ant = novo;
                break;
            }
            else if(p.prox == null){
                p.prox = novo;
                novo.prox = null;
                novo.ant = p;
                break;
            }
        }
    }

    //A complexidade do método é O(1)
    public void atender(){
        if(prim != null){
            prim = prim.prox;
            prim.ant = null;
        }
    }
}
