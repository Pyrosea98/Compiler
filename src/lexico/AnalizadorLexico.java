package lexico;

import java.util.ArrayList;

/**
 * Clase que permite realizar un analisis lexico en el codigo fuente
 * 
 * @author Juan Jose Alvarez Orozco
 * @Author Daniel Beltran Gomez
 * @author Tatiana Salazar
 */
public class AnalizadorLexico {
	private String codigoFuente;
	private char charActual, finCodigo;
	private int posActual, colActual, filaActual;
	private ArrayList<Token> tablaSimbolos, tablaErrores;
	private ArrayList<String> reservedWords;

	/**
	 *
	 * @param codigoFuente
	 *            el codigo fuente a analizar
	 */
	public AnalizadorLexico(String codigoFuente) {

		this.codigoFuente = codigoFuente;
		this.charActual = codigoFuente.charAt(0);
		this.tablaSimbolos = new ArrayList<>();
		this.tablaErrores = new ArrayList<>();
		this.reservedWords = new ArrayList<>();
		this.finCodigo = 0;
		llenarPalabras();
	}

	/**
	 * Metodo que almacena las palabras reservadas
	 */
	private void llenarPalabras() {
		// palabra reservada para indicar una clase
		reservedWords.add("clase");
		//palabra para indicar un metodo
		reservedWords.add("funapp");
		// palabras reservadas para visibilidad
		reservedWords.add("visible");
		reservedWords.add("oculto");
		// palabra reservada para indicar un metodo
		reservedWords.add("funaapp");
		// palabras reservadas de tipos de dato o retorno
		reservedWords.add("ltr");
		reservedWords.add("ltrarr");
		reservedWords.add("binary");
		reservedWords.add("pntdec");
		reservedWords.add("ntr");
		reservedWords.add("sr");
		// palabras reservadas para valores booleanos
		reservedWords.add("v");
		reservedWords.add("f");
		// palabra reservada para fin de sentencia
		reservedWords.add("fin");
		// palabra reservada para incrementar o decrementar variables numericas
		reservedWords.add("inc");
		reservedWords.add("dec");
		// palabras reservadas para ciclo
		reservedWords.add("ciclo");
		reservedWords.add("mientras");
		// Palabras para sentencia condicional
		reservedWords.add("pregunta");
		reservedWords.add("contrario");
		// Identificar arreglo
		reservedWords.add("$arr()");
		// Retorno
		reservedWords.add("devolver");
		// Lectura y escritura
		reservedWords.add("leer");
		reservedWords.add("imprimir");
	}

	/**
	 * Metodo general para analizar con metodos de predicado
	 */
	public void analizar() {

		while (charActual != finCodigo) {
			if (charActual == ' ' || charActual == '\n' || charActual == '\t' || charActual == '\r') {
				obtenerSiguienteCaracter();
				continue;
			}
			if (esEntero())
				continue;
			if (esReal())
				continue;
			if (esCadenaCaracteres())
				continue;
			if (esComentarioLinea())
				continue;
			if (esOperadorRelacional())
				continue;
			if (esComentarioBloque())
				continue;
			if (esIdentificadorVariable())
				continue;
			if (esIdentificadorMetodo())
				continue;
			if (esIdentificadorClase())
				continue;
			if (esOperadorLogico())
				continue;
			if (esOperadorAsignacion())
				continue;
			if (esOperadorAritmetico())
				continue;
			if (esCaracter())
				continue;
			if (esAgrupadorIzquierdo())
				continue;
			if (esAgrupadorDerecho())
				continue;
			if (esParentesisIzquierdo())
				continue;
			if (esParentesisDerecho())
				continue;
			if (esArreglo())
				continue;
			if (esSeparador())
				continue;
			if (esIdentificador())
				continue;
			if (esPunto()) {
				continue;
			}
			reportarError("" + charActual, filaActual, colActual, posActual);
			obtenerSiguienteCaracter();
		}
	}

	/**
	 * Metodo para devolver el proceso de metodos de predicado
	 * 
	 * @param posInicial
	 *            posicion hasta donde devolverse
	 */
	private void hacerBacktracking(int posInicial) {

		posActual = posInicial;
		charActual = codigoFuente.charAt(posActual);
	}

	/**
	 * Metodo que continÃºa con el siguiente caracter del codigo fuente
	 */
	private void obtenerSiguienteCaracter() {

		if (posActual == codigoFuente.length() - 1) {
			charActual = finCodigo;

		} else {
			if (charActual == '\n') {
				filaActual++;
				colActual = 0;

			} else {
				colActual++;
			}
			posActual++;
			charActual = codigoFuente.charAt(posActual);

		}

	}

	/**
	 * Metodo que almacena un simbolo del sistema
	 * 
	 * @param lexema
	 *            el lexema que se almacenarÃ¡
	 * @param fila
	 *            fila donde inicio el simbolo
	 * @param columna
	 *            columna donde se inicio el simbolo
	 * @param categoria
	 *            categorÃ­a del sÃ­mbolo
	 */
	private void almacenarSimbolo(String lexema, int fila, int columna, Categoria categoria) {

		tablaSimbolos.add(new Token(lexema, fila, columna, categoria));

	}

	/**
	 * Metodo que almacena un codigo desconocido del sistema
	 * 
	 * @param lexema
	 *            el lexema de error
	 * @param fila
	 *            la fila donde origino el error
	 * @param columna
	 *            la columna donde se origio el error
	 */
	private void reportarError(String lexema, int fila, int columna, int posInicial) {

		tablaErrores.add(new Token(lexema, fila, columna, posInicial - fila, Categoria.DESCONOCIDO));

	}

	// METODOS PREDICADO

	/**
	 * Metodo para determinar si lo ingresado en codigo es un nÃºmero real
	 * 
	 * @return
	 */
	private boolean esEntero() {

		if (!Character.isDigit(charActual)) {
			return false;
		}

		// Transicion
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		lexema += charActual;
		obtenerSiguienteCaracter();

		// Bucle
		while (Character.isDigit(charActual)) {

			lexema += charActual;
			obtenerSiguienteCaracter();

		}

		if (charActual == '.') {
			hacerBacktracking(posInicial);
			return false;
		}

		// AA
		almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.ENTERO);

		return true;

	}

	/**
	 * Metodo para determinar si lo ingresado en codigo es una cadena de
	 * caracteres
	 * 
	 * @return
	 */
	private boolean esCadenaCaracteres() {
		// Transicion
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;

		if (charActual == '$') {

			lexema += charActual;
			obtenerSiguienteCaracter();

			while (charActual != '$') {

				if (charActual == '\'') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (!(charActual == 'n' || charActual == 't' || charActual == '$' || charActual == 'f'
							|| charActual == 'b' || charActual == '\'' || charActual == 'r')) {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					} else {
						lexema += charActual;
						obtenerSiguienteCaracter();
						continue;
					}
				} else if (charActual == finCodigo) {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				} else {
					lexema += charActual;
					obtenerSiguienteCaracter();
				}
			}
			lexema += charActual;
			obtenerSiguienteCaracter();
			almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.CADENA_CARACTERES);
			return true;
		} else {
			hacerBacktracking(posInicial);
			return false;
		}
	}

	/**
	 * Metodo para determinar si lo ingresado en codigo es un caracter
	 * 
	 * @return
	 */
	private boolean esCaracter() {

		if (charActual != '#') {
			return false;
		}
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		lexema += charActual;
		obtenerSiguienteCaracter();

		if (charActual == '\'') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '#' || charActual == 'n' || charActual == 'b' || charActual == 't' || charActual == 'r') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == '#') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.CARACTER);
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			}
		} else if (charActual != '#') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '#') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.CARACTER);
				return true;
			} else {
				lexema += charActual;
				reportarError(lexema, filaInicial, colInicial, posInicial);
				;
				return true;
			}

		}

		return true;

	}

	/**
	 * Metodo para determinar si lo ingresado en codigo es un operador relacional
	 * 
	 * @return
	 */
	private boolean esOperadorRelacional() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == '(') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			switch (charActual) {
			case '<':
			case '>':
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'e') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (charActual == 's') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == ')') {
							lexema += charActual;
							obtenerSiguienteCaracter();
							almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_RELACIONAL);
						} else {
							reportarError(lexema, filaInicial, colInicial, posInicial);
						}
						return true;
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					}
				} else {
					if (charActual == ')') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_RELACIONAL);
						return true;
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					}
				}
			case 'e':
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 's') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (charActual == ')') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_RELACIONAL);
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
					}
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			default:
				hacerBacktracking(posInicial);
				return false;
			}
		} else if (charActual == 'N') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'O') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'T') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (charActual == '(') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == 'e') {
							lexema += charActual;
							obtenerSiguienteCaracter();
							if (charActual == 's') {
								lexema += charActual;
								obtenerSiguienteCaracter();
								if (charActual == ')') {
									lexema += charActual;
									obtenerSiguienteCaracter();
									almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_RELACIONAL);
								} else {
									reportarError(lexema, filaInicial, colInicial, posInicial);
								}
							} else {
								reportarError(lexema, filaInicial, colInicial, posInicial);
							}
						} else {
							reportarError(lexema, filaInicial, colInicial, posInicial);
						}
					} else {
						hacerBacktracking(posInicial);
						return false;
					}
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
				}
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para determinar si lo ingresado en codigo es un nÃºmero real
	 * 
	 * @return
	 */
	private boolean esReal() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;

		if (Character.isDigit(charActual)) {
			lexema += charActual;
			obtenerSiguienteCaracter();
			while (Character.isDigit(charActual)) {
				lexema += charActual;
				obtenerSiguienteCaracter();
			}
			if (charActual == '.') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				while (Character.isDigit(charActual)) {
					lexema += charActual;
					obtenerSiguienteCaracter();
				}
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.REAL);
				return true;
			} else {
				hacerBacktracking(posInicial);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Analiza si la parte de codigo analizado es un comentario de linea
	 * 
	 * @return
	 */
	private boolean esComentarioLinea() {
		String lexema = "";
		int colInicial = colActual;
		int filaInicial = filaActual;
		int posInicial = posActual;
		if (charActual == '-') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '-') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				while (charActual != '\n') {
					if (charActual == finCodigo) {
						reportarError(lexema, filaInicial, colInicial, posInicial);
					} else {
						lexema += charActual;
						obtenerSiguienteCaracter();
					}
				}
				return true;
			} else {
				hacerBacktracking(posInicial);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Identifica si la parte de codigo analizado es comentario de bloque
	 * 
	 * @return
	 */
	private boolean esComentarioBloque() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == '-') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '{') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				do {
					while (charActual != '}') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == finCodigo) {
							reportarError(lexema, filaInicial, colInicial, posInicial);
							return true;
						}
					}
					while (charActual == '}') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == finCodigo) {
							reportarError(lexema, filaInicial, colInicial, posInicial);
							return false;
						}
					}
				} while (charActual != '-');
				if (charActual == '-') {
					obtenerSiguienteCaracter();
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				hacerBacktracking(posInicial);
			}
		}
		return false;
	}

	/**
	 * Metodo para determinar si lo ingresado por codigo es un identificador de
	 * variable
	 * 
	 * @return
	 */
	private boolean esIdentificadorVariable() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == '<') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
				lexema += charActual;
				obtenerSiguienteCaracter();
			}
			while (charActual == '-') {
				if (charActual == '-') {
					lexema += charActual;
					obtenerSiguienteCaracter();
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
				while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
					lexema += charActual;
					obtenerSiguienteCaracter();
				}
			}
			if (charActual == '>') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.IDENTIFICADOR_VARIABLE);
			} else {
				hacerBacktracking(posInicial);
				return false;
			}
			return true;
		} else {
			hacerBacktracking(posInicial);
			return false;
		}
	}

	/**
	 * Metodo para determinar si lo ingresado por codigo es un identificador de
	 * metodo
	 * 
	 * @return
	 */
	private boolean esIdentificadorMetodo() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == 'f') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'u') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'n') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
						lexema += charActual;
						obtenerSiguienteCaracter();
						while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
							lexema += charActual;
							obtenerSiguienteCaracter();
						}
						if (lexema.substring(lexema.length()-2).equals("ar")
								|| lexema.substring(lexema.length()).equals("er")
								|| lexema.substring(lexema.length()).equals("ir")
								|| lexema.substring(lexema.length()).equals("or")
								|| lexema.substring(lexema.length()).equals("ur")) {
							almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.IDENTIFICADOR_METODO);
						} else {
							hacerBacktracking(posInicial);
							return false;
						}
						return true;
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					}
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				hacerBacktracking(posInicial);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metodo para determinar si lo ingresado por codigo es un identificador de
	 * metodo
	 * 
	 * @return
	 */
	private boolean esIdentificadorClase() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == '@') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (Character.getType(charActual) == Character.UPPERCASE_LETTER) {
				lexema += charActual;
				obtenerSiguienteCaracter();
				while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
					lexema += charActual;
					obtenerSiguienteCaracter();
				}
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.IDENTIFICADOR_CLASE);
				return true;
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metodo para hallar identificador
	 */
	private boolean esIdentificador() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		if (charActual == '_' || Character.getType(charActual) == Character.LOWERCASE_LETTER) {
			while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
				lexema += charActual;
				obtenerSiguienteCaracter();
			}
			while (charActual == '_') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				while (Character.getType(charActual) == Character.LOWERCASE_LETTER) {
					lexema += charActual;
					obtenerSiguienteCaracter();
				}
			}
			if (esPalabraReservada(lexema)) {
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.PALABRA_RESERVADA);
			} else {
				reportarError(lexema, filaInicial, colInicial, posActual);
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para determinar si un identificador es palabra reservada
	 * 
	 * @param lexema
	 *            el identificador encontrado
	 * @return
	 */
	private boolean esPalabraReservada(String lexema) {
		return reservedWords.contains(lexema);
	}

	private boolean esOperadorAritmetico() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;

		if (charActual == '(') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '+' || charActual == '-' || charActual == '*' || charActual == '/' || charActual == '%') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == ')') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_ARITMETICO);
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				hacerBacktracking(posInicial);
				return false;
			}

		} else {
			return false;
		}

	}

	/**
	 * Metodo para determinar si lo ingresado en codigo es un operador de
	 * asignacion
	 * 
	 * @return
	 */
	private boolean esOperadorAsignacion() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == 'e') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 's') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == '(') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (charActual == '+' || charActual == '-' || charActual == '*' || charActual == '/'
							|| charActual == '%') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == ')') {
							lexema += charActual;
							obtenerSiguienteCaracter();
							almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_ASIGNACION);
							return true;
						} else {
							reportarError(lexema, filaInicial, colInicial, posInicial);
							return true;
						}
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					}
				} else {
					almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_ASIGNACION);
					return true;
				}
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
				return true;
			}
		} else {
			return false;
		}

	}

	/**
	 * Metodo que permite determinar si una fraccion del codigo es un agrupador
	 * derecho
	 * 
	 * @return
	 */
	private boolean esAgrupadorIzquierdo() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;

		if (charActual == '-') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '>') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.AGRUPADOR_IZQUIERDO);
				return true;
			} else {
				hacerBacktracking(posInicial);
			}
		}
		return false;

	}

	/**
	 * Metodo que permite determinar si una fraccion del codigo es un agrupador
	 * izquierdo
	 * 
	 * @return
	 */
	private boolean esAgrupadorDerecho() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;

		if (charActual == '<') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '-') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.AGRUPADOR_DERECHO);
				return true;
			} else {
				hacerBacktracking(posInicial);
			}
		}
		return false;
	}

	/**
	 * Metodo que permite determinar si una fraccion del codigo es un parentesis
	 * izquierdoG
	 * 
	 * @return
	 */
	private boolean esParentesisIzquierdo() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;

		if (charActual == '{') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '{') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.PARENTESIS_IZQUIERDO);
				return true;
			}
		}
		return false;

	}

	/**
	 * Metodo que permite determinar si una fraccion del codigo es un parentesis
	 * derecho
	 * 
	 * @return
	 */
	private boolean esParentesisDerecho() {

		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;

		if (charActual == '}') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == '}') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.PARENTESIS_DERECHO);
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo que permite determinar si una fraccion del codigo es un operador
	 * logico
	 * 
	 * @return
	 */
	private boolean esOperadorLogico() {
		String lexema = "";
		int filaInicial = filaActual;
		int colInicial = colActual;
		int posInicial = posActual;
		if (charActual == 'A') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'N') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'D') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_LOGICO);
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
				return true;
			}

		} else if (charActual == 'O') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'R') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_LOGICO);
				return true;
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
				return true;
			}

		} else if (charActual == 'N') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'O') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'T') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.OPERADOR_LOGICO);
					return true;
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				reportarError(lexema, filaInicial, colInicial, posInicial);
				return true;
			}
		}

		return false;
	}

	/**
	 * Metodo para identificar si se esta asignando un arreglo
	 * 
	 * @return
	 */
	private boolean esArreglo() {
		String lexema = "";
		int colInicial = colActual;
		int filaInicial = filaActual;
		int posInicial = posActual;
		if (charActual == '$') {
			lexema += charActual;
			obtenerSiguienteCaracter();
			if (charActual == 'a') {
				lexema += charActual;
				obtenerSiguienteCaracter();
				if (charActual == 'r') {
					lexema += charActual;
					obtenerSiguienteCaracter();
					if (charActual == 'r') {
						lexema += charActual;
						obtenerSiguienteCaracter();
						if (charActual == '(') {
							lexema += charActual;
							obtenerSiguienteCaracter();
							while (Character.isDigit(charActual)) {
								lexema += charActual;
								obtenerSiguienteCaracter();
							}
							if (charActual == ')') {
								lexema += charActual;
								obtenerSiguienteCaracter();
								almacenarSimbolo(lexema, filaInicial, colInicial, Categoria.ARREGLO);
								obtenerSiguienteCaracter();
								return true;
							} else {
								hacerBacktracking(posInicial);
								return false;
							}
						} else {
							reportarError(lexema, filaInicial, colInicial, posInicial);
							return true;
						}
					} else {
						reportarError(lexema, filaInicial, colInicial, posInicial);
						return true;
					}
				} else {
					reportarError(lexema, filaInicial, colInicial, posInicial);
					return true;
				}
			} else {
				hacerBacktracking(posInicial);
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metodo que identifica si el simbolo ingresado es un separador
	 * 
	 * @return
	 */
	private boolean esSeparador() {
		if (charActual == '|') {
			almacenarSimbolo("" + charActual, filaActual, colActual, Categoria.SEPARADOR);
			obtenerSiguienteCaracter();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo paara identificar si es un invocador a elementos de objetos
	 * 
	 * @return
	 */
	private boolean esPunto() {
		if (charActual == '\\') {
			almacenarSimbolo("" + charActual, filaActual, colActual, Categoria.PUNTO);
			obtenerSiguienteCaracter();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @return the tablaSimbolos
	 */
	public ArrayList<Token> getTablaSimbolos() {
		return tablaSimbolos;
	}

	/**
	 * @return the tablaErrores
	 */
	public ArrayList<Token> getTablaErrores() {
		return tablaErrores;
	}

}
