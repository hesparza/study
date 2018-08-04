<?php
class Tarjeta_Credito {
	var $id;
	var $nombre;
	var $descripcion;
	var $numeracion;
	var $fechaExpiracion;
	var $cvv;
	var $calle;
	var $numero;
	var $colonia;
	var $codigoPostal;
	var $ciudad;
	var $estado;
	var $pais;

	function obtenerId() { return $this->id; }
	function obtenerNombre() { return $this->nombre; }
	function obtenerDescripcion() { return $this->descripcion; }
	function obtenerNumeracion() { return $this->numeracion; }
	function obtenerFechaExpiracion() { return $this->fechaExpiracion; }
	function obtenerCvv() { return $this->cvv; }
	function obtenerCalle() { return $this->calle; }
	function obtenerNumero() { return $this->numero; }
	function obtenerColonia() { return $this->colonia; }
	function obtenerCodigoPostal() { return $this->codigoPostal; }
	function obtenerCiudad() { return $this->ciudad; }
	function obtenerEstado() { return $this->estado; }
	function obtenerPais() { return $this->pais; }

	function establecerId($id) { $this->id = $id; }
	function establecerNombre($nombre) { $this->nombre = $nombre; }
	function establecerDescripcion($descripcion) { $this->descripcion = $descripcion; }
	function establecerNumeracion($numeracion) { $this->numeracion = $numeracion; }
	function establecerFechaExpiracion($fechaExpiracion) { $this->fechaExpiracion = $fechaExpiracion; }
	function establecerCvv($cvv) { $this->cvv = $cvv; }
	function establecerCalle($calle) { $this->calle = $calle; }
	function establecerNumero($numero) { $this->numero = $numero; }
	function establecerColonia($colonia) { $this->colonia = $colonia; }
	function establecerCodigoPostal($codigoPostal) { $this->codigoPostal = $codigoPostal; }
	function establecerCiudad($ciudad) { $this->ciudad = $ciudad; }
	function establecerEstado($estado) { $this->estado = $estado; }
	function establecerPais($pais) { $this->pais = $pais; }
}
?>
