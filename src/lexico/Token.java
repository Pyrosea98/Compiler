package lexico;

/**
 * Clase que pemite la abstracción de un token de lenguaje de programación
 * 
 * @author Juan JosÃ© Ã�lvarez Orozco
 * @Author Daniel BeltrÃ¡n Gomez
 * @author Tatiana Salazar
 */
public class Token {

	private String lexema;
	private int fila, columna, columnaReal;
	private Categoria categoria;

	/**
	 * Contructor para simbolos
	 * @param lexema
	 * @param fila
	 * @param columna
	 * @param categoria
	 */
	public Token(String lexema, int fila, int columna, Categoria categoria) {
		this.lexema = lexema;
		this.fila = fila;
		this.columna = columna;
		this.categoria = categoria;
	}
	
	/**
	 * Contructor para errores
	 * @param lexema
	 * @param fila
	 * @param columna
	 * @param columnaReal
	 * @param categoria
	 */
	public Token(String lexema, int fila, int columna, int columnaReal, Categoria categoria) {
		this.lexema = lexema;
		this.fila = fila;
		this.columna = columna;
		this.categoria = categoria;
		this.columnaReal = columnaReal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Token [lexema=" + lexema + ", fila=" + fila + ", columna=" + columna + ", categoria=" + categoria
				+ "]";
	}

	public String getLexema() {
		return lexema;
	}

	public void setLexema(String lexema) {
		this.lexema = lexema;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		this.columna = columna;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getColumnaReal() {
		return columnaReal;
	}

	public void setColumnaReal(int columnaReal) {
		this.columnaReal = columnaReal;
	}
	
	

}
