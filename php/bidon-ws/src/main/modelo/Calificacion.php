<?php
class Calificacion {
	var $id;
	var $usuarioCalificaId;
	var $usuarioCalificadoId;
	var $subastaId;
	var $calificacion;

	function obtenerId() { return $this->id; }
	function obtenerUsuarioCalificaId() { return $this->usuarioCalificaId; }
	function obtenerUsuarioCalificadoId() { return $this->usuarioCalificadoId; }
	function obtenerSubastaId() { return $this->subastaId; }
	function obtenerCalificacion() { return $this->calificacion; }

	function establecerId($id) { $this->id = $id; }
	function establecerUsuarioCalificaId($usuarioCalificaId) { $this->usuarioCalificaId = $usuarioCalificaId; }
	function establecerUsuarioCalificadoId($usuarioCalificadoId) { $this->usuarioCalificadoId = $usuarioCalificadoId; }
	function establecerSubastaId($subastaId) { $this->subastaId = $subastaId; }
	function establecerCalificacion($calificacion) { $this->calificacion = $calificacion; }
}
?>
