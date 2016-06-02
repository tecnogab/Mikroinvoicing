<meta charset="utf-8"> 
<?php
/**
*Autor: José Gabriel Tejerina
*Desarrollado para Geeky Theory
*
*Este archivo mostrará un JSON para que la aplicación JAVA lo lea
*/

//--Incluimos el archivo en domicilios.php	
	require_once("domicilios.php"); 	
	//--Creamos un objeto de la clase domicilios
	$domicilio = new Domicilios();
    $data = $domicilio->getAllDom();	
	echo json_encode($data);
?>