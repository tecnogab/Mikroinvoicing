<?php  
require_once "../conn/database.php"; 

class Cliente{
    
    function getAllCli(){
			$pdo = Database::connect();											      //Conexion a la base de datos
			$sql = 'SELECT * FROM t_clientes';								          //Consulta SQL	
			$rawdata = array();														  //Se crea un array
            $rawdata = $pdo->query($sql)->fetchAll(PDO::FETCH_ASSOC);                 //Se guardan todos los resultados de la consulta en el array
			$json_string = json_encode($rawdata);								      //Creamos el JSON
			echo $json_string;			
			Database::disconnect();
		}

		function insertCli($dni, $nombre, $apellido, $fecha_up){        
			
            $pdo = Database::connect();
			$sentencia = $pdo->prepare("INSERT INTO t_clientes (dni_cli, nombre_cli, apellido_cli, fecha_up_cli) VALUES (?, ?, ?, ?)");		
			
            $sentencia->bindParam(1, $dni);
			$sentencia->bindParam(2, $nombre);
			$sentencia->bindParam(3, $apellido);
            $sentencia->bindParam(4, $fecha_up);		
		
			$sentencia->execute();
            
            print $pdo->lastInsertId();
		
			Database::disconnect();
		}
}