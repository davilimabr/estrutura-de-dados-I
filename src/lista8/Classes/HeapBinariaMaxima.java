package lista8.Classes;

import lista7.Classes.Arvbin;

import java.util.Arrays;

public class HeapBinariaMaxima
{
	private int n;               /* Numero de elementos no heap. */
	private int tam;             /* Tamanho m�ximo do heap. */
	private int[] vetor;          /* Vetor com elementos. */

	/* Constr�i heap vazio. */
	public HeapBinariaMaxima(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new int[tamanho+1];
	}

	/* Constr�i heap a partir de vetor v. */
	public HeapBinariaMaxima(int tamanho, int[] v)
	{
		tam = tamanho;
		vetor = new int[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	public int getN() {
		return n;
	}

	public int getTam() {
		return tam;
	}

	public int[] getVetor() {
		return vetor;
	}

	/* Testa se a fila de prioridade est� logicamente vazia.
           Retorna true se vazia, false, caso contr�rio. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}

	/* Busca o maior item na fila de prioridades.
	   Retorna o maior item em itemMin e true, ou falso se a heap estiver vazia. */
	public int max()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		return vetor[1];
	}

	/* Remove o maior item da lista de prioridades e coloca ele em itemMax. */
	public int removeMax()
	{
		int itemMax;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return Integer.MAX_VALUE;
		}

		itemMax = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);

		return itemMax;
	}

	/* M�todo auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitr�rio dos itens. */
	private void constroiHeap()
	{
		/* As posi��es n at� a posi��o (n / 2) + 1 j� constituem uma heap,
		 * pois s�o folhas. */
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* M�todo auxiliar para restaurar a propriedade de heap que
	 * n�o est� sendo respeitada pelo n� i. */
	private void refaz(int i)
	{
		int x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, maiorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o maior filho � o da esquerda. */
			maiorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se � maior que o filho esquerdo. */
				if(vetor[ filhoDir ] > vetor[ filhoEsq ])
					maiorFilho = filhoDir;
			}

			if(vetor[ maiorFilho ] > x)
				vetor [ i ] = vetor[ maiorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posi��o "i" desceu para o n�vel de baixo, a pr�xima
			 * itera��o vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posi��o "maiorFilho") com um de seus novos filhos. */
			i = maiorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * S�o permitidas duplicatas. */
	public void insere(int x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento � inicialmente inserido na primeira posi��o dispon�vel
		 * na �rvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do n� raiz (de �ndice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x > vetor[pos/2])
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	/* Implementa o algoritmo de ordena��o Heapsort. */
	public void heapsort()
	{
		int x;           
		int resta = n;
		int raiz = 1;
		constroiHeap();
		
		while (resta > 1)
		{
			x = vetor[raiz];
			vetor[raiz] = vetor[resta];
			vetor[resta] = x;
			resta--;
			refaz(raiz);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	QUESTÃO 3:
		A complexidade desse método é O(n) onde n é a quantidade de elementos da heap.
		Isso porque é chamado o método constroiHeap() que possui complexidade O(n) e o restante da implementação é constante.
	 */
	public HeapBinariaMaxima(HeapBinariaMinima heapMinima){
		vetor = heapMinima.getVetor();
		n = heapMinima.getN();
		tam = heapMinima.getTam();

		constroiHeap();
	}

	/*
	 QUESTÃO 4:
	  Esse método possui complexidade equivalente a O(n).


	  o método transformaArvoreCompletaEmVetor(), possui complexidade O(n), pois percorre todos os nós da arvore e o método constroiHeap() possui complexidade O(n)
	  então temos: O(n) + O(n) = O(2n) --> crescimento assintótico equivalente a O(n)
	*/
	public void transformaHeapMaxima(Arvbin<Integer> arvore){
		vetor = Arvbin.transformaArvoreCompletaEmVetor(arvore); // implementação desse método está na classe ArvBin, dentro da pasta "classes" da lista 7
		n = tam = vetor.length-1;

		constroiHeap();
	}

	/*
	QUESTÃO 5:
		A complexidade desse método é O(n), sendo n a quantidade de elementos da árvore representada pelo vetor.
		Temos um loop que percorre de 1 até n/2, assim: O(n/2) -> equivalente a O(n)

		complexidade O(n)
	 */
	public static boolean verificaPropriedadeHeap(int[] vetor){
		for(int i = 1; i <= vetor.length/2; i++){
			int filhoEsq = i * 2 < vetor.length ? vetor[i*2] : Integer.MIN_VALUE;
			int filhoDir = i * 2 + 1< vetor.length ? vetor[i*2+1] : Integer.MIN_VALUE;

			if(vetor[i] < filhoEsq || vetor[i] < filhoDir)
				return false;
		}
		return true;
	}

	/*
	QUESTÃO 6:
    A complexidade desse método é O(logn), sendo n a quantidade de elementos da árvore representada pelo vetor.
    Isso porque é chamado o método refaz() que possui complexidade O(logn) e o restante da implementação é constante.

    complexidade O(n)
 	*/
	public int remove(int i){
		if(i < 1 || i > n)
			return Integer.MIN_VALUE;

		int removido = vetor[i];
		vetor[i] = vetor[n];
		n--;
		refaz(i);
		return removido;
	}
}