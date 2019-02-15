package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa el valor de asignacion
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class ValorAsignacion {

	private Token tipoDato;

	public ValorAsignacion(Token tipoDato) {
		super();
		this.tipoDato = tipoDato;
	}

	@Override
	public String toString() {
		return "ValorAsignacion [tipoDato=" + tipoDato + "]";
	}

	public DefaultMutableTreeNode getArbolVisual() {
		return new DefaultMutableTreeNode(tipoDato.getLexema());
	}
}
