package lista_conjuntos;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Conjunto conj1 = new Conjunto();
        conj1.adiciona(1);
        conj1.adiciona(2);
        conj1.adiciona(3);
        conj1.adiciona(4);
        conj1.adiciona(5);
        conj1.adiciona(6);
        conj1.adiciona(7);
        conj1.adiciona(8);
        conj1.adiciona(9);
        conj1.adiciona(10);
        conj1.adiciona(97);
        conj1.remove(97);


        Conjunto conj2 = new Conjunto();
        conj2.adiciona(2);
        conj2.adiciona(12);
        conj2.adiciona(4);
        conj2.adiciona(7);
        conj2.adiciona(18);

        System.out.print(String.format("União conjunto 1 e 2:  %s\n", conj1.uniao(conj2).toString()));
        System.out.print(String.format("Intersecção conjunto 1 e 2:  %s\n", conj1.interseccao(conj2).toString()));
        System.out.print(String.format("8 pertence ao conjunto 1?  %s\n", conj1.pertence(8)));
        System.out.print(String.format("Cardinalidade do conjunto 1:  %s\n", conj1.cardinalidade()));
        System.out.print(String.format("Menor elemento conjunto 1:  %s\n", conj1.menorElemento()));
        System.out.print(String.format("Maior elemento conjunto 1: %s\n", conj1.maiorElemento()));
        System.out.print(String.format("conjunto 1 é vazio? %s\n", conj1.isVazio()));
        System.out.print(String.format("conjunto 1 e 2 iguais? %s\n", conj1.iguais(conj2)));
        System.out.print(String.format("conjunto 2 é subconjunto de 1 ? %s\n", conj1.isSubConjunto(conj2)));
        System.out.print(String.format("conjunto 2 é subconjunto propópio de 1 ?%s\n", conj1.isSubconjuntoProprio(conj2)));
        System.out.print(String.format("conjunto 1 é universo ? %s\n", conj1.isUniverso()));
    }
}