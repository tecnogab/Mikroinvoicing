<?php
require_once "config.php";
class Database {
     
    private static $conn  = null;
     
    public function __construct(){
        die('Init function is not allowed');
    }
     
    public static function connect(){		
		// One connection through whole application
		if ( null == self::$conn ){
			try {
				self::$conn = new PDO( "mysql:host=".DB_HOST.";"."dbname=".DB_NAME, DB_USER, DB_PASS, $opciones); 
			} catch(PDOException $pdoException){
				die($pdoException -> getMessage()); 
			}
		}
       return self::$conn;
    }
     
    public static function disconnect(){
        self::$conn = null;
    }
}
?>