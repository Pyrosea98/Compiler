package sintaxis;

import java.util.ArrayList;

import lexico.Categoria;
import lexico.Token;

public class AnalizadorSintactico {
	
	/**
	 * Clase que representa el analizador sintactico
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */
	
	private ArrayList<Token> tablaSimbolos;
	private ArrayList<ErrorSintactico> tablaErrores;
	private int posActual;
	private Token tokenActual;
	private UnidadCompilacion unidadCompilacion;

	public AnalizadorSintactico(ArrayList<Token> tablaSimbolos) {
		super();
		posActual = 0;
		this.tablaSimbolos = tablaSimbolos;
		this.tokenActual = tablaSimbolos.get(posActual);
		this.tablaErrores = new ArrayList<>();
	}

	/**
	 * Metodo que analiza el codigo sintacticamente
	 */
	public void analizar() {
		unidadCompilacion = esUnidadDeCompilacion();
	}

	/**
	 * Metodo que verifica si es unidad de compilacion
	 * 
	 * <{@link UnidadCompilacion}>::= clase identificadorClase agrupadorDerecho
	 * <{@link CuerpoClase}> agrupadorIzquierdo
	 * 
	 * @return unidadDeCompilacion{@link UnidadCompilacion}
	 */
	private UnidadCompilacion esUnidadDeCompilacion() {

		return null;
	}

	/**
	 * Metodo que verifica si es cuerpo de clase
	 * 
	 * <{@link CuerpoClase}>::= <{@link Funcion}> [<{@link CuerpoClase}>] |
	 * <{@link DeclaracionVariable}> [<{@link CuerpoClase}>]
	 * 
	 * @return cuerpoClase{@link CuerpoClase}
	 */
	private CuerpoClase esCuerpoClase() {
		return null;
	}

	/**
	 * Metodo que verifica si es una funcion
	 * 
	 * <{@link Funcion}>::= [<{@link Visibilidad}>] <{@link TipoRetorno}> funapp
	 * identificadorVariable parentesisIzquierdo <"Lista"{@link Parametro}>
	 * parentesisDerecho agrupadorIzquierdo <"Lista" {@link Sentencia}>
	 * agrupadorDerecho
	 * 
	 * @return funcion{@link Funcion}
	 */
	private Funcion esFuncion() {
		return null;
	}

	/**
	 * Metodo que verifica si es visibilidad
	 * 
	 * <{@link Visibilidad}>::= visible | oculto
	 * 
	 * @return visibilidad{@link Visibilidad}
	 */
	private Token esVisibilidad() {
		if (tokenActual.getLexema().equals("visible") || tokenActual.getLexema().equals("oculto")) {
			return tokenActual;
		}
		return null;
	}

	/**
	 * Metodo que verifica si es un tipo de retorno
	 * 
	 * <{@link TipoRetorno}>::= sr | [<{@link TipoDato}>]
	 * 
	 * @return tipoRetorno{@link TipoRetorno}
	 */
	private TipoRetorno esTipoRetorno() {
		return null;
	}

	/**
	 * Metodo que verifica si es un tipo de dato
	 * 
	 * <{@link TipoDato}>::= ntr | ltr | ltrarr | binary | pntdec
	 * 
	 * @return tipoDato{@link TipoDato}
	 */
	private TipoDato esTipoDato() {
		return null;
	}

	/**
	 * Metodo que verifica si es un parametro
	 * 
	 * <"Lista"{@link Parametro}>::= <{@link Parametro}> ["|"
	 * <"Lista"{@link Parametro}>] <{@link Parametro}>::= <{@link TipoDato}>
	 * [$arr()] identificadorVariable
	 * 
	 * @return parametro{@link Parametro}
	 */
	private Parametro esParametro() {
		return null;
	}

	/**
	 * Metodo que verifica si es una sentencia
	 * 
	 * <"List"{@link Sentencia}>::= <{@link Sentencia}>[<"List"{@link Sentencia}>]
	 * <{@link Sentencia}>::= <{@link Condicional}> | <{@link Ciclo}> |
	 * <{@link Retorno}> | <{@link Impresion}> | <{@link Lectura}> |
	 * <{@link DeclaracionVariable}> | <{@link AsignacionVariable}> |
	 * <{@link ExpresionIncremento}> | <{@link ExpresionDecremento}>|
	 * <{@link LlamadoFuncion}>
	 * 
	 * @return sentencia{@link Sentencia}
	 */
	private Sentencia esSentencia() {
		return null;
	}

	/**
	 * Metodo que verifica si es un condicional
	 * 
	 * <{@link Condicional}>::= pregunta parentesisIzquierdo
	 * <{@link ExpresionLogica}> parentesisDerecho agrupadorIzquierdo <"Lista"
	 * {@link Sentencia}> agrupadorDerecho [contrario agrupadorIzquierdo <"Lista"
	 * {@link Sentencia}> agrupadorDerecho]
	 * 
	 * @return condicional{@link Condicional}
	 */
	private Condicional esCondicional() {
		return null;
	}

	/**
	 * Metodo que verifica si es una expresion logica
	 * 
	 * <{@link ExpresionLogica}>::= <{@link ExpresionRelacional}> [operadorLogico
	 * <{@link ExpresionLogica}>] | parentesisIzquierdo <{@link ExpresionLogica}>
	 * parentesisDerecho
	 * 
	 * @return expresionLogica{@link ExpresionLogica}
	 */
	private ExpresionLogica esExpresionLogica() {
		return null;
	}

	/**
	 * Metodo que verifica si es una expresion relacional
	 * 
	 * <{@link ExpresionRelacional}>::= <{@link ExpresionAritmetica}>
	 * [operadorRelacional <{@link ExpresionRelacional}>] | parentesisIzquierdo
	 * <{@link ExpresionRelacional}> parentesisDerecho
	 * 
	 * @return expresionLogica{@link ExpresionLogica}
	 */
	private ExpresionRelacional esExpresionRelacional() {
		return null;
	}

	/**
	 * Metodo que verifica si es una expresion aritmetica
	 * 
	 * <{@link ExpresionAritmetica}>::= <{@link Termino}> [operadorAritmetico
	 * <{@link ExpresionAritmetica}>] | parentesisIzquierdo
	 * <{@link ExpresionAritmetica}> parentesisDerecho | parentesisIzquierdo
	 * <{@link Termino}> [operadorAritmetico <{@link ExpresionAritmetica}>]
	 * parentesisDerecho
	 * 
	 * @return expresionAritmetica{@link ExpresionAritmetica}
	 */
	private ExpresionAritmetica esExpresionAritmetica() {
		Termino termino = esTermino();

		if (termino != null) {
			obtenerSiguienteToken();

			if (tokenActual.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
				Token operadorAritmetico = tokenActual;
				obtenerSiguienteToken();

				ExpresionAritmetica ex = esExpresionAritmetica();

				if (ex != null) {
					return new ExpresionAritmetica(termino, operadorAritmetico, ex);
				} else {
					reportarError("Falta expresion aritmetica", tokenActual.getFila(), tokenActual.getColumna());
				}

			} else {
				return new ExpresionAritmetica(termino);
			}
		}

		else if (tokenActual.getCategoria() == Categoria.AGRUPADOR_IZQUIERDO) {
			obtenerSiguienteToken();
			ExpresionAritmetica ex1 = esExpresionAritmetica();

			if (ex1 != null) {
				if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
					obtenerSiguienteToken();

					if (tokenActual.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
						Token operadorAritmetico = tokenActual;
						obtenerSiguienteToken();

						ExpresionAritmetica ex = esExpresionAritmetica();

						if (ex != null) {
							return new ExpresionAritmetica(ex1, operadorAritmetico, ex);
						} else {
							reportarError("Falta expresion aritmetica", tokenActual.getFila(),
									tokenActual.getColumna());
						}

					} else {
						return new ExpresionAritmetica(ex1);
					}
				} else {
					reportarError("Falta parentesis derecho", tokenActual.getFila(), tokenActual.getColumna());
				}
			} else {
				reportarError("Falta expresion aritmetica", tokenActual.getFila(), tokenActual.getColumna());
			}
		}

		return null;
	}

	/**
	 * Metodo que verifica si es un termino
	 * 
	 * <"Lista" {@link Termino}>::= <{@link Termino}> ["|" <"Lista"
	 * {@link Termino}>] <{@link Termino}>::= identificadorVariable |
	 * <{@link LlamadoFuncion}> | <{@link ValorAsignacion}> |
	 * <{@link ExpresionCadena}>
	 * 
	 * @return termino{@link Termino}
	 */
	private Termino esTermino() {
		if (tokenActual.getCategoria() == Categoria.ENTERO || tokenActual.getCategoria() == Categoria.REAL
				|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR
				|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE
				|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_METODO) {
			return new Termino(tokenActual);
		}

		return null;
	}

	/**
	 * Metodo que verifica si es un valor de asignacion
	 * 
	 * <{@link ValorAsignacion}>::= entero | real | caracter | cadena | booleano
	 * 
	 * @return valorAsignacion{@link ValorAsignacion}
	 */
	private ValorAsignacion esValorAsignacion() {
		return null;
	}

	/**
	 * Metodo que verifica si es un llamado a una funcion
	 * 
	 * <{@link LlamadoFuncion}>::= identificadorFuncion parentesisIzquierdo <"Lista"
	 * {@link Termino}> parentesisDerecho fin
	 * 
	 * @return llamadoFuncion{@link LlamadoFuncion}
	 */
	private LlamadoFuncion esLlamadoFuncion() {
		return null;
	}

	/**
	 * Metodo que verifica si es un ciclo
	 * 
	 * <{@link Ciclo}>::= ciclo mientras parentesisIzquierdo
	 * <{@link ExpresionLogica}> parentesisDerecho agrupadorIzquierdo <>
	 * 
	 * @return ciclo{@link Ciclo}
	 */
	private Ciclo esCiclo() {
		return null;
	}

	/**
	 * Metodo que verifica si es un retorno
	 * 
	 * <{@link Retorno}>::= devolver <{@link Termino}> fin
	 * 
	 * @return retorno {@link Retorno}
	 */
	private Retorno esRetorno() {
		return null;
	}

	/**
	 * Metodo que verifica si es una impresion
	 * 
	 * <{@link Impresion}>::= escribir parentesisIzquierdo <{@link} Termino}>
	 * parentesisDerecho fin
	 * 
	 * @return impresion{@link Impresion}
	 */
	private Impresion esImpresion() {
		return null;
	}

	/**
	 * Metodo que verifica si es una comcatenacion de cadena
	 * 
	 * <{@link ExpresionCadena}>::= <{@link} Termino}> [ (+)
	 * <{@link ExpresionCadena}> ] fin
	 * 
	 * @return expresionCadena{@link ExpresionCadena}
	 */
	private ExpresionCadena esExpresionCadena() {
		return null;
	}

	/**
	 * Metodo que verifica si es una sentencia de lectura
	 * 
	 * <{@link Lectura}>::= leer parentesisIzquierdo <{@link TipoDato}>
	 * parentesisDerecho fin
	 * 
	 * @return lectura{@link Lectura}
	 */
	private Lectura esLectura() {
		return null;
	}

	/**
	 * Metodo que identifica si es una declaracion de campo
	 * 
	 * <{@link DeclaracionVariable}>::= [<{@link Visibilidad}>] <{@link TipoDato}>
	 * [arreglo] identificadorVariable fin
	 * 
	 * @return declaracionnCampo{@link DeclaracionVariable}
	 */
	private DeclaracionVariable esDeclaracionVariable() {
		Token visibilidad = esVisibilidad();

		obtenerSiguienteToken();
		if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
			Token tipo = tokenActual;
			if (tokenActual.getLexema().equals("ntr") || tokenActual.getLexema().equals("pntdec")
					|| tokenActual.getLexema().equals("binary") || tokenActual.getLexema().equals("ltr")
					|| tokenActual.getLexema().equals("ltrarr")) {
				obtenerSiguienteToken();

				ArrayList<Token> listaId = esListaIdentificadores();

				if (listaId != null) {
					if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA
							&& tokenActual.getLexema().equals("fin")) {
						return visibilidad != null ? new DeclaracionVariable(visibilidad, tipo, tokenActual, listaId)
								: new DeclaracionVariable(tipo, tokenActual, listaId);
					} else {
						reportarError("No hay final de sentencia", tokenActual.getFila(), tokenActual.getColumna());
					}
				} else {
					reportarError("No hay una lista de sentencias", tokenActual.getFila(), tokenActual.getColumna());
				}
			} else {
				reportarError("No es un tipo de dato", tokenActual.getFila(), tokenActual.getColumna());
			}
		} else {
			reportarError("No hay palabra reservada", tokenActual.getFila(), tokenActual.getColumna());
		}
		return null;
	}

	/**
	 * Metodo que identifica si es una asignacion de variable
	 * 
	 * <{@link AsignacionVariable}>::= identificadorVariable operadorAsignacion
	 * <{@link ValorAsignacion}> fin
	 * 
	 * @return declaracionnCampo{@link DeclaracionVariable}
	 */
	private AsignacionVariable esAsignacionVariable() {
		int posInicial = posActual;
		if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
			Token tipo = tokenActual;
			obtenerSiguienteToken();

			if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE) {
				Token identificadorVariable = tokenActual;
				obtenerSiguienteToken();

				if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA
						&& !tokenActual.getLexema().equals("fin")) {
					Token asignador = tokenActual;
					obtenerSiguienteToken();

					if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR
							|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE
							|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_METODO) {
						Token identificador = tokenActual;
						obtenerSiguienteToken();
						if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
							return new AsignacionVariable(tipo, identificadorVariable, asignador, identificador,
									tokenActual);
						} else {
							reportarError("Falta fin de setencia", tokenActual.getFila(), tokenActual.getColumna());
						}
					} else {
						ExpresionAritmetica ex = esExpresionAritmetica();
						if (ex != null) {
							if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
								return new AsignacionVariable(tipo, identificadorVariable, asignador, ex, tokenActual);
							} else {
								reportarError("Falta fin de setencia", tokenActual.getFila(), tokenActual.getColumna());
							}
						} else {
							reportarError("Falta expresion aritmetica", tokenActual.getFila(),
									tokenActual.getColumna());
						}
					}
				} else {
					hacerBactracking(posInicial);
				}
			} else {
				hacerBactracking(posInicial);
			}
		} else if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE) {
			Token identificadorVariable = tokenActual;
			obtenerSiguienteToken();

			if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA && !tokenActual.getLexema().equals("fin")) {
				Token asignador = tokenActual;
				obtenerSiguienteToken();

				if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR
						|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE
						|| tokenActual.getCategoria() == Categoria.IDENTIFICADOR_METODO) {
					Token identificador = tokenActual;
					obtenerSiguienteToken();
					if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
						return new AsignacionVariable(identificadorVariable, asignador, identificador, tokenActual);
					} else {
						reportarError("Falta fin de setencia", tokenActual.getFila(), tokenActual.getColumna());
					}
				} else {
					ExpresionAritmetica ex = esExpresionAritmetica();
					if (ex != null) {
						if (tokenActual.getCategoria() == Categoria.PALABRA_RESERVADA) {
							return new AsignacionVariable(identificadorVariable, asignador, tokenActual, ex);
						} else {
							reportarError("Falta fin de setencia", tokenActual.getFila(), tokenActual.getColumna());
						}
					} else {
						reportarError("Falta expresion aritmetica", tokenActual.getFila(), tokenActual.getColumna());
					}
				}
			} else {
				hacerBactracking(posInicial);
			}
		} else {
			hacerBactracking(posInicial);
		}
		return null;
	}

	/**
	 * Metodo que identifica si es una sentencia de incremento
	 * 
	 * <{@link SentenciaIncremento}>::= identificadorVariable INC fin
	 * 
	 * @return sentenciaIncremento {@link SentenciaIncremento}
	 */
	private SentenciaIncremento esSentenciaIncremento() {
		return null;
	}

	/**
	 * Metodo que identifica si es una sentencia de decremento
	 * 
	 * <{@link SentenciaDecremento}>::= identificadorVariable DEC fin
	 * 
	 * @return sentenciaDecremento {@link SentenciaDecremento}
	 */
	private SentenciaIncremento esSentenciaDecremento() {
		return null;
	}

	/**
	 * Metodo para lista de identificadores
	 * 
	 * @return
	 */
	private ArrayList<Token> esListaIdentificadores() {
		ArrayList<Token> listaId = new ArrayList<>();

		if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE) {
			listaId.add(tokenActual);
			obtenerSiguienteToken();
			while (tokenActual.getCategoria() == Categoria.SEPARADOR) {
				obtenerSiguienteToken();
				if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE) {
					listaId.add(tokenActual);
					obtenerSiguienteToken();
				} else {
					reportarError("Falta identificador", tokenActual.getFila(), tokenActual.getColumna());
				}
			}
			return listaId.size() > 0 ? listaId : null;
		}
		return null;
	}

	/**
	 * Obtiene el siguiente token del la lista de codigos
	 */
	public void obtenerSiguienteToken() {
		if (posActual < tablaSimbolos.size() - 1) {
			posActual++;
			tokenActual = tablaSimbolos.get(posActual);
		} else {
			tokenActual = new Token("", 0, 0, Categoria.FIN_CODIGO);
		}
	}

	/**
	 * Metodo para volver a una instancia anterior del codigo
	 * 
	 * @param posInicial:
	 *            posicion donde se inicio el analisis
	 */
	public void hacerBactracking(int posInicial) {
		posActual = posInicial;
		tokenActual = tablaSimbolos.get(posActual);
	}

	/**
	 * Metodo para reportar un error sintactico
	 * 
	 * @param mensaje:
	 *            El mensaje con el error
	 * @param fila:
	 *            fila del error
	 * @param columna:
	 *            columna del error
	 */
	private void reportarError(String mensaje, int fila, int columna) {
		tablaErrores.add(new ErrorSintactico(mensaje, fila, columna));
	}

	/**
	 * @return the tablaSimbolos
	 */
	public ArrayList<Token> getTablaSimbolos() {
		return tablaSimbolos;
	}

	/**
	 * @param tablaSimbolos
	 *            the tablaSimbolos to set
	 */
	public void setTablaSimbolos(ArrayList<Token> tablaSimbolos) {
		this.tablaSimbolos = tablaSimbolos;
	}

	/**
	 * @return the tablaErrores
	 */
	public ArrayList<ErrorSintactico> getTablaErrores() {
		return tablaErrores;
	}

	/**
	 * @param tablaErrores
	 *            the tablaErrores to set
	 */
	public void setTablaErrores(ArrayList<ErrorSintactico> tablaErrores) {
		this.tablaErrores = tablaErrores;
	}

}
