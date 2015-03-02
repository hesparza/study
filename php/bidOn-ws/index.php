<?php
include_once 'Ruteador.php';
include_once './src/main/controlador/Controlador.php';

$ruteador = new Ruteador();
$ruteador->agregar('/','Home');
$ruteador->agregar('/about', 'About');
$ruteador->agregar('/controlador', 'Controlador');

$ruteador->enviar();
?>