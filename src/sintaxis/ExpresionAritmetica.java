package sintaxis;

import lexico.Token;

public class ExpresionAritmetica {
	
	private Termino termino;
	private Token operadorAritmetico;
	private ExpresionAritmetica ex1, ex2;
	
	public ExpresionAritmetica(Termino termino) {
		this.termino = termino;
	}
	
	public ExpresionAritmetica(Termino termino, Token operadorAritmetico, ExpresionAritmetica ex1) {
		this.termino = termino;
		this.operadorAritmetico = operadorAritmetico;
		this.ex1 = ex1;
	}
	
	
	public ExpresionAritmetica(ExpresionAritmetica ex1) {
		this.ex1 = ex1;
	}
	
	public ExpresionAritmetica(ExpresionAritmetica ex2, Token operadorAritmetico, ExpresionAritmetica ex1) {
		this.ex1 = ex1;
		this.operadorAritmetico = operadorAritmetico;
		this.ex2 = ex2;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ExpresionAritmetica [termino=" + termino + ", operadorAritmetico=" + operadorAritmetico + ", ex1=" + ex1
				+ ", ex2=" + ex2 + "]";
	}

	/**
	 * @return the termino
	 */
	public Termino getTermino() {
		return termino;
	}

	/**
	 * @param termino the termino to set
	 */
	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	/**
	 * @return the operadorAritmetico
	 */
	public Token getOperadorAritmetico() {
		return operadorAritmetico;
	}

	/**
	 * @param operadorAritmetico the operadorAritmetico to set
	 */
	public void setOperadorAritmetico(Token operadorAritmetico) {
		this.operadorAritmetico = operadorAritmetico;
	}

	/**
	 * @return the ex1
	 */
	public ExpresionAritmetica getEx1() {
		return ex1;
	}

	/**
	 * @param ex1 the ex1 to set
	 */
	public void setEx1(ExpresionAritmetica ex1) {
		this.ex1 = ex1;
	}

	/**
	 * @return the ex2
	 */
	public ExpresionAritmetica getEx2() {
		return ex2;
	}

	/**
	 * @param ex2 the ex2 to set
	 */
	public void setEx2(ExpresionAritmetica ex2) {
		this.ex2 = ex2;
	}
	
	
}
