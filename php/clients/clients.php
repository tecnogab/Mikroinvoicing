<?php  

require_once "../conn/conexion.php"; 

class Clientes extends Conexion{     
			
		
	function getIdClient($dni){
		
		$phpConn = new Conexion();
		$conn = $phpConn->connectDB();
		//Consulta SQL
		$sql = "SELECT id_cli FROM t_clients WHERE dni_cli = '$dni'";
		
		if(!$result = mysqli_query($conn, $sql)) 
			die();			
		
		$id_cliente;
		if ($row = mysqli_fetch_array($result))
			$id_cliente = $row['id_cli'];				
			
		
		$phpConn->disconnectDB($conn); //desconectamos la base de datos		
		
		//Creamos el JSON
		$json_string = json_encode($id_cliente);
		echo $json_string;
	}


	//inserta en la base de datos un nuevo registro en la tabla usuarios
    function insertClient($dni, $nombre, $apellido, $fecha_up){
        
		$phpConn = new Conexion();
		$conn = $phpConn->connectDB();
        
		//Escribimos la sentencia sql necesaria respetando los tipos de datos
    	$sql = "INSERT INTO t_clients (dni_cli, nombre_cli, apellido_cli, fecha_up_cli) values ('".$dni."', '".$nombre."','".$apellido."','".$fecha_up."')";
        
		//hacemos la consulta y la comprobamos 
        $consulta = mysqli_query($conn, $sql);
        if(!$consulta){
            echo "No se ha podido insertar el cliente en la base de datos<br><br>".mysqli_error($conn);
        }

        printf (mysqli_insert_id($conn));
        $phpConn->disconnectDB($conn); //desconectamos la base de datos
        //devolvemos el resultado de la consulta (true o false)
        return $consulta;
    }	
}