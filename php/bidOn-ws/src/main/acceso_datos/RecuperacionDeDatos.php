<?php
include_once 'src/main/lectura_escritura_datos/LecturaMySql.php';
class RecuperacionDeDatos {
	private $_lecturaMySql;

	function __construct() {
		$this->_lecturaMySql = new LecturaMySql();
	}

	/**
	Obtener todos los datos
	**/
	function leerArticulos() {
		return $this->_lecturaMySql->seleccionarArticulos();
	}
	function leerCalificaciones() {
		return $this->_lecturaMySql->seleccionarCalificaciones();
	}
	function leerCategorias() {
		return $this->_lecturaMySql->seleccionarCategorias();
	}
	function leerDirecciones() {
		return $this->_lecturaMySql->seleccionarDirecciones();
	}
	function leerEnvios() {
		return $this->_lecturaMySql->seleccionarEnvios();
	}
	function leerEstadoSubastas() {
		return $this->_lecturaMySql->seleccionarEstado_Subastas();
	}
	function leerEstadoUsuarios() {
		return $this->_lecturaMySql->seleccionarEstado_Usuarios();
	}
	function leerImagenes() {
		return $this->_lecturaMySql->seleccionarImagenes();
	}
	function leerMensajes() {
		return $this->_lecturaMySql->seleccionarMensajes();
	}
	function leerOfertas() {
		return $this->_lecturaMySql->seleccionarOfertas();
	}
	function leerPagos() {
		return $this->_lecturaMySql->seleccionarPagos();
	}
	function leerRoles() {
		return $this->_lecturaMySql->seleccionarRoles();
	}
	function leerSubastas() {
		return $this->_lecturaMySql->seleccionarSubastas();
	}
	function leerTarjetaCreditos() {
		return $this->_lecturaMySql->seleccionarTarjeta_Creditos();
	}
	function leerTarjetaCreditoUsuarios() {
		return $this->_lecturaMySql->seleccionarTarjeta_Credito_Usuarios();
	}
	function leerTipoEnvios() {
		return $this->_lecturaMySql->seleccionarTipo_Envios();
	}
	function leerTipoPagos() {
		return $this->_lecturaMySql->seleccionarTipo_Pagos();
	}
	function leerTipoSubastas() {
		return $this->_lecturaMySql->seleccionarTipo_Subastas();
	}
	function leerUsuarios() {
		return $this->_lecturaMySql->seleccionarUsuarios();
	}
	function leerUsuarioDirecciones() {
		return $this->_lecturaMySql->seleccionarUsuario_Direcciones();
	}


	/**
	Obtener todos los datos por indices
	**/
	function leerArticuloPorId($id) {
		return $this->_lecturaMySql->seleccionarArticuloPorId($id);
	}
	function leerCalificacionPorId($id) {
		return $this->_lecturaMySql->seleccionarCalificacionPorId($id);
	}
	function leerCalificacionPorSubastaId($subastaId) {
		return $this->_lecturaMySql->seleccionarCalificacionPorSubastaId($subastaId);
	}
	function leerCalificacionPorUsuarioCalificaId($usuarioCalificaId) {
		return $this->_lecturaMySql->seleccionarCalificacionPorUsuarioCalificaId($usuarioCalificaId);
	}
	function leerCalificacionPorUsuarioCalificadoId($usuarioCalificadoId) {
		return $this->_lecturaMySql->seleccionarCalificacionPorUsuarioCalificadoId($usuarioCalificadoId);
	}
	function leerCategoriaPorId($id) {
		return $this->_lecturaMySql->seleccionarCategoriaPorId($id);
	}
	function leerDireccionPorId($id) {
		return $this->_lecturaMySql->seleccionarDireccionPorId($id);
	}
	function leerEnvioPorId($id) {
		return $this->_lecturaMySql->seleccionarEnvioPorId($id);
	}
	function leerEnvioPorDireccionId($direccionId) {
		return $this->_lecturaMySql->seleccionarEnvioPorDireccionId($direccionId);
	}
	function leerEnvioPorSubastaId($subastaId) {
		return $this->_lecturaMySql->seleccionarEnvioPorSubastaId($subastaId);
	}
	function leerEnvioPorTipoEnvioId($tipoEnvioId) {
		return $this->_lecturaMySql->seleccionarEnvioPorTipoEnvioId($tipoEnvioId);
	}
	function leerEstadoSubastaPorId($id) {
		return $this->_lecturaMySql->seleccionarEstadoSubastaPorId($id);
	}
	function leerEstadoUsuarioPorId($id) {
		return $this->_lecturaMySql->seleccionarEstadoUsuarioPorId($id);
	}
	function leerImagenPorId($id) {
		return $this->_lecturaMySql->seleccionarImagenPorId($id);
	}
	function leerImagenPorArticuloId($articuloId) {
		return $this->_lecturaMySql->seleccionarImagenPorArticuloId($articuloId);
	}
	function leerMensajePorId($id) {
		return $this->_lecturaMySql->seleccionarMensajePorId($id);
	}
	function leerMensajePorSubastaId($subastaId) {
		return $this->_lecturaMySql->seleccionarMensajePorSubastaId($subastaId);
	}
	function leerMensajePorUsuarioId($usuarioId) {
		return $this->_lecturaMySql->seleccionarMensajePorUsuarioId($usuarioId);
	}
	function leerOfertaPorId($id) {
		return $this->_lecturaMySql->seleccionarOfertaPorId($id);
	}
	function leerOfertaPorSubastaId($subastaId) {
		return $this->_lecturaMySql->seleccionarOfertaPorSubastaId($subastaId);
	}
	function leerOfertaPorUsuarioId($usuarioId) {
		return $this->_lecturaMySql->seleccionarOfertaPorUsuarioId($usuarioId);
	}
	function leerPagoPorId($id) {
		return $this->_lecturaMySql->seleccionarPagoPorId($id);
	}
	function leerPagoPorSubastaId($subastaId) {
		return $this->_lecturaMySql->seleccionarPagoPorSubastaId($subastaId);
	}
	function leerPagoPorTipoPagoId($tipoPagoId) {
		return $this->_lecturaMySql->seleccionarPagoPorTipoPagoId($tipoPagoId);
	}
	function leerRolPorId($id) {
		return $this->_lecturaMySql->seleccionarRolPorId($id);
	}
	function leerSubastaPorId($id) {
		return $this->_lecturaMySql->seleccionarSubastaPorId($id);
	}
	function leerSubastaPorArticuloId($articuloId) {
		return $this->_lecturaMySql->seleccionarSubastaPorArticuloId($articuloId);
	}
	function leerSubastaPorCategoriaId($categoriaId) {
		return $this->_lecturaMySql->seleccionarSubastaPorCategoriaId($categoriaId);
	}
	function leerSubastaPorEstadoId($estadoId) {
		return $this->_lecturaMySql->seleccionarSubastaPorEstadoId($estadoId);
	}
	function leerSubastaPorFechaInicio($fechaInicio) {
		return $this->_lecturaMySql->seleccionarSubastaPorFechaInicio($fechaInicio);
	}
	function leerSubastaPorTipoSubastaId($tipoSubastaId) {
		return $this->_lecturaMySql->seleccionarSubastaPorTipoSubastaId($tipoSubastaId);
	}
	function leerSubastaPorUsuarioAprobo($usuarioAprobo) {
		return $this->_lecturaMySql->seleccionarSubastaPorUsuarioAprobo($usuarioAprobo);
	}
	function leerSubastaPorUsuarioCreo($usuarioCreo) {
		return $this->_lecturaMySql->seleccionarSubastaPorUsuarioCreo($usuarioCreo);
	}
	function leerSubastaPorUsuarioGanador($usuarioGanador) {
		return $this->_lecturaMySql->seleccionarSubastaPorUsuarioGanador($usuarioGanador);
	}
	function leerTarjetaCreditoPorId($id) {
		return $this->_lecturaMySql->seleccionarTarjetaCreditoPorId($id);
	}
	function leerTarjetaCreditoUsuarioPorTarjetaCreditoId($tarjetaCreditoId) {
		return $this->_lecturaMySql->seleccionarTarjetaCreditoUsuarioPorTarjetaCreditoId($tarjetaCreditoId);
	}
	function leerTarjetaCreditoUsuarioPorUsuarioId($usuarioId) {
		return $this->_lecturaMySql->seleccionarTarjetaCreditoUsuarioPorUsuarioId($usuarioId);
	}
	function leerTipoEnvioPorId($id) {
		return $this->_lecturaMySql->seleccionarTipoEnvioPorId($id);
	}
	function leerTipoPagoPorId($id) {
		return $this->_lecturaMySql->seleccionarTipoPagoPorId($id);
	}
	function leerTipoSubastaPorId($id) {
		return $this->_lecturaMySql->seleccionarTipoSubastaPorId($id);
	}
	function leerUsuarioPorId($id) {
		return $this->_lecturaMySql->seleccionarUsuarioPorId($id);
	}
	function leerUsuarioPorNomUsuario($nomUsuario) {
		return $this->_lecturaMySql->seleccionarUsuarioPorNomUsuario($nomUsuario);
	}
	function leerUsuarioPorEstadoUsuarioId($estadoUsuarioId) {
		return $this->_lecturaMySql->seleccionarUsuarioPorEstadoUsuarioId($estadoUsuarioId);
	}
	function leerUsuarioPorRolId($rolId) {
		return $this->_lecturaMySql->seleccionarUsuarioPorRolId($rolId);
	}
	function leerUsuarioDireccionPorDireccionId($direccionId) {
		return $this->_lecturaMySql->seleccionarUsuarioDireccionPorDireccionId($direccionId);
	}
	function leerUsuarioDireccionPorUsuarioId($usuarioId) {
		return $this->_lecturaMySql->seleccionarUsuarioDireccionPorUsuarioId($usuarioId);
	}

}
?>
