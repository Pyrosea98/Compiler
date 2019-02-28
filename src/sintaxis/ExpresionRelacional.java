package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa la sentencia
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class ExpresionRelacional extends Expresion {

	private ExpresionAritmetica expAritmetica;
	private Token opRelacional;
	private ExpresionRelacional expRelacional;

	/**
	 * Constructor con expresion aritmetica
	 * 
	 * @param expAritmetica
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica) {
		super();
		this.expAritmetica = expAritmetica;
	}

	/**
	 * Constructor con expresion aritmetica y operador relacional
	 * 
	 * @param expAritmetica
	 * @param opRelacional
	 * @param expRelacional
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica, Token opRelacional,
			ExpresionRelacional expRelacional) {
		super();
		this.expAritmetica = expAritmetica;
		this.opRelacional = opRelacional;
		this.expRelacional = expRelacional;
	}

	/**
	 * Constructor con expresion relacional
	 * 
	 * @param expRelacional
	 */
	public ExpresionRelacional(ExpresionRelacional expRelacional) {
		super();
		this.expRelacional = expRelacional;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Relacional");
		if (expAritmetica != null) {
			nodo.add(expAritmetica.getArbolVisual());
			if (expRelacional != null) {
				nodo.add(new DefaultMutableTreeNode(opRelacional.getLexema()));
				return expRelacional.getArbolVisual(nodo);
			}
		} else {
			if (expRelacional != null) {
				return expRelacional.getArbolVisual(nodo);
			}
		}
		return nodo;
	}

	private DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		if (expAritmetica != null) {
			nodo.add(expAritmetica.getArbolVisual());
			if (expRelacional != null) {
				nodo.add(new DefaultMutableTreeNode(opRelacional.getLexema()));
				return expRelacional.getArbolVisual(nodo);
			}
		} else {
			if (expRelacional != null) {
				return expRelacional.getArbolVisual(nodo);
			}
		}

		return nodo;
	}

	/**
	 * @return the expAritmetica
	 */
	public ExpresionAritmetica getExpAritmetica() {
		return expAritmetica;
	}

	/**
	 * @param expAritmetica
	 *            the expAritmetica to set
	 */
	public void setExpAritmetica(ExpresionAritmetica expAritmetica) {
		this.expAritmetica = expAritmetica;
	}

	/**
	 * @return the opRelacional
	 */
	public Token getOpRelacional() {
		return opRelacional;
	}

	/**
	 * @param opRelacional
	 *            the opRelacional to set
	 */
	public void setOpRelacional(Token opRelacional) {
		this.opRelacional = opRelacional;
	}

	/**
	 * @return the expRelacional
	 */
	public ExpresionRelacional getExpRelacional() {
		return expRelacional;
	}

	/**
	 * @param expRelacional
	 *            the expRelacional to set
	 */
	public void setExpRelacional(ExpresionRelacional expRelacional) {
		this.expRelacional = expRelacional;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (expRelacional != null) {
			expRelacional.analizarSemantica(errores, ts, ambito);
		}
		if (expAritmetica != null) {
			expAritmetica.analizarSemantica(errores, ts, ambito);
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts) {

	}

	@Override
	public String traducir() {
		String operador = "";
		if (opRelacional != null) {
			switch (opRelacional.getLexema()) {
			case "(>)":
				operador = ">";
				break;
			case "(<)":
				operador = "<";
				break;
			case "NOT(es)":
				operador = "!=";
				break;
			case "(es)":
				operador = "==";
				break;
			case "(>es)":
				operador = ">=";
				break;
			case "(<es)":
				operador = "<=";
				break;
			default:
				break;
			}
		}
		return expAritmetica.traducir() + operador + expRelacional != null ? expRelacional.traducir() : "";
	}
}
