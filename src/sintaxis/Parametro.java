package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa el parametro
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Parametro {

	private Token tipoDato;
	private Token arreglo;
	private Token idenVariable;

	/**
	 * Constructor que tiene ell tipo de dato y el identificador de variable
	 * 
	 * @param tipoDato
	 * @param idenVariable
	 */
	public Parametro(Token tipoDato, Token idenVariable) {
		super();
		this.tipoDato = tipoDato;
		this.idenVariable = idenVariable;
	}

	/**
	 * Constructor que tiene tipo de dato, arreglo y un identificador de variable
	 * 
	 * @param tipoDato
	 * @param arreglo
	 * @param idenVariable
	 */
	public Parametro(Token tipoDato, Token arreglo, Token idenVariable) {
		super();
		this.tipoDato = tipoDato;
		this.arreglo = arreglo;
		this.idenVariable = idenVariable;
	}

	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Parametros");

		nodo.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		if (arreglo != null) {
			nodo.add(new DefaultMutableTreeNode(arreglo.getLexema()));
		}
		nodo.add(new DefaultMutableTreeNode(idenVariable.getLexema()));
		return nodo;
	}

}
