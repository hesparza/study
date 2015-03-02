<?php
class LecturaMySql {
	
	/**
	 * Selecciona todos los usuarios
	 */
	function seleccionarUsuarios() {
		return 'Llegue a LecturaMySql para seleccionar todos los usuarios';
	}
	
	/**
	 * Selecciona un usuario por NomUsuario 
	 * @param unknown $nomUsuario
	 */
	function seleccionarUsuarioPorNomUsuario($nomUsuario) {
		return 'Llegue a LecturaMySql con $nomUsuario = ' . $nomUsuario;
	}
}
?>