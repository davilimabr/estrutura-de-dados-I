package lista9.classes;

import lista7.Classes.Arvbin;

import java.util.NoSuchElementException;

public class ArvBinBusca<Chave extends Comparable<Chave>, Valor> 
{
	private No raiz; /* Raiz da �rvore. */

	private class No
	{
		private Chave chave; /* Chave usada nas compara��es. */
		private Valor valor; /* Informa��o armazenada. */
		private No esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */

		/* Cria um n� com chave e valor fornecidos e esq = dir = null. */
		public No(Chave chave, Valor valor)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = null;
			this.dir = null;
		}
		
		/* Cria um n� com chave e valor fornecidos. As sub�rvores esq e dir s�o
		 * passadas por par�metro. */
		public No(Chave chave, Valor valor, No esq, No dir)
		{
			this.chave = chave;
			this.valor = valor;
			this.esq = esq;
			this.dir = dir;
		}
	}
	
	/**
	 *  Cria��o de uma �rvore vazia. 
	 */
	public ArvBinBusca()
	{
		raiz = null;
	}
	
	/** 
	 * Verifica se a �rvore est� vazia.
	 * 
	 * @return se a �rvore est� vazia ou possui algum elemento
	 */
	public boolean vazia()
	{
		return (raiz == null);
	}
	
	/**
	 * Apresenta o conte�do da �rvore em ordem sim�trica.
	 */
	public void mostra()
	{
		mostra(raiz);
	}
	
	private void mostra(No x)
	{
		/* Caso base (crit�rio de parada). */
		if(x == null)
			return;
		
		System.out.print("[");
		
		/* Chamada recursiva para a esquerda. */
		mostra(x.esq);
		
		/* Imprime a chave do n� corrente. */
		System.out.print("<" + x.chave + ">");
		
		/* Chamada recursiva para a direita. */
		mostra(x.dir);
		
		System.out.print("]");
	}
	
    /**
     * Retorna a menor chave da �rvore.
     *
     * @return a menor chave da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave min()
    {
        if(vazia()) 
        	throw new NoSuchElementException("�rvore est� vazia!");
        
        return min(raiz).chave;
    } 

    private No min(No x) { 
        if (x.esq == null) 
        	return x; 
        else
        	return min(x.esq); 
    }
    
    /**
     * Retorna o maior elemento da �rvore.
     *
     * @return o maior elemento da �rvore
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public Chave max() {
        if(vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        return max(raiz).chave;
    } 

    private No max(No x) {
        if (x.dir == null)
        	return x; 
        else
        	return max(x.dir); 
    }
    
    /**
     * Retorna o n�mero de n�s, isto �, pares (chave, valor), contidos na �rvore 
     * bin�ria de busca.
     * 
     * @return o n�mero de n�s da �rvore
     */
    public int tamanho()
    {
    	return tamanho(raiz);
    }
    
    private int tamanho(No x)
    {
    	/* Caso base (crit�rio de parada). */
    	if(x == null)
    		return 0;
    	
    	/* Chamada recursiva para sub�rvores esquerda e direita. */
    	return 1 + tamanho(x.esq) + tamanho(x.dir);
    }
    
    
    /**
     * Retorna a altura da �rvore bin�ria de busca.
     *
     * @return a altura da �rvore (uma �rvore de um �nico n� possui altura 0)
     */
    public int altura()
    {
    	return altura(raiz);
    }
    
    private int altura(No x)
    {
    	if(x == null)
    		return -1;
    	
    	int maxAltura = Math.max(altura(x.esq), altura(x.dir));
    	
    	return 1 + maxAltura;
    }
    
    
    /**
     * Essa �rvore bin�ria de busca cont�m a chave fornecida?
     *
     * @param  chave a chave fornecida
     * @return {@code true} se a �rvore cont�m a chave {@code chave} e
     *         {@code false} caso contr�rio
     * @throws IllegalArgumentException se {@code key} � {@code null}
     */
    public boolean contem(Chave chave) {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        return get(chave) != null;
    }
	
    /**
     * Retorna o valor associado � chave fornecida.
     *
     * @param  chave a chave a ser buscada
     * @return o valor associado � chave fornecida se tal chave se encontra na �rvore
     *         e {@code null} se a chave n�o est� na �rvore
     * @throws IllegalArgumentException if {@code chave} is {@code null}
     */
    public Valor get(Chave chave) 
    {
        return get(raiz, chave);
    }

    private Valor get(No x, Chave chave) 
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        /* A chave n�o se encontra na �rvore. */
        if(x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	return get(x.esq, chave);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	return get(x.dir, chave);
        else /* Chave encontrada. */
        	return x.valor;
    }
    
    /**
     * Insere na �rvore bin�ria de busca o par (chave, valor) fornecido. Caso a �rvore
     * j� possua a chave especificada, o valor antigo � sobrescrito com o novo valor 
     * fornecido. Remove o n� de chave igual � chave fornecida caso o valor especificado
     * seja {@code null}.
     *
     * @param  chave a chave fornecida
     * @param  valor o valor fornecido
     * @throws IllegalArgumentException se {@code chave} � {@code null}
     */
    public void put(Chave chave, Valor valor)
    {
        if(chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if(valor == null) {
            delete(chave);
            return;
        }
        
        raiz = put(raiz, chave, valor);
    }

    private No put(No x, Chave chave, Valor valor)
    {
    	/* Caso base: encontrou a posi��o de inser��o. */
        if (x == null)
        	return new No(chave, valor);
        
        int cmp = chave.compareTo(x.chave);
        
        if(cmp < 0) /* Deve-se ir para a esquerda. */
        	x.esq = put(x.esq, chave, valor);
        else if(cmp > 0) /* Deve-se ir para a direita. */
        	x.dir = put(x.dir, chave, valor);
        else /* Caso tenha encontrado n� de mesma chave. */
        	x.valor = valor;
        
        return x;
    }
	
    /**
     * Remove o n� de menor chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMin() 
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMin(raiz);
    }

    /* M�todo recursivo que anda sempre para a esquerda, procurando o n�
     * de menor chave a ser removido. */
    private No deleteMin(No x) 
    {
    	/* Caso n�o haja filho � esquerda, o n� corrente possui a menor chave. */
        if(x.esq == null) 
        	return x.dir;
        
        x.esq = deleteMin(x.esq);
        
        return x;
    }

    /**
     * Remove o n� de maior chave da �rvore.
     *
     * @throws NoSuchElementException se a �rvore est� vazia
     */
    public void deleteMax()
    {
        if(vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        raiz = deleteMax(raiz);
    }

    /* M�todo recursivo que anda sempre para a direita, procurando o n�
     * de maior chave a ser removido. */
    private No deleteMax(No x) 
    {
        if(x.dir == null)
        	return x.esq;
        
        x.dir = deleteMax(x.dir);
        
        return x;
    }
    
    /**
     * Remove o n� cuja chave seja igual � {@code chave} fornecida.
     * 
     * @param chave a chave fornecida
     * @return {@code true} se foi poss�vel remover o n� de chave {@code chave} e
     *         {@code false} caso contr�rio
     */
    public void delete(Chave chave)
    {    	
    	raiz = delete(raiz, chave);    	
    }
    
    /* Remove o n� com o valor "val" da "�rvore" a partir do n� para o qual est� sendo chamada a fun��o. Obs: "ref_no" � o ponteiro que referencia o n� para o qual est� sendo chamada a fun��o, o qual pode ter que ser modificado. Retorna false se o valor n�o pertencer � "�rvore".
    */
    private No delete(No x, Chave chave)
    {
    	if (x == null)
    		return null;

    	int cmp = chave.compareTo(x.chave);
    	
    	if(cmp < 0)
    		x.esq = delete(x.esq, chave);
    	else if(cmp > 0)
    		x.dir = delete(x.dir, chave);
    	else
    	{ 
    		if(x.dir == null)
    			return x.esq;
    		if(x.esq  == null)
    			return x.dir;
    		
    		No t = x;

    		/* Pega o menor da sub�rvore direita (mais � esquerda). */
    		x = min(t.dir);

    		/* Remove o menor. */
    		x.dir = deleteMin(t.dir);

    		/* A sub�rvore esquerda se mant�m a mesma. */
    		x.esq = t.esq;
    	}

    	return x;
    }
    
    
    /**
     * Retorna a maior chave na �rvore que � menor ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a maior chave na �rvore menor ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave piso(Chave chave)
    {
        if (chave == null)
        	throw new IllegalArgumentException("A chave fornecida � null!");
        
        if (vazia()) 
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = piso(raiz, chave);
        
        if (x == null)
        	return null;
        else
        	return x.chave;
    } 

    private No piso(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp <  0)
        	return piso(x.esq, chave);
        
        No t = piso(x.dir, chave);

        if (t != null) 
        	return t;
        else
        	return x; 
    }

    
    /**
     * Retorna a menor chave na �rvore que � maior ou igual � {@code chave} fornecida.
     *
     * @param  chave a chave fornecida
     * @return a menor chave na �rvore maior ou igual � {@code chave}
     * @throws NoSuchElementException se a �rvore est� vazia
     * @throws IllegalArgumentException se a {@code chave} � {@code null}
     */
    public Chave topo(Chave chave)
    {
        if (chave == null) 
        	throw new IllegalArgumentException("A chave fornecida � null!");

        if (vazia())
        	throw new NoSuchElementException("A �rvore est� vazia!");
        
        No x = topo(raiz, chave);
        
        if (x == null)
        	return null;
        else 
        	return x.chave;
    }

    private No topo(No x, Chave chave)
    {
        if (x == null)
        	return null;
        
        int cmp = chave.compareTo(x.chave);
        
        if (cmp == 0)
        	return x;
        
        if (cmp < 0)
        { 
            No t = topo(x.esq, chave);
            
            if (t != null)
            	return t;
            else
            	return x; 
        } 
        
        return topo(x.dir, chave); 
    } 

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
        QUEST�O 2:
        A complexidade do m�todo constroiArvore �, em m�dia, O(n log n), onde n � a quantidade de elementos no vetor.

        OBS:
        A complexidade do m�todo put � O(h), onde h � a altura da arvore de busca, por�m a complexidade em rela��o a quantidade de elementos pode variar.
        Se a �rvore estiver perfeitamente balanceada, a complexidade de inser��o ser� O(log n) para cada elemento, resultando em uma complexidade total de O(n log n)
        No entanto, se a �rvore estiver desbalanceada, a complexidade de inser��o pode ser O(n), o que resultaria em uma complexidade total de O(n�).
     */

    public void constroiArvore(int[] vetor){
        raiz = null;

        for (int i = 0; i < vetor.length; i++) {
            Integer num = vetor[i];
            raiz = put(raiz, (Chave) num, (Valor) num);
        }
    }

    /**
        QUEST�O 3:
           A complexidade do m�todo transformaArvBinBusca �, em m�dia, O(n log n), onde n � a quantidade de elementos na arvbin.

        OBS:
        A complexidade do m�todo put � O(h), onde h � a altura da arvore de busca, por�m a complexidade em rela��o a quantidade de elementos pode variar.
        Se a �rvore estiver perfeitamente balanceada, a complexidade de inser��o ser� O(log n) para cada elemento, resultando em uma complexidade total de O(n log n)
        No entanto, se a �rvore estiver desbalanceada, a complexidade de inser��o pode ser O(n), o que resultaria em uma complexidade total de O(n�).
     */

    public void transformaArvBinBusca(Arvbin<Chave> arvoreBinaria){
        raiz = null;
        transformaArvBinBuscaRecursivo(arvoreBinaria);
    }

    private void transformaArvBinBuscaRecursivo(Arvbin<Chave> arvoreBinaria){
        raiz = put(raiz, arvoreBinaria.retornaVal(), null);

        if(arvoreBinaria.retornaEsq() != null)
            transformaArvBinBuscaRecursivo(arvoreBinaria.retornaEsq());
        if(arvoreBinaria.retornaDir() != null)
            transformaArvBinBuscaRecursivo(arvoreBinaria.retornaDir());
    }

    /**
       QUEST�O 4:
        A complexidade do m�todo removeForaIntervalo �, em m�dia, O(n log n), onde n � a quantidade de elementos na arvbin.

        OBS:
        A complexidade do m�todo delete � O(h), onde h � a altura da arvore de busca, por�m a complexidade em rela��o a quantidade de elementos pode variar.
        Se a �rvore estiver perfeitamente balanceada, a complexidade de remo��o ser� O(log n) para cada elemento, resultando em uma complexidade total de O(n log n)
        No entanto, se a �rvore estiver desbalanceada, a complexidade de remo��o pode ser O(n), o que resultaria em uma complexidade total de O(n�).
    */
    public boolean removeForaIntervalo(Chave chaveMin, Chave chaveMax) {
        if (raiz == null)
            return false;

        String raiz1 = raiz.toString();
        raiz = removeForaIntervalo(raiz, chaveMin, chaveMax);

        String raiz2 = "";

        if(raiz != null)
            raiz2 = raiz.toString();

        return !raiz1.equals(raiz2);
    }

    private No removeForaIntervalo(No no, Chave chaveMin, Chave chaveMax) {
        if (no == null)
            return null;

        if (no.chave.compareTo(chaveMin) < 0 || no.chave.compareTo(chaveMax) > 0) {
            no = delete(no, no.chave);
            return removeForaIntervalo(no, chaveMin, chaveMax);
        }

        no.esq = removeForaIntervalo(no.esq, chaveMin, chaveMax);
        no.dir = removeForaIntervalo(no.dir, chaveMin, chaveMax);

        return no;
    }

    /**
       QUEST�O 5:
        A complexidade do m�todo obtemAncestralComum �, no pior caso, O(n), onde n � a quantidade de elementos na arvbin.

        OBS:
        A complexidade do m�todo obtemAncestralComum � O(h), onde h � a altura da arvore de busca, por�m a complexidade em rela��o a quantidade de elementos pode variar.
        Se a �rvore estiver perfeitamente balanceada, a complexidade ser� O(log n) e se a �rvore estiver desbalanceada, a complexidade ser� O(n).
    */
    public No obtemAncestralComum(No primeiroNo, No segundoNo) {
        return obtemAncestralComumAux(raiz, primeiroNo, segundoNo);
    }

    private No obtemAncestralComumAux(No no, No primeiroNo, No segundoNo) {
        if (no == null)
            return null;

        if (primeiroNo.chave.compareTo(no.chave) < 0 && segundoNo.chave.compareTo(no.chave) < 0)
            return obtemAncestralComumAux(no.esq, primeiroNo, segundoNo);
        else if (primeiroNo.chave.compareTo(no.chave) > 0 && segundoNo.chave.compareTo(no.chave) > 0)
            return obtemAncestralComumAux(no.dir, primeiroNo, segundoNo);
        else
            return no;
    }
}