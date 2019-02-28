package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa la sentencia
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public abstract class Sentencia {
	public abstract DefaultMutableTreeNode getArbolVisual();
	public abstract void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito);
	public abstract void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito);
	public abstract String traducir(String identacion);

}
