<?php
class Usuario {
	var $id;
	var $estadoUsuarioId;
	var $rolId;
	var $nombre;
	var $apellidoP;
	var $apellidoM;
	var $correo;
	var $nomUsuario;
	var $contrasena;
	var $reputacion;

	function obtenerId() { return $this->id; }
	function obtenerEstadoUsuarioId() { return $this->estadoUsuarioId; }
	function obtenerRolId() { return $this->rolId; }
	function obtenerNombre() { return $this->nombre; }
	function obtenerApellidoP() { return $this->apellidoP; }
	function obtenerApellidoM() { return $this->apellidoM; }
	function obtenerCorreo() { return $this->correo; }
	function obtenerNomUsuario() { return $this->nomUsuario; }
	function obtenerContrasena() { return $this->contrasena; }
	function obtenerReputacion() { return $this->reputacion; }

	function establecerId($id) { $this->id = $id; }
	function establecerEstadoUsuarioId($estadoUsuarioId) { $this->estadoUsuarioId = $estadoUsuarioId; }
	function establecerRolId($rolId) { $this->rolId = $rolId; }
	function establecerNombre($nombre) { $this->nombre = $nombre; }
	function establecerApellidoP($apellidoP) { $this->apellidoP = $apellidoP; }
	function establecerApellidoM($apellidoM) { $this->apellidoM = $apellidoM; }
	function establecerCorreo($correo) { $this->correo = $correo; }
	function establecerNomUsuario($nomUsuario) { $this->nomUsuario = $nomUsuario; }
	function establecerContrasena($contrasena) { $this->contrasena = $contrasena; }
	function establecerReputacion($reputacion) { $this->reputacion = $reputacion; }
}
?>
