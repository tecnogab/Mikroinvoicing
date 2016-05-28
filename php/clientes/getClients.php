<?php   
	require_once "clients.php"; 
	$sql= "SELECT * FROM t_clients";	
	$test = new Clientes();
	//$test->insertClient("28050444", "Joselo", "Bilardon", "2016-05-14");
	//$test->getClients($sql);
	$test->getIdClient("28050944");
?>
