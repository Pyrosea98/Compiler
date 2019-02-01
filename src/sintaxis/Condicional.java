package sintaxis;

import java.util.ArrayList;

import lexico.Token;

public class Condicional {
	
	private Token pregunta;
	private Token parentesisIzquierdo;
	private ExpresionLogica expresionLogica;
	private Token parentesisDerecho;
	private Token agrupadorIzquierdo;
	private ArrayList<Sentencia> listaSentencia;
	private Token agrupadorDerecho;
	private Token contrario;
	private Token agrupadorIzquierdo0;
	private ArrayList<Sentencia> listaSentencia0;
	private Token agrupadorDerecho0;
	
	/**
	 * Constructor que crea condicional sin caso contrario
	 * @param pregunta
	 * @param parentesisIzquierdo
	 * @param expresionLogica
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param listaSentencia
	 * @param agrupadorDerecho
	 */
	public Condicional(Token pregunta, Token parentesisIzquierdo, ExpresionLogica expresionLogica,
			Token parentesisDerecho, Token agrupadorIzquierdo, ArrayList<Sentencia> listaSentencia,
			Token agrupadorDerecho) {
		super();
		this.pregunta = pregunta;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.expresionLogica = expresionLogica;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.listaSentencia = listaSentencia;
		this.agrupadorDerecho = agrupadorDerecho;
	}

	/**
	 * Constructor que crea condicional con caso contrario
	 * @param pregunta
	 * @param parentesisIzquierdo
	 * @param expresionLogica
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param listaSentencia
	 * @param agrupadorDerecho
	 * @param contrario
	 * @param agrupadorIzquierdo0
	 * @param listaSentencia0
	 * @param agrupadorDerecho0
	 */
	public Condicional(Token pregunta, Token parentesisIzquierdo, ExpresionLogica expresionLogica,
			Token parentesisDerecho, Token agrupadorIzquierdo, ArrayList<Sentencia> listaSentencia,
			Token agrupadorDerecho, Token contrario, Token agrupadorIzquierdo0, ArrayList<Sentencia> listaSentencia0,
			Token agrupadorDerecho0) {
		super();
		this.pregunta = pregunta;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.expresionLogica = expresionLogica;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.listaSentencia = listaSentencia;
		this.agrupadorDerecho = agrupadorDerecho;
		this.contrario = contrario;
		this.agrupadorIzquierdo0 = agrupadorIzquierdo0;
		this.listaSentencia0 = listaSentencia0;
		this.agrupadorDerecho0 = agrupadorDerecho0;
	}

	@Override
	public String toString() {
		if(contrario!=null) {
		return "Condicional [pregunta=" + pregunta + ", parentesisIzquierdo=" + parentesisIzquierdo
				+ ", expresionLogica=" + expresionLogica + ", parentesisDerecho=" + parentesisDerecho
				+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", listaSentencia=" + listaSentencia
				+ ", agrupadorDerecho=" + agrupadorDerecho + ", contrario=" + contrario + ", agrupadorIzquierdo0="
				+ agrupadorIzquierdo0 + ", listaSentencia0=" + listaSentencia0 + ", agrupadorDerecho0="
				+ agrupadorDerecho0 + "]";
		}else {
			return "Condicional [pregunta=" + pregunta + ", parentesisIzquierdo=" + parentesisIzquierdo
					+ ", expresionLogica=" + expresionLogica + ", parentesisDerecho=" + parentesisDerecho
					+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", listaSentencia=" + listaSentencia
					+ ", agrupadorDerecho=" + agrupadorDerecho;
		}
	}
}
