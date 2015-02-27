<?php
class ProcesadorDeRespuestas {	
	function procesarRespuesta($formato, $codigo, $mensaje, $datos) {
		//header("HTTP/1.1 $codigo $mensaje");
		if($formato == "html") {
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