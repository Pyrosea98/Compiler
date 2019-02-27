package semantico;

import java.util.ArrayList;

public class Simbolo {
	
	private String nombre,tipo;
	private Simbolo ambito, ambitoPadre;
	private boolean esFuncion;
	private ArrayList<String> tipos;
	/**
	 * @param nombre
	 * @param tipo
	 * @param ambito
	 * @param esFuncion
	 * @param parametros
	 */
	public Simbolo(String nombre, String tipo, Simbolo ambito) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.setAmbito(ambito);
		esFuncion = false;
	}
	/**
	 * @param nombre
	 * @param tipo
	 * @param parametros
	 * @param tipos 
	 */
	public Simbolo(String nombre, String tipo, ArrayList<String> tipos) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.tipos = tipos;
		esFuncion = true;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the tipos
	 */
	public ArrayList<String> getTipos() {
		return tipos;
	}
	/**
	 * @param tipos the tipos to set
	 */
	public void setTipos(ArrayList<String> tipos) {
		this.tipos = tipos;
	}
	public Simbolo getAmbito() {
		return ambito;
	}
	public void setAmbito(Simbolo ambito) {
		this.ambito = ambito;
	}
	public boolean isEsFuncion() {
		return esFuncion;
	}
	public void setEsFuncion(boolean esFuncion) {
		this.esFuncion = esFuncion;
	}
	public Simbolo getAmbitoPadre() {
		return ambitoPadre;
	}
	public void setAmbitoPadre(Simbolo ambitoPadre) {
		this.ambitoPadre = ambitoPadre;
	}
	
}
