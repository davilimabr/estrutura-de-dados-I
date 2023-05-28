package lista6.Classes;
public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;
	private Elo ult;

	private class Elo{
		T dado;
		Elo prox;

		public Elo() {
			prox = null;
		}

		public Elo(T elem) {
			dado = elem;
			prox = null;
		}

		public Elo(T elem, Elo proxElem) {
			dado = elem;
			prox = proxElem;
		}
	}

	public ConjGenerico(){
		prim = ult = null;
	}

	private void copia(ConjGenerico<T> conj2){
		Elo ult = null, q;

		prim = null;

		for (Elo p = conj2.prim; p != null; p = p.prox) {
			q = new Elo(p.dado);

			if (ult == null)
				prim = q;
			else
				ult.prox = q;

			ult = q;
		}
	}

	public void apaga(){
		for (Elo p = prim; p != null; p = prim) {
			prim = prim.prox;
			p.prox = null;
		}
	}

	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
		if (this != conj2) {
			apaga();
			copia(conj2);
		}

		return this;
	}

	public boolean vazio(){
		return prim == null;
	}

	public boolean pertence(T valor){
		Elo p;

		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;

		return true;
	}

	public boolean insere(T valor){
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox){
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;

			ant = p;
		}

		Elo q = new Elo(valor);

		if(prim == null)
			ult = q;

		if (p == prim)
			prim = q;
		else{
			if(p == null) ult = q;
			ant.prox = q;
		}

		q.prox = p;

		return true;
	}

	/* Remo��o de elemento do conjunto. Usa fato de estar ordenado.
       Retorna false se elemento n�o estava l�. */
	public boolean remove(T valor){
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox) {
			if (p.dado.compareTo(valor) > 0) return false;
			if (p.dado.compareTo(valor) == 0) break;

			ant = p;
		}

		if (p == null)
			return false;

		if (p == prim)
			prim = prim.prox;
		else{
			if(p.prox == null) ult = ant;
			ant.prox = p.prox;
		}

		p = null;

		return true;
	}

	/* M�todo para uni�o de conjuntos. Une conjunto com cj2 e retorna novo conjunto com a uni�o.
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> uniao(ConjGenerico<T> conj2){
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> uniao = new ConjGenerico<T>();

		while ( (p1 != null) || (p2 != null) ) {
			if ( (p1 != null) && ( (p2 == null) || (p1.dado.compareTo(p2.dado) < 0))) {
				q = new Elo(p1.dado);
				p1 = p1.prox;
			} else {
				q = new Elo(p2.dado);
				if ((p1 != null) && (p1.dado.compareTo(p2.dado) == 0))
					p1 = p1.prox;
				p2 = p2.prox;
			}

			if (ult == null)
				uniao.prim = q;
			else
				ult.prox = q;

			ult = q;
		}

		return uniao;
	}

	/* M�todo para intersecao de conjuntos. Calcula intersecao do conjunto com cj2 e retorna novo conjunto com a intersecao.
	 * Usa fato de conjuntos estarem ordenados e percorre as listas em paralelo. */
	public ConjGenerico<T> intersecao(ConjGenerico<T> conj2){
		Elo q, p1 = prim, p2 = conj2.prim, ult = null;
		ConjGenerico<T> inter = new ConjGenerico<T>();

		while ( (p1 != null) && (p2 != null) ) {
			if (p1.dado.compareTo(p2.dado) < 0) {
				p1 = p1.prox;
			} else if(p2.dado.compareTo(p1.dado) < 0) {
				p2 = p2.prox;
			} else {
				q = new Elo(p1.dado);

				p1 = p1.prox;
				p2 = p2.prox;

				if (ult == null)
					inter.prim = q;
				else
					ult.prox = q;

				ult = q;
			}
		}

		return inter;
	}

	/* Retorna cardinalidade do conjunto */
	public int tamanho(){
		int tam = 0;
		Elo p;

		for(p = prim; p != null; p = p.prox)
			tam++;

		return tam;
	}

	/* Imprime todos os elementos do conjunto */
	public void imprime(){
		Elo p;

		System.out.println("Elementos do conjunto");

		for(p = prim; p != null; p = p.prox)
			System.out.print(p.dado + " ");

		System.out.println();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /*
	QUEST�O 1:
		Para obter o maior e menor valor do conjunto em tempo constante, levei em considera��o a ordena��o dos elementos do conjunto nos m�todos insere e remove.
		Um atributo maiorElemento e um menorElemento, s�o modificados nos m�todos de inser��o e remo��o para sempre manterem armazenados os valores atualizados, dessa forma, basta
		retornar o valor desses atributos, como foi implementado nos m�todos abaixo.
	 */

	// Complexidade O(1)
	public T obterMaiorElemento(){
		return (ult != null) ? ult.dado : null;
	}

	// Complexidade O(1)
	public T obterMenorElemento(){
		return (prim != null) ? prim.dado : null;
	}


	/*
    QUEST�O 2:
        O m�todo utiliza um while para percorrer os dois conjuntos, enquanto, pelo menos, um deles n�o esteja vazio. A cada repeti��o � comparado o dado dos elos atuais de ambos os
        conjuntos, caso seja diferente � retornado false, pois basta que um valor seja direfente para que eles n�o sejam iguais.

        Complexidade do m�todo O(n)
     */
	public boolean eIgual(ConjGenerico<T> conj2){
		if (this == conj2) return true;

		Elo p = prim;
		Elo q = conj2.prim;

		while(p != null && q != null){
			if(!p.dado.equals(q.dado))
				return false;

			p = p.prox;
			q = q.prox;
		}

		return p == null && q == null;
	}

    /*
	QUEST�O 3:
		O m�todo utiliza a ordena��o dos conjuntos para verificar quais elementosdo conjunto universo n�o est�o no conjunto corrente.
		temos: O(n) + O(m)
		 		O(n+m)

		OBS: o m�todo eSubconjunto tem tempo de execu��o constante, logo n�o influencia na complexidade.

		A complexidade do m�todo complementar � O(n + m), onde n � o n�mero de elementos no conjunto corrente e m � o n�mero de elementos no conjunto universo.
	 */

	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception{
		if (universo.vazio())  throw new Exception("O conjunto universo � vazio e o corrente n�o.");

		if(obterMenorElemento().compareTo(universo.obterMenorElemento()) < 0 ||
				obterMaiorElemento().compareTo(universo.obterMaiorElemento()) > 0)
			throw new Exception("O conjunto corrente possui elementos fora do conjunto universo.");

		ConjGenerico<T> complementar = new ConjGenerico<>();
		Elo p = prim, pUni = universo.prim, pCom = null;

		while(p != null)
			if(p.dado.compareTo(pUni.dado) > 0){
				Elo elo = new Elo(pUni.dado);

				if(pCom == null)
					complementar.prim = elo;
				else
					pCom.prox = elo;

				pCom = elo;
				pUni = pUni.prox;
			}
			else{
				p = p.prox;
				pUni = pUni.prox;
			}

		if(pUni != null)
			while(pUni != null){
				Elo elo = new Elo(pUni.dado);

				pCom.prox = elo;
				pCom = elo;
				pUni = pUni.prox;
			}

		return complementar;
	}

	// Essa segunda implementa��o usa os m�todos dos pr�ximos exercicios e possui a mesma complexidade O(n+m)
	public ConjGenerico<T> complementarAlternativo(ConjGenerico<T> universo) throws Exception{
		if (universo.vazio())  throw new Exception("O conjunto universo � vazio e o corrente n�o.");

		if(!eSubconjunto(universo))
			throw new Exception("O conjunto corrente possui elementos fora do conjunto universo.");

		return diferenca(universo);
	}

	/*
	QUEST�O 4:
		O m�todo leva em considera��o a ordena��o dos conjuntos, caso o menorElmento do conjunto corrente seja menor que o menorElemento do conjunto fornecido, ent�o n�o �
		subConjunto, o mesmo vale para caso o maiorElemento seja maior que o maiorElemento do conjunto fornecido.

		complexidade O(1)
	 */
	public boolean eSubconjunto(ConjGenerico<T> conj2){
		if(prim == null)
			return true;
		if(conj2 == null || conj2.prim == null)
			return false;

		return obterMenorElemento().compareTo(conj2.obterMenorElemento()) >= 0 &&
				obterMaiorElemento().compareTo(conj2.obterMaiorElemento()) <= 0;
	}

	/*
	QUEST�O 5:
		o m�todo leva em considera��o a ordena��o dos conjuntos para comparar os elementos e saber se s�o diferentes.

		temos: O(n+m)  + ( O(n) + O(m) )
				O(n+m)  +  O(n+m)
					O(2n+2m) -> ignorando as constantes multiplicativas
					O(n+m)
		Logo, o crescimento assint�tico equivalente do m�todo � O(n*m).
		Sendo N a quantidade de elos do conjunto corrente e M a do conjunto fornecido.

		complexidade O(n+m)
	 */
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2){
		ConjGenerico<T> diferenca = new ConjGenerico<>();

		Elo p = prim, p2 = conj2.prim, pDif = null;
		while(p != null && p2 != null)
			if(p.dado.compareTo(p2.dado) < 0){
				Elo elo = new Elo(p.dado);

				if(pDif == null)
					diferenca.prim = elo;
				else
					pDif.prox = elo;

				pDif = elo;
				p = p.prox;
			}
			else if(p.dado.compareTo(p2.dado) > 0){
				Elo elo = new Elo(p2.dado);

				if(pDif == null)
					diferenca.prim = elo;
				else
					pDif.prox = elo;

				pDif = elo;
				p2 = p2.prox;
			}
			else{
				p = p.prox;
				p2 = p2.prox;
			}

		if(p != null)
			while (p != null){
				Elo elo = new Elo(p.dado);

				if(pDif == null)
					diferenca.prim = elo;
				else
					pDif.prox = elo;

				pDif = elo;
				p = p.prox;
			}
		else if(p2 != null)
			while (p2 != null){
				Elo elo = new Elo(p2.dado);

				if(pDif == null)
					diferenca.prim = elo;
				else
					pDif.prox = elo;

				pDif = elo;
				p2 = p2.prox;
			}

		return diferenca;
	}

	/*
		QUEST�O 6:
				O m�todo eIgualRecursivo verifica se os dois conjuntos s�o vazios e retorna true caso sim, por fim retorna eIgualRecursividade passando o prim de cada conjunto,
				dando inicio a recurs�o.
				O m�todo eIgualRecursividade primeiro verifica se os dois elos s�o nulos, se sim, significa que os dois conjuntos foram percorridos e todos os elos s�o iguais,
				ent�o retorna true. Depois verifica se pelo menos um dos elos � nulo, se sim, um dos conjuntos foi totalmente percorrido e o outro n�o, sendo assim possuem tamanhos diferentes,
				logo n�o s�o iguais, retorna false. A terceira verifica��o compara o dado de cada um dos elos, se for diferente retorna false, pois basta um elo diferente para que todo
				o conjunto seja difente. Por fim, retorna a chamada do pr�prio m�todo passando o prox de cada um dos elos.

				Assim como a implementa��o n�o recursiva, esse m�todo possui complexidade O(n).
	 */
	public boolean eIgualRecursivo(ConjGenerico<T> conj2){
		if(this.vazio() && conj2.vazio())
			return true;

		return eIgualRecursividade(prim, conj2.prim);
	}

	private boolean eIgualRecursividade(Elo elo1, Elo elo2){
		if(elo1 == null && elo2 == null)
			return true;

		if(! (elo1 != null && elo2 != null))
			return false;

		if(!elo1.dado.equals(elo2.dado))
			return false;

		return eIgualRecursividade(elo1.prox, elo2.prox);
	}

	/*
	QUEST�O 7:
		O m�todo utiliza os m�todos implementados nos exerc�cios anteriores para aplicar a Lei De Morgan.
		temos: O(n+m) + O(n+m) + O(n+m)
					  O(3n+3m) -> ignorando as constantes multiplicativas
					  O(n+m)

		complexidade O(n+m)
	 */
	public static ConjGenerico aplicaDeMorgan(ConjGenerico universo, ConjGenerico conj1, ConjGenerico conj2) throws Exception{
		ConjGenerico complementoConj1 = conj1.complementar(universo);
		ConjGenerico complementoConj2 = conj2.complementar(universo);

		return complementoConj1.intersecao(complementoConj2);
	}
}

