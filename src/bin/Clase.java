import javax.swing.JOptionPane;
public class Clase{
	public static double numero;
	public static boolean mayor;
	public static void main(String[] args){
		int a;;
		int b;;
		numero = 32;
		a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor entero"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor entero"));
		if(a>b){
		JOptionPane.showMessageDialog(null, "La suma entre " + a + '+' + b + " es: " + funsumar(a, b) + "\nEl numero por defecto " + numero + "Retorna " + mayor + " al mirar si es mayor a la suma");
		} else{
		JOptionPane.showMessageDialog(null, "La resta entre " + a + '-' + b + " es: " + funrestar(a, b) + "\nEl numero por defecto " + numero + "Retorna " + mayor + " al mirar si es mayor a la resta");
		}
	}
	private static int funsumar(int a, int b) {
		int suma;;
		suma = a+b;
		while(a<b){
		 a++;
		}
		if(suma>numero){
		mayor = false;
		return suma;
		} else{
		mayor = true;
		return suma;
		}
	}
	public static int funrestar(int c, int d) {
		 d++;
		 c++;
		numero = 0;
		mayor = false;
		return d-c;
	}
}