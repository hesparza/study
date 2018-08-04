<?php
class Oferta {
	var $id;
	var $usuarioId;
	var $subastaId;
	var $cantidad;
	var $fecha;

	function obtenerId() { return $this->id; }
	function obtenerUsuarioId() { return $this->usuarioId; }
	function obtenerSubastaId() { return $this->subastaId; }
	function obtenerCantidad() { return $this->cantidad; }
	function obtenerFecha() { return $this->fecha; }

	function establecerId($id) { $this->id = $id; }
	function establecerUsuarioId($usuarioId) { $this->usuarioId = $usuarioId; }
	function establecerSubastaId($subastaId) { $this->subastaId = $subastaId; }
	function establecerCantidad($cantidad) { $this->cantidad = $cantidad; }
	function establecerFecha($fecha) { $this->fecha = $fecha; }
}
?>
