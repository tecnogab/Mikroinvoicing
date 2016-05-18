<?PHP
	require_once "../conn/conexion.php"; 
	
	class IpAddress extends Conexion{
		
		//inserta en la base de datos un nuevo registro en la tabla t_ips
		function insertIp($ipv4, $ipv6, $id_client){

			$phpConn = new Conexion();
			$conn = $phpConn->connectDB();
        
			//Escribimos la sentencia sql necesaria respetando los tipos de datos
			$sql = "INSERT INTO t_ips (ipv4, ipv6, id_client) values ('".ip2long($ipv4)."', '".inet_pton($ipv6)."', '".$id_client."')";
        
			//hacemos la consulta y la comprobamos 
			$consulta = mysqli_query($conn, $sql);
			if(!$consulta){
				echo "No se ha podido insertar una nueva Medalla en la base de datos<br><br>".mysqli_error($conn);
			}			

			$phpConn->disconnectDB($conn); //desconectamos la base de datos
			//devolvemos el resultado de la consulta (true o false)
			return $consulta;
		}
		
		function getIp(){
			
			$phpConn = new Conexion();
			$conn = $phpConn->connectDB();
			
			mysqli_set_charset($conn, "latin1_swedish_ci");
			
			if(!$result = mysqli_query($conn, "SELECT * FROM t_ips LIMIT 1")) die();
				// Para leer:			
				$ipv4 = inet_ntop( $result['ipv4'] );
				$ipv6 = inet_ntop( $result['ipv6'] );			
				echo "Ip V4 = " . $ipv4;
				echo "Ip V6 = " . $ipv6;		
			
			$phpConn->disconnectDB($conn); //desconectamos la base de datos										
		}
	}		
?>