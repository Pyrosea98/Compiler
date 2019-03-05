package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

public class LlamadoFuncion extends Sentencia {

	/**
	 * Clase que representa el llamado a una funcion
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */

	private Token identificadorFuncion;
	private ArrayList<Termino> listaArgumentos;

	/**
	 * Constructor que declara un llamado a funcion
	 * 
	 * @param identificadorFuncion
	 * @param listaArgumentos
	 */
	public LlamadoFuncion(Token identificadorFuncion, ArrayList<Termino> listaArgumentos) {
		super();
		this.identificadorFuncion = identificadorFuncion;
		this.listaArgumentos = listaArgumentos;
	}

	/**
	 * Constructor que declara un llamado a funcion
	 * 
	 * @param identificadorFuncion
	 */
	public LlamadoFuncion(Token identificadorFuncion) {
		super();
		this.identificadorFuncion = identificadorFuncion;
	}

	@Override
	public String toString() {
		return "LlamadoFuncion [identificadorFuncion=" + identificadorFuncion + ", listaArgumentos=" + listaArgumentos
				+ "]";
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Llamado funcion");

		nodo.add(new DefaultMutableTreeNode(identificadorFuncion.getLexema()));
		if (listaArgumentos != null) {
			for (Termino termino : listaArgumentos) {
				nodo.add(termino.getArbolVisual());
			}
		}
		return nodo;
	}

	public ArrayList<String> getTipos(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		ArrayList<String> tipos = new ArrayList<>();
		if (listaArgumentos != null) {
			for (Termino termino : listaArgumentos) {
				tipos.add(termino.getTipo(errores, ts, ambito));
			}
		}
		return tipos;
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
	 * @return the listaArgumentos
	 */
	public ArrayList<Termino> getListaArgumentos() {
		return listaArgumentos;
	}

	/**
	 * @param listaArgumentos
	 *            the listaArgumentos to set
	 */
	public void setListaArgumentos(ArrayList<Termino> listaArgumentos) {
		this.listaArgumentos = listaArgumentos;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		boolean funcion = false;
		for (Simbolo simbolo : ts.getTablaSimbolos()) {
			if (identificadorFuncion.getLexema().equals(simbolo.getNombre()) && simbolo.isEsFuncion()) {
				if (simbolo.getTipos().containsAll(getTipos(errores, ts, ambito))) {
					funcion = true;
					break;
				}
			}
		}
		if (!funcion) {
			errores.add(identificadorFuncion.getLexema() + " No se encontró la función invocada");
		}
		if (listaArgumentos != null) {
			for (Termino termino : listaArgumentos) {
				termino.analizarSemantica(errores, ts, ambito);
			}
		}

	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion, boolean global) {
		String arguemntos = "";
		if (listaArgumentos != null) {
			for (Termino termino : listaArgumentos) {
				arguemntos += termino.traducir() + ", ";
			}
			arguemntos = arguemntos.substring(0, arguemntos.length() - 2);
		}
		return identacion + identificadorFuncion.getLexema() + "(" + arguemntos + ")";
	}

}
