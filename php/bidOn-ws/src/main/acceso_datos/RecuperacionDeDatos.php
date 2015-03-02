<?php
include_once 'src/main/lectura_escritura_datos/LecturaMySql.php';

class RecuperacionDeDatos {
	private $_lecturaMySql;
	
	function __construct() {
		$this->_lecturaMySql = new LecturaMySql();
		$this->_escrituraMySql = new EscrituraMySql();
	}
	
	function leerUsuarios() {
		return $this->_lecturaMySql->seleccionarUsuarios();
	}
	
	function leerUsuarioPorNomUsuario($nomUsuario) {
		return $this->_lecturaMySql->seleccionarUsuarioPorNomUsuario($nomUsuario);
	}
}
?>