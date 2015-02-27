<?php
class Controlador {
	var $formato;
	var $metodo;
	var $piezas;
	
	function __construct() {
       //echo "In BaseClass constructor\n";
	   
		if((isset($_SERVER['HTTP_ACCEPT'])) && false !== strpos($_SERVER['HTTP_ACCEPT'], "html")) {
		    $this->formato = "html";
		} else {
		    $this->formato = "json";
		}
		
		set_exception_handler(function ($e) use ($formato) {
			http_response_code($e->getCode());
			send_output($e->getMessage(), $formato);
		});
		
		$this->metodo = $_SERVER['REQUEST_METHOD'];
		$this->piezas = explode("/", $_SERVER['PATH_INFO']);
	}
	
	/**
	 * Genera la respuestas segun el formato en que se desea enviar
	 */
	function procesarRespuesta($formato, $codigo, $mensaje, $datos) {
		header("HTTP/1.1 $codigo $mensaje");
		if($formato == "html") {
			header("Content-Type: text/html");
			print_r($datos);
		} else {
			header("Content-Type: application/json");
			$respuesta['codigo']=$codigo;
			$respuesta['mensaje']=$mensaje;
			$respuesta['datos']=$datos;
			echo json_encode($respuesta);
		}
	}
	
	/**
	 * Recibe las piezas que forman el URL y determina el método que hay que llamar
	 */
	function rutearLlamada($piezas) {
		// route the request using all this info
		switch($piezas[1]) {
		    case "usuario":
		        $func_name = $method . "usuario";
		        if(function_exists($func_name)) {
		            $data = $func_name();
		        } else {
		            throw new Exception("Method not available", 405);
		        }
		        break;
		    default:
		        throw new Exception("Unknown URL", 404);
		        break;
		}		
	}
	
	function test() {
		$this->procesarRespuesta("json",200,"Ok","asd");
	}
}

$controlador = new Controlador();
	/*
	if (!post($_POST['obtenerUsuarioPorNombreDeUsuario']) {

	} else {
		$procesador->procesarRespuesta('404','Recurso no encontrado','Error');
	}
	*/
?>