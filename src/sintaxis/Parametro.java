package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa el parametro
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Parametro {

	private Token tipoDato;
	private Token arreglo;
	private Token idenVariable;

	/**
	 * Constructor que tiene ell tipo de dato y el identificador de variable
	 * 
	 * @param tipoDato
	 * @param idenVariable
	 */
	public Parametro(Token tipoDato, Token idenVariable) {
		super();
		this.tipoDato = tipoDato;
		this.idenVariable = idenVariable;
	}

	/**
	 * Constructor que tiene tipo de dato, arreglo y un identificador de variable
	 * 
	 * @param tipoDato
	 * @param arreglo
	 * @param idenVariable
	 */
	public Parametro(Token tipoDato, Token arreglo, Token idenVariable) {
		super();
		this.tipoDato = tipoDato;
		this.arreglo = arreglo;
		this.idenVariable = idenVariable;
	}

	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Parametros");

		nodo.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		if (arreglo != null) {
			nodo.add(new DefaultMutableTreeNode(arreglo.getLexema()));
		}
		nodo.add(new DefaultMutableTreeNode(idenVariable.getLexema()));
		return nodo;
	}

	/**
	 * @return the tipoDato
	 */
	public Token getTipoDato() {
		return tipoDato;
	}

	/**
	 * @param tipoDato
	 *            the tipoDato to set
	 */
	public void setTipoDato(Token tipoDato) {
		this.tipoDato = tipoDato;
	}

	/**
	 * @return the arreglo
	 */
	public Token getArreglo() {
		return arreglo;
	}

	/**
	 * @param arreglo
	 *            the arreglo to set
	 */
	public void setArreglo(Token arreglo) {
		this.arreglo = arreglo;
	}

	/**
	 * @return the idenVariable
	 */
	public Token getIdenVariable() {
		return idenVariable;
	}

	/**
	 * @param idenVariable
	 *            the idenVariable to set
	 */
	public void setIdenVariable(Token idenVariable) {
		this.idenVariable = idenVariable;
	}

	public void analizarSemantica() {

	}

	public void llenarTablaSimbolos() {

	}

	public String traducir() {
		String arreglo = (this.arreglo != null) ? "[]" : "";
		String variable = "";
		variable = idenVariable.getLexema();

		variable = variable.replaceAll("<", "");
		variable = variable.replaceAll(">", "");
		variable = variable.replaceAll("-", "_");

		String tipo = "";
		switch (this.tipoDato.getLexema()) {
		case "ltr":
			tipo = "char";
		case "ntr":
			tipo = "int";
		case "pntdec":
			tipo = "double";
		case "ltrarr":
			tipo = "String";
		case "binary":
			tipo = "boolean";
		default:
			tipo = "";
		}
		return tipo + arreglo + " " + variable;
	}

}
