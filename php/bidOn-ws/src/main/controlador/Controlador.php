<?php
include_once 'procesadorDeRespuestas.php';
class Controlador {
	private $_formato;
	private $_metodo;
	private $_parametros;
	private $_procesadorDeRespuestas;
	
	function __construct($parametros) {
       //echo "In BaseClass constructor\n";
	   
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
// 		echo '<br /><hr />' . '$this->_metodo = ' . $this->_metodo . '<br />';
		$this->_parametros = $parametros;
// 		echo '<br /><hr />' . '$this->_parametros = ';
// 		print_r($this->_parametros);
// 		echo '<br />';
		
		$this->procesadorDeRespuestas = new ProcesadorDeRespuestas();

		set_exception_handler(function ($e) use ($_formato) {
			http_response_code($e->getCode());
			$this->procesadorDeRespuestas->procesarRespuesta( $this->_formato, $e->getCode(), $e->getMessage(), '');			
		});
	}

	private function test() {
		return 'testing ' . __FUNCTION__;
	}
	
	private function obtenerUsuario() {
		return 'testing ' . __FUNCTION__;
	}

	/**
	 * Recibe las piezas que forman el URL y determina el método que hay que llamar
	 */
	function rutearLlamada() {
		// route the request using all this info
		switch(strtolower($this->_parametros[1])) {
			case 'usuario':
		        $nombre_metodo = $this->_metodo . "Usuario";
		        if(method_exists($this, $nombre_metodo)) {
					$datos = $this->$nombre_metodo();					
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