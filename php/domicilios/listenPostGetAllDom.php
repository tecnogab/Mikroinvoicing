<meta charset="utf-8"> 
<?php
/**
*Autor: Jos� Gabriel Tejerina
*Desarrollado para Geeky Theory
*
*Este archivo mostrar� un JSON para que la aplicaci�n JAVA lo lea
*/

//--Incluimos el archivo en domicilios.php	
	require_once("domicilios.php"); 	
	//--Creamos un objeto de la clase domicilios
	$domicilio = new Domicilios();
    $data = $domicilio->getAllDom();	
	echo json_encode($data);
?>