package semantico;

import java.util.ArrayList;

/**
 * Clase que representa un simbolo dentro del lenguaje
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Simbolo {
	
	private String nombre,tipo;
	private Simbolo ambito, ambitoPadre;
	private boolean esFuncion;
	private int numeroCiclo = 0, numeroCondicional = 0;
	private ArrayList<String> tipos;
	private Boolean retorno = false;
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
	public boolean getRetorno() {
		return retorno;
	}
	
	public void setRetorno(Boolean retorno) {
		this.retorno = retorno;
	}
	/**
	 * @return the numeroCIclo
	 */
	public int getNumeroCiclo() {
		return numeroCiclo;
	}
	/**
	 * @param numeroCiclo the numeroCIclo to set
	 */
	public void setNumeroCiclo(int numeroCiclo) {
		this.numeroCiclo = numeroCiclo;
	}
	/**
	 * @return the numeroCondicional
	 */
	public int getNumeroCondicional() {
		return numeroCondicional;
	}
	/**
	 * @param numeroCondicional the numeroCondicional to set
	 */
	public void setNumeroCondicional(int numeroCondicional) {
		this.numeroCondicional = numeroCondicional;
	}
	
}
