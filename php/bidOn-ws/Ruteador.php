<?php
class Ruteador {
	private $_uri = array();	
	private $_metodo = array();

	/**
	 * Contruye una colección de URLs
	 * @param unknown $uri
	 */
	public function agregar($uri, $metodo = null) {
		$this->_uri[] = trim($uri, '/') == '' ? '/' : trim($uri, '/');
		
		if ($metodo != null) {
			$this->_metodo[] = $metodo;
		}
	}
	
	/**
	 * Punto de inicio del ruteo
	 */
	public function enviar() {				
		$parametros = isset($_GET['uri']) ? explode('/', $_GET['uri']) : '/';
// 		echo '<pre/>';
// 		print_r($parametros);
// 		echo '$parametros = ' . $parametros . '<br />';
		$uriGetParametro = $parametros[0];
// 		echo '<br /><hr />$uriGetParametro = ' .$uriGetParametro . '<br /><hr />';

		foreach($this->_uri as $llave => $valor) {			
			if (preg_match("#^$valor$#", $uriGetParametro)) {
// 				echo 'match! on => ' . $valor . "<br />";
// 				echo 'key = ' . $llave. '<br />';
				
				$metodoSeleccionado = $this->_metodo[$llave];
// 				echo 'Metodo Seleccionado = ' . $metodoSeleccionado;
				
				

				$metodoSeleccionado = new $metodoSeleccionado($parametros);
				$metodoSeleccionado->rutearLlamada();
			}
		}
	}
}
?>