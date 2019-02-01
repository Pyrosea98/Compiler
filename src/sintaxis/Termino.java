package sintaxis;

import lexico.Token;

public class Termino {
	private Token termino;

	public Termino(Token termino) {
		this.setTermino(termino);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Termino [termino=" + termino + "]";
	}

	public Token getTermino() {
		return termino;
	}

	public void setTermino(Token termino) {
		this.termino = termino;
	}
}
