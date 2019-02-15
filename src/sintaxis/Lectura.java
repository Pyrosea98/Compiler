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
public class Lectura extends Sentencia {

	private Token idVariable;
	private Token opAsignacion;
	private Token leer;
	private Token tipoDato;

	/**
	 * Constructor para leer un dato
	 * 
	 * @param idVariable
	 * @param opAsignacion
	 * @param leer
	 * @param parentesisIzq
	 * @param tipoDato
	 * @param parentesisDer
	 * @param fin
	 */
	public Lectura(Token idVariable, Token opAsignacion, Token leer, Token tipoDato) {
		super();
		this.idVariable = idVariable;
		this.opAsignacion = opAsignacion;
		this.leer = leer;
		this.tipoDato = tipoDato;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Lectura");
		nodo.add(new DefaultMutableTreeNode(idVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(opAsignacion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(leer.getLexema()));
		nodo.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		return nodo;
	}
}
