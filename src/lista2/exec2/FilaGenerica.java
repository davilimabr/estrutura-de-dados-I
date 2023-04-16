package lista2.exec2;

import java.util.Vector;

public class FilaGenerica<T>{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;    /* Tamanho do vetor */
	protected Vector<T> vetor;    /* Vetor de elementos */
	protected int ini;    /* Posicao do proximo elemento a ser retirado */
	protected int n;    /* Numero de elementos na fila */

	public FilaGenerica(int tam){
		tamanho = tam;
		vetor = new Vector<>(tam);
		ini = 0;
		n = 0;
	}

	public boolean vazia() {
		return (n == 0);
	}

	public boolean cheia() {
		return (n == tamanho);
	}

	//Retiramos o elemento do início da fila
	public T remove(){
		T elemento = null;

		if (!this.vazia()) {
			elemento = this.vetor.get(ini);
			ini = (ini + 1) % tamanho;
			n--;
		}

		return elemento;
	}

	//Inserimos o elemento no final da fila
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

	@Override
	public String toString(){
		String string = "";

		for(int i = ini; i < ini + n; i++){
			string += this.vetor.get(i).toString() + "  ";
		}

		if(ini > 0 && (ini + n) > tamanho){
			for(int i = 0; i < ini; i++){
				string += this.vetor.toString() + "  ";
			}
		}
		return string;
	}
}