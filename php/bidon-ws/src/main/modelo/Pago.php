<?php
class Pago {
	var $id;
	var $tipoPagoId;
	var $subastaId;
	var $fecha;
	var $pagoAceptado;
	var $cantidad;

	function obtenerId() { return $this->id; }
	function obtenerTipoPagoId() { return $this->tipoPagoId; }
	function obtenerSubastaId() { return $this->subastaId; }
	function obtenerFecha() { return $this->fecha; }
	function obtenerPagoAceptado() { return $this->pagoAceptado; }
	function obtenerCantidad() { return $this->cantidad; }

	function establecerId($id) { $this->id = $id; }
	function establecerTipoPagoId($tipoPagoId) { $this->tipoPagoId = $tipoPagoId; }
	function establecerSubastaId($subastaId) { $this->subastaId = $subastaId; }
	function establecerFecha($fecha) { $this->fecha = $fecha; }
	function establecerPagoAceptado($pagoAceptado) { $this->pagoAceptado = $pagoAceptado; }
	function establecerCantidad($cantidad) { $this->cantidad = $cantidad; }
}
?>
