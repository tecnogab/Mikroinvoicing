<meta charset="utf-8"> 
<?php
	require_once("clientes.php"); 
	
	//Comprobamos si hemos recibido alguna llamada por POST
	if(isset($_POST["json"])){
    	
    	$json = $_POST["json"];
    	$json = urldecode($json);
    	$json = str_replace("\\", "",$json);
    	$jsonencode = json_decode($json);

    	//--Creamos un objeto de la clase usuarioClass
    	$cliente = new Clientes();
    	//Insertamos un nuevo usuario en la base de datos
    	$cliente->insertClient($jsonencode[0]->nombre,$jsonencode[0]->apellidos,$jsonencode[0]->email);
	}
?>