package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa la expresion logica
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class ExpresionLogica extends Expresion {

	private ExpresionRelacional expresionRelacional;
	private Token opLogico;
	private ExpresionLogica expresionLogica;

	/**
	 * Constructor que crea expresion logica con solo una expresion logica
	 * 
	 * @param expresionLogica
	 */
	public ExpresionLogica(ExpresionLogica expresionLogica) {
		super();
		this.expresionLogica = expresionLogica;
	}

	/**
	 * Constructor que crea expresion logica con solo una expresion relacional
	 * 
	 * @param expresionRelacional
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional) {
		super();
		this.expresionRelacional = expresionRelacional;
	}

	/**
	 * Constructor que crea expresion logica con caso contrario
	 * 
	 * @param expresionRelacional
	 * @param operadorLogico
	 * @param expresionLogica
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, Token opLogico, ExpresionLogica expresionLogica) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.opLogico = opLogico;
		this.expresionLogica = expresionLogica;
	}

	/**
	 * Metodo del arbol grafico
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Logica");
		if (expresionRelacional != null) {
			nodo.add(expresionRelacional.getArbolVisual());
		}
		if (expresionLogica != null) {
			if (opLogico != null) {
				nodo.add(new DefaultMutableTreeNode(opLogico.getLexema()));
			}
			return expresionLogica.getArbolVisual(nodo);
		}

		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		if (expresionRelacional != null) {
			nodo.add(expresionRelacional.getArbolVisual());
		}
		if (expresionLogica != null) {
			if (opLogico != null) {
				nodo.add(new DefaultMutableTreeNode(opLogico.getLexema()));
			}
			return expresionLogica.getArbolVisual(nodo);
		}

		return nodo;
	}

	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (expresionRelacional != null) {
			expresionRelacional.analizarSemantica(errores, ts, ambito);
		}
		if (expresionLogica != null) {
			expresionLogica.analizarSemantica(errores, ts, ambito);
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir() {
		String operador = "";
		if (opLogico != null) {
			switch (opLogico.getLexema()) {
			case "AND":
				operador = "&&";
				break;
			case "OR":
				operador = "||";
				break;
			case "NOT":
				operador = "!";
				break;
			default:
				break;
			}
		}
		if(expresionLogica!=null) {
			return expresionRelacional.traducir() + operador + expresionLogica.traducir();
		}else {
			return expresionRelacional.traducir();
		}
	}

	/**
	 * @return the expresionRelacional
	 */
	public ExpresionRelacional getExpresionRelacional() {
		return expresionRelacional;
	}

	/**
	 * @param expresionRelacional the expresionRelacional to set
	 */
	public void setExpresionRelacional(ExpresionRelacional expresionRelacional) {
		this.expresionRelacional = expresionRelacional;
	}

	/**
	 * @return the opLogico
	 */
	public Token getOpLogico() {
		return opLogico;
	}

	/**
	 * @param opLogico the opLogico to set
	 */
	public void setOpLogico(Token opLogico) {
		this.opLogico = opLogico;
	}

	/**
	 * @return the expresionLogica
	 */
	public ExpresionLogica getExpresionLogica() {
		return expresionLogica;
	}

	/**
	 * @param expresionLogica the expresionLogica to set
	 */
	public void setExpresionLogica(ExpresionLogica expresionLogica) {
		this.expresionLogica = expresionLogica;
	}
	
	
}