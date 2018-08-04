<?php
class Articulo {
	var $id;
	var $nombre;
	var $descripcion;
	var $precio;
	var $cantidad;
	var $fechaCreacion;
	var $fechaModificacion;

	function obtenerId() { return $this->id; }
	function obtenerNombre() { return $this->nombre; }
	function obtenerDescripcion() { return $this->descripcion; }
	function obtenerPrecio() { return $this->precio; }
	function obtenerCantidad() { return $this->cantidad; }
	function obtenerFechaCreacion() { return $this->fechaCreacion; }
	function obtenerFechaModificacion() { return $this->fechaModificacion; }

	function establecerId($id) { $this->id = $id; }
	function establecerNombre($nombre) { $this->nombre = $nombre; }
	function establecerDescripcion($descripcion) { $this->descripcion = $descripcion; }
	function establecerPrecio($precio) { $this->precio = $precio; }
	function establecerCantidad($cantidad) { $this->cantidad = $cantidad; }
	function establecerFechaCreacion($fechaCreacion) { $this->fechaCreacion = $fechaCreacion; }
	function establecerFechaModificacion($fechaModificacion) { $this->fechaModificacion = $fechaModificacion; }
}
?>
