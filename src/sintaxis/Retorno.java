package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa una sentencia de retorno
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Retorno extends Sentencia {

	private Token retorno;
	private Termino termino;

	/**
	 * Constructor de clase
	 * 
	 * @param retorno
	 * @param termino
	 */
	public Retorno(Token retorno, Termino termino) {
		super();
		this.retorno = retorno;
		this.termino = termino;
	}

	/**
	 * @return the retorno
	 */
	public Token getRetorno() {
		return retorno;
	}

	/**
	 * @param retorno
	 *            the retorno to set
	 */
	public void setRetorno(Token retorno) {
		this.retorno = retorno;
	}

	/**
	 * @return the termino
	 */
	public Termino getTermino() {
		return termino;
	}

	/**
	 * @param termino
	 *            the termino to set
	 */
	public void setTermino(Termino termino) {
		this.termino = termino;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Retorno");
		nodo.add(new DefaultMutableTreeNode(retorno.getLexema()));
		nodo.add(termino.getArbolVisual());

		return nodo;
	}

	public void analizarSemantica() {

	}

	public void llenarTablaSimbolos() {

	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (!ambito.getTipo().equals(termino.getTipo(errores, ts, ambito))) {
			errores.add("El tipo de retorno " + ambito.getTipo() + " de la función " + ambito.getNombre()
					+ " no coincide con el retorno " + termino.getTipo(errores, ts, ambito));
		}
		Simbolo pivote = ambito;
		while (pivote != null) {
			pivote.setRetorno(true);
			if (pivote.getNombre().contains("condicional") && pivote.getRetorno() == false) {
				break;
			} else {
				pivote = pivote.getAmbitoPadre();
			}
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion, boolean global) {
		return identacion + "return " + termino.traducir();
	}

}
