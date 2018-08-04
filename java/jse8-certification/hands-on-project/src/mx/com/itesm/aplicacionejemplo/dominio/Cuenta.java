package mx.com.itesm.aplicacionejemplo.dominio;

import mx.com.itesm.aplicacionejemplo.dominio.utilerias.TipoDeCuenta;

import java.time.LocalDateTime;

public abstract class Cuenta {
    private Integer numeroCuenta;
    private Double balance;
    private String numeroTarjeta;
    private TipoDeCuenta tipo;
    private String divisa;
    private String clabe;
    private LocalDateTime fechaApertura;

    public Cuenta(Integer numeroCuenta, Double balance, String numeroTarjeta, String divisa, String clabe, LocalDateTime fechaApertura) {
        this.numeroCuenta = numeroCuenta;
        this.balance = balance;
        this.numeroTarjeta = numeroTarjeta;
        this.divisa = divisa;
        this.clabe = clabe;
        this.fechaApertura = fechaApertura;
    }

    public abstract double generaComision(final double monto);

        public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public TipoDeCuenta getTipo() {
        return tipo;
    }

    public void setTipo(TipoDeCuenta tipo) {
        this.tipo = tipo;
    }

    public String getDivisa() {
        return divisa;
    }

    public void setDivisa(String divisa) {
        this.divisa = divisa;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public LocalDateTime getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDateTime fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
}
