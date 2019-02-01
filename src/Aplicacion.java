import lexico.AnalizadorLexico;
import sintaxis.AnalizadorSintactico;

/**
 * Clase que permite la ejecución del programa de compilador
 * 
 * @author Juan Jose Alvarez Orozco
 * @Author Daniel Beltran Gomez
 * @author Tatiana Salazar
 */
public class Aplicacion {

    public static void main(String[] args) {

//       new VentanaCompilador();
    	
    	String codigoFuente = "visible ntr a|b|c fin";
    	
    	AnalizadorLexico al = new AnalizadorLexico(codigoFuente);
    	al.analizar();
    	AnalizadorSintactico as = new AnalizadorSintactico(al.getTablaSimbolos());
    	as.analizar();
    	
//    	System.out.println(al.getTablaSimbolos());
//    	System.out.println(al.getTablaErrores());
    	System.out.println(as.getTablaSimbolos());
    	System.out.println(as.getTablaErrores());
    	

    }

}
