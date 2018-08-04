<?php
include_once 'src/main/acceso_datos/MantenimientoDeDatos.php';
include_once 'src/main/acceso_datos/RecuperacionDeDatos.php';
class Negocios {
	private $_mantenimientoDeDatos;
	private $_recuperacionDeDatos;
	function __construct() {
		$this->_mantenimientoDeDatos =  new MantenimientoDeDatos();
		$this->_recuperacionDeDatos =  new RecuperacionDeDatos();
	}

	/**
	Obtener todos los datos
	**/
	function obtenerArticulos() {
		return $this->_recuperacionDeDatos->leerArticulos();
	}
	function obtenerCalificaciones() {
		return $this->_recuperacionDeDatos->leerCalificaciones();
	}
	function obtenerCategorias() {
		return $this->_recuperacionDeDatos->leerCategorias();
	}
	function obtenerDirecciones() {
		return $this->_recuperacionDeDatos->leerDirecciones();
	}
	function obtenerEnvios() {
		return $this->_recuperacionDeDatos->leerEnvios();
	}
	function obtenerEstadoSubastas() {
		return $this->_recuperacionDeDatos->leerEstado_Subastas();
	}
	function obtenerEstadoUsuarios() {
		return $this->_recuperacionDeDatos->leerEstado_Usuarios();
	}
	function obtenerImagenes() {
		return $this->_recuperacionDeDatos->leerImagenes();
	}
	function obtenerMensajes() {
		return $this->_recuperacionDeDatos->leerMensajes();
	}
	function obtenerOfertas() {
		return $this->_recuperacionDeDatos->leerOfertas();
	}
	function obtenerPagos() {
		return $this->_recuperacionDeDatos->leerPagos();
	}
	function obtenerRoles() {
		return $this->_recuperacionDeDatos->leerRoles();
	}
	function obtenerSubastas() {
		return $this->_recuperacionDeDatos->leerSubastas();
	}
	function obtenerTarjetaCreditos() {
		return $this->_recuperacionDeDatos->leerTarjeta_Creditos();
	}
	function obtenerTarjetaCreditoUsuarios() {
		return $this->_recuperacionDeDatos->leerTarjeta_Credito_Usuarios();
	}
	function obtenerTipoEnvios() {
		return $this->_recuperacionDeDatos->leerTipo_Envios();
	}
	function obtenerTipoPagos() {
		return $this->_recuperacionDeDatos->leerTipo_Pagos();
	}
	function obtenerTipoSubastas() {
		return $this->_recuperacionDeDatos->leerTipo_Subastas();
	}
	function obtenerUsuarios() {
		return $this->_recuperacionDeDatos->leerUsuarios();
	}
	function obtenerUsuarioDirecciones() {
		return $this->_recuperacionDeDatos->leerUsuario_Direcciones();
	}


	/**
	Obtener todos los datos por indices
	**/
	function obtenerArticuloPorId($id) {
		return $this->_recuperacionDeDatos->leerArticuloPorId($id);
	}
	function obtenerCalificacionPorId($id) {
		return $this->_recuperacionDeDatos->leerCalificacionPorId($id);
	}
	function obtenerCalificacionPorSubastaId($subastaId) {
		return $this->_recuperacionDeDatos->leerCalificacionPorSubastaId($subastaId);
	}
	function obtenerCalificacionPorUsuarioCalificaId($usuarioCalificaId) {
		return $this->_recuperacionDeDatos->leerCalificacionPorUsuarioCalificaId($usuarioCalificaId);
	}
	function obtenerCalificacionPorUsuarioCalificadoId($usuarioCalificadoId) {
		return $this->_recuperacionDeDatos->leerCalificacionPorUsuarioCalificadoId($usuarioCalificadoId);
	}
	function obtenerCategoriaPorId($id) {
		return $this->_recuperacionDeDatos->leerCategoriaPorId($id);
	}
	function obtenerDireccionPorId($id) {
		return $this->_recuperacionDeDatos->leerDireccionPorId($id);
	}
	function obtenerEnvioPorId($id) {
		return $this->_recuperacionDeDatos->leerEnvioPorId($id);
	}
	function obtenerEnvioPorDireccionId($direccionId) {
		return $this->_recuperacionDeDatos->leerEnvioPorDireccionId($direccionId);
	}
	function obtenerEnvioPorSubastaId($subastaId) {
		return $this->_recuperacionDeDatos->leerEnvioPorSubastaId($subastaId);
	}
	function obtenerEnvioPorTipoEnvioId($tipoEnvioId) {
		return $this->_recuperacionDeDatos->leerEnvioPorTipoEnvioId($tipoEnvioId);
	}
	function obtenerEstadoSubastaPorId($id) {
		return $this->_recuperacionDeDatos->leerEstadoSubastaPorId($id);
	}
	function obtenerEstadoUsuarioPorId($id) {
		return $this->_recuperacionDeDatos->leerEstadoUsuarioPorId($id);
	}
	function obtenerImagenPorId($id) {
		return $this->_recuperacionDeDatos->leerImagenPorId($id);
	}
	function obtenerImagenPorArticuloId($articuloId) {
		return $this->_recuperacionDeDatos->leerImagenPorArticuloId($articuloId);
	}
	function obtenerMensajePorId($id) {
		return $this->_recuperacionDeDatos->leerMensajePorId($id);
	}
	function obtenerMensajePorSubastaId($subastaId) {
		return $this->_recuperacionDeDatos->leerMensajePorSubastaId($subastaId);
	}
	function obtenerMensajePorUsuarioId($usuarioId) {
		return $this->_recuperacionDeDatos->leerMensajePorUsuarioId($usuarioId);
	}
	function obtenerOfertaPorId($id) {
		return $this->_recuperacionDeDatos->leerOfertaPorId($id);
	}
	function obtenerOfertaPorSubastaId($subastaId) {
		return $this->_recuperacionDeDatos->leerOfertaPorSubastaId($subastaId);
	}
	function obtenerOfertaPorUsuarioId($usuarioId) {
		return $this->_recuperacionDeDatos->leerOfertaPorUsuarioId($usuarioId);
	}
	function obtenerPagoPorId($id) {
		return $this->_recuperacionDeDatos->leerPagoPorId($id);
	}
	function obtenerPagoPorSubastaId($subastaId) {
		return $this->_recuperacionDeDatos->leerPagoPorSubastaId($subastaId);
	}
	function obtenerPagoPorTipoPagoId($tipoPagoId) {
		return $this->_recuperacionDeDatos->leerPagoPorTipoPagoId($tipoPagoId);
	}
	function obtenerRolPorId($id) {
		return $this->_recuperacionDeDatos->leerRolPorId($id);
	}
	function obtenerSubastaPorId($id) {
		return $this->_recuperacionDeDatos->leerSubastaPorId($id);
	}
	function obtenerSubastaPorArticuloId($articuloId) {
		return $this->_recuperacionDeDatos->leerSubastaPorArticuloId($articuloId);
	}
	function obtenerSubastaPorCategoriaId($categoriaId) {
		return $this->_recuperacionDeDatos->leerSubastaPorCategoriaId($categoriaId);
	}
	function obtenerSubastaPorEstadoId($estadoId) {
		return $this->_recuperacionDeDatos->leerSubastaPorEstadoId($estadoId);
	}
	function obtenerSubastaPorFechaInicio($fechaInicio) {
		return $this->_recuperacionDeDatos->leerSubastaPorFechaInicio($fechaInicio);
	}
	function obtenerSubastaPorTipoSubastaId($tipoSubastaId) {
		return $this->_recuperacionDeDatos->leerSubastaPorTipoSubastaId($tipoSubastaId);
	}
	function obtenerSubastaPorUsuarioAprobo($usuarioAprobo) {
		return $this->_recuperacionDeDatos->leerSubastaPorUsuarioAprobo($usuarioAprobo);
	}
	function obtenerSubastaPorUsuarioCreo($usuarioCreo) {
		return $this->_recuperacionDeDatos->leerSubastaPorUsuarioCreo($usuarioCreo);
	}
	function obtenerSubastaPorUsuarioGanador($usuarioGanador) {
		return $this->_recuperacionDeDatos->leerSubastaPorUsuarioGanador($usuarioGanador);
	}
	function obtenerTarjetaCreditoPorId($id) {
		return $this->_recuperacionDeDatos->leerTarjetaCreditoPorId($id);
	}
	function obtenerTarjetaCreditoUsuarioPorTarjetaCreditoId($tarjetaCreditoId) {
		return $this->_recuperacionDeDatos->leerTarjetaCreditoUsuarioPorTarjetaCreditoId($tarjetaCreditoId);
	}
	function obtenerTarjetaCreditoUsuarioPorUsuarioId($usuarioId) {
		return $this->_recuperacionDeDatos->leerTarjetaCreditoUsuarioPorUsuarioId($usuarioId);
	}
	function obtenerTipoEnvioPorId($id) {
		return $this->_recuperacionDeDatos->leerTipoEnvioPorId($id);
	}
	function obtenerTipoPagoPorId($id) {
		return $this->_recuperacionDeDatos->leerTipoPagoPorId($id);
	}
	function obtenerTipoSubastaPorId($id) {
		return $this->_recuperacionDeDatos->leerTipoSubastaPorId($id);
	}
	function obtenerUsuarioPorId($id) {
		return $this->_recuperacionDeDatos->leerUsuarioPorId($id);
	}
	function obtenerUsuarioPorNomUsuario($nomUsuario) {
		return $this->_recuperacionDeDatos->leerUsuarioPorNomUsuario($nomUsuario);
	}
	function obtenerUsuarioPorEstadoUsuarioId($estadoUsuarioId) {
		return $this->_recuperacionDeDatos->leerUsuarioPorEstadoUsuarioId($estadoUsuarioId);
	}
	function obtenerUsuarioPorRolId($rolId) {
		return $this->_recuperacionDeDatos->leerUsuarioPorRolId($rolId);
	}
	function obtenerUsuarioDireccionPorDireccionId($direccionId) {
		return $this->_recuperacionDeDatos->leerUsuarioDireccionPorDireccionId($direccionId);
	}
	function obtenerUsuarioDireccionPorUsuarioId($usuarioId) {
		return $this->_recuperacionDeDatos->leerUsuarioDireccionPorUsuarioId($usuarioId);
	}


	/**
	Agregar datos
	**/
	function agregarArticulo($articulo) {
		return $this->_mantenimientoDeDatos->escribirArticulo($articulo);
	}
	function agregarCalificacion($calificacion) {
		return $this->_mantenimientoDeDatos->escribirCalificacion($calificacion);
	}
	function agregarCategoria($categoria) {
		return $this->_mantenimientoDeDatos->escribirCategoria($categoria);
	}
	function agregarDireccion($direccion) {
		return $this->_mantenimientoDeDatos->escribirDireccion($direccion);
	}
	function agregarEnvio($envio) {
		return $this->_mantenimientoDeDatos->escribirEnvio($envio);
	}
	function agregarEstadoSubasta($estadoSubasta) {
		return $this->_mantenimientoDeDatos->escribirEstadoSubasta($estadoSubasta);
	}
	function agregarEstadoUsuario($estadoUsuario) {
		return $this->_mantenimientoDeDatos->escribirEstadoUsuario($estadoUsuario);
	}
	function agregarImagen($imagen) {
		return $this->_mantenimientoDeDatos->escribirImagen($imagen);
	}
	function agregarMensaje($mensaje) {
		return $this->_mantenimientoDeDatos->escribirMensaje($mensaje);
	}
	function agregarOferta($oferta) {
		return $this->_mantenimientoDeDatos->escribirOferta($oferta);
	}
	function agregarPago($pago) {
		return $this->_mantenimientoDeDatos->escribirPago($pago);
	}
	function agregarRol($rol) {
		return $this->_mantenimientoDeDatos->escribirRol($rol);
	}
	function agregarSubasta($subasta) {
		return $this->_mantenimientoDeDatos->escribirSubasta($subasta);
	}
	function agregarTarjetaCredito($tarjetaCredito) {
		return $this->_mantenimientoDeDatos->escribirTarjetaCredito($tarjetaCredito);
	}
	function agregarTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_mantenimientoDeDatos->escribirTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function agregarTipoEnvio($tipoEnvio) {
		return $this->_mantenimientoDeDatos->escribirTipoEnvio($tipoEnvio);
	}
	function agregarTipoPago($tipoPago) {
		return $this->_mantenimientoDeDatos->escribirTipoPago($tipoPago);
	}
	function agregarTipoSubasta($tipoSubasta) {
		return $this->_mantenimientoDeDatos->escribirTipoSubasta($tipoSubasta);
	}
	function agregarUsuario($usuario) {
		return $this->_mantenimientoDeDatos->escribirUsuario($usuario);
	}
	function agregarUsuarioDireccion($usuarioDireccion) {
		return $this->_mantenimientoDeDatos->escribirUsuarioDireccion($usuarioDireccion);
	}


	/**
	Editar datos
	**/
	function editarArticulo($articulo) {
		return $this->_mantenimientoDeDatos->modificarArticulo($articulo);
	}
	function editarCalificacion($calificacion) {
		return $this->_mantenimientoDeDatos->modificarCalificacion($calificacion);
	}
	function editarCategoria($categoria) {
		return $this->_mantenimientoDeDatos->modificarCategoria($categoria);
	}
	function editarDireccion($direccion) {
		return $this->_mantenimientoDeDatos->modificarDireccion($direccion);
	}
	function editarEnvio($envio) {
		return $this->_mantenimientoDeDatos->modificarEnvio($envio);
	}
	function editarEstadoSubasta($estadoSubasta) {
		return $this->_mantenimientoDeDatos->modificarEstadoSubasta($estadoSubasta);
	}
	function editarEstadoUsuario($estadoUsuario) {
		return $this->_mantenimientoDeDatos->modificarEstadoUsuario($estadoUsuario);
	}
	function editarImagen($imagen) {
		return $this->_mantenimientoDeDatos->modificarImagen($imagen);
	}
	function editarMensaje($mensaje) {
		return $this->_mantenimientoDeDatos->modificarMensaje($mensaje);
	}
	function editarOferta($oferta) {
		return $this->_mantenimientoDeDatos->modificarOferta($oferta);
	}
	function editarPago($pago) {
		return $this->_mantenimientoDeDatos->modificarPago($pago);
	}
	function editarRol($rol) {
		return $this->_mantenimientoDeDatos->modificarRol($rol);
	}
	function editarSubasta($subasta) {
		return $this->_mantenimientoDeDatos->modificarSubasta($subasta);
	}
	function editarTarjetaCredito($tarjetaCredito) {
		return $this->_mantenimientoDeDatos->modificarTarjetaCredito($tarjetaCredito);
	}
	function editarTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->_mantenimientoDeDatos->modificarTarjetaCreditoUsuario($tarjetaCreditoUsuario);
	}
	function editarTipoEnvio($tipoEnvio) {
		return $this->_mantenimientoDeDatos->modificarTipoEnvio($tipoEnvio);
	}
	function editarTipoPago($tipoPago) {
		return $this->_mantenimientoDeDatos->modificarTipoPago($tipoPago);
	}
	function editarTipoSubasta($tipoSubasta) {
		return $this->_mantenimientoDeDatos->modificarTipoSubasta($tipoSubasta);
	}
	function editarUsuario($usuario) {
		return $this->_mantenimientoDeDatos->modificarUsuario($usuario);
	}
	function editarUsuarioDireccion($usuarioDireccion) {
		return $this->_mantenimientoDeDatos->modificarUsuarioDireccion($usuarioDireccion);
	}

}
?>
