package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;
import lexico.Token;

/**
 * Clase que representa un termino
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class Termino {
	private LlamadoFuncion llamadoFuncion;
	private ValorAsignacion valorAsignacion;
	private Expresion expresion;
	private Token termino;

	/**
	 * Método constructor
	 * 
	 * @param termino
	 */
	public Termino(Token termino) {
		this.setTermino(termino);
	}

	public Termino(LlamadoFuncion llamadoFuncion) {
		this.llamadoFuncion = llamadoFuncion;
	}

	public Termino(ValorAsignacion valorAsignacion) {
		this.valorAsignacion = valorAsignacion;
	}

	public Termino(Expresion expresion) {
		this.expresion = expresion;
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/**
	 * Arbol de Termino
	 * 
	 * @return nodo
	 */
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Termino");

		if (termino != null) {
			nodo.add(new DefaultMutableTreeNode(termino.getLexema()));
		}

		if (llamadoFuncion != null) {
			nodo.add(new DefaultMutableTreeNode(llamadoFuncion.getArbolVisual()));
		}

		if (valorAsignacion != null) {
			nodo.add(new DefaultMutableTreeNode(valorAsignacion.getArbolVisual()));
		}

		if (expresion != null) {
			nodo.add(new DefaultMutableTreeNode(llamadoFuncion.getArbolVisual()));
		}

		return nodo;
	}
}
