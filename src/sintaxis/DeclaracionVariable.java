package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa la declaración de variable
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class DeclaracionVariable extends Sentencia {

	private Token visibilidad;
	private Token tipo, arreglo;
	private ArrayList<Token> listaId;

	/**
	 * @param visibilidad
	 * @param tipo
	 * @param listaId
	 */
	public DeclaracionVariable(Token visibilidad, Token tipo, ArrayList<Token> listaId) {
		super();
		this.visibilidad = visibilidad;
		this.tipo = tipo;
		this.listaId = listaId;
	}

	/**
	 * @param tipo
	 * @param listaId
	 */
	public DeclaracionVariable(Token tipo, ArrayList<Token> listaId) {
		super();
		this.tipo = tipo;
		this.listaId = listaId;
	}

	/**
	 * @param visibilidad
	 * @param tipo
	 * @param arreglo
	 * @param listaId
	 */
	public DeclaracionVariable(Token visibilidad, Token tipo, Token arreglo, ArrayList<Token> listaId) {
		super();
		this.visibilidad = visibilidad;
		this.tipo = tipo;
		this.arreglo = arreglo;
		this.listaId = listaId;
	}

	/**
	 * @param tipo
	 * @param arreglo
	 * @param listaId
	 */
	public DeclaracionVariable(Token arreglo, ArrayList<Token> listaId, Token tipo) {
		super();
		this.tipo = tipo;
		this.arreglo = arreglo;
		this.listaId = listaId;
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
	 * @return the tipo
	 */
	public Token getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(Token tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the listaId
	 */
	public ArrayList<Token> getListaId() {
		return listaId;
	}

	/**
	 * @param listaId
	 *            the listaId to set
	 */
	public void setListaId(ArrayList<Token> listaId) {
		this.listaId = listaId;
	}

	/**
	 * Método para retornar el nodo de un arbol visual
	 * 
	 * @return
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Declaracion variable");

		if (visibilidad != null) {
			nodo.add(new DefaultMutableTreeNode(visibilidad.getLexema()));
		}

		if (arreglo != null) {
			nodo.add(new DefaultMutableTreeNode(arreglo.getLexema()));
		}

		nodo.add(new DefaultMutableTreeNode(tipo.getLexema()));

		for (Token id : listaId) {
			nodo.add(new DefaultMutableTreeNode(id.getLexema()));
		}

		return nodo;
	}

	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		for (Token token : listaId) {
			ts.agregarSimbolo(token.getLexema(), tipo.getLexema(), ambito);
		}
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion, boolean global) {
		String visibilidad = "";
		if(this.visibilidad!= null) {
			visibilidad = this.visibilidad.getLexema().equals("visible")? "public":"private";
		}
		String arreglo = (this.arreglo != null)? "[]" : "";
		String variables = "";
		for (Token token : listaId) {
			variables = token.getLexema() + ", ";
		}
		variables = variables.replaceAll("<", "");
		variables = variables.replaceAll(">", "");
		variables = variables.replaceAll("-", "_");
		variables = variables.substring(0, variables.length()-2);
		variables += ";";
		
		String tipo = "";
		switch (this.tipo.getLexema()) {
		case "ltr":
			tipo = "char";
			break;
		case "ntr":
			tipo = "int";
			break;
		case "pntdec":
			tipo = "double";
			break;
		case "ltrarr":
			tipo = "String";
			break;
		case "binary":
			tipo = "boolean";
			break;
		default:
			tipo = "";
			break;
		}
		return identacion + visibilidad + (global?" static ":"") + tipo + arreglo + " " + variables;
	}

}
