<?php
include_once 'src/main/modelo/Usuario.php';
include_once 'src/main/recursos/Configuracion.php';
class EscrituraMySql {
    private $_conn;

    function __construct() {        
        $this->_conn = mysqli_connect(Configuracion::URL, Configuracion::USUARIO, Configuracion::PASSWD, Configuracion::BASEDEDATOS, Configuracion::PUERTO, Configuracion::SOCKET);
        if ($this->_conn->connect_errno) {
            return ("Falló la conexión: " . $this->_conn->connect_error);
        }
    }

    function insertarUsuario($usuario) {
        return $this->insertar($usuario, 'Usuario');
    }
    
    function insertar($objeto, $clase) {
        $nObjeto = new $clase();
        $consultaCol = 'INSERT INTO ' . $clase . ' (';
        $consultaVal = 'VALUES (';
        foreach (array_keys((array) new $clase()) as $llave) {
            $metodo = ucfirst($llave);
            $metodo = 'establecer'. $metodo;
            if (method_exists($clase, $metodo) && isset($objeto->{$llave})){
                $consultaCol = $consultaCol . preg_replace('/\B([A-Z])/', '_$1', $llave) . ',';
                $consultaVal = $consultaVal . "'" . $objeto->{$llave} . "'" . ',';
                $nObjeto->$metodo($objeto->{$llave});
            } else {
                $this->cerrarConexion();
                return 'El objeto recibido no es correcto';
            }
        }
        $consultaCol = preg_replace('/,$/','', $consultaCol) . ') ';
        $consultaVal = preg_replace('/,$/','', $consultaVal) . ');';
        $consulta = $consultaCol . $consultaVal;
        if ($this->_conn->query($consulta) == FALSE) {
            return 'Error al insertar objeto: ' . $this->_conn->error;
        }
        $this->cerrarConexion();
        return json_encode($nObjeto);       
    }

    function cerrarConexion() {
        mysqli_close($this->_conn);
    }
}
?>