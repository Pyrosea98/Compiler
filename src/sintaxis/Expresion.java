package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase Abstracta que representa la Expresion
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public abstract class Expresion {
	public abstract DefaultMutableTreeNode getArbolVisual();
	public abstract void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito);
	public abstract void llenarTablaSimbolos(TablaSimbolos ts);
	public abstract String traducir();

}
