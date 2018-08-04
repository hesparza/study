<?php
class Subasta {
	var $id;
	var $tipoSubastaId;
	var $usuarioCreo;
	var $usuarioGanador;
	var $usuarioAprobo;
	var $articuloId;
	var $categoriaId;
	var $estadoId;
	var $fechaInicio;
	var $fechaFin;
	var $fechaAprobacion;
	var $fechaCreacion;
	var $fechaModificacion;

	function obtenerId() { return $this->id; }
	function obtenerTipoSubastaId() { return $this->tipoSubastaId; }
	function obtenerUsuarioCreo() { return $this->usuarioCreo; }
	function obtenerUsuarioGanador() { return $this->usuarioGanador; }
	function obtenerUsuarioAprobo() { return $this->usuarioAprobo; }
	function obtenerArticuloId() { return $this->articuloId; }
	function obtenerCategoriaId() { return $this->categoriaId; }
	function obtenerEstadoId() { return $this->estadoId; }
	function obtenerFechaInicio() { return $this->fechaInicio; }
	function obtenerFechaFin() { return $this->fechaFin; }
	function obtenerFechaAprobacion() { return $this->fechaAprobacion; }
	function obtenerFechaCreacion() { return $this->fechaCreacion; }
	function obtenerFechaModificacion() { return $this->fechaModificacion; }

	function establecerId($id) { $this->id = $id; }
	function establecerTipoSubastaId($tipoSubastaId) { $this->tipoSubastaId = $tipoSubastaId; }
	function establecerUsuarioCreo($usuarioCreo) { $this->usuarioCreo = $usuarioCreo; }
	function establecerUsuarioGanador($usuarioGanador) { $this->usuarioGanador = $usuarioGanador; }
	function establecerUsuarioAprobo($usuarioAprobo) { $this->usuarioAprobo = $usuarioAprobo; }
	function establecerArticuloId($articuloId) { $this->articuloId = $articuloId; }
	function establecerCategoriaId($categoriaId) { $this->categoriaId = $categoriaId; }
	function establecerEstadoId($estadoId) { $this->estadoId = $estadoId; }
	function establecerFechaInicio($fechaInicio) { $this->fechaInicio = $fechaInicio; }
	function establecerFechaFin($fechaFin) { $this->fechaFin = $fechaFin; }
	function establecerFechaAprobacion($fechaAprobacion) { $this->fechaAprobacion = $fechaAprobacion; }
	function establecerFechaCreacion($fechaCreacion) { $this->fechaCreacion = $fechaCreacion; }
	function establecerFechaModificacion($fechaModificacion) { $this->fechaModificacion = $fechaModificacion; }
}
?>
