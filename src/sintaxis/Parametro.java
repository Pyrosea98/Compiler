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

	private TipoDato tipoDato;
	private Token arreglo;
	private Token idenVariable;

	/**
	 * Constructor que tiene ell tipo de dato y el identificador de variable
	 * 
	 * @param tipoDato
	 * @param idenVariable
	 */
	public Parametro(TipoDato tipoDato, Token idenVariable) {
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
	public Parametro(TipoDato tipoDato, Token arreglo, Token idenVariable) {
		super();
		this.tipoDato = tipoDato;
		this.arreglo = arreglo;
		this.idenVariable = idenVariable;
	}

	/**
	 * @return the tipoDato
	 */
	public TipoDato getTipoDato() {
		return tipoDato;
	}

	/**
	 * @param tipoDato
	 *            the tipoDato to set
	 */
	public void setTipoDato(TipoDato tipoDato) {
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (arreglo != null) {
			return "Parametro [tipoDato=" + tipoDato + ", arreglo=" + arreglo + ", idenVariable=" + idenVariable + "]";
		} else {
			return "Parametro [tipoDato=" + tipoDato + ", idenVariable=" + idenVariable + "]";
		}

	}

	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}

}
