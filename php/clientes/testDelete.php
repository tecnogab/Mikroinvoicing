<?php  

require_once "../conn/conexion.php"; 

class Clientes extends Conexion{     

	function borrarCliente($dni){
		$phpConn = new Conexion();
		$conn = $phpConn->connectDB();        		
		$stmt = mysqli_prepare($conn, "DELETE FROM t_clientes WHERE dni_cli = ?");
		mysqli_stmt_bind_param($stmt, 's', $dni);				
		
		/* ejecuta sentencias preparadas */
		mysqli_stmt_execute($stmt);
		
		printf("%d Filas borradas.\n", mysqli_stmt_affected_rows($stmt));
        
		/* cierra sentencia y conexión */
		mysqli_stmt_close($stmt);
		
		$phpConn->disconnectDB($conn); //desconectamos la base de datos        
	}	
}

	//--Creamos un objeto de la clase usuarioClass
    $cliente = new Clientes();
	
    $cliente->borrarCliente("asdf");
?>