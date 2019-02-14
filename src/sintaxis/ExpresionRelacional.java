package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa la sentencia
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class ExpresionRelacional extends Expresion{

	private ExpresionAritmetica expAritmetica;
	private Token opRelacional;
	private Token parentesisIzq, parentesisDer;
	private ExpresionRelacional expRelacional;

	/**
	 * Constructor con expresion aritmetica
	 * 
	 * @param expAritmetica
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica) {
		super();
		this.expAritmetica = expAritmetica;
	}

	/**
	 * Constructor con expresion aritmetica y operador relacional
	 * 
	 * @param expAritmetica
	 * @param opRelacional
	 * @param expRelacional
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica, Token opRelacional,
			ExpresionRelacional expRelacional) {
		super();
		this.expAritmetica = expAritmetica;
		this.opRelacional = opRelacional;
		this.expRelacional = expRelacional;
	}

	/**
	 * Constructor con parentesis izquierdo , parentesis derecho y expresion
	 * relacional
	 * 
	 * @param parentesisIzq
	 * @param parentesisDer
	 * @param expRelacional
	 */
	public ExpresionRelacional(Token parentesisIzq, Token parentesisDer, ExpresionRelacional expRelacional) {
		super();
		this.parentesisIzq = parentesisIzq;
		this.parentesisDer = parentesisDer;
		this.expRelacional = expRelacional;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (expAritmetica != null) {
			return "ExpresionRelacional [expAritmetica=" + expAritmetica + "]";
		} else if (opRelacional != null) {
			return "ExpresionRelacional [expAritmetica=" + expAritmetica + ", opRelacional=" + opRelacional
					+ ", expRelacional=" + expRelacional + "]";
		} else if (parentesisIzq != null) {
			return "ExpresionRelacional [parentesisIzq=" + parentesisIzq + ", expRelacional=" + expRelacional
					+ ", parentesisDer=" + parentesisDer + "]";
		} else {
			return null;
		}

	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}

}
