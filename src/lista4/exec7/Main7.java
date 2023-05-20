package lista4.exec7;

import lista4.Listas.ListaDeInimigos;

import java.util.Random;

public class Main7 {
    public static void main(String[] args) {
        ListaDeInimigos listaInimigos = new ListaDeInimigos();

        Inimigo inimigo1 = new Inimigo("Bruxo", 12313, 1000);
        Inimigo inimigo2 = new Inimigo("Gladiador", 123, 77);
        Inimigo inimigo3 = new Inimigo("Guerreiro", 1450, 9.867675);

        listaInimigos.insere(inimigo1);
        listaInimigos.insere(inimigo2);
        listaInimigos.insere(inimigo3);

        System.out.println("Inimigos:\n");
        System.out.print(listaInimigos);

        while(inimigo1.getVida() > 0 || inimigo2.getVida() > 0 || inimigo3.getVida() > 0){
            double dano = 123;

            System.out.println("\n\n\nDano recebido por todos:");
            System.out.println(dano);

            listaInimigos.efetuarDano(inimigo1, dano);
            listaInimigos.efetuarDano(inimigo2, dano);
            listaInimigos.efetuarDano(inimigo3, dano);
            System.out.println("Inimigos:");
            System.out.print(listaInimigos);
        }
    }
}
