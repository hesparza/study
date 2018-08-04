<?php
class Tarjeta_Credito_Usuario {
	var $tarjetaCreditoId;
	var $usuarioId;

	function obtenerTarjetaCreditoId() { return $this->tarjetaCreditoId; }
	function obtenerUsuarioId() { return $this->usuarioId; }

	function establecerTarjetaCreditoId($tarjetaCreditoId) { $this->tarjetaCreditoId = $tarjetaCreditoId; }
	function establecerUsuarioId($usuarioId) { $this->usuarioId = $usuarioId; }
}
?>
