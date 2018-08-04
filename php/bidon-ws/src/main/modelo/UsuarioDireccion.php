<?php
class Usuario_Direccion {
	var $usuarioId;
	var $direccionId;

	function obtenerUsuarioId() { return $this->usuarioId; }
	function obtenerDireccionId() { return $this->direccionId; }

	function establecerUsuarioId($usuarioId) { $this->usuarioId = $usuarioId; }
	function establecerDireccionId($direccionId) { $this->direccionId = $direccionId; }
}
?>
