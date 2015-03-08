<?php
class Rol {
	var $id;
	var $nombre;
	var $descripcion;

	function obtenerId() { return $this->id; }
	function obtenerNombre() { return $this->nombre; }
	function obtenerDescripcion() { return $this->descripcion; }

	function establecerId($id) { $this->id = $id; }
	function establecerNombre($nombre) { $this->nombre = $nombre; }
	function establecerDescripcion($descripcion) { $this->descripcion = $descripcion; }
}
?>
