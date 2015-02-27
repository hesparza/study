<!-- Propiedad de BidOn -->
<!-- Autor: hesparza  - 17/02/2015-->
<!-- Propiedad de BidOn -->
<!-- Esta clase contiene -->
<?php
include_once('ProcesadorDeRespuestas.php');
class Controlador {
	function test() {
		ProcesadorDeRespuestas::procesarRespuesta(200,"Ok","asd");
		
	
	}
}

$controlador = new Controlador();
$controlador->test();
	/*
	if (!post($_POST['obtenerUsuarioPorNombreDeUsuario']) {

	} else {
		$procesador->procesarRespuesta('404','Recurso no encontrado','Error');
	}
	*/
?> 