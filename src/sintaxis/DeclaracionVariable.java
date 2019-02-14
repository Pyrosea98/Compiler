package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class DeclaracionVariable extends Sentencia {

	private Token visibilidad, tipo;
	private ArrayList<Token> listaId;

	/**
	 * @param visibilidad
	 * @param tipo
	 * @param fin
	 * @param listaId
	 */
	public DeclaracionVariable(Token visibilidad, Token tipo, ArrayList<Token> listaId) {
		super();
		this.visibilidad = visibilidad;
		this.tipo = tipo;
		this.listaId = listaId;
	}

	/**
	 * @param tipo
	 * @param fin
	 * @param listaId
	 */
	public DeclaracionVariable(Token tipo, ArrayList<Token> listaId) {
		super();
		this.tipo = tipo;
		this.listaId = listaId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (visibilidad != null) {
			return "DeclaracionCampo [visibilidad=" + visibilidad + ", tipo=" + tipo + ", fin=" + ", listaId=" + listaId
					+ "]";

		} else {
			return "DeclaracionCampo [tipo=" + tipo + ", fin=" + ", listaId=" + listaId + "]";
		}

	}

	/**
	 * @return the visibilidad
	 */
	public Token getVisibilidad() {
		return visibilidad;
	}

	/**
	 * @param visibilidad
	 *            the visibilidad to set
	 */
	public void setVisibilidad(Token visibilidad) {
		this.visibilidad = visibilidad;
	}

	/**
	 * @return the tipo
	 */
	public Token getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Token tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the listaId
	 */
	public ArrayList<Token> getListaId() {
		return listaId;
	}

	/**
	 * @param listaId
	 *            the listaId to set
	 */
	public void setListaId(ArrayList<Token> listaId) {
		this.listaId = listaId;
	}

	/**
	 * Método para retornar el nodo de un arbol visual
	 * 
	 * @return
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Declaracion variable");

		if (visibilidad != null) {
			nodo.add(new DefaultMutableTreeNode(visibilidad.getLexema()));
		}

		nodo.add(new DefaultMutableTreeNode(tipo.getLexema()));

		for (Token id : listaId) {
			nodo.add(new DefaultMutableTreeNode(id.getLexema()));
		}

		return nodo;
	}

}
