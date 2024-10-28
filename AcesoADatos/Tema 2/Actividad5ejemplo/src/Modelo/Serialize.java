package Modelo;

import Excepciones.PersistenciaException;

public interface Serialize {

	public String serialize(Object obj);
	public Object serialize(String linea) throws PersistenciaException;

}
