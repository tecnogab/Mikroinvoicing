<?php  

require_once "conexion.php"; 

class Clientes extends Conexion{     
			
		
	function getClients($sql){
		
		$phpConn = new Conexion();
		$conn = $phpConn->connectDB();
		
			mysqli_set_charset($conn, "latin1_swedish_ci");
			
			if(!$result = mysqli_query($conn, $sql)) die();
			$clientes = array(); //creamos un array

			while($row = mysqli_fetch_array($result)){
				$dni=$row['dni_cli'];
				$nombre=$row['nombre_cli'];
				$apellido=$row['apellido_cli'];
				$fecha_up=$row['fecha_up_cli'];

				$clientes[] = array('dni'=> $dni, 'nombre'=> $nombre, 'apellido'=> $apellido, 'fecha_up'=> $fecha_up);
			}
		
		$phpConn->disconnectDB($conn); //desconectamos la base de datos
		
		//Creamos el JSON
		$json_string = json_encode($clientes);
		echo $json_string;
	}


	//inserta en la base de datos un nuevo registro en la tabla usuarios
    function insertClient($dni, $nombre, $apellido, $fecha_up){
        $phpConn = new Conexion();
		$conn = $phpConn->connectDB();
        //Escribimos la sentencia sql necesaria respetando los tipos de datos
    	$sql = "INSERT INTO t_clients (dni_cli, nombre_cli, apellido_cli, fecha_up_cli) 
    		values ('".$dni."', '".$nombre."','".$apellido."','".$fecha_up."')";
        //hacemos la consulta y la comprobamos 
        $consulta = mysqli_query($conn, $sql);
        if(!$consulta){
            echo "No se ha podido insertar una nueva Medalla en la base de datos<br><br>".mysqli_error($conn);
        }
        $phpConn->disconnectDB($conn); //desconectamos la base de datos
        //devolvemos el resultado de la consulta (true o false)
        return $consulta;
    }	
} 
?> 