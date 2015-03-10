<?php
include_once 'procesadorDeRespuestas.php';
include_once 'src/main/negocios/Negocios.php';
class Controlador {
	private $_formato;
	private $_metodo;
	private $_parametros;
	private $_procesadorDeRespuestas;
	private $_negocios;
	
	function __construct($parametros) {
		if((isset($_SERVER['HTTP_ACCEPT'])) && false !== strpos($_SERVER['HTTP_ACCEPT'], "html")) {
		    $this->_formato = "html";
		} else {
		    $this->_formato = "json";
		}
		
		switch($_SERVER['REQUEST_METHOD']) {
			case 'GET':
				$this->_metodo = 'obtener';
				break;
			case 'POST':
				$this->_metodo = 'agregar';
				break;
			case 'PUT':
				$this->_metodo = 'actualizar';
				break;
			case 'DELETE':
				$this->_metodo = 'borrar';
				break;
			default:
				$this->_metodo = 'obtener';
				break;
		}

		$this->_parametros = $parametros;		
		$this->procesadorDeRespuestas = new ProcesadorDeRespuestas();

		set_exception_handler(function ($e) use ($_formato) {
			http_response_code($e->getCode());
			$this->procesadorDeRespuestas->procesarRespuesta( $this->_formato, $e->getCode(), $e->getMessage(), '');			
		});

		$this->_negocios =  new Negocios();
	}

	/**
	 * Forma el complemento del nombre del metodo a llamar 
	 * dependiendo de los parametros enviados en el URL
	 */
	function complementarNombre() {
		for ($i = 2; $i < sizeof($this->_parametros); $i++) {
			if ($this->_parametros[$i] != '') {
				$resultado = $resultado . 'Por' . $this->_parametros[$i];
			}
		}
		return $resultado;
	}
	
	/**
	 * Obtiene los parametros de la llamada dependiendo del tipo de llamada
	 */
	function obtenerParametros() {
		$cuerpo = file_get_contents('php://input');
		//print_r($cuerpo);
		//echo 'cuerpo = ' . $cuerpo . '<br />';
		if (isset($cuerpo) == false && $cuerpo !== "") {
			return '';
		}			
		switch($_SERVER['REQUEST_METHOD']) {
			case 'GET':
				$resultado = '';		
				$datosDeEntrada = json_decode($cuerpo);
				for ($i = 2; $i < sizeof($this->_parametros); $i++) {
					$llave = $this->_parametros[$i];
					if (isset($datosDeEntrada)) {
						$i === 2 ? $resultado = $datosDeEntrada->{$llave} : $resultado = $resultado . ',' . $datosDeEntrada->{$llave};
					}
				}
				if ($resultado === "") {
					throw new Exception("Metodo no disponible", 405);
				}						
				return $resultado;
				break;
			case 'POST':
			case 'PUT':
			case 'DELETE':
				return json_decode($cuerpo);
				break;
			default:
				return '';
				break;
		}
	}

	private function obtenerUsuarioPorNomUsuario($nomUsuario) {
		return $this->_negocios->obtenerUsuarioPorNomUsuario($nomUsuario);
	}

	private function agregarUsuario($nomUsuario) {
		return $this->_negocios->agregarUsuario($nomUsuario);
	}
	/**
	 * Determina el método que hay que llamar
	 */
	function rutearLlamada() {
		if ((sizeof($this->_parametros) - 2) >= 1 || $this->_metodo === 'agregar' || $this->_metodo === 'actualizar') {
			$hayParametros = TRUE;
		}
		// rutear la llamada a su metodo correspondiente
		switch($this->_parametros[1]) {
			case 'Articulo':
			case 'Calificacion':
			case 'Categoria':
			case 'Direccion':
			case 'Envio':
			case 'Estado_Subasta':
			case 'Estado_Usuario':
			case 'Imagen':
			case 'Mensaje':
			case 'Oferta':
			case 'Pago':
			case 'Rol':
			case 'Subasta':
			case 'Tarjeta_Credito':
			case 'Tarjeta_Credito_Usuario':
			case 'Tipo_Envio':
			case 'Tipo_Pago':
			case 'Tipo_Subasta':
			case 'Usuario':
			case 'Usuario_Direccion':
	        	$nombreMetodo = $this->_metodo . $this->_parametros[1] . $this->complementarNombre();
	        	if(method_exists($this, $nombreMetodo)) {
	        		$datos = $hayParametros ? $this->$nombreMetodo($this->obtenerParametros()) : $this->$nombreMetodo();
	        	} else {
	        		throw new Exception("Metodo no disponible", 405);
	        	}
        		break;		        
		    default:
		        throw new Exception("URL desconocida", 404);
		        break;
		}
		$this->procesadorDeRespuestas->procesarRespuesta("json",200,"Ok", $datos);
	}
}
?>