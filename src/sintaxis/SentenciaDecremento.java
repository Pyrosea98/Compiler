package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

public class SentenciaDecremento extends Sentencia {

	private Token identificadorVariable, decremento;

	/**
	 * Constructor de la sentencia decremento
	 * 
	 * @param identificadorVariable
	 * @param decremento
	 */
	public SentenciaDecremento(Token identificadorVariable, Token decremento) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.decremento = decremento;
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
	 * @return the decremento
	 */
	public Token getDecremento() {
		return decremento;
	}

	/**
	 * @param decremento
	 *            the decremento to set
	 */
	public void setDecremento(Token decremento) {
		this.decremento = decremento;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Decremento");

		nodo.add(new DefaultMutableTreeNode(identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode(decremento.getLexema()));

		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		for (Simbolo simbolo : ts.getTablaSimbolos()) {
			if (simbolo.getAmbito() != null) {
				if (identificadorVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()
						&& simbolo.getAmbito().equals(ambito)) {
					if (simbolo.getTipo().equals("ntr") || simbolo.getTipo().equals("pntdec")) {
						return;
					} else {
						errores.add(identificadorVariable.getLexema() + " La variable no es de tipo numerica");
						return;
					}
				}
			}else {
				if (identificadorVariable.getLexema().equals(simbolo.getNombre()) && !simbolo.isEsFuncion()) {
					if (simbolo.getTipo().equals("ntr") || simbolo.getTipo().equals("pntdec")) {
						return;
					} else {
						errores.add(identificadorVariable.getLexema() + " La variable no es de tipo numerica");
						return;
					}
				}
			}
		}
		if (ambito.getAmbitoPadre() != null) {
			analizarSemantica(errores, ts, ambito.getAmbitoPadre());
		} else {
			errores.add(identificadorVariable.getLexema() + " No se encontró la variable");
			return;
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion, boolean global) {
		String identificador = "";
		identificador = identificadorVariable.getLexema().replaceAll("<", "");
		identificador = identificador.replaceAll(">", "");
		identificador = identificador.replaceAll("-", "_");
		return identacion + " " + identificador + "--";
	}

}
