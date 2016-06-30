package ar.com.jgt.interfaces;

import java.util.List;

public interface Grabable<Datos> {
	/**
	 * Metodo a ser implementado para insertar datos, recibe como parametros los
	 * datos que se desean insertar en una tabla
	 * 
	 * @return boolean indicando si fue exitosa la entrada de datos
	 * @param conjunto de datos correspondiente a los atributos de las tablas
	 */
	public boolean create(Datos p_datos);

	/**
	 * Metodo a ser implementado para borrar datos, recibe como parametro un
	 * objeto y retorna un booleano
	 * 
	 * @param Object con la clave a ser borrada
	 * @return {@link Boolean} indicando si hubo exito en al borrar el dato
	 */
	
	public boolean delete(Object p_key);
	public boolean update(Datos p_datos); // Metodo a ser implementado para actualizar datos, recibe como parametros los datos que se desean actualizar
	public Datos read(Object p_key); // Metodo a ser implementado para leer un dato, recibe como parametor un Objeto
	public List<Datos> readAll(); // Metodo a ser implementado para leer todos los datos de una tabla, devuelve una lista
}
