package mx.com.itesm.aplicacionejemplo.dominio;

import mx.com.itesm.aplicacionejemplo.dominio.utilerias.TipoDeCuenta;

import java.time.LocalDateTime;

public class CuentaCheques extends Cuenta {
    private double sobregiro;

    public CuentaCheques(Integer numeroCuenta, Double balance, String numeroTarjeta, String divisa, String clabe, LocalDateTime fechaApertura) {
        super(numeroCuenta, balance, numeroTarjeta, divisa, clabe, fechaApertura);
        super.setTipo(TipoDeCuenta.CHEQUES);

    }

    @Override
    public double generaComision(double monto) {
        return 0;
    }

    public double getSobregiro() {
        return sobregiro;
    }

    public void setSobregiro(double sobregiro) {
        this.sobregiro = sobregiro;
    }
}
