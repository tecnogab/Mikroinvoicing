<meta charset="utf-8"> 
<?php
	require_once("domicilios.php"); 
	
	//Comprobamos si hemos recibido alguna llamada por POST
	if(isset($_POST["json"])){
    	
    	$json = $_POST["json"];
    	$json = urldecode($json);
    	$json = str_replace("\\", "",$json);
    	$jsonencode = json_decode($json);

    	//--Creamos un objeto de la clase usuarioClass
    	$domicilio = new Domicilios();
		echo "Pasamos por la consulta";
    	//Insertamos un nuevo usuario en la base de datos
    	//$domicilio->insertDom($jsonencode[0]->barrio, $jsonencode[0]->calle, $jsonencode[0]->latitude, $jsonencode[0]->longitude, $jsonencode[0]->id_cliente);
		$domicilio->insertDom('Catedral', 'Lopez y Planes 996', '-23.136286', '-64.318122', 5);
	}
?>