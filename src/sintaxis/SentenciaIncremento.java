package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

public class SentenciaIncremento extends Sentencia {

	private Token identificadorVariable, incremento;

	/**
	 * Constructor de la sentencia incremento
	 * 
	 * @param identificadorVariable
	 * @param incremento
	 */
	public SentenciaIncremento(Token identificadorVariable, Token incremento) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.incremento = incremento;
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
	 * @return the incremento
	 */
	public Token getIncremento() {
		return incremento;
	}

	/**
	 * @param incremento
	 *            the incremento to set
	 */
	public void setIncremento(Token incremento) {
		this.incremento = incremento;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
	DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Incremento");
		
		nodo.add(new DefaultMutableTreeNode (identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode (incremento.getLexema()));
		
		return nodo;
	}

}
