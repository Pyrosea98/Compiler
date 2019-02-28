package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa una función
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Funcion {

	private Token visibilidad;
	private TipoRetorno tipoRetorno;
	private Token identificadorFuncion;
	private Token palabraReservadaFuncion;
	private ArrayList<Parametro> listaParametros;
	private ArrayList<Sentencia> listaSentencias;
	private Simbolo ambito;

	/**
	 * Funcion con visibilidad, lista de parametros y sentencias
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(Token visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token palabraReservadaFuncion, ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin Visibilidad con Lista De Parametros y Sentencias
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token palabraReservadaFuncion,
			ArrayList<Parametro> listaParametros, ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion Sin visibilidad y con lista de Sentencias
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token palabraReservadaFuncion,
			ArrayList<Sentencia> listaSentencias) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 * @param listaParametros
	 */
	public Funcion(Token visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			ArrayList<Parametro> listaParametros, Token palabraReservadaFuncion) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
	}

	/**
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param listaParametros
	 * @param palabraReservadaFuncion
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, ArrayList<Parametro> listaParametros,
			Token palabraReservadaFuncion) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaParametros = listaParametros;
	}

	/**
	 * Funcion con visibilidad y con lista de Sentencias
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 * @param listaSentencias
	 */
	public Funcion(Token visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token palabraReservadaFuncion, ArrayList<Sentencia> listaSentencias) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
		this.listaSentencias = listaSentencias;
	}

	/**
	 * Funcion con solo Visibilidad
	 * 
	 * @param visibilidad
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 */
	public Funcion(Token visibilidad, TipoRetorno tipoRetorno, Token identificadorFuncion,
			Token palabraReservadaFuncion) {
		super();
		this.visibilidad = visibilidad;
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
		this.palabraReservadaFuncion = palabraReservadaFuncion;
	}

	/**
	 * Funcion sin Visibilidad, sin lista Parametros y sin lista Sentencias
	 * 
	 * @param tipoRetorno
	 * @param identificadorFuncion
	 * @param palabraReservadaFuncion
	 */
	public Funcion(TipoRetorno tipoRetorno, Token identificadorFuncion, Token palabraReservadaFuncion) {
		super();
		this.tipoRetorno = tipoRetorno;
		this.identificadorFuncion = identificadorFuncion;
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
				if (listaSentencias != null) {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + ", listaSentencias="
							+ listaSentencias + "]";
				} else {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaParametros=" + listaParametros + "]";
				}
			} else {
				if (listaSentencias != null) {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + ", listaSentencias=" + listaSentencias + "]";
				} else {
					return "Funcion [visibilidad=" + visibilidad + ", tipoRetorno=" + tipoRetorno
							+ ", identificadorFuncion=" + identificadorFuncion + ", palabraReservadaFuncion="
							+ palabraReservadaFuncion + "]";
				}
			}
		} else {
			if (listaParametros != null) {
				if (listaSentencias != null) {
					return "Funcion [" + " tipoRetorno=" + tipoRetorno + ", identificadorFuncion="
							+ identificadorFuncion + ", palabraReservadaFuncion=" + palabraReservadaFuncion
							+ ", listaParametros=" + listaParametros + ", listaSentencias=" + listaSentencias + "]";
				} else {
					return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
							+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaParametros="
							+ listaParametros + "]";
				}
			} else {
				if (listaSentencias != null) {
					return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
							+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + ", listaSentencias="
							+ listaSentencias + "]";
				}
			}
		}
		return "Funcion [tipoRetorno=" + tipoRetorno + ", identificadorFuncion=" + identificadorFuncion
				+ ", palabraReservadaFuncion=" + palabraReservadaFuncion + "]";
	}

	/**
	 * Metodo que permite crear el arbol grafico de una funcion
	 * 
	 * @return
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Funcion");

		if (visibilidad != null) {
			nodo.add(new DefaultMutableTreeNode(visibilidad.getLexema()));
		}
		nodo.add(tipoRetorno.getArbolVisual());
		nodo.add(new DefaultMutableTreeNode(palabraReservadaFuncion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
		if (listaParametros != null) {
			for (Parametro parametro : listaParametros) {
				nodo.add(parametro.getArbolVisual());
			}
		}
		if (listaSentencias != null) {
			for (Sentencia sentencia : listaSentencias) {
				nodo.add(sentencia.getArbolVisual());
			}
		}
		return nodo;
	}

	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts) {

		for (Sentencia sentencia : listaSentencias) {
			if (!ambito.getRetorno()) {
				sentencia.analizarSemantica(errores, ts, ambito);
				if (sentencia.getClass().equals(Ciclo.class)) {
					ambito.setNumeroCiclo(ambito.getNumeroCiclo() + 1);
				} else if (sentencia.getClass().equals(Condicional.class)) {
					ambito.setNumeroCondicional(ambito.getNumeroCondicional() + 1);
				}
			} else {
				errores.add("La función " + ambito.getNombre() + " ya ha retornado y el código es inalcanzable");
			}
		}
		if (!ambito.getRetorno() && !tipoRetorno.getTipoRetorno().getLexema().equals("sr")) {
			errores.add("La función no tiene algún retorno o falta otros casos de retorno");
		}

	}

	public void llenarTablaSimbolos(TablaSimbolos ts) {
		for (Parametro parametro : listaParametros) {
			ts.agregarSimbolo(parametro.getIdenVariable().getLexema(), parametro.getTipoDato().getLexema(), ambito);
		}
		for (Sentencia sentencia : listaSentencias) {
			sentencia.llenarTablaSimbolos(ts, ambito);
		}

	}

	/**
	 * @return the visibilidad
	 */
	public Token getVisibilidad() {
		return visibilidad;
	}

	/**
	 * @param visibilidad
	 *            the visibilidad to set
	 */
	public void setVisibilidad(Token visibilidad) {
		this.visibilidad = visibilidad;
	}

	/**
	 * @return the tipoRetorno
	 */
	public TipoRetorno getTipoRetorno() {
		return tipoRetorno;
	}

	/**
	 * @param tipoRetorno
	 *            the tipoRetorno to set
	 */
	public void setTipoRetorno(TipoRetorno tipoRetorno) {
		this.tipoRetorno = tipoRetorno;
	}

	/**
	 * @return the identificadorFuncion
	 */
	public Token getIdentificadorFuncion() {
		return identificadorFuncion;
	}

	/**
	 * @param identificadorFuncion
	 *            the identificadorFuncion to set
	 */
	public void setIdentificadorFuncion(Token identificadorFuncion) {
		this.identificadorFuncion = identificadorFuncion;
	}

	/**
	 * @return the palabraReservadaFuncion
	 */
	public Token getPalabraReservadaFuncion() {
		return palabraReservadaFuncion;
	}

	/**
	 * @param palabraReservadaFuncion
	 *            the palabraReservadaFuncion to set
	 */
	public void setPalabraReservadaFuncion(Token palabraReservadaFuncion) {
		this.palabraReservadaFuncion = palabraReservadaFuncion;
	}

	/**
	 * @return the listaParametros
	 */
	public ArrayList<Parametro> getListaParametros() {
		return listaParametros;
	}

	/**
	 * @param listaParametros
	 *            the listaParametros to set
	 */
	public void setListaParametros(ArrayList<Parametro> listaParametros) {
		this.listaParametros = listaParametros;
	}

	/**
	 * @return the listaSentencias
	 */
	public ArrayList<Sentencia> getListaSentencias() {
		return listaSentencias;
	}

	/**
	 * @param listaSentencias
	 *            the listaSentencias to set
	 */
	public void setListaSentencias(ArrayList<Sentencia> listaSentencias) {
		this.listaSentencias = listaSentencias;
	}

	/**
	 * @return the ambito
	 */
	public Simbolo getAmbito() {
		return ambito;
	}

	/**
	 * @param ambito
	 *            the ambito to set
	 */
	public void setAmbito(Simbolo ambito) {
		this.ambito = ambito;
	}

	public String traducir(String identacion) {
		String tipo = "";
		switch (this.tipoRetorno.getTipoRetorno().getLexema()) {
		case "ltr":
			tipo = "char";
		case "ntr":
			tipo = "int";
		case "pntdec":
			tipo = "double";
		case "ltrarr":
			tipo = "String";
		case "binary":
			tipo = "boolean";
		case "sr":
			tipo = "void";
		default:
			tipo = "";
		}
		String sentencias = "";
		if (listaSentencias != null) {
			for (Sentencia sentencia : listaSentencias) {
				sentencias += sentencia.traducir(identacion + "\t");
			}
		}
		
		String nombreFuncion = identificadorFuncion.getLexema();

		if (nombreFuncion.equals("funmainrealizar") && tipo.equals("void")) {
			return identacion + "public static void main(String[] args){\n" + sentencias + identacion + "\n}";
		}

		String visibilidad = this.visibilidad.getLexema().equals("visible") ? "public" : "private";
		String variables = "";
		if (listaParametros != null) {
			for (Parametro parametro : listaParametros) {
				variables = parametro.traducir() + ", ";
			}
			variables = variables.substring(0, variables.length() - 2);
		}

		return identacion + visibilidad + " " + tipo + " "  + nombreFuncion +  "("  + variables + ") {\n" + sentencias + identacion + "}";
	}
}