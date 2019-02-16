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
		setUnidadCompilacion(esUnidadDeCompilacion());
		if (unidadCompilacion != null) {
			tablaErrores.clear();
		}
	}

	/**
	 * Metodo que verifica si es unidad de compilacion
	 * 
	 * <{@link UnidadCompilacion}>::= clase identificadorClase grupadorIzquierdo
	 * <{@link CuerpoClase}> agrupadorDerechoa
	 * 
	 * @return unidadDeCompilacion{@link UnidadCompilacion}
	 */
	private UnidadCompilacion esUnidadDeCompilacion() {
		UnidadCompilacion unidadCompilacion;

		if (tokenActual.getLexema().equals("clase")) {
			Token clase = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_CLASE)) {
				Token identificadorClase = tokenActual;
				obtenerSiguienteToken();
				if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_IZQUIERDO)) {
					obtenerSiguienteToken();
					CuerpoClase cuerpoClase = esCuerpoClase();
					if (cuerpoClase != null) {
						if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_DERECHO)) {
							unidadCompilacion = new UnidadCompilacion(clase, identificadorClase, cuerpoClase);
							return unidadCompilacion;
						} else {
							reportarError("Falta agrupador derecho", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta cuerpo de clase", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta agrupador izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta identificador de clase", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}

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
		int posInicial = posActual;
		Funcion funcion = esFuncion();
		if (funcion != null) {
			obtenerSiguienteToken();
			CuerpoClase cuerpoClase = esCuerpoClase();
			if (cuerpoClase != null) {
				return new CuerpoClase(funcion, cuerpoClase);
			} else {
				return new CuerpoClase(funcion);
			}
		} else {
			hacerBactracking(posInicial);
			DeclaracionVariable declaracionVariable = esDeclaracionVariable();
			if (declaracionVariable != null) {
				obtenerSiguienteToken();
				CuerpoClase cuerpoClase1 = esCuerpoClase();
				if (cuerpoClase1 != null) {
					return new CuerpoClase(declaracionVariable, cuerpoClase1);
				} else {
					return new CuerpoClase(declaracionVariable);
				}
			}
		}
		return null;
	}

	/**
	 * Metodo que verifica si es una funcion
	 * 
	 * <{@link Funcion}>::= visibilidad <{@link TipoRetorno}> funapp
	 * identificadorFuncion parentesisIzquierdo <"Lista"{@link Parametro}>
	 * parentesisDerecho agrupadorIzquierdo <"Lista" {@link Sentencia}>
	 * agrupadorDerecho
	 * 
	 * @return funcion{@link Funcion}
	 */
	private Funcion esFuncion() {

		Token visibilidad = esVisibilidad();
		if (visibilidad != null) {
			obtenerSiguienteToken();
			TipoRetorno tipoRetorno = esTipoRetorno();
			if (tipoRetorno != null) {
				obtenerSiguienteToken();
				if (tokenActual.getLexema().equals("funapp")) {
					Token funcion = tokenActual;
					obtenerSiguienteToken();
					if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_METODO) {
						Token idFuncion = tokenActual;
						obtenerSiguienteToken();
						if (tokenActual.getCategoria() == Categoria.PARENTESIS_IZQUIERDO) {
							obtenerSiguienteToken();
							ArrayList<Parametro> listaParametros = esListaParametro();
							if (listaParametros != null) {
								if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
									obtenerSiguienteToken();
									if (tokenActual.getCategoria() == Categoria.AGRUPADOR_IZQUIERDO) {
										obtenerSiguienteToken();
										ArrayList<Sentencia> listaSentencias = esListaSentencia();
										if (listaSentencias != null) {
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, funcion,
														listaParametros, listaSentencias);
											}
										} else {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, listaParametros,
														funcion);
											} else {
												reportarError("Falta Agrupador Derecho", tokenActual.getFila(),
														tokenActual.getColumna(), tokenActual.getColumnaReal());
											}
										}
									} else {
										reportarError("Falta Agrupador Izquierdo", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}
								} else {
									reportarError("Falta parentesis derecho", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}
							} else {
								if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
									obtenerSiguienteToken();
									if (tokenActual.getCategoria() == Categoria.AGRUPADOR_IZQUIERDO) {
										obtenerSiguienteToken();
										ArrayList<Sentencia> listaSentencias = esListaSentencia();
										if (listaSentencias != null) {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, funcion,
														listaParametros, listaSentencias);
											}
										} else {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, listaParametros,
														funcion);
											} else {
												reportarError("Falta Agrupador Derecho", tokenActual.getFila(),
														tokenActual.getColumna(), tokenActual.getColumnaReal());
											}
										}
									} else {
										reportarError("Falta Agrupador Izquierdo", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}
								} else {
									reportarError("Falta parentesis derecho", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}
							}
						} else {
							reportarError("Falta Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta Identificador Metodo", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta La Palabra Reservada funapp", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta Tipo De Retorno", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		} else {
			TipoRetorno tipoRetorno = esTipoRetorno();
			if (tipoRetorno != null) {
				obtenerSiguienteToken();
				if (tokenActual.getLexema().equals("funapp")) {
					Token funcion = tokenActual;
					obtenerSiguienteToken();
					if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_METODO) {
						Token idFuncion = tokenActual;
						obtenerSiguienteToken();
						if (tokenActual.getCategoria() == Categoria.PARENTESIS_IZQUIERDO) {
							obtenerSiguienteToken();
							ArrayList<Parametro> listaParametros = esListaParametro();
							if (listaParametros != null) {
								obtenerSiguienteToken();
								if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
									obtenerSiguienteToken();
									if (tokenActual.getCategoria() == Categoria.AGRUPADOR_IZQUIERDO) {
										obtenerSiguienteToken();
										ArrayList<Sentencia> listaSentencias = esListaSentencia();
										if (listaSentencias != null) {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, funcion,
														listaParametros, listaSentencias);
											}
										} else {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, listaParametros,
														funcion);
											} else {
												reportarError("Falta Agrupador Derecho", tokenActual.getFila(),
														tokenActual.getColumna(), tokenActual.getColumnaReal());
											}
										}
									} else {
										reportarError("Falta Agrupador Izquierdo", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}
								} else {
									reportarError("Falta parentesis derecho", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}
							} else {
								if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
									obtenerSiguienteToken();
									if (tokenActual.getCategoria() == Categoria.AGRUPADOR_IZQUIERDO) {
										obtenerSiguienteToken();
										ArrayList<Sentencia> listaSentencias = esListaSentencia();
										if (listaSentencias != null) {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, funcion,
														listaParametros, listaSentencias);
											}
										} else {
											obtenerSiguienteToken();
											if (tokenActual.getCategoria() == Categoria.AGRUPADOR_DERECHO) {
												return new Funcion(visibilidad, tipoRetorno, idFuncion, listaParametros,
														funcion);
											} else {
												reportarError("Falta Agrupador Derecho", tokenActual.getFila(),
														tokenActual.getColumna(), tokenActual.getColumnaReal());
											}
										}
									} else {
										reportarError("Falta Agrupador Izquierdo", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}
								} else {
									reportarError("Falta parentesis derecho", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}
							}
						} else {
							reportarError("Falta Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta Identificador Metodo", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta La Palabra Reservada funapp", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta Tipo De Retorno", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
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
		Token retorno = esTipoDato();
		if (retorno != null) {
			return new TipoRetorno(retorno);
		} else if (tokenActual.getLexema().equals("sr")) {
			return new TipoRetorno(tokenActual);
		}
		return null;
	}

	/**
	 * Metodo que verifica si es un tipo de dato
	 * 
	 * <{@link TipoDato}>::= ntr | ltr | ltrarr | binary | pntdec
	 * 
	 * @return tipoDato{@link TipoDato}
	 */
	private Token esTipoDato() {
		if (tokenActual.getLexema().equals("ltr") || tokenActual.getLexema().equals("ntr")
				|| tokenActual.getLexema().equals("ltrarr") || tokenActual.getLexema().equals("pntdec")
				|| tokenActual.getLexema().equals("binary")) {
			return tokenActual;
		}
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

		Parametro parametro;
		int posInicial = posActual;

		Token tipoDatp = esTipoDato();
		if (tipoDatp != null) {
			Token tipoDato = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getLexema().equals("$arr()")) {
				Token arr = tokenActual;
				obtenerSiguienteToken();

				if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
					parametro = new Parametro(tipoDato, arr, tokenActual);
					return parametro;
				} else {
					reportarError("Debe seguir identificador de variable", tokenActual.getFila(),
							tokenActual.getColumna(), tokenActual.getColumnaReal());
				}
			} else if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
				parametro = new Parametro(tipoDato, tokenActual);
				return parametro;
			} else {
				hacerBactracking(posInicial);
			}
		}
		return null;
	}

	/**
	 * Metodo que verifica si es una sentencia
	 * 
	 * <"List"{@link Sentencia}>::= <{@link Sentencia}>[<"List"{@link Sentencia}>]
	 * <{@link Sentencia}>::= <{@link Condicional}> | <{@link Ciclo}> |
	 * <{@link Retorno}> | <{@link Impresion}> | <{@link Lectura}> |
	 * <{@link DeclaracionVariable}> | <{@link AsignacionVariable}> |
	 * <{@link SentenciaIncremento}> | <{@link SentenciDecremento}>|
	 * <{@link LlamadoFuncion}>
	 * 
	 * @return sentencia{@link Sentencia}
	 */
	private Sentencia esSentencia() {
		int posInicial = posActual;
		Sentencia sentencia;

		sentencia = esCondicional();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esCiclo();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esRetorno();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esImpresion();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esLectura();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esDeclaracionVariable();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esAsignacionVariable();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esSentenciaIncremento();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esSentenciaDecremento();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esLlamadoFuncion();
		if (sentencia != null) {
			return sentencia;
		}
		hacerBactracking(posInicial);

		sentencia = esRetorno();
		if (sentencia != null) {
			return sentencia;
		}

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

		Condicional condicional;

		if (tokenActual.getLexema().equals("pregunta")) {
			Token pregunta = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_IZQUIERDO)) {
				obtenerSiguienteToken();
				ExpresionLogica expresionLogica = esExpresionLogica();

				if (expresionLogica != null) {

					if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
						obtenerSiguienteToken();

						if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_IZQUIERDO)) {
							obtenerSiguienteToken();

							ArrayList<Sentencia> listaSentencia = esListaSentencia(); // lista sentencia

							if (listaSentencia != null) {

								if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_DERECHO)) {
									obtenerSiguienteToken();

									if (tokenActual.getLexema().equals("contrario")) {
										Token contrario = tokenActual;
										obtenerSiguienteToken();
										if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_IZQUIERDO)) {
											obtenerSiguienteToken();

											ArrayList<Sentencia> listaSentencia1 = esListaSentencia(); // lista
																										// sentencia

											if (listaSentencia1 != null) {
												obtenerSiguienteToken();

												if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_DERECHO)) {
													condicional = new Condicional(pregunta, expresionLogica,
															listaSentencia, contrario, listaSentencia1);
													return condicional;
												} else {
													reportarError("Falta agrupador derecho", tokenActual.getFila(),
															tokenActual.getColumna(), tokenActual.getColumnaReal());
												}
											} else {
												reportarError("Falta lista sentencia", tokenActual.getFila(),
														tokenActual.getColumna(), tokenActual.getColumnaReal());
											}
										} else {
											reportarError("Falta agrupador izquierdo", tokenActual.getFila(),
													tokenActual.getColumna(), tokenActual.getColumnaReal());
										}

									} else {

										condicional = new Condicional(pregunta, expresionLogica, listaSentencia);
										hacerBactracking(posActual - 1);
										return condicional;

									}

								} else {
									reportarError("Falta agrupador derecho", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}

							} else {
								reportarError("Falta lista sentencia", tokenActual.getFila(), tokenActual.getColumna(),
										tokenActual.getColumnaReal());
							}

						} else {
							reportarError("Falta agrupador izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta parentesis derecho", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}

				} else {
					reportarError("Falta expresion logica", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta parentesis izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}

		return null;
	}

	/**
	 * Metodo que verifica si es una expresion
	 * 
	 * <{@link Expresion}> ::= <{@link ExpresionLogica}> |
	 * <{@link ExpresionRelacional}> | <{@link ExpresionRelacional}>
	 * 
	 * @return expresion{@link Expresion}
	 */
	private Expresion esExpresion() {
		int posInicial = posActual;

		Expresion expresion = esExpresionLogica();
		if (expresion != null) {
			return expresion;
		}
		hacerBactracking(posInicial);

		expresion = esExpresionRelacional();
		if (expresion != null) {
			return expresion;
		}
		hacerBactracking(posInicial);

		expresion = esExpresionAritmetica();
		if (expresion != null) {
			return expresion;
		}
		hacerBactracking(posInicial);

		expresion = esExpresionCadena();
		if (expresion != null) {
			return expresion;
		}

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
		int posInicial = posActual;

		ExpresionRelacional expresionRelacional = esExpresionRelacional();
		if (expresionRelacional != null) {

			if (tokenActual.getCategoria().equals(Categoria.OPERADOR_LOGICO)) {
				Token opLogico = tokenActual;
				obtenerSiguienteToken();

				ExpresionLogica expresionLogica = esExpresionLogica();
				if (expresionLogica != null) {
					return new ExpresionLogica(expresionRelacional, opLogico, expresionLogica);
				} else {
					reportarError("Falta expresión lógica", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}

			} else {
				return new ExpresionLogica(expresionRelacional);
			}

		} else {
			hacerBactracking(posInicial);
			if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_IZQUIERDO)) {
				obtenerSiguienteToken();

				ExpresionLogica expresionLogica = esExpresionLogica();
				if (expresionLogica != null) {
					obtenerSiguienteToken();

					if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
						return expresionLogica;
					} else {
						reportarError("Falta parentesis derecho", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta expresión lógica", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			}
		}
		return null;
	}

	/**
	 * Metodo que verifica si es una expresion relacional
	 * 
	 * <{@link ExpresionRelacional}>::= <{@link ExpresionAritmetica}>
	 * [operadorRelacional <{@link ExpresionRelacional}>] | parentesisIzquierdo
	 * <{@link ExpresionRelacional}> parentesisDerecho
	 * 
	 * @return expresionLogica{@link ExpresionRelacional}
	 */
	private ExpresionRelacional esExpresionRelacional() {
		int posInicial = posActual;
		ExpresionAritmetica expresionAritmetica = esExpresionAritmetica();
		if (expresionAritmetica != null) {
			if (tokenActual.getCategoria() == Categoria.OPERADOR_RELACIONAL) {
				Token opeRelacional = tokenActual;
				obtenerSiguienteToken();
				ExpresionRelacional expresionRelacional = esExpresionRelacional();
				if (expresionRelacional != null) {
					return new ExpresionRelacional(expresionAritmetica, opeRelacional, expresionRelacional);
				} else {
					reportarError("Falta Expresion Relacional", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				return new ExpresionRelacional(expresionAritmetica);
			}
		} else {
			hacerBactracking(posInicial);
			if (tokenActual.getCategoria() == Categoria.PARENTESIS_IZQUIERDO) {
				obtenerSiguienteToken();
				ExpresionRelacional expRelacional = esExpresionRelacional();
				obtenerSiguienteToken();
				if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
					return new ExpresionRelacional(expRelacional);
				} else {
					reportarError("Falta Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta Parentesis Izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
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

		if (tokenActual.getCategoria() == Categoria.PARENTESIS_IZQUIERDO) {
			obtenerSiguienteToken();
			Termino termino = esTermino();
			if (termino != null) {
				obtenerSiguienteToken();
				if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
					obtenerSiguienteToken();
					Token opeAritmetico = tokenActual;
					if (opeAritmetico.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
						obtenerSiguienteToken();
						ExpresionAritmetica expAritmetica = esExpresionAritmetica();
						if (expAritmetica != null) {
							return new ExpresionAritmetica(termino, opeAritmetico, expAritmetica);
						} else {
							reportarError("Falta Expresion Aritmetica", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						return new ExpresionAritmetica(termino);
					}
				} else {
					reportarError("Falta Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				ExpresionAritmetica expresionAritmetica = esExpresionAritmetica();
				if (expresionAritmetica != null) {
					obtenerSiguienteToken();
					if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
						return new ExpresionAritmetica(expresionAritmetica);
					} else {
						reportarError("Falta Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta Expresion Aritmetica O Termino", tokenActual.getFila(),
							tokenActual.getColumna(), tokenActual.getColumnaReal());
				}
			}
		} else {
			Termino termino = esTermino();
			if (termino != null) {
				obtenerSiguienteToken();
				Token opArt = tokenActual;
				if (opArt.getCategoria() == Categoria.OPERADOR_ARITMETICO) {
					obtenerSiguienteToken();
					ExpresionAritmetica expresionAritmetica = esExpresionAritmetica();
					if (expresionAritmetica != null) {
						return new ExpresionAritmetica(termino, opArt, expresionAritmetica);
					} else {
						reportarError("Falta Expresion Aritmetica", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					return new ExpresionAritmetica(termino);
				}
			} else {
				reportarError("Falta Termino", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
		return null;
	}

	/**
	 * Metodo que verifica si es un termino
	 * 
	 * <"Lista" {@link Termino}>::= <{@link Termino}> ["|" <"Lista"
	 * {@link Termino}>] <{@link Termino}>::= identificadorVariable |
	 * <{@link LlamadoFuncion}> | <{@link ValorAsignacion}> | <{@link Expresion}>
	 * 
	 * @return termino{@link Termino}
	 */
	private Termino esTermino() {
		if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
			return new Termino(tokenActual);
		}

		LlamadoFuncion llamadoFuncion = esLlamadoFuncion();
		if (llamadoFuncion != null) {
			return new Termino(llamadoFuncion);
		}

		ValorAsignacion valorAsignacion = esValorAsignacion();
		if (valorAsignacion != null) {
			return new Termino(valorAsignacion);
		}

		Expresion expresion = esExpresion();
		if (expresion != null) {
			return new Termino(expresion);
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

		if (tokenActual.getCategoria() == Categoria.ENTERO || tokenActual.getCategoria() == Categoria.REAL
				|| tokenActual.getCategoria() == Categoria.CARACTER
				|| tokenActual.getCategoria() == Categoria.CADENA_CARACTERES || tokenActual.getLexema().equals("v")
				|| tokenActual.getLexema().equals("f")) {
			return new ValorAsignacion(tokenActual);
		}
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

		if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_METODO)) {
			Token identificadorFuncion = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_IZQUIERDO)) {
				obtenerSiguienteToken();
				ArrayList<Termino> listaArgumentos = esListaArgumento();
				if (listaArgumentos != null) {
					obtenerSiguienteToken();

					if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
						return new LlamadoFuncion(identificadorFuncion);
					} else {
						reportarError("Debe seguir parentesis derecho o lista de terminos", tokenActual.getFila(),
								tokenActual.getColumna(), tokenActual.getColumnaReal());
					}
				} else if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
					return new LlamadoFuncion(identificadorFuncion, listaArgumentos);
				} else {
					reportarError("Debe seguir parentesis derecho o lista de terminos", tokenActual.getFila(),
							tokenActual.getColumna(), tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta parentesisIzquierdo", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
		return null;
	}

	/**
	 * Metodo que verifica si es un ciclo
	 * 
	 * <{@link Ciclo}>::= ciclo mientras parentesisIzquierdo
	 * <{@link ExpresionLogica}> parentesisDerecho agrupadorIzquierdo
	 * [<"List"{@link Sentencia}>] agrupadorDerecho
	 * 
	 * @return ciclo{@link Ciclo}
	 */
	private Ciclo esCiclo() {

		if (tokenActual.getLexema().equals("ciclo")) {
			Token ciclo = tokenActual;
			obtenerSiguienteToken();

			if (tokenActual.getLexema().equals("mientras")) {
				Token mientras = tokenActual;
				obtenerSiguienteToken();
				if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_IZQUIERDO)) {
					obtenerSiguienteToken();

					ExpresionLogica expresionLogica = esExpresionLogica();
					if (expresionLogica != null) {
						if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
							obtenerSiguienteToken();

							if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_IZQUIERDO)) {
								obtenerSiguienteToken();

								ArrayList<Sentencia> listaSentencia = esListaSentencia();
								if (listaSentencia != null) {
									if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_DERECHO)) {
										return new Ciclo(ciclo, mientras, expresionLogica);
									} else {
										reportarError("Falta agrupador derecho", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}

								} else {
									if (tokenActual.getCategoria().equals(Categoria.AGRUPADOR_DERECHO)) {

									} else {
										reportarError("Falta agrupador derecho", tokenActual.getFila(),
												tokenActual.getColumna(), tokenActual.getColumnaReal());
									}
								}
							} else {
								reportarError("Falta agrupador izquierdo", tokenActual.getFila(),
										tokenActual.getColumna(), tokenActual.getColumnaReal());
							}
						} else {
							reportarError("Falta parentesis derecho", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {

					}

				} else {
					reportarError("Falta parentesis izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta palabrea reserrvada mientras", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
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
		if (tokenActual.getLexema().equals("devolver")) {
			Token retorno = tokenActual;
			obtenerSiguienteToken();

			int posInicial = posActual;
			Termino termino = esTermino();
			if (termino != null) {
				obtenerSiguienteToken();

				if (tokenActual.getLexema().equals("fin")) {
					return new Retorno(retorno, termino);
				} else {
					hacerBactracking(posInicial);
					Expresion expresion = esExpresion();

					if (expresion != null) {
						if (tokenActual.getLexema().equals("fin")) {
							return new Retorno(retorno, new Termino(expresion));
						} else {
							reportarError("Fala fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Fala fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				}
			} else {
				reportarError("Fala el termino a devolver", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
		return null;

	}

	/**
	 * Metodo que verifica si es una impresion
	 * 
	 * <{@link Impresion}>::= imprimir parentesisIzquierdo <{@link} Termino}>
	 * parentesisDerecho fin
	 * 
	 * @return impresion{@link Impresion}
	 */
	private Impresion esImpresion() {

		Token escribir = tokenActual;
		if (escribir.getLexema().equals("imprimir")) {
			obtenerSiguienteToken();
			if (tokenActual.getCategoria() == Categoria.PARENTESIS_IZQUIERDO) {
				obtenerSiguienteToken();
				Termino termino = esTermino();
				if (termino != null) {
					obtenerSiguienteToken();
					if (tokenActual.getCategoria() == Categoria.PARENTESIS_DERECHO) {
						obtenerSiguienteToken();
						if (tokenActual.getLexema().equals("fin")) {
							return new Impresion(escribir, termino);
						} else {
							reportarError("Falta la sentencia Fin", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta el Parentesis Derecho", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta el termino", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta el Parentesis Izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		} else {
			reportarError("Falta la sentencia escribir", tokenActual.getFila(), tokenActual.getColumna(),
					tokenActual.getColumnaReal());
		}
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

		Termino termino = esTermino();

		if (termino != null) {
			obtenerSiguienteToken();
			if (tokenActual.getLexema().equals("(+)")) {
				ExpresionCadena expresionCadena = esExpresionCadena();
				if (expresionCadena != null) {
					obtenerSiguienteToken();
					if (tokenActual.getLexema().equals("fin")) {
						return new ExpresionCadena(termino, expresionCadena);
					} else {
						reportarError("Falta palabra fin", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta expresion cadena", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}

			} else if (tokenActual.getLexema().equals("fin")) {
				return new ExpresionCadena(termino);
			} else {
				reportarError("Falta fin o (+)", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}

		}

		return null;
	}

	/**
	 * Metodo que verifica si es una sentencia de lectura
	 * 
	 * <{@link Lectura}>::= idVariable operadorAsignacion leer parentesisIzquierdo
	 * <{@link TipoDato}> parentesisDerecho fin
	 * 
	 * @return lectura{@link Lectura}
	 */
	private Lectura esLectura() {
		if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
			Token idVariable = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getCategoria().equals(Categoria.OPERADOR_ASIGNACION)) {
				Token opAsignacion = tokenActual;
				obtenerSiguienteToken();
				if (tokenActual.getLexema().equals("leer")) {
					Token leer = tokenActual;
					obtenerSiguienteToken();
					if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_IZQUIERDO)) {
						obtenerSiguienteToken();

						Token tipoDato = esTipoDato();
						if (tipoDato != null) {
							obtenerSiguienteToken();
							if (tokenActual.getCategoria().equals(Categoria.PARENTESIS_DERECHO)) {
								obtenerSiguienteToken();
								if (tokenActual.getLexema().equals("fin")) {
									return new Lectura(idVariable, opAsignacion, leer, tipoDato);
								} else {
									reportarError("Falta fin de sentencia", tokenActual.getFila(),
											tokenActual.getColumna(), tokenActual.getColumnaReal());
								}
							} else {
								reportarError("Falta parentesis derecho", tokenActual.getFila(),
										tokenActual.getColumna(), tokenActual.getColumnaReal());
							}
						} else {
							reportarError("Falta tipo de dato", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta parentesis izquierdo", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta la palabra reservada leer", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta operador de asignacion", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
		return null;
	}

	/**
	 * Metodo que identifica si es una declaracion de campo
	 * 
	 * <{@link DeclaracionVariable}>::= [<{@link Visibilidad}>] tipoDato [arreglo]
	 * lista identificadorVariable fin
	 * 
	 * @return declaracionnCampo{@link DeclaracionVariable}
	 */
	private DeclaracionVariable esDeclaracionVariable() {
		Token visibilidad = esVisibilidad();
		if (visibilidad != null) {
			obtenerSiguienteToken();

			Token tipoDato = esTipoDato();
			if (tipoDato != null) {
				obtenerSiguienteToken();

				if (tokenActual.getCategoria().equals(Categoria.ARREGLO)) {
					Token arreglo = tokenActual;
					obtenerSiguienteToken();

					ArrayList<Token> listaIdentificador = esListaIdentificadores();
					if (listaIdentificador != null) {

						if (tokenActual.getLexema().equals("fin")) {
							return new DeclaracionVariable(visibilidad, tipoDato, arreglo, listaIdentificador);
						} else {
							reportarError("Falta fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta algun identificador", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					ArrayList<Token> listaIdentificador = esListaIdentificadores();
					if (listaIdentificador != null) {

						if (tokenActual.getLexema().equals("fin")) {
							return new DeclaracionVariable(visibilidad, tipoDato, listaIdentificador);
						} else {
							reportarError("Falta fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta algun identificador", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				}
			} else {
				reportarError("Falta el tipo de dato", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		} else {
			Token tipoDato = esTipoDato();
			if (tipoDato != null) {
				obtenerSiguienteToken();

				if (tokenActual.getCategoria().equals(Categoria.ARREGLO)) {
					Token arreglo = tokenActual;
					obtenerSiguienteToken();

					ArrayList<Token> listaIdentificador = esListaIdentificadores();
					if (listaIdentificador != null) {

						if (tokenActual.getLexema().equals("fin")) {
							return new DeclaracionVariable(arreglo, listaIdentificador, tipoDato);
						} else {
							reportarError("Falta fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta algun identificador", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					ArrayList<Token> listaIdentificador = esListaIdentificadores();
					if (listaIdentificador != null) {

						if (tokenActual.getLexema().equals("fin")) {
							return new DeclaracionVariable(tipoDato, listaIdentificador);
						} else {
							reportarError("Falta fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
									tokenActual.getColumnaReal());
						}
					} else {
						reportarError("Falta algun identificador", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				}
			} else {
				reportarError("Falta el tipo de dato", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}
		return null;
	}

	/**
	 * Metodo que identifica si es una asignacion de variable
	 * 
	 * <{@link AsignacionVariable}>::= identificadorVariable operadorAsignacion
	 * <{@link Termino}> fin
	 * 
	 * @return declaracionnCampo{@link DeclaracionVariable}
	 */
	private AsignacionVariable esAsignacionVariable() {
		if (tokenActual.getCategoria() == Categoria.IDENTIFICADOR_VARIABLE) {
			Token identificador = tokenActual;
			obtenerSiguienteToken();

			if (tokenActual.getCategoria() == Categoria.OPERADOR_ASIGNACION) {
				Token operadorAsignacion = tokenActual;
				obtenerSiguienteToken();

				Termino termino = esTermino();
				if (termino != null) {
					obtenerSiguienteToken();
					if (tokenActual.getLexema().equals("fin")) {
						return new AsignacionVariable(identificador, operadorAsignacion, termino);
					} else {
						reportarError("Falta fin de sentencia", tokenActual.getFila(), tokenActual.getColumna(),
								tokenActual.getColumnaReal());
					}
				} else {
					reportarError("Falta termino", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta operador asignación", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
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

		if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
			Token indentificadorVariable = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getLexema().equals("INC")) {
				Token incremento = tokenActual;
				obtenerSiguienteToken();
				if (tokenActual.getLexema().equals("fin")) {
					return new SentenciaIncremento(indentificadorVariable, incremento);
				} else {
					reportarError("Falta Fin", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta incremento inc", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}

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
		if (tokenActual.getCategoria().equals(Categoria.IDENTIFICADOR_VARIABLE)) {
			Token indentificadorVariable = tokenActual;
			obtenerSiguienteToken();
			if (tokenActual.getLexema().equals("DEC")) {
				Token incremento = tokenActual;
				obtenerSiguienteToken();
				if (tokenActual.getLexema().equals("fin")) {
					return new SentenciaIncremento(indentificadorVariable, incremento);
				} else {
					reportarError("Falta Fin", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			} else {
				reportarError("Falta decremento dec", tokenActual.getFila(), tokenActual.getColumna(),
						tokenActual.getColumnaReal());
			}
		}

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
					reportarError("Falta identificador", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			}
			return listaId.size() > 0 ? listaId : null;
		}
		return null;
	}

	/**
	 * Metodo para lista de parametros
	 * 
	 * @return
	 */
	private ArrayList<Parametro> esListaParametro() {
		ArrayList<Parametro> listaParametro = new ArrayList<>();

		Parametro parametro = esParametro();
		if (parametro != null) {
			listaParametro.add(parametro);
			obtenerSiguienteToken();

			while (tokenActual.getCategoria() == Categoria.SEPARADOR) {
				obtenerSiguienteToken();
				Parametro parametro0 = esParametro();
				if (parametro0 != null) {
					listaParametro.add(parametro0);
					obtenerSiguienteToken();
				} else {
					reportarError("Falta parametro", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			}
			return listaParametro.size() > 0 ? listaParametro : null;
		}
		return null;
	}

	/**
	 * Metodo para lista de parametros
	 * 
	 * @return
	 */
	private ArrayList<Termino> esListaArgumento() {
		ArrayList<Termino> listaArgumento = new ArrayList<>();

		Termino termino = esTermino();
		if (termino != null) {
			listaArgumento.add(termino);
			obtenerSiguienteToken();

			while (tokenActual.getCategoria() == Categoria.SEPARADOR) {
				obtenerSiguienteToken();
				Termino termino0 = esTermino();
				if (termino0 != null) {
					listaArgumento.add(termino0);
					obtenerSiguienteToken();
				} else {
					reportarError("Falta parametro", tokenActual.getFila(), tokenActual.getColumna(),
							tokenActual.getColumnaReal());
				}
			}
			return listaArgumento.size() > 0 ? listaArgumento : null;
		}
		return null;
	}

	/**
	 * Método para identificar una lista de sentencias
	 * 
	 * @return
	 */
	private ArrayList<Sentencia> esListaSentencia() {
		ArrayList<Sentencia> listaSentencia = new ArrayList<>();

		while (true) {
			Sentencia sentencia = esSentencia();
			if (sentencia != null) {
				listaSentencia.add(sentencia);
				obtenerSiguienteToken();
			} else {
				break;
			}
		}
		return listaSentencia.size() > 0 ? listaSentencia : null;
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
	private void reportarError(String mensaje, int fila, int columna, int columnaReal) {
		tablaErrores.add(new ErrorSintactico(mensaje, fila, columna, columnaReal));
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

	public UnidadCompilacion getUnidadCompilacion() {
		return unidadCompilacion;
	}

	public void setUnidadCompilacion(UnidadCompilacion unidadCompilacion) {
		this.unidadCompilacion = unidadCompilacion;
	}

}
