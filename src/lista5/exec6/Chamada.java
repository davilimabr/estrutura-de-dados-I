package lista5.exec6;

public class Chamada {
    private final int CUSTO_POR_KM = 1;

    private int codigo;
    private double distanciaEmKm;

    public Chamada(int codigo, double distanciaEmKm) {
        this.codigo = codigo;
        this.distanciaEmKm = distanciaEmKm;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getDistanciaEmKm() {
        return distanciaEmKm;
    }

    public void setDistanciaEmKm(double distanciaEmKm) {
        this.distanciaEmKm = distanciaEmKm;
    }

    public double obterCustoTotal(){
        return distanciaEmKm * CUSTO_POR_KM;
    }

    @Override
    public String toString() {
        return "Chamada{" +
                "CUSTO_POR_KM=" + CUSTO_POR_KM +
                ", codigo=" + codigo +
                ", distanciaEmKm=" + distanciaEmKm +
                '}';
    }
}
