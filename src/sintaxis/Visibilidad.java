package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visibilidad [visibilidad=" + visibilidad + "]";
	}

	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}
}
