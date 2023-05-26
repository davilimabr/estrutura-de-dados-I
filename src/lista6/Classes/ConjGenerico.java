package lista6.Classes;
public class ConjGenerico<T extends Comparable<T>>
{
	private Elo prim;  /* Refer�ncia para primeiro elemento. */
	private Elo maiorElemento;
	private Elo menorElemento;

	/* Classe auxiliar para guardar cada elemento do conjunto. */
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

	/* Construtor que cria um conjunto vazio. */
	public ConjGenerico(){
		prim = null;
		maiorElemento = null;
		menorElemento = null;
	}

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
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

	/* M�todo privado para realizar uma c�pia de um outro conjunto. */
	public void apaga(){
		for (Elo p = prim; p != null; p = prim) {
			prim = prim.prox;
			p.prox = null;
		}
	}

	/* Simula uma sobrecarga do operador de atribui��o. */
	public ConjGenerico<T> atribui(ConjGenerico<T> conj2){
		if (this != conj2) {
			apaga();
			copia(conj2);
		}

		return this;
	}

	/* Testa se o conjunto est� vazio. */
	public boolean vazio(){
		return prim == null;
	}

	/* Teste de pertin�ncia. Usa fato de estar ordenado. */
	public boolean pertence(T valor){
		Elo p;

		for (p = prim; ((p != null) && (p.dado.compareTo(valor) < 0)); p = p.prox);

		if ((p == null) || (p.dado.compareTo(valor) > 0)) return false;

		return true;
	}

	/* Inser��o de elemento no conjunto. Usa fato de estar ordenado.
       Retorna false se elemento j� estava l�. */
	public boolean insere(T valor){
		Elo p = prim, ant = null;

		for (p = prim; (p != null); p = p.prox){
			if (p.dado.compareTo(valor) == 0) return false;
			if (p.dado.compareTo(valor) > 0) break;

			ant = p;
		}

		Elo q = new Elo(valor);

		if (p == prim){
			prim = q;
			menorElemento = q;
		} else{
			if(p == null) maiorElemento = q;
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

		if (p == prim) {
			prim = prim.prox;
			menorElemento = prim;
		} else{
			if(p.prox == null) maiorElemento = ant;
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

	///////////////////////////////////////////////////////////////////////////////////////////////////

    /*
	QUEST�O 1:
		Para obter o maior e menor valor do conjunto em tempo constante, levei em considera��o a ordena��o dos elementos do conjunto nos m�todos insere e remove.
		Um atributo maiorElemento e um menorElemento, s�o modificados nos m�todos de inser��o e remo��o para sempre manterem armazenados os valores atualizados, dessa forma, basta
		retornar o valor desses atributos, como foi implementado nos m�todos abaixo.
	 */

	// Complexidade O(1)
	public T obterMaiorElemento(){
		return maiorElemento.dado;
	}

	// Complexidade O(1)
	public T obterMenorElemento(){
		return menorElemento.dado;
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
		O m�todo inicialmente verifica o se o universo � vazio ou nulo, e lan�a uma exce��o. Depois percorre o conjunto atual e utiliza o m�todo pertence, chamado a partir de universo,
		para verificar se o elemento pertence ao universo. Em seguida se segue um loop percorrendo o conjunto universo, que verifica se cada elo pertence ao conjunto corrente, caso n�o seja,
		adiciona em complementar.

		Como o m�todo pertence possui complexidade O(n)
		temos: O(n) * O(m) +  O(m) * ( O(n) + O(n) )
		 				O(n*m) + O(m*2n) -> possui crescimento assint�tico equivalente a O(n*m)

		Sendo N a quantidade de elos do conjunto atual e M a do conjunto universo.

		OBS: Lembrando a complexidade dos m�todos chamados dentro do loop:
			pertence - O(n)
			insere - O(n)

		complexidade O(n*m)
	 */
	public ConjGenerico<T> complementar(ConjGenerico<T> universo) throws Exception{
		if(universo == null || universo.vazio()) throw new Exception("O conjunto universo � vazio.");

		for(Elo p = prim; p != null; p = p.prox)
			if(!universo.pertence(p.dado))
				throw new Exception("O conjunto corrente possui elementos fora do conjunto universo.");

		ConjGenerico<T> complementar = new ConjGenerico<>();
		for(Elo p = universo.prim; p != null; p = p.prox)
			if(!this.pertence(p.dado))
				complementar.insere(p.dado);

		return complementar;
	}

	/*
	QUEST�O 4:
		O m�todo percorre todos os elementos do conjunto corrente e verifica para cada um se ele pertence ao conjunto fornecido como par�metro, caso um n�o perten�a, j� � retornado false,
		pois j� se sabe que o conjunto atual n�o � subconjunto do fornecido.
		temos: O(n) * O(m) = O(n*m)
		Sendo N a quantidade de elementos do conjunto corrente e M a quantidade de elementos do conjunto fornecido

		complexidade O(n*m)
	 */
	public boolean eSubconjunto(ConjGenerico<T> conj2){
		for(Elo p = prim; p != null; p = p.prox)
			if(!conj2.pertence(p.dado))
				return false;

		return true;
	}

	/*
	QUEST�O 5:
		o m�todo percorre o conjunto corrente, veficando para cada elemento se ele pertence ao conjunto fornecido, se n�o pertencer, insere no conjunto diferen�a.
		Em seguida o mesmo processo � realizado, mas agora percorrendo o conjunto fornecido e verificando se pertence ao conjunto corrente.
		temos: ( O(n) * (O(m) + O(m)) ) + ( O(m) * (O(n) + O(n)) )
				O(n*2m)  +  O(m*2n)
					O(n*m) -> ignorando as constantes multiplicativas
		Sendo N a quantidade de elos do conjunto corrente e M a do conjunto fornecido.

		Logo, o crescimento assint�tico equivalente do m�todo � O(n*m).

		OBS: Lembrando a complexidade dos m�todos chamados dentro do loop:
				pertence - O(n)
				insere - O(n)

		complexidade O(n*m)
	 */
	public ConjGenerico<T> diferenca(ConjGenerico<T> conj2){
		ConjGenerico<T> diferenca = new ConjGenerico<>();

		for(Elo p = prim; p != null; p = p.prox)
			if(!conj2.pertence(p.dado))
				diferenca.insere(p.dado);

		for(Elo p = conj2.prim; p != null; p = p.prox)
			if(!this.pertence(p.dado))
				diferenca.insere(p.dado);

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
}

