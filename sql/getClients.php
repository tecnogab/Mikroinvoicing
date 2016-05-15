<?php   
	require_once "clientes.php"; 
	$sql= "SELECT * FROM t_clients";	
	$test = new Clientes();
	echo $test->getArraySQL($sql);		
		
?>
