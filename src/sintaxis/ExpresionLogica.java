package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;
import lexico.Token;

/**
 * Clase que representa la expresion logica
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class ExpresionLogica extends Expresion {

	private ExpresionRelacional expresionRelacional;
	private Token operadorLogico;
	private ExpresionLogica expresionLogica;
	private Token parentesisIzquierdo;
	private Token parentesisDerecho;

	/**
	 * Constructor que crea expresion logica con solo una expresion relacional
	 * 
	 * @param expresionRelacional
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional) {
		super();
		this.expresionRelacional = expresionRelacional;
	}

	/**
	 * Constructor que crea expresion logica con caso contrario
	 * 
	 * @param expresionRelacional
	 * @param operadorLogico
	 * @param expresionLogica
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, Token operadorLogico,
			ExpresionLogica expresionLogica) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.operadorLogico = operadorLogico;
		this.expresionLogica = expresionLogica;
	}

	/**
	 * Constructor que crea expresion logica entre parentesis
	 * 
	 * @param expresionRelacional
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, Token parentesisIzquierdo,
			Token parentesisDerecho) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
	}

	/**
	 * Metodo del arbol grafico
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Logica");

		if (expresionRelacional != null) {
			nodo.add(expresionRelacional.getArbolVisual());
			if (operadorLogico != null) {
				nodo.add(new DefaultMutableTreeNode(operadorLogico.getLexema()));
				if (expresionLogica != null) {
					nodo.add(expresionLogica.getArbolVisual(nodo));
				}
			}
		} else {
			if (expresionLogica != null) {
				nodo.add(expresionLogica.getArbolVisual(nodo));
			}
		}
		return nodo;
	}
	
	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode node) {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Logica");

		if (expresionRelacional != null) {
			nodo.add(expresionRelacional.getArbolVisual());
			if (operadorLogico != null) {
				nodo.add(new DefaultMutableTreeNode(operadorLogico.getLexema()));
				if (expresionLogica != null) {
					nodo.add(expresionLogica.getArbolVisual(node));
				}
			}
		} else {
			if (expresionLogica != null) {
				nodo.add(expresionLogica.getArbolVisual(node));
			}
		}
		return nodo;
	}
}