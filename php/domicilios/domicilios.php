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
	}		
?>