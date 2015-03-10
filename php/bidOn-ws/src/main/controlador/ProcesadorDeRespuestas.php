<?php
class ProcesadorDeRespuestas {	
	/**
	 * Genera la respuestas segun el formato en que se desea enviar
	 */
	function procesarRespuesta($formato, $codigo, $mensaje, $datos) {
		header("HTTP/1.1 $codigo $mensaje");
		if($formato == "html") {
			header("Content-Type: text/html");
			echo 'formato = ' . $formato . '<br/>codigo = ' . $codigo . '<br/>mensaje = ' . $mensaje . '<br/>datos = ';
			print_r($datos);
		} else {
			header("Content-Type: application/json");
			$respuesta['codigo']=$codigo;
			$respuesta['mensaje']=$mensaje;
			$respuesta['datos']=$datos;
			echo json_encode($respuesta);
		}
	}	
}
?>