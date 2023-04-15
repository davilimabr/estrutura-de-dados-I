package lista1.exec8;

import lista1.exec4.PilhaGenerica;

public class SequenciaNumerica {
    private PilhaGenerica<Integer> sequencia;
    public SequenciaNumerica(int n){
        sequencia = new PilhaGenerica<>(n);
        this.preencherSequencia(n);
    }
    private void preencherSequencia(int n){
        for(int i = 1; i <= n; i++)
            sequencia.push(i);
    }

    public PilhaGenerica<PilhaGenerica<Integer>> obterParesUnicos(){
        PilhaGenerica<PilhaGenerica<Integer>> paresUnicos = new PilhaGenerica<>(sequencia.quantidadeElementos()-1);

        while (!sequencia.vazia()) {
            int maior = sequencia.pop();

            if (maior < 2)
                break;

            int segundoMaior = sequencia.pop();

            PilhaGenerica<Integer> parUnico = new PilhaGenerica<>(2);
            parUnico.push(segundoMaior);
            parUnico.push(maior);

            paresUnicos.push(parUnico);
            sequencia.push(segundoMaior);
        }
        return paresUnicos;
    }
}
