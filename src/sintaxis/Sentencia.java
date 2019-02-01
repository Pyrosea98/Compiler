package sintaxis;

/**
 * Clase que representa la sentencia
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Sentencia {

	private Condicional condicional;
	private Ciclo ciclo;
	private Retorno retorno;
	private Impresion impresion;
	private Lectura lectura;
	private DeclaracionVariable declaraVariable;
	private AsignacionVariable asignaVariable;
	private ExpresionIncremento expIncremento;
	private ExpresionDecremento expDecremento;
	private LlamadoFuncion llamadoFuncion;

	/**
	 * Constructor con condicional
	 * 
	 * @param condicional
	 */
	public Sentencia(Condicional condicional) {
		super();
		this.condicional = condicional;
	}

	/**
	 * Constructor con ciclo
	 * 
	 * @param ciclo
	 */
	public Sentencia(Ciclo ciclo) {
		super();
		this.ciclo = ciclo;
	}

	/**
	 * Constructor con retorno
	 * 
	 * @param retorno
	 */
	public Sentencia(Retorno retorno) {
		super();
		this.retorno = retorno;
	}

	/**
	 * Constructor con impresion
	 * 
	 * @param impresion
	 */
	public Sentencia(Impresion impresion) {
		super();
		this.impresion = impresion;
	}

	/**
	 * Constructor con lectura
	 * 
	 * @param lectura
	 */
	public Sentencia(Lectura lectura) {
		super();
		this.lectura = lectura;
	}

	/**
	 * Constructor con declaracion variable
	 * 
	 * @param declaraVariable
	 */
	public Sentencia(DeclaracionVariable declaraVariable) {
		super();
		this.declaraVariable = declaraVariable;
	}

	/**
	 * Constructor con asignacion de variable
	 * 
	 * @param asignaVariable
	 */
	public Sentencia(AsignacionVariable asignaVariable) {
		super();
		this.asignaVariable = asignaVariable;
	}

	/**
	 * Constructor con expresion de incremento
	 * 
	 * @param expIncremento
	 */
	public Sentencia(ExpresionIncremento expIncremento) {
		super();
		this.expIncremento = expIncremento;
	}

	/**
	 * Constructor con expresion de decremento
	 * 
	 * @param expDecremento
	 */
	public Sentencia(ExpresionDecremento expDecremento) {
		super();
		this.expDecremento = expDecremento;
	}

	/**
	 * Constructor con llamado de funcion
	 * 
	 * @param llamadoFuncion
	 */
	public Sentencia(LlamadoFuncion llamadoFuncion) {
		super();
		this.llamadoFuncion = llamadoFuncion;
	}

	/**
	 * @return the condicional
	 */
	public Condicional getCondicional() {
		return condicional;
	}

	/**
	 * @param condicional
	 *            the condicional to set
	 */
	public void setCondicional(Condicional condicional) {
		this.condicional = condicional;
	}

	/**
	 * @return the ciclo
	 */
	public Ciclo getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 *            the ciclo to set
	 */
	public void setCiclo(Ciclo ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the retorno
	 */
	public Retorno getRetorno() {
		return retorno;
	}

	/**
	 * @param retorno
	 *            the retorno to set
	 */
	public void setRetorno(Retorno retorno) {
		this.retorno = retorno;
	}

	/**
	 * @return the impresion
	 */
	public Impresion getImpresion() {
		return impresion;
	}

	/**
	 * @param impresion
	 *            the impresion to set
	 */
	public void setImpresion(Impresion impresion) {
		this.impresion = impresion;
	}

	/**
	 * @return the lectura
	 */
	public Lectura getLectura() {
		return lectura;
	}

	/**
	 * @param lectura
	 *            the lectura to set
	 */
	public void setLectura(Lectura lectura) {
		this.lectura = lectura;
	}

	/**
	 * @return the declaraVariable
	 */
	public DeclaracionVariable getDeclaraVariable() {
		return declaraVariable;
	}

	/**
	 * @param declaraVariable
	 *            the declaraVariable to set
	 */
	public void setDeclaraVariable(DeclaracionVariable declaraVariable) {
		this.declaraVariable = declaraVariable;
	}

	/**
	 * @return the asignaVariable
	 */
	public AsignacionVariable getAsignaVariable() {
		return asignaVariable;
	}

	/**
	 * @param asignaVariable
	 *            the asignaVariable to set
	 */
	public void setAsignaVariable(AsignacionVariable asignaVariable) {
		this.asignaVariable = asignaVariable;
	}

	/**
	 * @return the expIncremento
	 */
	public ExpresionIncremento getExpIncremento() {
		return expIncremento;
	}

	/**
	 * @param expIncremento
	 *            the expIncremento to set
	 */
	public void setExpIncremento(ExpresionIncremento expIncremento) {
		this.expIncremento = expIncremento;
	}

	/**
	 * @return the expDecremento
	 */
	public ExpresionDecremento getExpDecremento() {
		return expDecremento;
	}

	/**
	 * @param expDecremento
	 *            the expDecremento to set
	 */
	public void setExpDecremento(ExpresionDecremento expDecremento) {
		this.expDecremento = expDecremento;
	}

	/**
	 * @return the llamadoFuncion
	 */
	public LlamadoFuncion getLlamadoFuncion() {
		return llamadoFuncion;
	}

	/**
	 * @param llamadoFuncion
	 *            the llamadoFuncion to set
	 */
	public void setLlamadoFuncion(LlamadoFuncion llamadoFuncion) {
		this.llamadoFuncion = llamadoFuncion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (condicional != null) {
			return "Sentencia [condicional=" + condicional + "]";
		} else if (ciclo != null) {
			return "Sentencia [ciclo=" + ciclo + "]";
		} else if (retorno != null) {
			return "Sentencia [ retorno=" + retorno + "]";
		} else if (impresion != null) {
			return "Sentencia [impresion=" + impresion + "]";
		} else if (lectura != null) {
			return "Sentencia [lectura=" + lectura + "]";
		} else if (declaraVariable != null) {
			return "Sentencia [ declaraVariable=" + declaraVariable + "]";
		} else if (asignaVariable != null) {
			return "Sentencia [ asignaVariable=" + asignaVariable + "]";
		} else if (expIncremento != null) {
			return "Sentencia [expIncremento=" + expIncremento + "]";
		} else if (expDecremento != null) {
			return "Sentencia [ expDecremento=" + expDecremento + "]";
		} else if (llamadoFuncion != null) {
			return "Sentencia [llamadoFuncion=" + llamadoFuncion + "]";
		} else {
			return null;
		}
	}

}
