package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

import gui.VentanaCompilador;
import lexico.AnalizadorLexico;
import lexico.Token;

/**
 * Esta clase se encarga de controlar la interfaz gr�fica y sus eventos
 * 
 * @author Juan Jos� �lvarez Orozco
 * @author Daniel Beltr�n G�mez
 * @author Tatiana Salazar
 *
 */
public class ControladorVentana {
	private VentanaCompilador ventanaCompilador;
	File fichero;
	boolean guardado;

	/**
	 * Contructor del controlador de la ventana, recibe la ventana a controlar
	 * 
	 * @param ventanaCompilador
	 */
	public ControladorVentana(VentanaCompilador ventanaCompilador) {
		this.ventanaCompilador = ventanaCompilador;
		organizar();
	}

	/**
	 * M�todo para poner n�meros en el editor
	 */
	private void organizar() {
		ventanaCompilador.getLinea().setText("");
		String aux = "";
		for (int i = 1; i <= ventanaCompilador.getTextEditor().getLineCount(); i++) {
			aux += i + "\n";
		}
		ventanaCompilador.getLinea().setText(aux);
	}

	/**
	 * M�todo para vargar un archivo
	 */
	public void cargar() {
		String aux = "";
		String texto = "";
		try {
			JFileChooser file = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter(".MG", "mg");
			file.setFileFilter(filter);
			file.showOpenDialog(null);
			fichero = file.getSelectedFile();
			if (fichero != null) {
				FileReader archivos = new FileReader(fichero);
				BufferedReader buff = new BufferedReader(archivos);
				while ((aux = buff.readLine()) != null) {
					texto += aux + "\n";

				}
				buff.close();
			}
			ventanaCompilador.getTextEditor().setText(texto.substring(0, texto.length() - 1));
			ventanaCompilador.getEditor().setText(ventanaCompilador.getTextEditor().getText());
			organizar();

		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, ex + "" + "\nNo se ha encontrado el archivo", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (NullPointerException e2) {
			JOptionPane.showMessageDialog(null, "Se ha cancelado el cargado");
		}
	}

	/**
	 * M�todo para guardar un archivo
	 */
	public void guardar() {
		FileWriter archivos;
		if (guardado) {
			try {
				archivos = new FileWriter(fichero);
				BufferedWriter buff = new BufferedWriter(archivos);
				buff.write(ventanaCompilador.getEditor().getText());
				buff.close();

				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No se ha guardao");
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado el guardado");
			}
		} else {
			try {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Elija donde guardar");
				FileNameExtensionFilter filter = new FileNameExtensionFilter(".MG", "mg");
				fileChooser.setFileFilter(filter);

				int userSelection = fileChooser.showSaveDialog(null);
				File fileToSave = null;
				if (userSelection == JFileChooser.APPROVE_OPTION) {
					fileToSave = fileChooser.getSelectedFile();
				}

				archivos = new FileWriter(fileToSave.getAbsolutePath() + ".MG");
				BufferedWriter buff = new BufferedWriter(archivos);
				buff.write(ventanaCompilador.getEditor().getText());
				buff.close();

				JOptionPane.showMessageDialog(null, "Se ha guardado correctamente");
				fichero = fileToSave.getAbsoluteFile();
				guardado = true;
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "No se ha guardao");
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "Se ha cancelado el guardado");
			}
		}
	}

	/**
	 * M�todo para crear un nuevo archivo
	 */
	public void crear() {
		ventanaCompilador.getEditor().setText("");
		fichero = null;
		ventanaCompilador.getTextEditor().requestFocus();
		guardado = false;
		ventanaCompilador.getPanelSimbolos().removeAll();
		ventanaCompilador.getPanelErrores().removeAll();
	}

	/**
	 * M�todo para la ejecuci�n del compilador
	 */
	public void compilar() {
		ventanaCompilador.setAnalizadorLexico(new AnalizadorLexico(ventanaCompilador.getEditor().getText()));
		ventanaCompilador.getAnalizadorLexico().analizar();

		agregarSimbolos();
		agregarErrores();

		for (Token token : ventanaCompilador.getAnalizadorLexico().getTablaErrores()) {
			DefaultHighlighter.DefaultHighlightPainter highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(
					ventanaCompilador.getBackground().equals(Color.BLACK)? new Color(180, 0, 0):new Color(255, 0, 0));
			try {
				ventanaCompilador.getEditor().getHighlighter().addHighlight(token.getColumnaReal(), token.getColumnaReal()+token.getLexema().length(), highlightPainter);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}

		}
		JOptionPane.showMessageDialog(null,
				"Compilado con " + ventanaCompilador.getAnalizadorLexico().getTablaErrores().size() + " errores");

	}

	/**
	 * M�todo para agregar s�mbolos a la tabla de la interfaz
	 */
	private void agregarSimbolos() {
		String[] fila_simbolo = { "Lexema", "Columna", "Fila", "Categor�a" };
		DefaultTableModel modelo_simbolo = new DefaultTableModel(fila_simbolo, 0);
		for (Token token : ventanaCompilador.getAnalizadorLexico().getTablaSimbolos()) {

			Object[] columnas = { token.getLexema(), token.getColumna(), token.getFila(),
					token.getCategoria().toString() };
			modelo_simbolo.addRow(columnas);
		}

		ventanaCompilador.getPanelSimbolos().removeAll();
		ventanaCompilador.setSimbolos(new JTable(modelo_simbolo));
		ventanaCompilador.getSimbolos().setBackground(ventanaCompilador.getEditor().getBackground());
		ventanaCompilador.getSimbolos().setForeground(ventanaCompilador.getEditor().getForeground());
		ventanaCompilador.getPanelSimbolos().add(ventanaCompilador.getSimbolos(), BorderLayout.CENTER);
	}

	/**
	 * M�todo para agregar errores a la tabla de la interfaz
	 */
	private void agregarErrores() {
		String[] fila_error = { "Lexema", "Columna", "Fila", "Categor�a" };
		DefaultTableModel modelo_simbolo = new DefaultTableModel(fila_error, 0);
		for (Token token : ventanaCompilador.getAnalizadorLexico().getTablaErrores()) {
			Object[] columnas = { token.getLexema(), token.getColumna(), token.getFila(),
					token.getCategoria().toString() };
			modelo_simbolo.addRow(columnas);
		}

		ventanaCompilador.getPanelErrores().removeAll();
		ventanaCompilador.setErrores(new JTable(modelo_simbolo));
		ventanaCompilador.getErrores().setBackground(ventanaCompilador.getEditor().getBackground());
		ventanaCompilador.getErrores().setForeground(ventanaCompilador.getEditor().getForeground());
		ventanaCompilador.getPanelErrores().add(ventanaCompilador.getErrores(), BorderLayout.CENTER);
	}

	/**
	 * Cambiar tema de la aplicaci�n
	 */
	public void ponerClaro() {
		ventanaCompilador.getEditor().setBackground(Color.WHITE);
		ventanaCompilador.getEditor().setForeground(Color.BLACK);
		ventanaCompilador.getLinea().setBackground(Color.WHITE);
		ventanaCompilador.getLinea().setForeground(Color.BLACK);
		ventanaCompilador.getSimbolos().setBackground(Color.WHITE);
		ventanaCompilador.getErrores().setBackground(Color.WHITE);
		ventanaCompilador.getSimbolos().setForeground(Color.BLACK);
		ventanaCompilador.getErrores().setForeground(Color.BLACK);
	}

	/**
	 * Cambiar tema de la aplicaci�n
	 */
	public void ponerOscuro() {
		ventanaCompilador.getEditor().setBackground(Color.BLACK);
		ventanaCompilador.getEditor().setForeground(Color.WHITE);
		ventanaCompilador.getLinea().setBackground(Color.BLACK);
		ventanaCompilador.getLinea().setForeground(Color.WHITE);
		ventanaCompilador.getSimbolos().setBackground(Color.BLACK);
		ventanaCompilador.getErrores().setBackground(Color.BLACK);
		ventanaCompilador.getSimbolos().setForeground(Color.WHITE);
		ventanaCompilador.getErrores().setForeground(Color.WHITE);
	}

	/**
	 * Insertar los numeros a partir de la escritura
	 */
	public void leerSaltoLinea() {
		ventanaCompilador.getTextEditor().setText(ventanaCompilador.getEditor().getText());
		organizar();
	}
}
