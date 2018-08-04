package mx.com.itesm.aplicacionejemplo.dominio.utilerias;

public class BDConfig {
/*
    // ---- Form 1, eagerly loading -----//

    private final String HOST_NAME;
    private final String BD_NOMBRE;
    private final String USER_NAME;
    private final String PASSWORD;

    private static final BDConfig CONEXION;

    static {
        CONEXION = new BDConfig();
    }

    private BDConfig() {
        HOST_NAME = "127.0.0.1";
        BD_NOMBRE = "practicas";
        USER_NAME = "hesparza";
        PASSWORD = "abc123";
    }

    public static BDConfig getCONEXION() {
        return CONEXION;
    }
*/


// ------ Form 2, lazy loading --------//

    private final String HOST_NAME;
    private final String BD_NOMBRE;
    private final String USER_NAME;
    private final String PASSWORD;

    private static BDConfig CONEXION;

    private BDConfig() {
        HOST_NAME = "127.0.0.1";
        BD_NOMBRE = "practicas";
        USER_NAME = "hesparza";
        PASSWORD = "abc123";
    }

    public static BDConfig getCONEXION() {
        if (CONEXION == null) {
            CONEXION = new BDConfig();
        }
        return CONEXION;
    }
}
