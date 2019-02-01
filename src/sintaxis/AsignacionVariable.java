package sintaxis;

import lexico.Token;

public class AsignacionVariable {

	private Token tipo, identificadorVariable, asignador, identificador, finSentencia;
	private ExpresionAritmetica ex;

	/**
	 * @param tipo
	 * @param identificadorVariable
	 * @param asignador
	 * @param identificador
	 * @param finSentencia
	 */
	public AsignacionVariable(Token tipo, Token identificadorVariable, Token asignador, Token identificador, Token finSentencia) {
		super();
		this.tipo = tipo;
		this.identificadorVariable = identificadorVariable;
		this.asignador = asignador;
		this.identificador = identificador;
		this.finSentencia = finSentencia;
	}

	/**
	 * @param tipo
	 * @param identificadorVariable
	 * @param asignador
	 * @param ex
	 * @param finSentencia
	 */
	public AsignacionVariable(Token tipo, Token identificadorVariable, Token asignador, ExpresionAritmetica ex, Token finSentencia) {
		super();
		this.tipo = tipo;
		this.identificadorVariable = identificadorVariable;
		this.asignador = asignador;
		this.ex = ex;
		this.finSentencia = finSentencia;
	}
	
	

	/**
	 * @param identificadorVariable
	 * @param asignador
	 * @param identificador
	 * @param finSentencia
	 */
	public AsignacionVariable(Token identificadorVariable, Token asignador, Token identificador, Token finSentencia) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.asignador = asignador;
		this.identificador = identificador;
		this.finSentencia = finSentencia;
	}
	
	

	/**
	 * @param identificadorVariable
	 * @param asignador
	 * @param finSentencia
	 * @param ex
	 */
	public AsignacionVariable(Token identificadorVariable, Token asignador, Token finSentencia, ExpresionAritmetica ex) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.asignador = asignador;
		this.finSentencia = finSentencia;
		this.ex = ex;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Asignacion [tipo=" + tipo + ", identificadorVariable=" + identificadorVariable + ", asignador="
				+ asignador + ", identificador=" + identificador + ", finSentencia=" + finSentencia + ", ex=" + ex
				+ "]";
	}

	/**
	 * @return the tipo
	 */
	public Token getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(Token tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the identificadorVariable
	 */
	public Token getIdentificadorVariable() {
		return identificadorVariable;
	}

	/**
	 * @param identificadorVariable the identificadorVariable to set
	 */
	public void setIdentificadorVariable(Token identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
	}

	/**
	 * @return the asignador
	 */
	public Token getAsignador() {
		return asignador;
	}

	/**
	 * @param asignador the asignador to set
	 */
	public void setAsignador(Token asignador) {
		this.asignador = asignador;
	}

	/**
	 * @return the identificador
	 */
	public Token getIdentificador() {
		return identificador;
	}

	/**
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(Token identificador) {
		this.identificador = identificador;
	}

	/**
	 * @return the finSentencia
	 */
	public Token getFinSentencia() {
		return finSentencia;
	}

	/**
	 * @param finSentencia the finSentencia to set
	 */
	public void setFinSentencia(Token finSentencia) {
		this.finSentencia = finSentencia;
	}

	/**
	 * @return the ex
	 */
	public ExpresionAritmetica getEx() {
		return ex;
	}

	/**
	 * @param ex the ex to set
	 */
	public void setEx(ExpresionAritmetica ex) {
		this.ex = ex;
	}
	
	
	
	
	
	
	
	

}
