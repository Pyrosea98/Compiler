package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
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
public class Lectura extends Sentencia {

	private Token idVariable;
	private Token opAsignacion;
	private Token leer;
	private Token tipoDato;

	/**
	 * Constructor para leer un dato
	 * 
	 * @param idVariable
	 * @param opAsignacion
	 * @param leer
	 * @param parentesisIzq
	 * @param tipoDato
	 * @param parentesisDer
	 * @param fin
	 */
	public Lectura(Token idVariable, Token opAsignacion, Token leer, Token tipoDato) {
		super();
		this.idVariable = idVariable;
		this.opAsignacion = opAsignacion;
		this.leer = leer;
		this.tipoDato = tipoDato;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Lectura");
		nodo.add(new DefaultMutableTreeNode(idVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(opAsignacion.getLexema()));
		nodo.add(new DefaultMutableTreeNode(leer.getLexema()));
		nodo.add(new DefaultMutableTreeNode(tipoDato.getLexema()));
		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		for (Simbolo simbolo : ts.getTablaSimbolos()) {
			if (simbolo.getAmbito() != null) {
				if (idVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()
						&& simbolo.getAmbito().equals(ambito)) {
					if (simbolo.getTipo().equals(tipoDato.getLexema())) {
						return;
					} else {
						errores.add(idVariable.getLexema() + " El tipo de dato no coinciden con la variable");
					}
				}
			} else {
				if (idVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()) {
					if (simbolo.getTipo().equals(tipoDato.getLexema())) {
						return;
					} else {
						errores.add(idVariable.getLexema() + " El tipo de dato no coinciden con la variable");
					}
				}
			}
		}
		if (ambito.getAmbitoPadre() != null) {
			analizarSemantica(errores, ts, ambito.getAmbitoPadre());
		} else {
			errores.add(idVariable.getLexema() + " No se encontró la variable invocada");
		}

	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion, boolean global) {
		String asignacion = "";
		switch (opAsignacion.getLexema()) {
		case "es":
			asignacion = "=";
			break;
		case "es(+)":
			asignacion = "+=";
			break;
		case "es(-)":
			asignacion = "-=";
			break;
		case "es(/)":
			asignacion = "/=";
			break;
		case "es(*)":
			asignacion = "*=";
			break;
		case "es(%)":
			asignacion = "%=";
			break;
		default:
			break;
		}
		String tipo = "";
		switch (this.tipoDato.getLexema()) {
		case "ltr":
			tipo = "JOptionPane.showInputDialog(\"Ingrese valor de caracter\").charAt(0)";
			break;
		case "ntr":
			tipo = "Integer.parseInt(JOptionPane.showInputDialog(\"Ingrese valor entero\"))";
			break;
		case "pntdec":
			tipo = "Double.parseDouble(JOptionPane.showInputDialog(\"Ingrese valor decimal\"))";
			break;
		case "ltrarr":
			tipo = "JOptionPane.showInputDialog(\"Ingrese valor cadena\")";
			break;
		case "binary":
			tipo = "Boolean.parseBoolean(JOptionPane.showInputDialog(\"Ingrese valor entero\")))";
			break;
		default:
			tipo = "";
		}

		String identificador = this.idVariable.getLexema();
		identificador = identificador.replaceAll("<", "");
		identificador = identificador.replaceAll(">", "");
		identificador = identificador.replaceAll("-", "_");
		return identacion + identificador + " " + asignacion + " " + tipo;
	}

}
