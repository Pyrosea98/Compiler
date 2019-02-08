package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import lexico.Token;

/**
 * Clase que representa una función
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Funcion {

	private Visibilidad visibilidad;
	private TipoRetorno tipoRetorno;
	private Token identificadorFuncion;
	private Token parentesisIzquierdo;
	private Token parentesisDerecho;
	private Token agrupadorIzquierdo;
	private Token agrupadorDerecho;
	private Token palabraReservadaFuncion;
	private ArrayList<Parametro> listaParametros;
	private ArrayList<Sentencia> listaSentencias;

	/**
	 * Funcion con visibilidad, lista de parametros y sentencias
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(Visibilidad visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token parentesisIzquierdo, Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho,
			Token palabraReservadaFuncion, ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin Visibilidad con Lista De Parametros y Sentencias
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token parentesisIzquierdo,
			Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho, Token palabraReservadaFuncion,
			ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin visibilidad y con lista de Sentencias
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token parentesisIzquierdo,
			Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho, Token palabraReservadaFuncion,
			ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion con visibilidad y con lista de Sentencias
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(Visibilidad visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token parentesisIzquierdo, Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho,
			Token palabraReservadaFuncion, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}
	
	/**
	 * Funcion con solo Visibilidad
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 */
	public Funcion(Visibilidad visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token parentesisIzquierdo, Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho,
			Token palabraReservadaFuncion) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
	}

	/**
	 * Funcion sin Visibilidad, sin lista Parametros y sin lista Sentencias 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param parentesisDerecho
	 * @param agrupadorIzquierdo
	 * @param agrupadorDerecho
	 * @param palabraReservadaFuncion
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token parentesisIzquierdo,
			Token parentesisDerecho, Token agrupadorIzquierdo, Token agrupadorDerecho, Token palabraReservadaFuncion) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.parentesisDerecho = parentesisDerecho;
		this.agrupadorIzquierdo = agrupadorIzquierdo;
		this.agrupadorDerecho = agrupadorDerecho;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (visibilidad != null) {
			if (listaParametros != null) {
				if(listaSentencias!=null) {
				return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
						+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
						+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
						+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
						+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + ", listaSentencias="
						+ listaSentencias + "]";		
				} else {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
							+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
							+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + "]";
				}
			} else {
				if(listaSentencias!=null) {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
							+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
							+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaSentencias=" + listaSentencias + "]";
				}else {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
							+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
							+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + "]";
				}
			}
		} else {
			if(listaParametros!=null) {
				if(listaSentencias!=null) {
					return "Funcion [" + " tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
							+ parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho + ", agrupadorIzquierdo="
							+ agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + ", listaSentencias="
							+ listaSentencias + "]";	
				}else {
					return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
							+ ", parentesisIzquierdo=" + parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho
							+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho
							+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaParametros="
							+ listaParametros + "]";
				}
			}else {
				if (listaSentencias!=null) {
					return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
							+ ", parentesisIzquierdo=" + parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho
							+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho
							+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaSentencias="
							+ listaSentencias + "]";	
				}
			}	
		}
		return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
				+ ", parentesisIzquierdo=" + parentesisIzquierdo + ", parentesisDerecho=" + parentesisDerecho
				+ ", agrupadorIzquierdo=" + agrupadorIzquierdo + ", agrupadorDerecho=" + agrupadorDerecho
				+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + "]";	
	}

	/**
	 * Metodo que permite crear el arbol grafico de una funcion
	 * @return 
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Funcion");

		if(visibilidad!=null) {
			if (listaParametros!=null) {
				if (listaSentencias!=null) {
					
				}else {
					
				}
			}else {
				if (listaSentencias!=null) {
					
				}else {
					
				}
			}
		}else {
			if (listaParametros!=null) {
				if (listaSentencias!=null) {
					
				}else {
					
				}
			}else {
				if (listaSentencias!=null) {
				
			}
		}
	}
			
		
		
//		if (visibilidad != null) {
//			nodo.add(visibilidad.getArbolVisual());
//			nodo.add(tipoRetorno.getArbolVisual());
//			nodo.add(new DefaultMutableTreeNode(palabraReservadaFuncion.getLexema()));
//			nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
//			nodo.add(new DefaultMutableTreeNode(parentesisIzquierdo.getLexema()));
//			if (listaParametros != null) {
//				for (Parametro parametro : listaParametros) {
//					nodo.add(parametro.getArbolVisual());
//				}
//				nodo.add(new DefaultMutableTreeNode(parentesisDerecho.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(agrupadorIzquierdo.getLexema()));
//				for (Sentencia sentencia : listaSentencias) {
//					nodo.add(sentencia.getArbolVisual());
//				}
//				nodo.add(new DefaultMutableTreeNode(agrupadorDerecho.getLexema()));
//			} else if (listaSentencias != null) {
//				nodo.add(new DefaultMutableTreeNode(parentesisDerecho.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(agrupadorIzquierdo.getLexema()));
//				for (Sentencia sentencia : listaSentencias) {
//					nodo.add(sentencia.getArbolVisual());
//				}
//				nodo.add(new DefaultMutableTreeNode(agrupadorDerecho.getLexema()));
//			}
//		} else {
//			if (listaSentencias != null) {
//				nodo.add(tipoRetorno.getArbolVisual());
//				nodo.add(new DefaultMutableTreeNode(palabraReservadaFuncion.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(parentesisIzquierdo.getLexema()));
//			} else if (listaParametros != null) {
//				nodo.add(tipoRetorno.getArbolVisual());
//				nodo.add(new DefaultMutableTreeNode(palabraReservadaFuncion.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
//				nodo.add(new DefaultMutableTreeNode(parentesisIzquierdo.getLexema()));
//				
//			} else {
//
//			}
//			return null;
//		}
		return null;
	}
}