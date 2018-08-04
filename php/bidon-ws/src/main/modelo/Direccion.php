<?php
class Direccion {
	var $id;
	var $usuarioId;
	var $calle;
	var $numeroExt;
	var $numeroInt;
	var $colonia;
	var $codigoPostal;
	var $ciudad;
	var $estado;
	var $pais;

	function obtenerId() { return $this->id; }
	function obtenerUsuarioId() { return $this->usuarioId; }
	function obtenerCalle() { return $this->calle; }
	function obtenerNumeroExt() { return $this->numeroExt; }
	function obtenerNumeroInt() { return $this->numeroInt; }
	function obtenerColonia() { return $this->colonia; }
	function obtenerCodigoPostal() { return $this->codigoPostal; }
	function obtenerCiudad() { return $this->ciudad; }
	function obtenerEstado() { return $this->estado; }
	function obtenerPais() { return $this->pais; }

	function establecerId($id) { $this->id = $id; }
	function establecerUsuarioId($usuarioId) { $this->usuarioId = $usuarioId; }
	function establecerCalle($calle) { $this->calle = $calle; }
	function establecerNumeroExt($numeroExt) { $this->numeroExt = $numeroExt; }
	function establecerNumeroInt($numeroInt) { $this->numeroInt = $numeroInt; }
	function establecerColonia($colonia) { $this->colonia = $colonia; }
	function establecerCodigoPostal($codigoPostal) { $this->codigoPostal = $codigoPostal; }
	function establecerCiudad($ciudad) { $this->ciudad = $ciudad; }
	function establecerEstado($estado) { $this->estado = $estado; }
	function establecerPais($pais) { $this->pais = $pais; }
}
?>
