import java.util.Scanner;
/*
	Listo | 1) Mostrar la cadena invertida por letra 
	Listo | 2) y por palabras
	Listo | 3) Agregar/
	Listo | 4) eliminar caracteres y/o subcadenas en posiciones especificas
	Listo | 5) Mostrar cadena en formato CaMeL CaSe  especial
	Listo | 6) Mostar la cadena con la primer letra de cada palabra en mayúscula
*/

class CadenaEspecial{
	Scanner entrada = new Scanner(System.in);
	private String cadena;
	
	public CadenaEspecial(String cadena) {
		this.cadena = cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	public String getCadena() {
		return cadena;
	}
	
	//1) Mostrar la cadena invertida por letra 
	public String invertirLetras() {
		String cadenaInvertida = "";
		for(int i = cadena.length()-1; i>=0; i--) {
			cadenaInvertida += cadena.charAt(i);
		}
		return cadenaInvertida;
	}
	
	//2) y por palabras
	public String invertirPalabras() {
		String cadenaDividida[] = cadena.split(" ");
		String cadenaInvertida = "";
		for(int i = cadenaDividida.length-1; i>=0; i--) {
			if(i == cadenaDividida.length-1) {
				cadenaInvertida = cadenaInvertida + cadenaDividida[i];
			}
			else {
				cadenaInvertida = cadenaInvertida + " " + cadenaDividida[i];
			}
		}
		return cadenaInvertida;
	}
	
	//3) Agregar/
	public String agregarTexto() {
		String cad1 = "", cad2 = "", cad3 = "";
		System.out.print("Ingrese el Caracter de Inicio Donde Desea Agregar (NOTA: Despues del Caracter,y los espacios cuentan): ");
		int op1 = entrada.nextInt();
		cad1 = cadena.substring(0, op1);
		cad2 = cadena.substring(op1-1, cadena.length());
		System.out.print("Ingrese el Texto que se desea Agregar: ");
		cad3 = entrada.next();
		return (cad1+cad3+cad2);
	}
	
	//4) eliminar caracteres y/o subcadenas en posiciones especificas
	public String eliminarTexto() {
		String cad1 = "", cad2 = "";
		System.out.print("Ingrese el Caracter de Inicio Donde Desea Eliminar (NOTA: Despues del Caracter,y los espacios cuentan): ");
		int op1 = entrada.nextInt();
		System.out.print("Ingrese el Caracter de Fin Donde Desea Eliminar (NOTA: Antes del Caracter): ");
		int op2 = entrada.nextInt();
		cad1 = cadena.substring(0, op1);
		cad2 = cadena.substring(op2, cadena.length());
		return (cad1+cad2);
	}
	
	//5) Mostrar cadena en formato CaMeL CaSe  especial
	public String cadenaCamelCaseEsp() {
		String cadenaCamel = "";
		for(int i = 0; i<=cadena.length()-1; i++) {
			if(i%2 == 0) {
				cadenaCamel += cadena.substring(i, i+1).toUpperCase();
			}
			else {
				cadenaCamel += cadena.substring(i, i+1).toLowerCase();
			}
		}
		return cadenaCamel;
	}
	
	//6) Mostar la cadena con la primer letra de cada palabra en mayúscula
	public String cadenaLetraMayus() {
		String cadenaDividida[] = cadena.split(" ");
		String cadenaFinal = "";
		String cadenaMayus = "";
		for(int i = 0; i <= cadenaDividida.length-1; i++) {
			cadenaDividida[i].toLowerCase();
			for(int j = 0; j <= cadenaDividida[i].length()-1; j++) {
				if(j ==  0) {
					cadenaMayus += cadenaDividida[i].substring(j, j+1).toUpperCase();
				}
				else {
					cadenaMayus += cadenaDividida[i].substring(j, j+1).toLowerCase();
				}
			}
			cadenaDividida[i] = cadenaMayus;
			cadenaMayus = "";
			if(i ==  0) {
				cadenaFinal += cadenaDividida[i];
			}
			else {
				cadenaFinal += " " + cadenaDividida[i];
			}
		}
		return cadenaFinal;
	}
}

public class P1_T1_A3 {
	public static void main(String[] args) {
		String cad = "INGENERIA EN SISTEMAS COMPUTACIONALES";
		CadenaEspecial ob1 = new CadenaEspecial(cad);
		Scanner entrada = new Scanner(System.in);

		System.out.println("OPCIONES");
		System.out.println("1) Mostrar la cadena invertida por letra \r\n"
				+ "2) Mostrar la cadena invertida por palabras \r\n"
				+ "3) Agregar caracteres y/o subcadenas en posiciones especificas \r\n"
				+ "4) Eliminar caracteres y/o subcadenas en posiciones especificas \r\n"
				+ "5) Mostrar cadena en formato CaMeL CaSe  especial \r\n"
				+ "6) Mostar la cadena con la primer letra de cada palabra en mayúscula \r\n"
				+ "7) Mostar la cadena actual \r\n"
				+ "8) Salir");
		
		int s=0;
		while (s == 0) {
			System.out.println("---------------------------------------");
			System.out.println("Ingrese la Opcion a Elegir:");
			String op = entrada.next();
			switch(op) {
				case "1": System.out.println(ob1.invertirLetras());
					break;
				case "2": System.out.println(ob1.invertirPalabras());
					break;
				case "3": System.out.println(ob1.agregarTexto());
					break;
				case "4": System.out.println(ob1.eliminarTexto());
					break;
				case "5": System.out.println(ob1.cadenaCamelCaseEsp());
					break;
				case "6": System.out.println(ob1.cadenaLetraMayus());
					break;
				case "7": System.out.println(ob1.getCadena());;
					break;
				case "8": s = 1;
					break;
				default: System.out.println("ESA NO ES UNA OPCION, VUELVAA INTENTARLO");
					break;
			}
		}
	}
}
