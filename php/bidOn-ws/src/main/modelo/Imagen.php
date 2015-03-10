<?php
class Imagen {
	var $id;
	var $articuloId;
	var $nombre;
	var $descripcion;
	var $ruta;

	function obtenerId() { return $this->id; }
	function obtenerArticuloId() { return $this->articuloId; }
	function obtenerNombre() { return $this->nombre; }
	function obtenerDescripcion() { return $this->descripcion; }
	function obtenerRuta() { return $this->ruta; }

	function establecerId($id) { $this->id = $id; }
	function establecerArticuloId($articuloId) { $this->articuloId = $articuloId; }
	function establecerNombre($nombre) { $this->nombre = $nombre; }
	function establecerDescripcion($descripcion) { $this->descripcion = $descripcion; }
	function establecerRuta($ruta) { $this->ruta = $ruta; }
}
?>
