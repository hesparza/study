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
		return $this->_escrituraMySql->insertarArticulo($articulo);
	}
	function escribirCalificacion($calificacion) {
		return $this->_escrituraMySql->insertarCalificacion($calificacion);
	}
	function escribirCategoria($categoria) {
		return $this->_escrituraMySql->insertarCategoria($categoria);
	}
	function escribirDireccion($direccion) {
		return $this->_escrituraMySql->insertarDireccion($direccion);
	}
	function escribirEnvio($envio) {
		return $this->_escrituraMySql->insertarEnvio($envio);
	}
	function escribirEstadoSubasta($estadoSubasta) {
		return $this->_escrituraMySql->insertarEstadoSubasta($estadoSubasta);
	}
	function escribirEstadoUsuario($estadoUsuario) {
		return $this->_escrituraMySql->insertarEstadoUsuario($estadoUsuario);
	}
	function escribirImagen($imagen) {
		return $this->_escrituraMySql->insertarImagen($imagen);
	}
	function escribirMensaje($mensaje) {
		return $this->_escrituraMySql->insertarMensaje($mensaje);
	}
	function escribirOferta($oferta) {
		return $this->_escrituraMySql->insertarOferta($oferta);
	}
	function escribirPago($pago) {
		return $this->_escrituraMySql->insertarPago($pago);
	}
	function escribirRol($rol) {
		return $this->_escrituraMySql->insertarRol($rol);
	}
	function escribirSubasta($subasta) {
		return $this->_escrituraMySql->insertarSubasta($subasta);
	}
	function escribirTarjetaCredito($tarjetaCredito) {
		return $this->_escrituraMySql->insertarTarjetaCredito($tarjetaCredito);
	}
	function escribirTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_escrituraMySql->insertarTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function escribirTipoEnvio($tipoEnvio) {
		return $this->_escrituraMySql->insertarTipoEnvio($tipoEnvio);
	}
	function escribirTipoPago($tipoPago) {
		return $this->_escrituraMySql->insertarTipoPago($tipoPago);
	}
	function escribirTipoSubasta($tipoSubasta) {
		return $this->_escrituraMySql->insertarTipoSubasta($tipoSubasta);
	}
	function escribirUsuario($usuario) {
		return $this->_escrituraMySql->insertarUsuario($usuario);
	}
	function escribirUsuarioDireccion($usuarioDireccion) {
		return $this->_escrituraMySql->insertarUsuarioDireccion($usuarioDireccion);
	}


	/**
	Editar datos
	**/
	function modificarArticulo($articulo) {
		return $this->_escrituraMySql->actualizarArticulo($articulo);
	}
	function modificarCalificacion($calificacion) {
		return $this->_escrituraMySql->actualizarCalificacion($calificacion);
	}
	function modificarCategoria($categoria) {
		return $this->_escrituraMySql->actualizarCategoria($categoria);
	}
	function modificarDireccion($direccion) {
		return $this->_escrituraMySql->actualizarDireccion($direccion);
	}
	function modificarEnvio($envio) {
		return $this->_escrituraMySql->actualizarEnvio($envio);
	}
	function modificarEstadoSubasta($estadoSubasta) {
		return $this->_escrituraMySql->actualizarEstadoSubasta($estadoSubasta);
	}
	function modificarEstadoUsuario($estadoUsuario) {
		return $this->_escrituraMySql->actualizarEstadoUsuario($estadoUsuario);
	}
	function modificarImagen($imagen) {
		return $this->_escrituraMySql->actualizarImagen($imagen);
	}
	function modificarMensaje($mensaje) {
		return $this->_escrituraMySql->actualizarMensaje($mensaje);
	}
	function modificarOferta($oferta) {
		return $this->_escrituraMySql->actualizarOferta($oferta);
	}
	function modificarPago($pago) {
		return $this->_escrituraMySql->actualizarPago($pago);
	}
	function modificarRol($rol) {
		return $this->_escrituraMySql->actualizarRol($rol);
	}
	function modificarSubasta($subasta) {
		return $this->_escrituraMySql->actualizarSubasta($subasta);
	}
	function modificarTarjetaCredito($tarjetaCredito) {
		return $this->_escrituraMySql->actualizarTarjetaCredito($tarjetaCredito);
	}
	function modificarTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_escrituraMySql->actualizarTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function modificarTipoEnvio($tipoEnvio) {
		return $this->_escrituraMySql->actualizarTipoEnvio($tipoEnvio);
	}
	function modificarTipoPago($tipoPago) {
		return $this->_escrituraMySql->actualizarTipoPago($tipoPago);
	}
	function modificarTipoSubasta($tipoSubasta) {
		return $this->_escrituraMySql->actualizarTipoSubasta($tipoSubasta);
	}
	function modificarUsuario($usuario) {
		return $this->_escrituraMySql->actualizarUsuario($usuario);
	}
	function modificarUsuarioDireccion($usuarioDireccion) {
		return $this->_escrituraMySql->actualizarUsuarioDireccion($usuarioDireccion);
	}

}
?>
