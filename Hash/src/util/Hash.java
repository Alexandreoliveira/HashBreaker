package util;

public class Hash {
    private int qtd = 1;
    private int caracteres;

    public Hash(int caracteres) {
        this.caracteres = caracteres;
    }

    protected int getQtd() {
        return qtd;
    }

    protected void setQtd() {
        this.qtd++;
    }

    protected int getCaracteres() {
        return caracteres;
    }

    protected void setCaracteres(int caracteres) {
        this.caracteres = caracteres;
    }
    
    
}
