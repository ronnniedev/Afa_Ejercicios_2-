package Modelo;

public class Cliente {
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String contraseña;
	private int numeroReservas;
	private int puntosTienda;
	
	public Cliente(String nombre, String apellidos, String telefono, String email, 
			String contraseña, int numeroReservas,int puntosTienda) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.contraseña = contraseña;
		this.numeroReservas = numeroReservas;
		this.puntosTienda = puntosTienda;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/**
	 * @return the numeroReservas
	 */
	public int getNumeroReservas() {
		return numeroReservas;
	}

	/**
	 * @param numeroReservas the numeroReservas to set
	 */
	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}

	/**
	 * @return the puntosTienda
	 */
	public int getPuntosTienda() {
		return puntosTienda;
	}

	/**
	 * @param puntosTienda the puntosTienda to set
	 */
	public void setPuntosTienda(int puntosTienda) {
		this.puntosTienda = puntosTienda;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + 
				", email=" + email.toString()
				+ ", contraseña=" + contraseña 
				+ ", numeroReservas=" + numeroReservas 
				+ ", puntosTienda=" + puntosTienda
				+ "]";
	}

	public static Cliente serializeCliente(String linea) {
		String trozos[] = linea.split(";");
		
		String nombre = trozos[1];
		String apellidos = trozos[2];
		String telefono = trozos[3];
		String email = trozos[4];
		String contraseña = trozos[5];
		int numeroReservas = Integer.parseInt(trozos[6]);
		int puntosTienda = Integer.parseInt(trozos[7]);
		
		return new Cliente(nombre,apellidos,telefono,email,contraseña,numeroReservas,puntosTienda);
	}
	
	
	
	

}
