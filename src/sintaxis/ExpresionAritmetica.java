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
	private Token opAritmetico;
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
	public ExpresionAritmetica(Termino termino, Token opAritmetico, ExpresionAritmetica expArt) {
		this.termino = termino;
		this.opAritmetico = opAritmetico;
		this.expArt = expArt;
	}

	/**
	 * Constructor que identifica la expresion aritmetica conformadad por una
	 * expresion aritmetica
	 * 
	 * @param expArt
	 */
	public ExpresionAritmetica(ExpresionAritmetica expArt) {
		super();
		this.expArt = expArt;
	}

	/**
	 * Método para obtener el arbol visual de una expresion aritmetica
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Aritmetica");
		if (termino != null) {
			nodo.add(termino.getArbolVisual());
			if (opAritmetico != null) {
				nodo.add(new DefaultMutableTreeNode(opAritmetico.getLexema()));
				if (expArt!=null) {
					nodo.add(expArt.getArbolVisual(nodo));
				}
			}
		}
		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		if (termino != null) {
			nodo.add(termino.getArbolVisual());
			if (opAritmetico != null) {
				nodo.add(new DefaultMutableTreeNode(opAritmetico.getLexema()));
				if (expArt!=null) {
					nodo.add(expArt.getArbolVisual(nodo));
				}
			}
		}
		return nodo;
	}

	/**
	 * @return the termino
	 */
	public Termino getTermino() {
		return termino;
	}

	/**
	 * @param termino
	 *            the termino to set
	 */
	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	/**
	 * @return the opAritmetico
	 */
	public Token getOpAritmetico() {
		return opAritmetico;
	}

	/**
	 * @param opAritmetico
	 *            the opAritmetico to set
	 */
	public void setOpAritmetico(Token opAritmetico) {
		this.opAritmetico = opAritmetico;
	}

	/**
	 * @return the expArt
	 */
	public ExpresionAritmetica getExpArt() {
		return expArt;
	}

	/**
	 * @param expArt
	 *            the expArt to set
	 */
	public void setExpArt(ExpresionAritmetica expArt) {
		this.expArt = expArt;
	}

}
