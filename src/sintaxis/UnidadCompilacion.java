package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa la unidad de compilacion, (Raiz del arbol de analisis
 * lexico)
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class UnidadCompilacion {

	// Variables
	private Token palabraReservadaClase;
	private Token identificadorClase;
	private CuerpoClase cuerpoClase;

	/**
	 * Constructor de la unidad de compilacion
	 * 
	 * @param palabraReservadaClase:
	 *            Palabra reservada del lexico {Clase}
	 * @param identificadorClase
	 * @param agrupadorDerecho
	 * @param cuerpoClase
	 * @param agrupadorIzquierda
	 */
	public UnidadCompilacion(Token palabraReservadaClase, Token identificadorClase,
			CuerpoClase cuerpoClase) {
		super();
		this.palabraReservadaClase = palabraReservadaClase;
		this.identificadorClase = identificadorClase;
		this.cuerpoClase = cuerpoClase;
	}

	/**
	 * @return the palabraReservadaClase
	 */
	public Token getPalabraReservadaClase() {
		return palabraReservadaClase;
	}

	/**
	 * @param palabraReservadaClase
	 *            the palabraReservadaClase to set
	 */
	public void setPalabraReservadaClase(Token palabraReservadaClase) {
		this.palabraReservadaClase = palabraReservadaClase;
	}

	/**
	 * @return the identificadorClase
	 */
	public Token getIdentificadorClase() {
		return identificadorClase;
	}

	/**
	 * @param identificadorClase
	 *            the identificadorClase to set
	 */
	public void setIdentificadorClase(Token identificadorClase) {
		this.identificadorClase = identificadorClase;
	}


	/**
	 * @return the cuerpoClase
	 */
	public CuerpoClase getCuerpoClase() {
		return cuerpoClase;
	}

	/**
	 * @param cuerpoClase
	 *            the cuerpoClase to set
	 */
	public void setCuerpoClase(CuerpoClase cuerpoClase) {
		this.cuerpoClase = cuerpoClase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnidadCompilacion [palabraReservadaClase=" + palabraReservadaClase + ", identificadorClase="
				+ identificadorClase + ", cuerpoClase=" + cuerpoClase + "]";
	}
	
	/**
	 * Método para retornar el nodo de un arbol visual
	 * @return
	 */
	public DefaultMutableTreeNode getArbolVisual() {
		
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Unidad de compilacion");
		
		nodo.add(new DefaultMutableTreeNode(palabraReservadaClase.getLexema()));
		nodo.add(new DefaultMutableTreeNode(identificadorClase.getLexema()));
		nodo.add(cuerpoClase.getArbolVisual());
	
		return nodo;
	}
	
	
	
}
