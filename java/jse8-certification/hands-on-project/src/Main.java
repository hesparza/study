import mx.com.itesm.aplicacionejemplo.dominio.Cliente;
import mx.com.itesm.aplicacionejemplo.dominio.Cuenta;
import mx.com.itesm.aplicacionejemplo.dominio.CuentaAhorros;
import mx.com.itesm.aplicacionejemplo.dominio.CuentaCheques;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
    public static void main(String[] args) {
        System.out.println("Test Banco Starting");

        Cuenta cuenta = new CuentaCheques(900,5000.00,"1234567890123456","MXN","", LocalDateTime.now());
        Cliente cliente = new Cliente("Esparza", "Hiram", "Av. Barrio Americano 2003","Madera", "Chihuahua", "Mexico", "6525720658" , "hiram.esparaz@gmail.com", cuenta);

        Cuenta cuenta2 = new CuentaAhorros(1200,10000.00,"1234567890123345","MXN","", LocalDateTime.now());
        Cliente cliente2 = new Cliente("Esparza", "Hiram", "Av. Barrio Americano 2003","Madera", "Chihuahua", "Mexico", "6525720658" , "hiram.esparaz@gmail.com", cuenta2);
    }
}
