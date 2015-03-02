<?php
include_once 'Ruteador.php';
include_once './src/main/controlador/Controlador.php';

$ruteador = new Ruteador();
$ruteador->agregar('/controlador', 'Controlador');

$ruteador->enviar();
?>