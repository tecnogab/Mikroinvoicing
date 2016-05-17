<meta charset="utf-8"> 
<?php
	require_once("ipaddress.php"); 
	
	//Comprobamos si hemos recibido alguna llamada por POST
	if(isset($_POST["json"])){
    	
    	$json = $_POST["json"];
    	$json = urldecode($json);
    	$json = str_replace("\\", "",$json);
    	$jsonencode = json_decode($json);

    	//--Creamos un objeto de la clase usuarioClass
    	$ip_cli = new IpAddress();
    	//Insertamos un nuevo usuario en la base de datos
    	$ip_cli->insertIp($jsonencode[0]->ipv4, $jsonencode[0]->ipv6, $jsonencode[0]->id_client);
	}
?>