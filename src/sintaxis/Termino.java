package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;
import lexico.Token;

/**
 * Clase que representa un termino
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class Termino {
	private Token termino;

	public Termino(Token termino) {
		this.setTermino(termino);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Termino [termino=" + termino + "]";
	}

	public Token getTermino() {
		return termino;
	}

	public void setTermino(Token termino) {
		this.termino = termino;
	}

	/**
	 * Arbol de Termino
	 * @return nodo
	 */
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Termino");
		nodo.add(new DefaultMutableTreeNode(termino.getLexema()));
		return nodo;
	}
}
