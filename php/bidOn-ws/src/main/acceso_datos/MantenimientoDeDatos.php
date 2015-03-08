<?php
include_once 'src/main/lectura_escritura_datos/EscrituraMySql.php';
class MantenimientoDeDatos {
	private $_escrituraMySql;

	function __construct() {
		$this->_escrituraMySql = new EscrituraMySql();
	}

	/**
	Agregar datos
	**/
	function escribirArticulo($articulo) {
		return $this->_mantenimientoDeDatos->insertarArticulo($articulo);
	}
	function escribirCalificacion($calificacion) {
		return $this->_mantenimientoDeDatos->insertarCalificacion($calificacion);
	}
	function escribirCategoria($categoria) {
		return $this->_mantenimientoDeDatos->insertarCategoria($categoria);
	}
	function escribirDireccion($direccion) {
		return $this->_mantenimientoDeDatos->insertarDireccion($direccion);
	}
	function escribirEnvio($envio) {
		return $this->_mantenimientoDeDatos->insertarEnvio($envio);
	}
	function escribirEstadoSubasta($estadoSubasta) {
		return $this->_mantenimientoDeDatos->insertarEstadoSubasta($estadoSubasta);
	}
	function escribirEstadoUsuario($estadoUsuario) {
		return $this->_mantenimientoDeDatos->insertarEstadoUsuario($estadoUsuario);
	}
	function escribirImagen($imagen) {
		return $this->_mantenimientoDeDatos->insertarImagen($imagen);
	}
	function escribirMensaje($mensaje) {
		return $this->_mantenimientoDeDatos->insertarMensaje($mensaje);
	}
	function escribirOferta($oferta) {
		return $this->_mantenimientoDeDatos->insertarOferta($oferta);
	}
	function escribirPago($pago) {
		return $this->_mantenimientoDeDatos->insertarPago($pago);
	}
	function escribirRol($rol) {
		return $this->_mantenimientoDeDatos->insertarRol($rol);
	}
	function escribirSubasta($subasta) {
		return $this->_mantenimientoDeDatos->insertarSubasta($subasta);
	}
	function escribirTarjetaCredito($tarjetaCredito) {
		return $this->_mantenimientoDeDatos->insertarTarjetaCredito($tarjetaCredito);
	}
	function escribirTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_mantenimientoDeDatos->insertarTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function escribirTipoEnvio($tipoEnvio) {
		return $this->_mantenimientoDeDatos->insertarTipoEnvio($tipoEnvio);
	}
	function escribirTipoPago($tipoPago) {
		return $this->_mantenimientoDeDatos->insertarTipoPago($tipoPago);
	}
	function escribirTipoSubasta($tipoSubasta) {
		return $this->_mantenimientoDeDatos->insertarTipoSubasta($tipoSubasta);
	}
	function escribirUsuario($usuario) {
		return $this->_mantenimientoDeDatos->insertarUsuario($usuario);
	}
	function escribirUsuarioDireccion($usuarioDireccion) {
		return $this->_mantenimientoDeDatos->insertarUsuarioDireccion($usuarioDireccion);
	}


	/**
	Editar datos
	**/
	function modificarArticulo($articulo) {
		return $this->_mantenimientoDeDatos->actualizarArticulo($articulo);
	}
	function modificarCalificacion($calificacion) {
		return $this->_mantenimientoDeDatos->actualizarCalificacion($calificacion);
	}
	function modificarCategoria($categoria) {
		return $this->_mantenimientoDeDatos->actualizarCategoria($categoria);
	}
	function modificarDireccion($direccion) {
		return $this->_mantenimientoDeDatos->actualizarDireccion($direccion);
	}
	function modificarEnvio($envio) {
		return $this->_mantenimientoDeDatos->actualizarEnvio($envio);
	}
	function modificarEstadoSubasta($estadoSubasta) {
		return $this->_mantenimientoDeDatos->actualizarEstadoSubasta($estadoSubasta);
	}
	function modificarEstadoUsuario($estadoUsuario) {
		return $this->_mantenimientoDeDatos->actualizarEstadoUsuario($estadoUsuario);
	}
	function modificarImagen($imagen) {
		return $this->_mantenimientoDeDatos->actualizarImagen($imagen);
	}
	function modificarMensaje($mensaje) {
		return $this->_mantenimientoDeDatos->actualizarMensaje($mensaje);
	}
	function modificarOferta($oferta) {
		return $this->_mantenimientoDeDatos->actualizarOferta($oferta);
	}
	function modificarPago($pago) {
		return $this->_mantenimientoDeDatos->actualizarPago($pago);
	}
	function modificarRol($rol) {
		return $this->_mantenimientoDeDatos->actualizarRol($rol);
	}
	function modificarSubasta($subasta) {
		return $this->_mantenimientoDeDatos->actualizarSubasta($subasta);
	}
	function modificarTarjetaCredito($tarjetaCredito) {
		return $this->_mantenimientoDeDatos->actualizarTarjetaCredito($tarjetaCredito);
	}
	function modificarTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_mantenimientoDeDatos->actualizarTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function modificarTipoEnvio($tipoEnvio) {
		return $this->_mantenimientoDeDatos->actualizarTipoEnvio($tipoEnvio);
	}
	function modificarTipoPago($tipoPago) {
		return $this->_mantenimientoDeDatos->actualizarTipoPago($tipoPago);
	}
	function modificarTipoSubasta($tipoSubasta) {
		return $this->_mantenimientoDeDatos->actualizarTipoSubasta($tipoSubasta);
	}
	function modificarUsuario($usuario) {
		return $this->_mantenimientoDeDatos->actualizarUsuario($usuario);
	}
	function modificarUsuarioDireccion($usuarioDireccion) {
		return $this->_mantenimientoDeDatos->actualizarUsuarioDireccion($usuarioDireccion);
	}

}
?>
