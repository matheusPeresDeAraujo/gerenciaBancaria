package model;

public class Boleto {

    private String codBarra;
    private float valor;

    public Boleto(String codBarra, float valor) {
        super();
        this.codBarra = codBarra;
        this.valor = valor;
    }

    public Boleto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getCodBarra() {
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codBarra == null) ? 0 : codBarra.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Boleto other = (Boleto) obj;
        if (codBarra == null) {
            if (other.codBarra != null) {
                return false;
            }
        } else if (!codBarra.equals(other.codBarra)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Boleto [codBarra=" + codBarra + ", valor=" + valor + "]";
    }

}
