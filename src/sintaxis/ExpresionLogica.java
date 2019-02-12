package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;
//<<<<<<< HEAD
import javax.swing.tree.MutableTreeNode;
//=======
//>>>>>>> 4c99e2be335f55547cc5cc8451f756a791ecfa5d

import lexico.Token;

public class ExpresionLogica extends Expresion{
	
	/**
	 * Clase que representa la expresion logica
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */
	
	private ExpresionRelacional expresionRelacional;
	private Token operadorLogico;
	private ExpresionLogica expresionLogica;
	private Token parentesisIzquierdo;
	private ExpresionLogica expresionLogica0;
	private Token parentesisDerecho;
	
	/**
	 * Constructor que crea expresion logica con solo una expresion relacional
	 * @param expresionRelacional
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional) {
		super();
		this.expresionRelacional = expresionRelacional;
	}

	/**
	 * Constructor que crea expresion logica con caso contrario
	 * @param expresionRelacional
	 * @param operadorLogico
	 * @param expresionLogica
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, Token operadorLogico,
			ExpresionLogica expresionLogica) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.operadorLogico = operadorLogico;
		this.expresionLogica = expresionLogica;
	}

	/**
	 * Constructor que crea expresion logica entre parentesis
	 * @param expresionRelacional
	 * @param parentesisIzquierdo
	 * @param expresionLogica0
	 * @param parentesisDerecho
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, Token parentesisIzquierdo,
			ExpresionLogica expresionLogica0, Token parentesisDerecho) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.expresionLogica0 = expresionLogica0;
		this.parentesisDerecho = parentesisDerecho;
	}

	@Override
	public String toString() {
		
		if(parentesisIzquierdo!=null) {
			if(operadorLogico!=null) {
				return "ExpresionLogica [expresionRelacional=" + expresionRelacional + ", operadorLogico=" + operadorLogico
						+ ", expresionLogica=" + expresionLogica + ", parentesisIzquierdo=" + parentesisIzquierdo
						+ ", expresionLogica0=" + expresionLogica0 + ", parentesisDerecho=" + parentesisDerecho + "]";
			}else {
				return "ExpresionLogica [expresionRelacional=" + expresionRelacional  + ", parentesisIzquierdo=" + parentesisIzquierdo
						+ ", expresionLogica0=" + expresionLogica0 + ", parentesisDerecho=" + parentesisDerecho + "]";
			}
		}else if(operadorLogico!=null) {
			return "ExpresionLogica [expresionRelacional=" + expresionRelacional + ", operadorLogico=" + operadorLogico
					+ ", expresionLogica=" + expresionLogica;
		}
		return null;
	}

	public DefaultMutableTreeNode getArbolVisual() {
		// TODO Auto-generated method stub
		return null;
	}
}