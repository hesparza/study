<?php
include_once 'src/main/lectura_escritura_datos/EscrituraMySql.php';
class MantenimientoDeDatos {
	private $_escrituraMySql;
	
	function __construct() {
		$this->_escrituraMySql = new EscrituraMySql();
	}
	
	function escribirUsuario($usuario) {
		return $this->_escrituraMySql->insertarUsuario($usuario);
	}
}
?>