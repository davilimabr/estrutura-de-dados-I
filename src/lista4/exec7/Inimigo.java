package lista4.exec7;

import java.util.Objects;

public class Inimigo
{
    private String nome;
    private int vida;
    private double danoPorSegundo;

    public Inimigo(String nome, int vida, double danoPorSegundo) {
        this.nome = nome;
        this.vida = vida;
        this.danoPorSegundo = danoPorSegundo;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getDanoPorSegundo() {
        return danoPorSegundo;
    }

    public void setDanoPorSegundo(double danoPorSegundo) {
        this.danoPorSegundo = danoPorSegundo;
    }

    @Override
    public String toString() {
        return String.format("{nome: %s, vida: %d, danoPorsegundo: %f}\n", nome, vida, danoPorSegundo);
    }
}
