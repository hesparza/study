<?php
class ProcesadorDeRespuestas {	
	function procesarRespuesta($codigo, $mensaje, $datos) {
		//header("HTTP/1.1 $codigo $mensaje");

		$respuesta['codigo']=$codigo;
		$respuesta['mensaje']=$mensaje;
		$respuesta['datos']=$datos;
		
		echo json_encode($respuesta);
	}
}
?>