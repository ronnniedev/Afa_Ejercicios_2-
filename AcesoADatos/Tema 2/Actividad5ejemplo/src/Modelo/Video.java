package Modelo;

import Excepciones.PersistenciaException;

public class Video implements Serialize {
	
	private int codigo;
	private int anioEstreno;
	private String titulo;
	private String director;
	
	public Video(int codigo, int anioEstreno, String titulo, String director) {
		this.codigo = codigo;
		this.anioEstreno = anioEstreno;
		this.titulo = titulo;
		this.director = director;
	}
	
	public Video() {};

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the anioEstreno
	 */
	public int getAnioEstreno() {
		return anioEstreno;
	}

	/**
	 * @param anioEstreno the anioEstreno to set
	 */
	public void setAnioEstreno(int anioEstreno) {
		this.anioEstreno = anioEstreno;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}

	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Video [codigo=" + codigo + ", anioEstreno=" + anioEstreno + ", titulo=" + titulo + ", director="
				+ director + "]";
	}

	@Override
	public String serialize(Object obj) {
		Video v=(Video)obj;
		
		return "2@"+ v.getCodigo() + "@" + v.getAnioEstreno() + "@" 
				+ v.getTitulo() + "@" + v.getDirector() + "\n";
	}

	@Override
	public Object serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length !=5) {
			throw new PersistenciaException("ERROR registro video incorrecto");
		}
		try {
			int codigo = Integer.parseInt(trozos[1]);
			int anioEstreno = Integer.parseInt(trozos[2]);
			String titulo = trozos[3];
			String director = trozos[4];
			
			return new Video(codigo,anioEstreno,titulo,director);
		}catch(Exception e) {
			throw new PersistenciaException("ERROR numero mal formado");
		}
		
	}
	
	
	

}
