<?php
include_once 'src/main/acceso_datos/MantenimientoDeDatos.php';
include_once 'src/main/acceso_datos/RecuperacionDeDatos.php';
class Negocios {
	private $_mantenimientoDeDatos;
	private $_recuperacionDeDatos;
	function __construct() {
		$this->_mantenimientoDeDatos =  new MantenimientoDeDatos();
		$this->_recuperacionDeDatos =  new RecuperacionDeDatos();
	}
		
	function obtenerUsuarios() {
		return $this->_recuperacionDeDatos->leerUsuarios();
	}
	
	function obtenerUsuarioPorNomUsuario($nomUsuario) {
		return $this->_recuperacionDeDatos->leerUsuarioPorNomUsuario($nomUsuario);
	}
	
	function agregarUsuario($usuario) {
		return $this->_mantenimientoDeDatos->escribirUsuario($usuario);
	}
}
?>