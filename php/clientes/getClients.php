<?php   
	require_once "clients.php"; 
		
	$clientes = new Clientes();
	//$clientes->insertClient("28050444", "Joselo", "Bilardon", "2016-05-14");
	//$clientes->getClients($sql);
	$clientes->getAllClients();
?>
