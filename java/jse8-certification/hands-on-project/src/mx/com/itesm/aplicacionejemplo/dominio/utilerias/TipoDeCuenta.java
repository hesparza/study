package mx.com.itesm.aplicacionejemplo.dominio.utilerias;

public enum TipoDeCuenta {
    AHORROS("AHORROS"),
    CHEQUES("CHEQUES");

    private final String tipo;

    private TipoDeCuenta(final String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

}
