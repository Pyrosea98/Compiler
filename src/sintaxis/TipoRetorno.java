package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;

/**
 * Clase que representa el tipo de retorno
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class TipoRetorno {

	private Token tipoRetorno;

	/**
	 * Constructor sin retorno o con tipo de dato
	 * 
	 * @param tipoDato
	 * 
	 */
	public TipoRetorno(Token tipoDato) {
		super();
		this.tipoRetorno = tipoDato;
	}

	public DefaultMutableTreeNode getArbolVisual() {

		return new DefaultMutableTreeNode(tipoRetorno.getLexema());
	}

	public void analizarSemantica() {

	}

	public void llenarTablaSimbolos() {

	}

	/**
	 * @return the tipoRetorno
	 */
	public Token getTipoRetorno() {
		return tipoRetorno;
	}

	/**
	 * @param tipoRetorno the tipoRetorno to set
	 */
	public void setTipoRetorno(Token tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}
	
	

}
