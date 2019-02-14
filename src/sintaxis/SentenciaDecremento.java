package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class SentenciaDecremento extends Sentencia {

	private Token identificadorVariable, decremento;

	/**
	 * Constructor de la sentencia decremento
	 * 
	 * @param identificadorVariable
	 * @param decremento
	 */
	public SentenciaDecremento(Token identificadorVariable, Token decremento) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.decremento = decremento;
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
	 * @return the decremento
	 */
	public Token getDecremento() {
		return decremento;
	}

	/**
	 * @param decremento
	 *            the decremento to set
	 */
	public void setDecremento(Token decremento) {
		this.decremento = decremento;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
	
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Decremento");
		
		nodo.add(new DefaultMutableTreeNode (identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode (decremento.getLexema()));
		
		return nodo;
	}

}
