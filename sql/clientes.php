<?php  

require_once "conexion.php"; 

class Clientes extends Conexion{     
			
		
	function getArraySQL($sql){
		$phpConn = new Conexion();
		//Creamos la conexión con la función anterior
		$conn = $phpConn->connectDB();
		//generamos la consulta
		mysqli_set_charset($conn, "latin1_swedish_ci"); //formato de datos latin1_swedish_ci
		if(!$result = mysqli_query($conn, $sql)) die(); //si la conexión cancelar programa
		$rawdata = array(); //creamos un array
		//guardamos en un array multidimensional todos los datos de la consulta
		$i=0;

		while($row = mysqli_fetch_array($result)){
			$rawdata[$i] = $row;
			$i++;
		}
		$phpConn->disconnectDB($conn); //desconectamos la base de datos
		
		return $rawdata; //devolvemos el array
	}	
} 
  ?> 