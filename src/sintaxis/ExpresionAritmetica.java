package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa la expresion Aritmetica
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class ExpresionAritmetica extends Expresion {

	private Termino termino;
	private ExpresionAritmetica expArt;

	/**
	 * Constructor que identifica la expresion Aritmetica conformada solo por un
	 * Termino
	 * 
	 * <ExpresionAritmetica>::= <Termino>
	 * 
	 * @param termino
	 */
	public ExpresionAritmetica(Termino termino) {
		this.termino = termino;
	}

	/**
	 * Constructor que identifica la expresion aritmetica conformada por un termino,
	 * una expresion aritmetica y un operador aritmetico
	 * 
	 * <ExpresionAritmetica>::= <Termino> operadorAritmetico <ExpresionAritmetica>
	 * 
	 * @param termino
	 * @param operadorAritmetico
	 * @param expArt
	 */
	public ExpresionAritmetica(Termino termino, ExpresionAritmetica expArt) {
		this.termino = termino;
		this.expArt = expArt;
	}

	/**
	 * Método para obtener el arbol visual de una expresion aritmetica
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Aritmetica");

		nodo.add(termino.getArbolVisual());
		if (expArt != null) {
			nodo.add(expArt.getArbolVisual(nodo));
		}
		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {
		
		nodo.add(termino.getArbolVisual());
		if (expArt != null) {
			nodo.add(expArt.getArbolVisual(nodo));
		}
		return nodo;
	}

}
