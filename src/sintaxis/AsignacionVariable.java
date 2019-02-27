package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa las asignaciones de variable.
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class AsignacionVariable extends Sentencia {

	private Token identificadorVariable, operadorAsignacion;
	private Termino termino;

	/**
	 * Constructor de la asignación de variable
	 * 
	 * @param identificadorVariable
	 * @param operadorAsignacion
	 * @param termino
	 */
	public AsignacionVariable(Token identificadorVariable, Token operadorAsignacion, Termino termino) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.operadorAsignacion = operadorAsignacion;
		this.termino = termino;
	}

	/**
	 * @return the identificadorVariable
	 */
	public Token getIdentificadorVariable() {
		return identificadorVariable;
	}

	/**
	 * @param identificadorVariable
	 *            the identificadorVariable to set
	 */
	public void setIdentificadorVariable(Token identificadorVariable) {
		this.identificadorVariable = identificadorVariable;
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

	public Token getOperadorAsignacion() {
		return operadorAsignacion;
	}

	public void setOperadorAsignacion(Token operadorAsignacion) {
		this.operadorAsignacion = operadorAsignacion;
	}

	/**
	 * Método para obtener el árbol de visual de la asignación de variable.
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Declaracion variable");

		nodo.add(new DefaultMutableTreeNode(identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(operadorAsignacion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(termino.getArbolVisual()));

		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		Boolean idEncontrado = false;
		for (Simbolo simbolo : ts.getTablaSimbolos()) {
			if (simbolo.getAmbito() != null) {
				if (identificadorVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()
						&& simbolo.getAmbito().equals(ambito)) {
					if (simbolo.getTipo().equals(termino.getTipo(errores, ts, ambito))) {
						idEncontrado = true;
						break;
					} else {
						errores.add(identificadorVariable.getLexema()
								+ " Los tipos de dato no coinciden o exceden memopria");
						idEncontrado = true;
						break;
					}
				}
			} else {
				if (identificadorVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()) {
					if (simbolo.getTipo().equals(termino.getTipo(errores, ts, ambito))) {
						idEncontrado = true;
						break;
					} else {
						errores.add(identificadorVariable.getLexema()
								+ " Los tipos de dato no coinciden o exceden memopria");
						idEncontrado = true;
						break;
					}
				}
			}
		}
		if (!idEncontrado) {
			if (ambito.getAmbitoPadre() != null) {
				analizarSemantica(errores, ts, ambito.getAmbitoPadre());
			} else {
				errores.add(identificadorVariable.getLexema() + " Los tipos de dato no coinciden o exceden memopria");
			}
		}

		termino.analizarSemantica(errores, ts, ambito);

	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub
	}

}
