<?php
class Envio {
	var $id;
	var $direccionId;
	var $tipoEnvioId;
	var $subastaId;
	var $recibido;
	var $fecha;

	function obtenerId() { return $this->id; }
	function obtenerDireccionId() { return $this->direccionId; }
	function obtenerTipoEnvioId() { return $this->tipoEnvioId; }
	function obtenerSubastaId() { return $this->subastaId; }
	function obtenerRecibido() { return $this->recibido; }
	function obtenerFecha() { return $this->fecha; }

	function establecerId($id) { $this->id = $id; }
	function establecerDireccionId($direccionId) { $this->direccionId = $direccionId; }
	function establecerTipoEnvioId($tipoEnvioId) { $this->tipoEnvioId = $tipoEnvioId; }
	function establecerSubastaId($subastaId) { $this->subastaId = $subastaId; }
	function establecerRecibido($recibido) { $this->recibido = $recibido; }
	function establecerFecha($fecha) { $this->fecha = $fecha; }
}
?>
