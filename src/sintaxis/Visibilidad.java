package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;


/**
 * Clase que representa la unidad de la visibilidad
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Visibilidad {
	
	private Token visibilidad;

	/**
	 * Constructor de visibilidad
	 * @param visibilidad
	 */
	public Visibilidad(Token visibilidad) {
		super();
		this.visibilidad = visibilidad;
	}

	public DefaultMutableTreeNode getArbolVisual() {
		
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Visibilidad");
		
		nodo.add(new DefaultMutableTreeNode(visibilidad.getLexema()));
		
		return nodo;
	}
}
