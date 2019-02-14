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
 
    //variables
	private Token sinRetorno;
	private TipoDato tipoDato;

	/**
	 * constructor sinRetorno
	 * @param sinRetorno
	 */
	public TipoRetorno(Token sinRetorno) {
		super();
		this.sinRetorno = sinRetorno;
	}

	/**
	 * Constructor con Retorno
	 * @param tipoDato
	 */
	public TipoRetorno(TipoDato tipoDato) {
		super();
		this.tipoDato = tipoDato;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (sinRetorno != null) {
			return "TipoRetorno [sinRetorno=" + sinRetorno + "]";
		} else {
			return "TipoRetorno[tipoDato=" + tipoDato + "]";
		}

	}

	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}

}
