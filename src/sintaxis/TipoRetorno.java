package sintaxis;

import lexico.Token;

public class TipoRetorno {

	private Token sinRetorno;
	private TipoDato tipoDato;

	/**
	 * @param sinRetorno
	 */
	public TipoRetorno(Token sinRetorno) {
		super();
		this.sinRetorno = sinRetorno;
	}

	/**
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

}
