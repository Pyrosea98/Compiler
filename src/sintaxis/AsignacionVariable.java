package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa las asignaciones de variable.
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class AsignacionVariable extends Sentencia {

	private Token identificadorVariable;
	private Expresion ex;
	
	
	
	/**
	 * Constructor de la asignación de variable
	 * @param identificadorVariable
	 * @param ex
	 */
	public AsignacionVariable(Token identificadorVariable, Expresion ex) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.ex = ex;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AsignacionVariable [identificadorVariable=" + identificadorVariable + ", ex=" + ex + "]";
	}
	/**
	 * @return the identificadorVariable
	 */
	public Token getIdentificadorVariable() {
		return identificadorVariable;
	}
	/**
	 * @param identificadorVariable the identificadorVariable to set
	 */
	public void setIdentificadorVariable(Token identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}
	/**
	 * @return the ex
	 */
	public Expresion getEx() {
		return ex;
	}
	/**
	 * @param ex the ex to set
	 */
	public void setEx(Expresion ex) {
		this.ex = ex;
	}


	/**
	 * Método para obtener el árbol de visual de la asignación de variable.
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Declaracion variable");
		
		nodo.add(new DefaultMutableTreeNode(identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(ex.getArbolVisual()));
		
		return nodo;
	}
}
