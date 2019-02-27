package semantico;

import java.util.ArrayList;

public class TablaSimbolos {

	private ArrayList<Simbolo> tablaSimbolos;
	private ArrayList<String> errores;

	public TablaSimbolos(ArrayList<String> errores) {
		this.tablaSimbolos = new ArrayList<>();
		this.errores = errores;
	}

	public void agregarSimbolo(String nombre, String tipo, Simbolo ambito) {
		Simbolo s = getSimbolo(nombre, tipo, ambito);
		if (s != null) {
			tablaSimbolos.add(s);
		} else {
			errores.add("El Identificador" + nombre + "dentro de " + ambito + "esta repetido");
		}
	}

	public Simbolo agregarFuncion(String nombre, String tipo, ArrayList<String> tipos) {
		Simbolo s = getSimbolo(nombre, tipo, tipos);
		if (s != null) {
			tablaSimbolos.add(s);
			return s;
		} else {
			errores.add("La funcion" + nombre + "esta repetida");
			return null;
		}
	}

	public Simbolo getSimbolo(String nombre, String tipo, Simbolo ambito) {
		for (Simbolo simbolo : tablaSimbolos) {
			if (simbolo.getNombre().equals(nombre) && simbolo.getTipo().equals(tipo)
					&& simbolo.getAmbito().getNombre().equals(ambito.getNombre())
					&& simbolo.getAmbito().getTipo().equals(tipo) && !simbolo.isEsFuncion()) {
				return null;
			}
		}
		if (ambito != null) {
			if (ambito.getAmbitoPadre() != null) {
				return getSimbolo(nombre, tipo, ambito.getAmbitoPadre());
			} else {
				return new Simbolo(nombre, tipo, ambito);
			}
		}else {
			return new Simbolo(nombre, tipo, ambito);
		}

	}

	public Simbolo getSimbolo(String nombre, String tipo, ArrayList<String> tipos) {
		for (Simbolo simbolo : tablaSimbolos) {
			if (simbolo.getNombre().equals(nombre) && simbolo.getTipo().equals(tipo)
					&& simbolo.getTipos().containsAll(tipos) && !simbolo.isEsFuncion()) {
				return null;
			}
		}
		return new Simbolo(nombre, tipo, tipos);
	}

	/**
	 * @return the tablaSimbolos
	 */
	public ArrayList<Simbolo> getTablaSimbolos() {
		return tablaSimbolos;
	}

	/**
	 * @param tablaSimbolos
	 *            the tablaSimbolos to set
	 */
	public void setTablaSimbolos(ArrayList<Simbolo> tablaSimbolos) {
		this.tablaSimbolos = tablaSimbolos;
	}

	/**
	 * @return the errores
	 */
	public ArrayList<String> getErrores() {
		return errores;
	}

	/**
	 * @param errores
	 *            the errores to set
	 */
	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}

}
