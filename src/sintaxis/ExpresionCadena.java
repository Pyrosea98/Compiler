package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa la expresion Cadena
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class ExpresionCadena extends Expresion {

	private Termino termino;
	private ExpresionCadena expCadena;

	/**
	 * Constructor para una expresion de cadena con solo un termino
	 * 
	 * @param termino
	 */
	public ExpresionCadena(Termino termino) {
		super();
		this.termino = termino;
	}

	/**
	 * Constructor para una expresion de cadena con uno o mas terminos
	 * 
	 * @param termino
	 * @param expCadena
	 */
	public ExpresionCadena(Termino termino, ExpresionCadena expCadena) {
		super();
		this.termino = termino;
		this.expCadena = expCadena;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Cadena");

		nodo.add(termino.getArbolVisual());
		if (expCadena != null) {
			nodo.add(expCadena.getArbolVisual(nodo));
		}
		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		nodo.add(termino.getArbolVisual());
		if (expCadena != null) {
			nodo.add(expCadena.getArbolVisual(nodo));
		}
		return nodo;
	}

}
