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
		$uriGetParametro = $parametros[0];

		foreach($this->_uri as $llave => $valor) {			
			if (preg_match("#^$valor$#", $uriGetParametro)) {
				$metodoSeleccionado = $this->_metodo[$llave];
				$metodoSeleccionado = new $metodoSeleccionado($parametros);
				$metodoSeleccionado->rutearLlamada();
			}
		}
	}
}
?>