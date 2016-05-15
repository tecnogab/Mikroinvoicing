<?php  

require_once "config.php";

class Conexion { 
			
	public function connectDB(){
		$conexion = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
			if($conexion){
				/*echo 'La conexion de la base de datos se ha hecho satisfactoriamente';*/
			}else{
				/*echo 'Ha sucedido un error inesperado en la conexión de la base de datos';*/
			}   
		return $conexion;
	}
	
	public function disconnectDB($conexion){
		$close = mysqli_close($conexion);
		if($close){
			/*echo 'La desconexión de la base de datos se ha hecho satisfactoriamente';*/
		}else{
			/*echo 'Ha sucedido un error inesperado en la desconexión de la base de datos';*/
		}   
		return $close;
	}
} 
?> 