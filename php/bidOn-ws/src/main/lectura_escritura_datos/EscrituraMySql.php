<?php
include_once 'src/main/modelo/Usuario.php';
include_once 'src/main/recursos/Configuracion.php';
class EscrituraMySql {
	private $_conn;
	const NOMBRE_METODO = 'establecer';

	/**
	* Inserta un nuevo objeto de una determinada clase
	* @param unknown $objeto
	* @param unknown $clase
	* @return number|string
	*/
	function insertar($objeto, $clase) {
	$nObjeto = new $clase();
	$consultaCol = 'INSERT INTO ' . $clase . ' (';
	$consultaVal = 'VALUES (';
	
	$arr = get_class_methods($clase);
	$metodosEstablecer = array_filter($arr, function($var){return preg_match('/' . self::NOMBRE_METODO . '/', $var);});
	$metodosEstablecer = array_values($metodosEstablecer);
	$parametrosNecesarios = preg_replace('/' . self::NOMBRE_METODO . '/', '', $metodosEstablecer);        
	$parametrosNecesarios = array_map(function($word) { return lcfirst($word); }, $parametrosNecesarios);
		foreach ($parametrosNecesarios as $llave => $valor) {
		if(property_exists($objeto, $valor)) {
			$consultaCol .= $this->aFormatoDeBD($valor) . ','; 
			$consultaVal .= "'" . $objeto->{$valor} . "'" . ',';
			$nObjeto->$metodosEstablecer[$llave]($objeto->{$valor});
		} else {
			return 'El objeto recibido no es correcto';
		}
	}
	return json_encode($nObjeto);
	$consultaCol = $this->eliminarCadenaAlFinal($consultaCol) . ') '; //Remover la ultima coma
	$consultaVal = $this->eliminarCadenaAlFinal($consultaVal) . ');'; //Remover la ultima coma
	$consulta = $consultaCol . $consultaVal;
	
	$this->abrirConexion();
	if ($this->_conn->query($consulta) == FALSE) {			
		$error = $this->_conn->error;
		$this->cerrarConexion();
		return 'Error al insertar objeto: ' . $error;
	}
	$this->cerrarConexion();
	return json_encode($nObjeto);  
	}
	
	/**
	* Elimina la ultima coma al final del string $cadena
	*/
	private function eliminarComaAlFinal($cadena) {
		return preg_replace('/,$/','', $cadena);
	}
	
	/**
	* Convierte el string $cadena al formato utilizado en la base de datos
	* que es: todas las letras minusculas y guiones bajos en lugar de espacios.
	*/
	private function aFormatoDeBD($cadena) {
		return strtolower(preg_replace('/\B([A-Z])/', '_$1', $cadena));
	}
	
	private function abrirConexion() {
		$this->_conn = mysqli_connect(Configuracion::URL, Configuracion::USUARIO, Configuracion::PASSWD, Configuracion::BASEDEDATOS, Configuracion::PUERTO, Configuracion::SOCKET);
		if ($this->_conn->connect_errno) {
			return ("Falló la conexión: " . $this->_conn->connect_error);
		}    	
	}
	
	private function cerrarConexion() {
		mysqli_close($this->_conn);
	}

	/**
	Insertar datos
	**/
	function insertarArticulo($articulo) {
		return $this->insertar($articulo,'Articulo');
	}
	function insertarCalificacion($calificacion) {
		return $this->insertar($calificacion,'Calificacion');
	}
	function insertarCategoria($categoria) {
		return $this->insertar($categoria,'Categoria');
	}
	function insertarDireccion($direccion) {
		return $this->insertar($direccion,'Direccion');
	}
	function insertarEnvio($envio) {
		return $this->insertar($envio,'Envio');
	}
	function insertarEstadoSubasta($estadoSubasta) {
		return $this->insertar($estadoSubasta,'EstadoSubasta');
	}
	function insertarEstadoUsuario($estadoUsuario) {
		return $this->insertar($estadoUsuario,'EstadoUsuario');
	}
	function insertarImagen($imagen) {
		return $this->insertar($imagen,'Imagen');
	}
	function insertarMensaje($mensaje) {
		return $this->insertar($mensaje,'Mensaje');
	}
	function insertarOferta($oferta) {
		return $this->insertar($oferta,'Oferta');
	}
	function insertarPago($pago) {
		return $this->insertar($pago,'Pago');
	}
	function insertarRol($rol) {
		return $this->insertar($rol,'Rol');
	}
	function insertarSubasta($subasta) {
		return $this->insertar($subasta,'Subasta');
	}
	function insertarTarjetaCredito($tarjetaCredito) {
		return $this->insertar($tarjetaCredito,'TarjetaCredito');
	}
	function insertarTarjetaCreditoUsuario($tarjetaCreditoUsuario) {
		return $this->insertar($tarjetaCreditoUsuario,'TarjetaCreditoUsuario');
	}
	function insertarTipoEnvio($tipoEnvio) {
		return $this->insertar($tipoEnvio,'TipoEnvio');
	}
	function insertarTipoPago($tipoPago) {
		return $this->insertar($tipoPago,'TipoPago');
	}
	function insertarTipoSubasta($tipoSubasta) {
		return $this->insertar($tipoSubasta,'TipoSubasta');
	}
	function insertarUsuario($usuario) {
		return $this->insertar($usuario,'Usuario');
	}
	function insertarUsuarioDireccion($usuarioDireccion) {
		return $this->insertar($usuarioDireccion,'UsuarioDireccion');
	}


	/**
	Actualizar datos
	**/

}
?>
