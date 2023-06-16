package lista7.Classes;

import java.util.Deque;
import java.util.Iterator;
import java.util.Random;

public class Arvbin<T extends Comparable<T>>
{
	private T val;
	private Arvbin<T> esq;
	private Arvbin<T> dir;

	public Arvbin(T valor){
		val = valor;
		esq = null;
		dir = null;
	}

	public Arvbin(T valor, Arvbin<T> arvEsq, Arvbin<T> arvDir){
		val = valor;
		esq = arvEsq;
		dir = arvDir;
	}

	public T retornaVal()
	{
		return val;
	}

	public Arvbin<T> retornaEsq(){
		return esq;
	}


	public Arvbin<T> retornaDir(){
		return dir;
	}

	public void defineVal(T valor){
		val = valor;
	}

	public void defineEsq(Arvbin<T> filho){
		esq = filho;
	} 

	public void defineDir(Arvbin<T> filho){
		dir = filho;
	}






	public void mostra(){
		String valor = val != null ? val.toString() : "";
		System.out.print("(" + valor);
		if (esq != null)
			esq.mostra();
		if (dir != null)
			dir.mostra();
		System.out.print(")");
	}
	
	public Arvbin<T> busca(T valor){
		Arvbin<T> ret;

		/* Se � igual ao valor armazenado, n�o precisa procurar mais. O n� � a raiz. */
		if (valor.compareTo(val) == 0)
		{
			return this;
		}

		/* Sen�o, come�a procurando na sub�rvore esquerda. */
		if (esq != null)
		{
			ret = esq.busca(valor);

			if (ret != null)
				return ret;
		}

		/* Se chega a esse ponto, estar� na �rvore se, e somente se, 
	     estiver na sub�rvore direita */
		if (dir != null) 
			return dir.busca(valor);
		
		return null;
	}
	
	public int contaNos(){
		if((esq == null) && (dir == null))
			return 1;
		
		int nosEsq = 0, nosDir = 0;
		
		if(esq != null)
			nosEsq = esq.contaNos();
		
		if(dir != null)
			nosDir = dir.contaNos();
		
		return 1 + nosEsq + nosDir;
	}
	
	public int calculaAltura(){
		if((esq == null) && (dir == null))
			return 0;
		
		int altEsq = 0, altDir = 0;
		
		if(esq != null)
			altEsq = esq.calculaAltura();
		
		if(dir != null)
			altDir = dir.calculaAltura();
		
		return 1 + Math.max(altEsq, altDir);
	}
	
	public T calculaMaximo(){
		if((esq == null) && (dir == null))
			return val;
		
		T maiorFilhos, maiorEsq, maiorDir; 
		
		if((esq != null) && (dir == null))
		{
			maiorFilhos = esq.calculaMaximo();
		}
		else if((esq == null) && (dir != null))
		{
			maiorFilhos = dir.calculaMaximo();
		}
		else
		{
			maiorEsq = esq.calculaMaximo();
			maiorDir = dir.calculaMaximo();
			
			if(maiorEsq.compareTo(maiorDir) > 0)
				maiorFilhos = maiorEsq;
			else
				maiorFilhos = maiorDir;
		}
		
		if(maiorFilhos.compareTo(val) > 0)
			return maiorFilhos;
		
		return val;
	}
	
	public static int calculaSoma(Arvbin<Integer> no){
		if(no == null)
			return 0;

		int acumulado = 0;
						
		acumulado += calculaSoma(no.esq);
		
		acumulado += calculaSoma(no.dir);
		
		acumulado += no.val;
		
		return acumulado;
	}
	
	public int contaNosIntervalo(T min, T max){
		if((esq == null) && (dir == null))
		{
			if((val.compareTo(min)) >= 0 && (val.compareTo(max) <= 0))
				return 1;
			else
				return 0;
		}
		
		int nosEsq = 0, nosDir = 0, noCont = 0;
		
		if(esq != null)
			nosEsq = esq.contaNosIntervalo(min, max);
		
		if(dir != null)
			nosDir = dir.contaNosIntervalo(min, max);
		
		if((val.compareTo(min) >= 0) && (val.compareTo(max) <= 0))
			noCont = 1;
		
		return noCont + nosEsq + nosDir;
	}
	
	public static int verificaArvoreSoma(Arvbin<Integer> arvore){
		/* Caso base: se � uma sub�rvore vazia, deve retornar 0. */
		if(arvore == null)
			return 0;
		
		/* Caso base: se � uma folha, retorna o valor contido no n�. */
		if((arvore.esq == null) && (arvore.dir == null))
			return arvore.val;
		
		/* Caso geral: deve chamar para a esquerda e para a direita, verificando
		 * a soma. */
		int somaEsquerda = 0, somaDireita = 0;
		
		if(arvore.esq != null)
			somaEsquerda = verificaArvoreSoma(arvore.esq);
		
		if(arvore.dir != null)
			somaDireita = verificaArvoreSoma(arvore.dir);
			
		/* Agora devemos verificar se o valor do n� corresponde � soma dos valores
		 * contidos nas sub�rvores esquerda e direita. */
		if((somaEsquerda != Integer.MIN_VALUE) && (somaDireita != Integer.MIN_VALUE)
				&& (arvore.val == somaEsquerda + somaDireita))
			return arvore.val + somaEsquerda + somaDireita;
		
		return Integer.MIN_VALUE;
	}
	
	public boolean eIgual(Arvbin<T> outra){
		if(this.esq == null && this.dir == null)
		{
			if(outra.esq == null && outra.dir == null)
			{
				if(this.val.compareTo(outra.val) == 0)
					return true;
				else
					return false;
			}
			else
				return false;
		}
		
		boolean esqIgual = true, dirIgual = true;
		
		if(this.esq != null)
		{
			if(outra.esq == null)
				return false;
			else
				esqIgual = this.esq.eIgual(outra.esq);
		}
		else
		{
			if(outra.esq != null)
				return false;
		}
		
		if(this.dir != null)
		{
			if(outra.dir == null)
				return false;
			else
				dirIgual = this.dir.eIgual(outra.dir);
		}
		else
		{
			if(outra.dir != null)
				return false;
		}
		
		if(this.val.compareTo(outra.val) == 0)
			return esqIgual && dirIgual;
		else
			return false;
	}
	
	/* Calcula e retorna o di�metro da �rvore, isto �, o n�mero
	 * de n�s contido no maior caminho de um n� para outro n� da
	 * �rvore. */
	public int calculaDiametro()
	{
		/* Caso base, quando � uma folha. */
		if((esq == null) && (dir == null))
		{
			return 1;
		}
		
		/* Calcula a altura das sub�rvores esquerda e direita do n�. */
		int alturaEsq = 0, alturaDir = 0;
		
		if(esq != null)
			alturaEsq = esq.calculaAltura();
		
		if(dir != null)
			alturaDir = dir.calculaAltura();
		
		int maxDistanciaNo = alturaEsq + alturaDir + 1;
		
		/* Nesse ponto, temos a maior dist�ncia entre dois n�s da �rvore
		 * que passa pelo n� corrente (this). Agora devemos calcular esse
		 * valor para as sub�rvores esquerda e direita, comparando depois. */		
		
		int maxDistanciaEsq = 0, maxDistanciaDir = 0;
		
		if(esq != null)
			maxDistanciaEsq = esq.calculaDiametro();
		
		if(dir != null)
			maxDistanciaDir = dir.calculaDiametro();
		
		int maxDistanciaFilhos = Math.max(maxDistanciaEsq,  maxDistanciaDir);
		
		if(maxDistanciaNo > maxDistanciaFilhos)
			return maxDistanciaNo;
		else
			return maxDistanciaFilhos;
	}
	
	/* M�todo que realiza a impress�o de todos os caminhos da raiz para uma folha. */
	public void imprimeTodosCaminhos(Deque<T> caminhos)
	{
		/* Adiciona o n� no caminho. */
		caminhos.addLast(val);

		/* Caso base: quando � uma folha. */
		if((esq == null) && (dir == null))
		{
			/* Chegou-se ao fim do caminho, portanto deve-se imprimi-lo. */
			imprimeCaminho(caminhos);
		}

		/* Caso geral: deve-se fazer a recurs�o para os n�s esquerdo (se houver) e 
		 * para o direito (se houver). */
		
		if(esq != null)
			esq.imprimeTodosCaminhos(caminhos);

		if(dir != null)
			dir.imprimeTodosCaminhos(caminhos);
		
		/* Remove o n� corrente do caminho ap�s as chamadas recursivas para os
		 * n�s esquerdo e direito. */ 
		caminhos.removeLast();
	}

	/* M�todo privado auxiliar que imprime os n�s contidos na estrutura caminhos. */
	private void imprimeCaminho(Deque<T> caminhos){
		Iterator<T> iterator = caminhos.iterator();

		while(iterator.hasNext())
		{
			System.out.print(iterator.next() + " -> ");
		}

		System.out.println();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/*
	QUEST�O 1:
		A complexidade do m�todo imprimePreOrdem � O(n), onde n � o n�mero de n�s na �rvore.
		temos : O(1) * n = O(n)
		Isso porque os m�todos visitam cada n� exatamente uma vez, realizando uma opera��o de impress�o. Em seguida, ele faz chamadas recursivas para percorrer as sub�rvores.
	 */
	public void imprimePreOrdem(){
			System.out.print("(" + val);

			if (esq != null)
				esq.imprimePreOrdem();

			if (dir != null)
				dir.imprimePreOrdem();

			System.out.print(")");
		}

	public void imprimeEmOrdem(){
		System.out.print("(");
		if(esq != null)
			esq.imprimeEmOrdem();

		System.out.print(val);

		if (dir != null)
			dir.imprimeEmOrdem();

		System.out.print(")");
	}

	public void imprimePosOrdem(){
		System.out.print("(");
		if(esq != null)
			esq.imprimePosOrdem();
		if (dir != null)
			dir.imprimePosOrdem();

		System.out.print(val);
		System.out.print(")");
	}


	/*
	QUEST�O 2:
		A complexidade do m�todo � O(n), pois cada execu��o do m�todo possui O(1) e � realizado n vezes, sendo n a quantidade de n�s da sub �rvore
		temos : O(1) * n = O(n)
	 */
	public static Integer retornaSomaSubArvore(Arvbin<Integer> no){
		if(no == null)
			return 0;

		int soma = 0;
		if(no.esq != null)
			soma += no.esq.val;
		if(no.dir != null)
			soma += no.dir.val;

		return soma + retornaSomaSubArvore(no.esq) + retornaSomaSubArvore(no.dir);
	}

	/*
	QUEST�O 3:
		A complexidade do m�todo � O(n), pois, no pior dos casos, ser� executado n vezes com custo individual de O(1). Sendo n a quantidade de n�s da arvore corrente.
		temos: O(1) * n = O(n)
	 */
	public boolean eSimilar(Arvbin<T> arvore){
		if(arvore == null)
			return false;

		if((esq == null && arvore.esq == null) && (dir == null && arvore.dir == null))
			return true;

		if(!(esq != null && arvore.esq != null) && (dir != null && arvore.dir != null))
			return false;

		return esq.eSimilar(arvore.esq) && dir.eSimilar(arvore.dir);
	}

	/*
	QUEST�O 4:
		A complexidade do m�todo � O(n), pois, no pior dos casos, ser� executado n vezes com custo individual de O(1). Sendo n a quantidade de n�s na arvore

		OBS: o m�todo recursivo buscaFolhaEsq n�o interfere na complexidade do deleteRecursivo pois ele � chamado apenas uma vez, que � no caso do n� possuir o valor
		que esta sendo buscado e seus dois filhos serem n�o nulos. Sendo assim, a complexidade desse m�todo � somada, e n�o multiplicada por cada n�. Ignorando a complexidade
		menor, entre buscaFolhaEsq e o restante da implementa��o de deleteRecursivo, temos O(n).

		temos: O(1) * n = O(n)
	*/
	public void delete(T valor){
		Arvbin<T> ant = this;
		deleteRecursivo(valor, ant);
	}

	private void deleteRecursivo(T valor, Arvbin<T> ant){
		if (val != null && val.compareTo(valor) == 0) {
			if (esq == null && dir == null)
				if(ant.esq == this)
					ant.esq = null;
				else
					ant.dir = null;
			else if (esq != null && dir != null) {
				Arvbin<T> folha = esq.buscaFolhaEsq();

				if(ant.esq == this){
					ant.esq = esq;
					folha.esq = dir;
				}
				else{
					ant.dir = esq;
					folha.esq = dir;
				}
				esq = dir = null;
			} else {
				Arvbin<T> filho = (esq != null) ? esq : dir;

				if(ant.esq == this)
					ant.esq = filho;
				else
					ant.dir = filho;

				filho = null;
			}
		}
		else {
			ant = this;
			if(esq != null)
				esq.deleteRecursivo(valor, ant);
			if(dir != null)
				dir.deleteRecursivo(valor, ant);
		}
	}

	private Arvbin<T> buscaFolhaEsq(){
		if(esq != null)
			return esq.buscaFolhaEsq();
		else
			return this;
	}


	/*
	QUEST�O 5:
		A complexidade desse m�todo vai ser a mesma que a do m�todo busca que est� sendo chamado, o restante � constante pois s�o apenas atribui��es.
		complexidade O(n)
	 */
	public void tornaRaiz(T valor){
		Arvbin<T> ant, raiz;
		ant = raiz = this;

		tornaRaizRecursivo(valor, raiz, ant);
	}

	private Arvbin<T> tornaRaizRecursivo(T valor, Arvbin<T> raiz, Arvbin<T> ant){
		if(val != null && val.compareTo(valor) == 0){
			if(esq == null && dir == null){
				if(ant.esq == this)
					ant.esq = null;
				else
					ant.dir = null;
			}
			else if(esq != null && dir != null){
				Arvbin<T> folha = esq.buscaFolhaEsq();

				if(ant.esq == this){
					ant.esq = esq;
					folha.esq = dir;
				}
				else{
					ant.dir = esq;
					folha.esq = dir;
				}
				dir = null;
			}
			else{
				Arvbin<T> filho = (esq != null) ? esq: dir;

				if(ant.esq == this)
					ant.esq = filho;
				else
					ant.dir = filho;
			}
			esq = raiz;
		}
		else{
			ant = this;
			if(esq != null)
				esq.tornaRaizRecursivo(valor, raiz, ant);
			if(dir != null)
				dir.tornaRaizRecursivo(valor,raiz, ant);
		}
	}


	/*
	QUEST�O 6:
	 	A complexidade desse m�todo � O(n), ele � bem parecido com o m�todo calculaAltura, por�m ele retorna -1 quando a altura das subarvores da esquerda e direita tem diferen�a maior que 1.
	 	Sendo n a quantidade de n�s da arvore corrente.
	 	temos: O(1) * n = O(n)

		complexidade O(n)
	 */
	public boolean eBalanceada(){
		return verificaBalanceamento(this) != -1;
	}

	private int verificaBalanceamento(Arvbin<T> no){
		if(no == null)
			return 0;

		int alturaEsq = verificaBalanceamento(no.esq);
		int alturaDir = verificaBalanceamento(no.dir);
		int alturaDif = alturaEsq - alturaDir;

		if(alturaEsq == -1 || alturaDir == -1)
			return -1;

		if(Math.abs(alturaDif) > 1)
			return -1;
		else
			return Math.max(alturaEsq, alturaDir) + 1;
	}


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//m�todo para auxiliar nos testes
	public static Arvbin<Integer> criarArvoreDeInteirosDeAltura(int altura) {
		if (altura < 0) {
			return null;
		}

		Random random = new Random();
		int valor = random.nextInt(100); // Gerando valores aleat�rios de 0 a 99

		Arvbin<Integer> arvore = new Arvbin<>(valor);

		arvore.defineEsq(criarArvoreDeInteirosDeAltura(altura - 1));
		arvore.defineDir(criarArvoreDeInteirosDeAltura(altura - 1));

		return arvore;
	}
}