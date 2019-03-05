package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa la expresion Cadena
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class ExpresionCadena extends Expresion {

	private Termino termino;
	private ExpresionCadena expCadena;

	/**
	 * Constructor para una expresion de cadena con solo un termino
	 * 
	 * @param termino
	 */
	public ExpresionCadena(Termino termino) {
		super();
		this.termino = termino;
	}

	/**
	 * Constructor para una expresion de cadena con uno o mas terminos
	 * 
	 * @param termino
	 * @param expCadena
	 */
	public ExpresionCadena(Termino termino, ExpresionCadena expCadena) {
		super();
		this.termino = termino;
		this.expCadena = expCadena;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Cadena");

		nodo.add(termino.getArbolVisual());
		if (expCadena != null) {
			expCadena.getArbolVisual(nodo);
		}
		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		nodo.add(termino.getArbolVisual());
		if (expCadena != null) {
			expCadena.getArbolVisual(nodo);
		}
		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (!termino.getTipo(errores, ts, ambito).equals("ltrarr")) {
			return;
		} else if (expCadena != null) {
			if (expCadena.getTipo(errores, ts, ambito).equals("ltrarr")) {

			} else {
				errores.add("Falta alguna cadena para concatenar");
				return;
			}
		} else {
			errores.add("Falta alguna cadena para concatenar");
			return;
		}

	}

	public String getTipo(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (!termino.getTipo(errores, ts, ambito).equals("ltrarr")) {
			return "ltrarr";
		} else if (expCadena != null) {
			if (expCadena.getTipo(errores, ts, ambito).equals("ltrarr")) {
				return "ltrarr";
			} else {
				errores.add("Falta alguna cadena para concatenar");
				return "sr";
			}
		} else {
			return "sr";
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir() {
		if(expCadena != null) {
			return termino.traducir() +  " + " + expCadena.traducir();
		}else {
			return termino.traducir();
		}
	}

}
