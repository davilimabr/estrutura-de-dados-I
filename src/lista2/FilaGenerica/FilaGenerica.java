package lista2.FilaGenerica;

import lista1.exec3.PilhaDuplaDeInteiros;
import lista1.exec4.PilhaGenerica;
import lista2.exec4.FilaDuplaGenerica;

import java.util.Vector;

public class FilaGenerica<T>{
	protected final int TAMANHO_DEFAULT = 50;
	protected int tamanho;    /* Tamanho do vetor */
	protected Vector<T> vetor;    /* Vetor de elementos */
	protected int ini;    /* Posicao do proximo elemento a ser retirado */
	protected int n;    /* Numero de elementos na fila */

	public FilaGenerica(int tamanho){
		inicializarAtributos(tamanho);
	}
	public FilaGenerica(){
		inicializarAtributos(TAMANHO_DEFAULT);
	}

	protected void inicializarAtributos(int tamanho){
		this.tamanho = tamanho;
		this.vetor = new Vector<>(tamanho);
		this.ini = 0;
		this.n = 0;
	}

	public boolean vazia() {
		return (n == 0);
	}

	public boolean cheia() {
		return (n == tamanho);
	}

	public T remove(){
		T elemento = null;

		if (!this.vazia()) {
			elemento = this.vetor.get(ini);
			ini = (ini + 1) % tamanho;
			n--;
		}

		return elemento;
	}

	public boolean insere(T elemento) {
		int fim;

		if ( !cheia() ) {
			fim = (ini + n) % tamanho;
			this.vetor.add(fim, elemento);
			n++;
			return true;
		} else
			return false;
	}

	//METODO DO EXERCICIO 2 ----------------------------------------------
	public void combinaFilas(FilaGenerica fila1, FilaGenerica fila2){
		if(fila1.getClass() != this.getClass() && fila2.getClass() != this.getClass())
			return;

		boolean alterna = true;
		while(!this.cheia()){
			T objeto = null;

			if(alterna)
				objeto = (T) fila1.remove();
			else
				objeto = (T) fila2.remove();

			this.insere(objeto);
			alterna = !alterna;
		}
	}

	//METODO DO EXERCICIO 4 -----------------------------------------------
	public static FilaDuplaGenerica FilaParaFilaDupla(FilaGenerica fila){
		FilaDuplaGenerica filaDupla = new FilaDuplaGenerica(fila.tamanho);

		while(!fila.vazia()){
			filaDupla.insere(fila.remove());
		}

		return filaDupla;
	}

	@Override
	public String toString(){
		String string = "";

		for(int i = ini, count = 0; count < n; count++){
			string += this.vetor.get(i).toString() + "  ";

			i = (i == tamanho-1) ? 0 : i+1;
		}

		return string;
	}
}