<?php
class Mensaje {
	var $id;
	var $usuarioId;
	var $subastaId;
	var $contenido;
	var $abilitado;
	var $fechaCreacion;
	var $fechaModificacion;

	function obtenerId() { return $this->id; }
	function obtenerUsuarioId() { return $this->usuarioId; }
	function obtenerSubastaId() { return $this->subastaId; }
	function obtenerContenido() { return $this->contenido; }
	function obtenerAbilitado() { return $this->abilitado; }
	function obtenerFechaCreacion() { return $this->fechaCreacion; }
	function obtenerFechaModificacion() { return $this->fechaModificacion; }

	function establecerId($id) { $this->id = $id; }
	function establecerUsuarioId($usuarioId) { $this->usuarioId = $usuarioId; }
	function establecerSubastaId($subastaId) { $this->subastaId = $subastaId; }
	function establecerContenido($contenido) { $this->contenido = $contenido; }
	function establecerAbilitado($abilitado) { $this->abilitado = $abilitado; }
	function establecerFechaCreacion($fechaCreacion) { $this->fechaCreacion = $fechaCreacion; }
	function establecerFechaModificacion($fechaModificacion) { $this->fechaModificacion = $fechaModificacion; }
}
?>
