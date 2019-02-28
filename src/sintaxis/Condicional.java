package sintaxis;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;

import lexico.Token;
import semantico.Simbolo;
import semantico.TablaSimbolos;

public class Condicional extends Sentencia {

	private Token pregunta;
	private ExpresionLogica expresionLogica;
	private ArrayList<Sentencia> listaSentencia;
	private Token contrario;
	private ArrayList<Sentencia> listaSentencia0;

	/**
	 * Constructor que crea condicional sin caso contrario
	 * 
	 * @param pregunta
	 * @param expresionLogica
	 * @param listaSentencia
	 */
	public Condicional(Token pregunta, ExpresionLogica expresionLogica, ArrayList<Sentencia> listaSentencia) {
		super();
		this.pregunta = pregunta;
		this.expresionLogica = expresionLogica;
		this.listaSentencia = listaSentencia;

	}

	/**
	 * Constructor que crea condicional con caso contrario
	 * 
	 * @param pregunta
	 * @param expresionLogica
	 * @param listaSentencia
	 * @param contrario
	 * @param listaSentencia0
	 */
	public Condicional(Token pregunta, ExpresionLogica expresionLogica, ArrayList<Sentencia> listaSentencia,
			Token contrario, ArrayList<Sentencia> listaSentencia0) {
		super();
		this.pregunta = pregunta;
		this.expresionLogica = expresionLogica;
		this.listaSentencia = listaSentencia;
		this.contrario = contrario;
		this.listaSentencia0 = listaSentencia0;
	}

	@Override
	public String toString() {
		if (contrario != null) {
			return "Condicional [pregunta=" + pregunta + ", expresionLogica=" + expresionLogica + ", listaSentencia="
					+ listaSentencia + ", contrario=" + contrario + ", listaSentencia0=" + listaSentencia0 + "]";
		} else {
			return "Condicional [pregunta=" + pregunta + ", expresionLogica=" + expresionLogica + ", listaSentencia="
					+ listaSentencia;
		}
	}

	/**
	 * Metodo que permite dibujar el arbol grafico de condicional
	 */
	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Condicional");
		nodo.add(new DefaultMutableTreeNode(pregunta.getLexema()));
		nodo.add(expresionLogica.getArbolVisual());
		for (Sentencia sentencia : listaSentencia) {
			nodo.add(sentencia.getArbolVisual());
		}
		if (contrario != null) {
			nodo.add(new DefaultMutableTreeNode(contrario.getLexema()));
			for (Sentencia sentencia0 : listaSentencia0) {
				nodo.add(sentencia0.getArbolVisual());
			}
		}
		return nodo;
	}

	@Override
	public void analizarSemantica(ArrayList<String> errores, TablaSimbolos ts, Simbolo ambito) {
		expresionLogica.analizarSemantica(errores, ts, ambito);
		Simbolo nuevoAmbito = new Simbolo(ambito.getNombre() + "condicional"+ambito.getNumeroCondicional(), ambito.getTipo(), ambito.getTipos());
		nuevoAmbito.setAmbitoPadre(ambito);
		for (Sentencia sentencia : listaSentencia) {
			if (!nuevoAmbito.getRetorno()) {
				sentencia.analizarSemantica(errores, ts, nuevoAmbito);
				if (sentencia.getClass().equals(Ciclo.class)) {
					nuevoAmbito.setNumeroCiclo(nuevoAmbito.getNumeroCiclo()+1);
				}else if (sentencia.getClass().equals(Condicional.class)){
					nuevoAmbito.setNumeroCondicional(nuevoAmbito.getNumeroCondicional()+1);
				}
			} else {
				errores.add("La función " + ambito.getNombre() + " ya ha retornado y el código es inalcanzable");
			}
		}
		nuevoAmbito.setNombre(nuevoAmbito.getNombre() + "contrario" + ambito.getNumeroCondicional());
		if (listaSentencia0 != null) {
			for (Sentencia sentencia : listaSentencia0) {
				if (!nuevoAmbito.getRetorno()) {
					sentencia.analizarSemantica(errores, ts, nuevoAmbito);
					if (sentencia.getClass().equals(Ciclo.class)) {
						nuevoAmbito.setNumeroCiclo(nuevoAmbito.getNumeroCiclo()+1);
					}else if (sentencia.getClass().equals(Condicional.class)){
						nuevoAmbito.setNumeroCondicional(nuevoAmbito.getNumeroCondicional()+1);
					}
				} else {
					errores.add("La función " + ambito.getNombre() + " ya ha retornado y el código es inalcanzable");
				}
			}
		}
	}

	@Override
	public void llenarTablaSimbolos(TablaSimbolos ts, Simbolo ambito) {
	}

}
