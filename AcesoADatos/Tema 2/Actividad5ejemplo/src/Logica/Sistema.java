package Logica;

import java.util.ArrayList;
import java.util.List;

import Modelo.Cliente;
import Modelo.Video;

public class Sistema {
	
	private List <Cliente>clientes;
	private List <Video>videos;
	
	public Sistema() {
		clientes = new ArrayList<Cliente>();
		videos = new ArrayList<Video>();
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
	 * @return the videos
	 */
	public List<Video> getVideos() {
		return videos;
	}

	/**
	 * @param videos the videos to set
	 */
	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public String listarClientes() {
		String texto = "";
		
		for(Cliente c: clientes) {
			texto += c.toString();
		}
		return texto;
	}

	public String listarVideos() {
		String texto = "";
		for(Video v: videos) {
			texto += v.toString() + "\n";
		}
		return texto;
	}
	
	public void addVideo(Video v) {
		videos.add(v);
	}

	public void añadirAlqui(String dni, int codigo) {
		// TODO Auto-generated method stub
		
	}
	
	public Cliente buscarCliente(String dni) {
		for(Cliente c: clientes) {
			if(c.getDNI().compareTo(dni)==0) {
				return c;
			}
		}
		return null;
	}
	
	public Video buscarVideo(int codigo) {
		for(Video v: videos) {
			if(v.getCodigo() == codigo) {
				return v;
			}
			
		}
		return null;
	}

	public void listarAlquileres(String dni) {
		// TODO Auto-generated method stub
		
	}

	public void borrarAlqui(String dni, int codigo) {
		// TODO Auto-generated method stub
		
	}

	public void añadirCliente(Cliente cliente) {
		clientes.add(cliente);
		
	}

}
