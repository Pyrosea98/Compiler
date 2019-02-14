package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa la expresion Cadena
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Impresion extends Sentencia {

	private Token escribir;
	private Termino termino;
	private Token fin;

	/**
	 * Constructor para imprimir un dato
	 * 
	 * @param escribir
	 * @param termino
	 * @param fin
	 */
	public Impresion(Token escribir, Termino termino, Token fin) {
		super();
		this.escribir = escribir;
		this.termino = termino;
		this.fin = fin;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Impresion");

		nodo.add(new DefaultMutableTreeNode(escribir.getLexema()));
		if (termino != null) {
			nodo.add(termino.getArbolVisual());
			nodo.add(new DefaultMutableTreeNode(fin.getLexema()));
		}
		return nodo;
	}
}
