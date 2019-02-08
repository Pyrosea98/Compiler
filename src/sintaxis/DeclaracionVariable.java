package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class DeclaracionVariable extends Sentencia{

	private Token visibilidad, tipo, fin;
	private ArrayList<Token> listaId;

	/**
	 * @param visibilidad
	 * @param tipo
	 * @param fin
	 * @param listaId
	 */
	public DeclaracionVariable(Token visibilidad, Token tipo, Token fin, ArrayList<Token> listaId) {
		super();
		this.visibilidad = visibilidad;
		this.tipo = tipo;
		this.fin = fin;
		this.listaId = listaId;
	}

	/**
	 * @param tipo
	 * @param fin
	 * @param listaId
	 */
	public DeclaracionVariable(Token tipo, Token fin, ArrayList<Token> listaId) {
		super();
		this.tipo = tipo;
		this.fin = fin;
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
			return "DeclaracionCampo [visibilidad=" + visibilidad + ", tipo=" + tipo + ", fin=" + fin + ", listaId="
					+ listaId + "]";

		} else {
			return "DeclaracionCampo [tipo=" + tipo + ", fin=" + fin + ", listaId=" + listaId + "]";
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
	 * @return the fin
	 */
	public Token getFin() {
		return fin;
	}

	/**
	 * @param fin
	 *            the fin to set
	 */
	public void setFin(Token fin) {
		this.fin = fin;
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
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("");

		if (visibilidad != null) {

			nodo.add(new DefaultMutableTreeNode(visibilidad.getLexema()));

		}

		nodo.add(new DefaultMutableTreeNode(tipo.getLexema()));
		nodo.add(new DefaultMutableTreeNode(fin.getLexema()));

		for (Token id : listaId) {
			nodo.add(new DefaultMutableTreeNode(id.getLexema()));
		}

		return nodo;
	}

}
