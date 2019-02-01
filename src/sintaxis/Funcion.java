package sintaxis;

import java.util.ArrayList;

import lexico.Token;

/**
 * Clase que representa una función
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Funcion {

	private Visibilidad visibilidad;
	private TipoRetorno tipoRetorno;
	private Token identificadorFuncion;
	private Token parentesisIzquierdo;
	private Token parentesisDerecho;
	private Token agrupadorIzquierdo;
	private Token agrupadorDerecho;
	private Token palabraReservadaFuncion;
	private ArrayList<Parametro> listaParametros;
	private ArrayList<Sentencia> listaSentencias;

	/**
	 * Funcion con visibilidad y lista de parametros
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(Visibilidad visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token parentesisIzquierdo, Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho,
			Token palabraReservadaFuncion, ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin Visibilidad y con Lista De Parametros
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token parentesisIzquierdo,
			Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho, Token palabraReservadaFuncion,
			ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin visibilidad y sin lista de parametros
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token parentesisIzquierdo,
			Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho, Token palabraReservadaFuncion,
			ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion con visibilidad y sin lista de parametros
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(Visibilidad visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token parentesisIzquierdo, Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho,
			Token palabraReservadaFuncion, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (visibilidad != null) {
			if (listaParametros != null) {
				return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
						+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
						+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
						+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
						+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + ", listaSentencias="
						+ listaSentencias + "]";
			} else {
				return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
						+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
						+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
						+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
						+ palabraReservadaFuncion + ", listaSentencias=" + listaSentencias + "]";
			}
		} else if (listaParametros == null) {
			return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
					+ ", parentesisIzquierdo=" + parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho
					+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho
					+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaSentencias=" + listaSentencias
					+ "]";
		} else {
			return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
					+ ", parentesisIzquierdo=" + parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho
					+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho
					+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaParametros=" + listaParametros
					+ ", listaSentencias=" + listaSentencias + "]";
		}
	}
}
