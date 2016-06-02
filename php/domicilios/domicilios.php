<?PHP
	require_once "../conn/conexion.php"; 
	
	class Domicilios extends Conexion{
		//inserta en la base de datos un nuevo registro en la tabla t_ips
		function insertDom($barrio, $calle, $latitude, $longitude, $id_cliente){
			
			$phpConn = new Conexion();
			$conn = $phpConn->connectDB();
        
			//Escribimos la sentencia sql necesaria respetando los tipos de datos
			$sql = "INSERT INTO t_domicilios (barrio_dom, calle_dom, coordenadas_dom, id_cli) VALUES 
				('".$barrio."', '".$calle."', GeomFromText('POINT($latitude $longitude),4'), '".$id_cliente."');";
        
			//hacemos la consulta y la comprobamos 
			$consulta = mysqli_query($conn, $sql);
			if(!$consulta){
				echo "No se ha podido insertar una nueva Medalla en la base de datos<br><br>".mysqli_error($conn);
			}			

			$phpConn->disconnectDB($conn); //desconectamos la base de datos
			//devolvemos el resultado de la consulta (true o false)
			return $consulta;
		}
		
		function getAllDom(){
			
			$phpConn = new Conexion();
			$conn = $phpConn->connectDB();
        
			//Escribimos la sentencia sql necesaria respetando los tipos de datos
			$sql = "SELECT * FROM t_domicilios";
			// Ejecutar la consulta
			$resultado = mysqli_query($conn, $sql);
			
			// Comprobar el resultado
			// Lo siguiente muestra la consulta real enviada a MySQL, y el error ocurrido. Útil para depuración.
			if (!$resultado) {
				$mensaje  = 'Consulta no válida: ' . mysql_error() . "\n";
				$mensaje .= 'Consulta completa: ' . $sql;
				die($mensaje);
			}			
			$resultado->data_seek(0);			
			while ($fila = $resultado->fetch_assoc()) {				
				echo $fila['id_domicilio'];?> <br> <?PHP
				echo $fila['barrio_dom']; ?> <br> <?PHP
				echo $fila['calle_dom'];?> <br> <?PHP
				echo $fila['coordenadas_dom'];?> <br> <?PHP
				echo $fila['id_cli'];				
			}
			
			$phpConn->disconnectDB($conn); //desconectamos la base de datos			
			return $rawdata;
		}
	}
?>