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
	private Token operadorAritmetico;
	private Token parentesisIzq;
	private Token parentesisDer;
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
	public ExpresionAritmetica(Termino termino, Token operadorAritmetico, ExpresionAritmetica expArt) {
		this.termino = termino;
		this.operadorAritmetico = operadorAritmetico;
		this.expArt = expArt;
	}

	/**
	 * Constructor que identifica la expresion aritmetica conformada por un termino,
	 * una expresion aritmetica y un operador aritmetico. Con diferencia a la
	 * anterior, esta tiene el termino entre parentesis
	 * 
	 * <ExpresionAritmetica>::= (<Termino>) operadorAritmetico <ExpresionAritmetica>
	 * 
	 * @param parentesisIzq
	 * @param termino
	 * @param parentesisDer
	 * @param operadorAritmetico
	 * @param expArt
	 */
	public ExpresionAritmetica(Token parentesisIzq, Termino termino, Token parentesisDer, ExpresionAritmetica expArt,
			Token operadorAritmetico) {
		this.parentesisIzq = parentesisIzq;
		this.termino = termino;
		this.parentesisDer = parentesisDer;
		this.operadorAritmetico = operadorAritmetico;
		this.expArt = expArt;
	}

	/**
	 * Constructor que identifica la expresion aritmetica conformada por una
	 * expresion aritmetica encerrada entre parentesis
	 * 
	 * <ExpresionAritmetica>::= (<ExpresionAritmetica>)
	 * 
	 * @param parentesisIzq
	 * @param expArt
	 * @param parentesisDer
	 */
	public ExpresionAritmetica(Token parentesisIzq, ExpresionAritmetica expArt, Token parentesisDer) {
		super();
		this.parentesisIzq = parentesisIzq;
		this.expArt = expArt;
		this.parentesisDer = parentesisDer;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Aritmetica");

		nodo.add(termino.getArbolVisual());
		if (operadorAritmetico != null) {
			nodo.add(new DefaultMutableTreeNode(operadorAritmetico.getLexema()));
			if (expArt != null) {
				nodo.add(expArt.getArbolVisual(nodo));
			}
		}
		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode node) {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Aritmetica");

		nodo.add(termino.getArbolVisual());
		if (operadorAritmetico != null) {
			nodo.add(new DefaultMutableTreeNode(operadorAritmetico.getLexema()));
			if (expArt != null) {
				nodo.add(expArt.getArbolVisual(nodo));
			}
		}
		return nodo;
	}

}
