package modelo;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import excepciones.ExcepcionExamen;
import excepciones.PersistenciaException;

public class Sistema {

	private List<Cliente> clientes;
	private List<Pelicula> peliculas;

	public Sistema() {
		this.clientes = new LinkedList<Cliente>();
		this.peliculas = new LinkedList<Pelicula>();
	}

	/**
	 * @return the clientes
	 */
	public List<Cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	/**
	 * @return the peliculas
	 */
	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	/**
	 * @param peliculas the peliculas to set
	 */
	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public void añadirAlquiler(String linea) throws PersistenciaException, ExcepcionExamen {
		String trozos[] = linea.split("@");

		if (trozos.length != 3) {
			throw new PersistenciaException("ERROR parametros con numeros distintos");
		}

		for (Cliente c : clientes) {
			if (c.getDni().compareTo(trozos[1]) == 0) {
				Pelicula p = encontrarPelicula(trozos[2]);
				if (p != null) {
					c.getPeliculasAlquiladas().add(p);
					return;
				}

			}

		}
		System.out.println("Pelicula no encontrada");
	}

	public Pelicula encontrarPelicula(String codPelicula) {
		int cod = Integer.parseInt(codPelicula);

		for (Pelicula p : peliculas) {
			if (p.getCodigo() == cod) {
				return p;
			}
		}

		return null;
	}

	public void añadirCliente(Cliente cliente) throws LogicaException {

		for (Cliente c : clientes) {
			if (c.getDni().compareTo(cliente.getDni()) == 0) {
				throw new LogicaException("Cliente ya en la base de datos");
			}
		}

		clientes.add(cliente);
	}

	public void añadirPelicula(Pelicula pelicula) throws LogicaException {

		for (Pelicula p : peliculas) {
			if (p.getCodigo() == pelicula.getCodigo()) {
				throw new LogicaException("Pelicula ya existe en la base de datos");
			}
		}

		peliculas.add(pelicula);
	}

	public String listarClientes() {
		String texto = "-----Lista de clientes-----\n";

		clientes.sort(Comparator.comparing(Cliente::getApellidos));

		for (Cliente c : clientes) {
			texto += c.toString() + "\n";
		}

		return texto;
	}

	public String listarVideos() {
		String texto = "-----Lista de clientes-----";

		peliculas.sort(Comparator.comparing(Pelicula::getTitulo));

		for (Pelicula p : peliculas) {
			texto += p.toString() + "\n";
		}

		return texto;
	}

	public void añadirAlqui(String dni, int codigo) {

		try {
			String linea = 3 + "@" + dni + "@" + codigo;
			this.añadirAlquiler(linea);
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionExamen e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void borrarAlqui(String dni, int codigo) {
		for (Cliente c : clientes) {
			if (c.getDni().compareTo(dni) == 0) {
				List<Pelicula> alquiladas = c.getPeliculasAlquiladas();
				for (int i = 0; i < alquiladas.size(); i++) {
					if (alquiladas.get(i).getCodigo() == codigo) {
						alquiladas.remove(i);
						return;
					}
				}
				System.out.println("Pelicula no encontrada");
				return;
			}
		}
		System.out.println("Cliente no encontrado");

	}

	public void listarAlquileres(String dni) {
		System.out.println("Alquileres de cliente " + dni);

		for (Cliente c : clientes) {
			if (c.getDni().compareTo(dni) == 0) {
				List peliculas = c.getPeliculasAlquiladas();
				for (int i = 0; i < peliculas.size(); i++) {
					System.out.println(peliculas.get(i));
				}
			}
		}
	}

}
