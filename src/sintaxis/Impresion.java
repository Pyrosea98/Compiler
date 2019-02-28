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
public class Impresion extends Sentencia {

	private Token escribir;
	private Termino termino;

	/**
	 * Constructor para imprimir un dato
	 * 
	 * @param escribir
	 * @param termino
	 * @param fin
	 */
	public Impresion(Token escribir, Termino termino) {
		super();
		this.escribir = escribir;
		this.termino = termino;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Impresion");

		nodo.add(new DefaultMutableTreeNode(escribir.getLexema()));
		if (termino != null) {
			nodo.add(termino.getArbolVisual());
		}
		return nodo;
	}

	public void analizarSemantica() {

	}

	public void llenarTablaSimbolos() {

	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		termino.analizarSemantica(errores, ts, ambito);
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
		// TODO Auto-generated method stub

	}

	@Override
	public String traducir(String identacion) {
		return identacion + "JOptionPane.showMessageDialog(null, " + termino + ");";
	}

}
