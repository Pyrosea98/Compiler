package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa un cilclo
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Ciclo extends Sentencia {
	
	private Token ciclo, mientras;
	private ExpresionLogica expresionLogica;
	private ArrayList<Sentencia> sentencias;

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		
		return null;
	}

}
