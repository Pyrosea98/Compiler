package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

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
			return nodo;
		}

		if (llamadoFuncion != null) {
			nodo.add(new DefaultMutableTreeNode(llamadoFuncion.getArbolVisual()));
			return nodo;
		}

		if (valorAsignacion != null) {
			nodo.add(new DefaultMutableTreeNode(valorAsignacion.getArbolVisual()));
			return nodo;
		}

		if (expresion != null) {
			nodo.add(expresion.getArbolVisual());
			return nodo;
		}

		return nodo;
	}

	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		if (termino != null) {
			for (Simbolo simbolo : ts.getTablaSimbolos()) {
				if (simbolo.getAmbito() != null) {
					if (termino.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()
							&& simbolo.getAmbito().equals(ambito)) {
						return;
					} else {
						if (ambito.getAmbitoPadre() != null) {
							analizarSemantica(errores, ts, ambito.getAmbitoPadre());
						} else {
							errores.add(termino.getLexema() + " No se encontró la variable invocada");
						}
					}
				}else {
					if (termino.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()) {
						return;
					} else {
						if (ambito.getAmbitoPadre() != null) {
							analizarSemantica(errores, ts, ambito.getAmbitoPadre());
						} else {
							errores.add(termino.getLexema() + " No se encontró la variable invocada");
						}
					}
				}
			}
		}

		if (llamadoFuncion != null) {
			for (Simbolo simbolo : ts.getTablaSimbolos()) {
				if (llamadoFuncion.getIdentificadorFuncion().getLexema().equals(simbolo.getNombre())
						&& simbolo.isEsFuncion()) {
					return;
				} else {
					if (ambito.getAmbitoPadre() != null) {
						analizarSemantica(errores, ts, ambito.getAmbitoPadre());
					} else {
						errores.add(llamadoFuncion.getIdentificadorFuncion().getLexema()
								+ " No se encontró la función invocada");
					}
				}
			}
		}

		if (valorAsignacion != null) {
			return;
		}

		if (expresion != null) {
			expresion.analizarSemantica(errores, ts, ambito);
			return;
		}
	}

	public void llenarTablaSimbolos() {

	}

	public String getTipo(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {

		if (termino != null) {
			for (Simbolo simbolo : ts.getTablaSimbolos()) {
				if (termino.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()
						&& simbolo.getAmbito().equals(ambito)) {
					return simbolo.getTipo();
				} else {
					if (ambito.getAmbitoPadre() != null) {
						getTipo(errores, ts, ambito.getAmbitoPadre());
					} else {
						errores.add(termino.getLexema() + " No se encontró la variable invocada");
					}
				}
			}
		}

		else if (llamadoFuncion != null) {
			for (Simbolo simbolo : ts.getTablaSimbolos()) {
				if (llamadoFuncion.getIdentificadorFuncion().getLexema().equals(simbolo.getNombre())
						&& simbolo.isEsFuncion()) {
					return simbolo.getTipo();
				} else {
					if (ambito.getAmbitoPadre() != null) {
						getTipo(errores, ts, ambito.getAmbitoPadre());
					} else {
						errores.add(llamadoFuncion.getIdentificadorFuncion().getLexema()
								+ " No se encontró la función invocada");
					}
				}
			}
		}

		else if (valorAsignacion != null) {
			switch (valorAsignacion.getTipoDato().getCategoria()) {
			case CARACTER:
				return "ltr";
			case ENTERO:
				return "ntr";
			case REAL:
				return "pntdec";
			case CADENA_CARACTERES:
				return "ltrarr";
			default:
				if (valorAsignacion.getTipoDato().getLexema().equals("v")
						|| valorAsignacion.getTipoDato().getLexema().equals("f")) {
					return "binary";
				}
				return null;
			}
		}

		else if (expresion != null) {
			if (expresion.getClass().equals(ExpresionAritmetica.class)) {
				return ((ExpresionAritmetica) expresion).getTipo(errores, ts, ambito);
			} else if (expresion.getClass().equals(ExpresionLogica.class)
					|| expresion.getClass().equals(ExpresionRelacional.class)) {
				return "binary";
			}
		}

		return null;
	}

	public String traducir() {
		String termino = "";

		if (this.termino != null) {
			termino = this.termino.getLexema().replaceAll("<", "").replaceAll(">", "").replaceAll("-", "_");
		} else if (llamadoFuncion != null) {
			termino = llamadoFuncion.traducir("");
		} else if (valorAsignacion != null) {
			termino = valorAsignacion.getTipoDato().getLexema();
		} else if (expresion != null) {
			termino = expresion.traducir();
		}
		return termino;
	}

}
