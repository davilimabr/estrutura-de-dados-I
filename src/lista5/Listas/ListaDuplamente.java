package lista5.Listas;

public class ListaDuplamente
{
	protected Elo prim;
	protected int quantidadeElos;

	protected class Elo{
		protected int dado;
		protected Elo ant;
		protected Elo prox;

		public Elo() {
			ant = null;
			prox = null;
		}

		public Elo(int elem) {
			dado = elem;
			ant = null;
			prox = null;
		}

		public Elo(int elem, Elo antElem, Elo proxElem) {
			dado = elem;
			ant = antElem;
			prox = proxElem;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Elo elo = (Elo) o;
			return dado == elo.dado;
		}
	}

	public ListaDuplamente(){
		prim = null;
		quantidadeElos = 0;
	}

	public boolean vazia() {
		return prim == null;
	}

	public void insere(int novo){
		Elo p;

		p = new Elo(novo);

		p.prox = prim;

		p.ant = null;

		if (prim != null)
			prim.ant = p;

		prim = p;
		quantidadeElos++;
	}

	//Complexidade O(n)
	private Elo busca(int elem){
		Elo p = null;

		for( p = prim; ((p != null) && (p.dado != elem)); p = p.prox);

		return p;
	}

	public boolean remove(int elem){
		Elo p = null;
		p = busca(elem);

		if (p == null) return false;

		/* Retira primeiro elemento */
		if (p == prim)
			prim = prim.prox;
		else
			/* Retira elemento do meio */
			p.ant.prox = p.prox;

		/* Testa se � ultimo elemento */
		if (p.prox != null)
			p.prox.ant = p.ant;

		p = null;

		quantidadeElos--;
		return true;
	}

	public void imprimeReversa(){
		Elo p;
		Elo ult = null;

		System.out.println("Elementos da lista em ordem reversa:");

		p = prim;

		while(p != null) {
			ult = p;
			p = p.prox;
		}

		for(p = ult; p != null; p = p.ant) {
			System.out.print(p.dado + " ");
		}

		System.out.println();
	}

	public static ListaDuplamente concatena(ListaDuplamente l1, ListaDuplamente l2) {
		Elo p;

		/* Verifica se a lista l1 � vazia. */
		if(l1.prim == null) {
			l1.prim = l2.prim;
		} else {
			/* Primeiramente, precisamos obter o �ltimo elo da lista l1. */
			for(p = l1.prim; p.prox != null; p = p.prox);

			/* Faz o "prox" do �ltimo elemento da lista l1, apontado por "p",
			 * apontar para o "prim" da lista l2. */
			p.prox = l2.prim;

			/* Faz o "ant" do "prim" da lista l2 apontar para o �ltimo elemento da
			 * lista l1, apontado por "p". */
			l2.prim.ant = p;
		}

		/* Nesse ponto, os elementos de l2 j� est�o encadeados ao final de l1,
		 * como desejado. Assim, vamos deixar a lista l2 vazia. */
		l2.prim = null;

		return l1;
	}

	@Override
	public String toString(){
		String string = "";

		for(Elo p = prim; p != null; p = p.prox)
			string += p.dado + " ";

		return string;
	}

	/* 	QUESTÃO 1
    A complexidade desse método é O(n*m), sendo N a quantidade de elos da lista1 e M a quantidade de elos da lista 2.
    É utilizado um loop que percorre a lista1 e para cada repetição é chamado o método busca da lista2, que possue complexidade O(n)  (nesse casso O(M))
    Assim temos: O(n) * O(m) = O(n*m)
     */
	public static ListaDuplamente interseccao(ListaDuplamente lista1, ListaDuplamente lista2){
		ListaDuplamente interseccao = new ListaDuplamente();

		for(Elo p = lista1.prim; p != null ; p = p.prox){
			if(lista2.busca(p.dado) != null)
				interseccao.insere(p.dado);
		}

		return interseccao;
	}

	/*
    QUESTÃO 4
    Esse método possui complexidade O(n), sendo n a quantidade de elos da lista
    temos a chamada do método buscaPorindice, que possui complexidade O(n), duas vezes em sequencia, ou seja, O(n) + O(n) = O(2n), que podemos dizer
    que possui crescimento assintótico equivalente a O(n).
     */
	public void trocaElos(int indiceElo1, int indiceElo2){
		Elo elo1 = this.buscaPorIndice(indiceElo1);
		Elo elo2 = this.buscaPorIndice(indiceElo2);

		int temp = elo1.dado;
		elo1.dado = elo2.dado;
		elo2.dado = temp;
	}

	//Complexidade O(n)
	private Elo buscaPorIndice(int indice){
		if(indice > quantidadeElos-1 && indice < 0)
			return null;

		Elo p = null;
		int i = 0;
		for( p = prim; ((p != null) && i < indice); p = p.prox)
			i++;

		return p;
	}

	//QUESTÃO 5
	public boolean verificaIgualdade(ListaDuplamente lista2){
		if(this.vazia() && lista2.vazia())
			return true;

		return verificaIgualdadeRecurcao(prim, lista2.prim);
	}

	/*
	Complexidade desse método é O(n), em que n é a quantidade de elos da lista.
	 */
	private boolean verificaIgualdadeRecurcao(Elo elo1, Elo elo2){
		if(elo1 == null && elo2 == null)
			return true;

		if(!elo1.equals(elo2))
			return false;

		return verificaIgualdadeRecurcao(elo1.prox, elo2.prox);
	}

}
