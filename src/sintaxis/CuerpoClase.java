package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa el cuerpo de la clase, (Funciones y variables)
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class CuerpoClase {

	// Variables
	private Funcion funcion;
	private DeclaracionVariable declaracionVariable;
	private CuerpoClase cuerpoClase;

	/**
	 * Constructor con una funcion y posibilidad de agregar mas cuerpos de clase
	 * 
	 * @param funcion
	 * @param cuerpoClase
	 */
	public CuerpoClase(Funcion funcion, CuerpoClase cuerpoClase) {
		super();
		this.funcion = funcion;
		this.cuerpoClase = cuerpoClase;
	}

	/**
	 * Constructor con una funcion y posibilidad de agregar mas cuerpos de clase
	 * 
	 * @param declaracionVariable
	 * @param cuerpoClase
	 */
	public CuerpoClase(DeclaracionVariable declaracionVariable, CuerpoClase cuerpoClase) {
		super();
		this.declaracionVariable = declaracionVariable;
		this.cuerpoClase = cuerpoClase;
	}

	/**
	 * Constructor con solo una funcion
	 * 
	 * @param funcion
	 */
	public CuerpoClase(Funcion funcion) {
		super();
		this.funcion = funcion;
	}

	/**
	 * Constructor con solo una declaracion de variable
	 * 
	 * @param declaracionVariable
	 */
	public CuerpoClase(DeclaracionVariable declaracionVariable) {
		super();
		this.declaracionVariable = declaracionVariable;
	}

	/**
	 * @return the funcion
	 */
	public Funcion getFuncion() {
		return funcion;
	}

	/**
	 * @param funcion
	 *            the funcion to set
	 */
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}

	/**
	 * @return the declaracionVariable
	 */
	public DeclaracionVariable getDeclaracionVariable() {
		return declaracionVariable;
	}

	/**
	 * @param declaracionVariable
	 *            the declaracionVariable to set
	 */
	public void setDeclaracionVariable(DeclaracionVariable declaracionVariable) {
		this.declaracionVariable = declaracionVariable;
	}

	/**
	 * @return the cuerpoClase
	 */
	public CuerpoClase getCuerpoClase() {
		return cuerpoClase;
	}

	/**
	 * @param cuerpoClase
	 *            the cuerpoClase to set
	 */
	public void setCuerpoClase(CuerpoClase cuerpoClase) {
		this.cuerpoClase = cuerpoClase;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (funcion != null) {
			if (cuerpoClase != null)
				return "CuerpoClase [funcion=" + funcion + "cuerpoClase=" + cuerpoClase + "]";
			else {
				return "CuerpoClase [funcion=" + funcion + "]";
			}
		} else if (declaracionVariable != null) {
			if (cuerpoClase != null)
				return "CuerpoClase [declaracionVariable=" + declaracionVariable + "cuerpoClase=" + cuerpoClase + "]";
			else {
				return "CuerpoClase [declaracionVariable=" + declaracionVariable + "]";
			}
		} else {
			return "";
		}
	}

	/**
	 * Método para un nodo proviniente de otro cuerpo de clase
	 * 
	 * @param node
	 * @return
	 */
	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		if (funcion != null) {
			nodo.add(funcion.getArbolVisual());
			if (cuerpoClase != null) {
				nodo.add(cuerpoClase.getArbolVisual(nodo));
			}
		} else if (declaracionVariable != null) {
			nodo.add(declaracionVariable.getArbolVisual());
			if (cuerpoClase != null) {
				nodo.add(cuerpoClase.getArbolVisual(nodo));
			}
		}

		return nodo;
	}

	/**
	 * Método para retornar de otro cuerpo de clase
	 * 
	 * @param node
	 * @return
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Cuerpo clase");

		if (funcion != null) {
			nodo.add(funcion.getArbolVisual());
			if (cuerpoClase != null) {
				return cuerpoClase.getArbolVisual(nodo);
			}
		} else if (declaracionVariable != null) {
			nodo.add(declaracionVariable.getArbolVisual());
			if (cuerpoClase != null) {
				return cuerpoClase.getArbolVisual(nodo);
			}
		}

		return nodo;
	}

}
