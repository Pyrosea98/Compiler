package sintaxis;

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
	private Token agrupadorDerecho;
	private CuerpoClase cuerpoClase;
	private Token agrupadorIzquierda;

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
	public UnidadCompilacion(Token palabraReservadaClase, Token identificadorClase, Token agrupadorDerecho,
			CuerpoClase cuerpoClase, Token agrupadorIzquierda) {
		super();
		this.palabraReservadaClase = palabraReservadaClase;
		this.identificadorClase = identificadorClase;
		this.agrupadorDerecho = agrupadorDerecho;
		this.cuerpoClase = cuerpoClase;
		this.agrupadorIzquierda = agrupadorIzquierda;
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
	 * @return the agrupadorDerecho
	 */
	public Token getAgrupadorDerecho() {
		return agrupadorDerecho;
	}

	/**
	 * @param agrupadorDerecho
	 *            the agrupadorDerecho to set
	 */
	public void setAgrupadorDerecho(Token agrupadorDerecho) {
		this.agrupadorDerecho = agrupadorDerecho;
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

	/**
	 * @return the agrupadorIzquierda
	 */
	public Token getAgrupadorIzquierda() {
		return agrupadorIzquierda;
	}

	/**
	 * @param agrupadorIzquierda
	 *            the agrupadorIzquierda to set
	 */
	public void setAgrupadorIzquierda(Token agrupadorIzquierda) {
		this.agrupadorIzquierda = agrupadorIzquierda;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnidadCompilacion [palabraReservadaClase=" + palabraReservadaClase + ", identificadorClase="
				+ identificadorClase + ", agrupadorDerecho=" + agrupadorDerecho + ", cuerpoClase=" + cuerpoClase
				+ ", agrupadorIzquierda=" + agrupadorIzquierda + "]";
	}

}
