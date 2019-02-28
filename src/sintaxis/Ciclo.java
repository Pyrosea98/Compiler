package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

/**
 * Clase que representa un cilclo
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Ciclo extends Sentencia {

	private Token ciclo, mientras;
	private ExpresionLogica expresionLogica;
	private ArrayList<Sentencia> sentencias;

	/**
	 * Constructor con sintencias
	 * 
	 * @param ciclo
	 * @param mientras
	 * @param expresionLogica
	 * @param sentencias
	 */
	public Ciclo(Token ciclo, Token mientras, ExpresionLogica expresionLogica, ArrayList<Sentencia> sentencias) {
		super();
		this.ciclo = ciclo;
		this.mientras = mientras;
		this.expresionLogica = expresionLogica;
		this.sentencias = sentencias;
	}

	/**
	 * Constructor sin sentencias
	 * 
	 * @param ciclo
	 * @param mientras
	 * @param expresionLogica
	 */
	public Ciclo(Token ciclo, Token mientras, ExpresionLogica expresionLogica) {
		super();
		this.ciclo = ciclo;
		this.mientras = mientras;
		this.expresionLogica = expresionLogica;
	}

	/**
	 * @return the ciclo
	 */
	public Token getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 *            the ciclo to set
	 */
	public void setCiclo(Token ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the mientras
	 */
	public Token getMientras() {
		return mientras;
	}

	/**
	 * @param mientras
	 *            the mientras to set
	 */
	public void setMientras(Token mientras) {
		this.mientras = mientras;
	}

	/**
	 * @return the expresionLogica
	 */
	public ExpresionLogica getExpresionLogica() {
		return expresionLogica;
	}

	/**
	 * @param expresionLogica
	 *            the expresionLogica to set
	 */
	public void setExpresionLogica(ExpresionLogica expresionLogica) {
		this.expresionLogica = expresionLogica;
	}

	/**
	 * @return the sentencias
	 */
	public ArrayList<Sentencia> getSentencias() {
		return sentencias;
	}

	/**
	 * @param sentencias
	 *            the sentencias to set
	 */
	public void setSentencias(ArrayList<Sentencia> sentencias) {
		this.sentencias = sentencias;
	}

	/**
	 * Método de árbol visual
	 * 
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {
		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Ciclo");

		nodo.add(new DefaultMutableTreeNode(ciclo.getLexema()));
		nodo.add(new DefaultMutableTreeNode(mientras.getLexema()));
		nodo.add(expresionLogica.getArbolVisual());
		if (sentencias != null) {
			for (Sentencia sentencia : sentencias) {
				nodo.add(sentencia.getArbolVisual());
			}
		}
		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		expresionLogica.analizarSemantica(errores, ts, ambito);
		Simbolo nuevoAmbito = new Simbolo(ambito.getNombre() + "ciclo" + ambito.getNumeroCiclo(), ambito.getTipo(),
				ambito.getTipos());
		nuevoAmbito.setAmbitoPadre(ambito);
		for (Sentencia sentencia : sentencias) {
			if (!nuevoAmbito.getRetorno()) {
				sentencia.analizarSemantica(errores, ts, nuevoAmbito);
				if (sentencia.getClass().equals(Ciclo.class)) {
					nuevoAmbito.setNumeroCiclo(nuevoAmbito.getNumeroCiclo() + 1);
				} else if (sentencia.getClass().equals(Condicional.class)) {
					nuevoAmbito.setNumeroCondicional(nuevoAmbito.getNumeroCondicional() + 1);
				}
			} else {
				errores.add("La función " + ambito.getNombre() + " ya ha retornado y el código es inalcanzable");
			}
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
	}

	@Override
	public String traducir(String identacion) {
		String sentencias = "";
		for (Sentencia sentencia : this.sentencias) {
			sentencias += sentencia.traducir(identacion) + "\n";
		}
		return identacion + "while(" + expresionLogica.traducir() + "){\n" + sentencias + identacion + "}";
	}

}
