package mx.com.itesm.aplicacionejemplo.dominio;

import mx.com.itesm.aplicacionejemplo.dominio.utilerias.TipoDeCuenta;

import java.time.LocalDateTime;

public class CuentaAhorros extends Cuenta {
    private static final double TASA_INTERES_DEFAULT = 0.023;

    private double tasaInteres;

    public CuentaAhorros(Integer numeroCuenta, Double balance, String numeroTarjeta, String divisa, String clabe, LocalDateTime fechaApertura) {
        super(numeroCuenta, balance, numeroTarjeta, divisa, clabe, fechaApertura);
        super.setTipo(TipoDeCuenta.AHORROS);
        tasaInteres = TASA_INTERES_DEFAULT;
    }

    @Override
    public double generaComision(double monto) {
        return 0;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }
}
