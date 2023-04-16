package lista2.exec1;

public class Processo {
    private int id;
    private String nome;

    public Processo(int id, String nome){
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString(){
        return String.format("{%d, %s}", id, nome);
    }
}
