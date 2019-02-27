package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

public class SentenciaIncremento extends Sentencia {

	private Token identificadorVariable, incremento;

	/**
	 * Constructor de la sentencia incremento
	 * 
	 * @param identificadorVariable
	 * @param incremento
	 */
	public SentenciaIncremento(Token identificadorVariable, Token incremento) {
		super();
		this.identificadorVariable = identificadorVariable;
		this.incremento = incremento;
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
	 * @return the incremento
	 */
	public Token getIncremento() {
		return incremento;
	}

	/**
	 * @param incremento
	 *            the incremento to set
	 */
	public void setIncremento(Token incremento) {
		this.incremento = incremento;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {
	DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Incremento");
		
		nodo.add(new DefaultMutableTreeNode (identificadorVariable.getLexema()));
		nodo.add(new DefaultMutableTreeNode (incremento.getLexema()));
		
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

}
