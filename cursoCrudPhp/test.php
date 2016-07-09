<?php
    require 'database.php';
		$pdo = Database::connect();										//Conexion a la base de datos
		$sql = 'SELECT * FROM customers ORDER BY id DESC';				//Consulta SQL	
		$rawdata = array();												//Se crea un array
		$rawdata = $pdo->query($sql)->fetchAll(PDO::FETCH_ASSOC);		//Se guardan todos los resultados de la consulta en el array
		$json_string = json_encode($rawdata);							//Creamos el JSON
		echo $json_string;			
		Database::disconnect();
?>