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

	private Token identificadorVariable, operadorAsignacion;
	private Expresion ex;

	/**
	 * Constructor de la asignaci�n de variable
	 * 
	 * @param identificadorVariable
	 * @param ex
	 */
	public AsignacionVariable(Token identificadorVariable, Token operadorAsignacion, Expresion ex) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.setOperadorAsignacion(operadorAsignacion);
		this.ex = ex;
	}

	/**
	 * @return the identificadorVariable
	 */
	public Token getIdentificadorVariable() {
		return identificadorVariable;
	}

	/**
	 * @param identificadorVariable
	 *            the identificadorVariable to set
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
	 * @param ex
	 *            the ex to set
	 */
	public void setEx(Expresion ex) {
		this.ex = ex;
	}

	public Token getOperadorAsignacion() {
		return operadorAsignacion;
	}

	public void setOperadorAsignacion(Token operadorAsignacion) {
		this.operadorAsignacion = operadorAsignacion;
	}

	/**
	 * M�todo para obtener el �rbol de visual de la asignaci�n de variable.
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Declaracion variable");

		nodo.add(new DefaultMutableTreeNode(identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(operadorAsignacion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(ex.getArbolVisual()));

		return nodo;
	}
}
