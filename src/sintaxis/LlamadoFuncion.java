package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class LlamadoFuncion extends Sentencia {

	/**
	 * Clase que representa el llamado a una funcion
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */

	private Token identificadorFuncion;
	private ArrayList<Termino> listaArgumentos;

	/**
	 * Constructor que declara un llamado a funcion
	 * 
	 * @param identificadorFuncion
	 * @param listaArgumentos
	 */
	public LlamadoFuncion(Token identificadorFuncion, ArrayList<Termino> listaArgumentos) {
		super();
		this.identificadorFuncion = identificadorFuncion;
		this.listaArgumentos = listaArgumentos;
	}
	
	/**
	 * Constructor que declara un llamado a funcion
	 * 
	 * @param identificadorFuncion
	 */
	public LlamadoFuncion(Token identificadorFuncion) {
		super();
		this.identificadorFuncion = identificadorFuncion;
	}

	@Override
	public String toString() {
		return "LlamadoFuncion [identificadorFuncion=" + identificadorFuncion + ", listaArgumentos=" + listaArgumentos
				+ "]";
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Llamado funcion");

		nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
		if (listaArgumentos != null) {
			for (Termino termino : listaArgumentos) {
				nodo.add(termino.getArbolVisual());
			}
		}
		return nodo;
	}
}
