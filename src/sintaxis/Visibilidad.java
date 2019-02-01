package sintaxis;

import lexico.Token;

public class Visibilidad {
	
	private Token visibilidad;

	/**
	 * @param visibilidad
	 */
	public Visibilidad(Token visibilidad) {
		super();
		this.visibilidad = visibilidad;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Visibilidad [visibilidad=" + visibilidad + "]";
	}
}
