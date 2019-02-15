package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa una sentencia de retorno
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Retorno extends Sentencia {

	private Token retorno;
	private Termino termino;

	/**
	 * Constructor de clase
	 * 
	 * @param retorno
	 * @param termino
	 */
	public Retorno(Token retorno, Termino termino) {
		super();
		this.retorno = retorno;
		this.termino = termino;
	}

	/**
	 * @return the retorno
	 */
	public Token getRetorno() {
		return retorno;
	}

	/**
	 * @param retorno
	 *            the retorno to set
	 */
	public void setRetorno(Token retorno) {
		this.retorno = retorno;
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

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Retorno");
		nodo.add(new DefaultMutableTreeNode(retorno.getLexema()));
		nodo.add(new DefaultMutableTreeNode(retorno.getLexema()));

		return nodo;
	}

}
