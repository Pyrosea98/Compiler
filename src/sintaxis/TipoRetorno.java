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

	private Token sinRetorno;
	private Token tipoDato;

	/**
	 * Constructor sin retorno o con tipo de dato
	 * 
	 * @param tipoDato
	 * 
	 */
	public TipoRetorno(Token tipoDato) {
		super();
		this.tipoDato = tipoDato;
	}

	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Tipo Retorno");

		if (sinRetorno != null) {
			nodo.add(new DefaultMutableTreeNode(sinRetorno.getLexema()));
		} else {
			nodo.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		}
		return nodo;
	}
}
