package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class Lectura extends Sentencia {

	private Token idVariable;
	private Token opAsignacion;
	private Token leer;
	private TipoDato tipoDato;
	private Token fin;

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
	public Lectura(Token idVariable, Token opAsignacion, Token leer, TipoDato tipoDato, Token fin) {
		super();
		this.idVariable = idVariable;
		this.opAsignacion = opAsignacion;
		this.leer = leer;
		this.tipoDato = tipoDato;
		this.fin = fin;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Lectura");
		nodo.add(new DefaultMutableTreeNode(idVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(opAsignacion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(leer.getLexema()));
		if (tipoDato != null) {
			nodo.add(tipoDato.getArbolVisual());
			nodo.add(new DefaultMutableTreeNode(fin.getLexema()));
		}
		return nodo;
	}

}
