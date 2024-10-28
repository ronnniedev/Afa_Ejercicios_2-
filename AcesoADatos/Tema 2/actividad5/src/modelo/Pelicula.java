package modelo;

import excepciones.PersistenciaException;

public class Pelicula {
	
	private int codigo;
	private int anoEstreno;
	private String titulo;
	private String director;
	
	public Pelicula(int codigo, int anoEstreno, String titulo, String director) {
		this.codigo = codigo;
		this.anoEstreno = anoEstreno;
		this.titulo = titulo;
		this.director = director;
	}

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
	 * @return the anoEstreno
	 */
	public int getAnoEstreno() {
		return anoEstreno;
	}

	/**
	 * @param anoEstreno the anoEstreno to set
	 */
	public void setAnoEstreno(int anoEstreno) {
		this.anoEstreno = anoEstreno;
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
		return "Pelicula [codigo=" + codigo + ", anoEstreno=" + anoEstreno + ", titulo=" 
				+ titulo + ", director="+ director + "]";
	}

	public static Pelicula serialize(String linea) throws PersistenciaException {
		String trozos[] = linea.split("@");
		if(trozos.length != 5) {
			throw new PersistenciaException("ERROR sobra o falta una categoria en pelicula");
		}
		return new Pelicula(Integer.parseInt(trozos[1]),Integer.parseInt(trozos[2])
							,trozos[3],trozos[4]);
	}

	public static String serialize(Pelicula p) {
		return "2@" + p.getCodigo() + "@" + p.getAnoEstreno() 
				+ "@" + p.getTitulo() + "@" + p.getDirector() +"\n" ;
	}
	
	

}
