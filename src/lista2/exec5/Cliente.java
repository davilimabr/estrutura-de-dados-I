package lista2.exec5;

public class Cliente {
    private String nome;
    private int idade;
    private Cliente.FaixaEtaria faixaEtaria;

    public Cliente(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        definirFaixaEtaria();
    }

    private void definirFaixaEtaria(){
        if(this.idade < 18)
            this.faixaEtaria = FaixaEtaria.Jovem;
        else if(this.idade < 60)
            this.faixaEtaria = FaixaEtaria.Adulto;
        else
            this.faixaEtaria = FaixaEtaria.Idoso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    @Override
    public String toString(){
        return String.format("{nome: %s, idade: %d}", this.nome, this.idade);
    }

    public enum FaixaEtaria {
        Jovem, Adulto, Idoso
    }
}
