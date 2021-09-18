import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Aspirante{
	private String folio;
	private String nombre;
	private String primerAp;
	private String segundoAP;
	private byte edad;
	private String direccion;
	private String telefono;
	private String correosElectronicos[];
	private String redesSociales[];
	private String carrerasInteres[];
	private String escuelaProcedencia;
	private String bachillerato;
	
	public Aspirante(String folio, String nombre, String primerAp, String segundoAP, byte edad, String direccion,
			String telefono, String[] correosElectronicos, String[] redesSociales, String[] carrerasInteres,
			String escuelaProcedencia, String bachillerato) {
		super();
		this.folio = folio;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAP = segundoAP;
		this.edad = edad;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correosElectronicos = correosElectronicos;
		this.redesSociales = redesSociales;
		this.carrerasInteres = carrerasInteres;
		this.escuelaProcedencia = escuelaProcedencia;
		this.bachillerato = bachillerato;
	}

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerAp() {
		return primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	public String getSegundoAP() {
		return segundoAP;
	}

	public void setSegundoAP(String segundoAP) {
		this.segundoAP = segundoAP;
	}

	public byte getEdad() {
		return edad;
	}

	public void setEdad(byte edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String[] getCorreosElectronicos() {
		return correosElectronicos;
	}

	public void setCorreosElectronicos(String[] correosElectronicos) {
		this.correosElectronicos = correosElectronicos;
	}

	public String[] getRedesSociales() {
		return redesSociales;
	}

	public void setRedesSociales(String[] redesSociales) {
		this.redesSociales = redesSociales;
	}

	public String[] getCarrerasInteres() {
		return carrerasInteres;
	}

	public void setCarrerasInteres(String[] carrerasInteres) {
		this.carrerasInteres = carrerasInteres;
	}

	public String getEscuelaProcedencia() {
		return escuelaProcedencia;
	}

	public void setEscuelaProcedencia(String escuelaProcedencia) {
		this.escuelaProcedencia = escuelaProcedencia;
	}

	public String getBachillerato() {
		return bachillerato;
	}

	public void setBachillerato(String bachillerato) {
		this.bachillerato = bachillerato;
	}

	@Override
	public String toString() {
		return "\nFicha de ingreso: " + folio + "\n====================" + "\nnombre: " + nombre + "\nprimerAp:" + primerAp + "\nsegundoAP: "
				+ segundoAP + "\nedad: " + edad + "\ndireccion: " + direccion + "\ntelefono: " + telefono
				+ "\ncorreosElectronicos: " + Arrays.toString(correosElectronicos) + "\nredesSociales: "
				+ Arrays.toString(redesSociales) + "\ncarrerasInteres: " + Arrays.toString(carrerasInteres)
				+ "\nescuelaProcedencia: " + escuelaProcedencia + "\nbachillerato: " + bachillerato;
	}
}
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
class RegistroAspirante{
	private Aspirante vectorAspirante[];
	
	public RegistroAspirante(int tamano) {
		vectorAspirante = new Aspirante[tamano];
	}

	public Aspirante[] getVectorAspirante() {
		return vectorAspirante;
	}

	public void setVectorAspirante(Aspirante[] vectorAspirante) {
		this.vectorAspirante = vectorAspirante;
	}
	
	public void registrarAspirante(Aspirante a, int contFolio) {
		try {
			vectorAspirante[contFolio] = a;
        }
        catch(ArrayIndexOutOfBoundsException e) {
           System.out.println("\n----ERROR PRODUCIDO PORQUE ESTA LLENO EL VECTOR----");
        }
	}
	
	public void eliminarAspirante(String folioFicha) {
		for (int i = 0; i < vectorAspirante.length; i++) {
			try {
				if((vectorAspirante[i].getFolio().equals(folioFicha))) {
					String correosElectronicos[] = new String[1];
					String redesSociales[] = new String[1];
					String carrerasInteres[] = new String[1]; 
					vectorAspirante[i].setFolio("");
					vectorAspirante[i].setNombre("");
					vectorAspirante[i].setPrimerAp("");
					vectorAspirante[i].setSegundoAP("");
					vectorAspirante[i].setEdad((byte)0);
					vectorAspirante[i].setDireccion("");
					vectorAspirante[i].setTelefono("");
					vectorAspirante[i].setEscuelaProcedencia("");
					vectorAspirante[i].setBachillerato("");
					vectorAspirante[i].setCorreosElectronicos(correosElectronicos);
					vectorAspirante[i].setRedesSociales(redesSociales);
					vectorAspirante[i].setCarrerasInteres(carrerasInteres);
					System.out.println("\n>> Aspirante eliminado.");
					break;
				}	
	        }
	        catch(NullPointerException e) {}
		}  
	}
	
	public void imprimirListaAspirantes() {
		for (int i = 0; i < vectorAspirante.length; i++) {
			try {
				if(!(vectorAspirante[i].getNombre().equals("")))
					 System.out.println(vectorAspirante[i].toString()); 
	        }
	        catch(NullPointerException e) {}
		}  
	}
}
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
public class P1_T1_A5 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int numeroAspirantes = 100;
		RegistroAspirante ra = new RegistroAspirante(numeroAspirantes);
		
		int contFolio = 0;
		String folio;
		String nombre;
		String primerAp;
		String segundoAP;
		byte edad;
		String direccion;
		String telefono;
		String correosElectronicos[];
		String redesSociales[];
		String carrerasInteres[];
		String escuelaProcedencia;
		String bachillerato;
		
		String opcion;
		
		do {
			System.out.println("----ELIGE UNA OPCION----");
			System.out.println("1) Agregar Usuario");
			System.out.println("2) Eliminar Usuario");
			System.out.println("3) Mostrar Usuarios");
			System.out.println("4) Salir");
			System.out.println("Introduce tu eleccion: ");
			opcion = entrada.next();
			
			switch (opcion) {
			case "1":
				contFolio ++;
				folio = "0" + contFolio;
				System.out.println("-----INGRESE LOS DATOS----");
				System.out.println("Nombre: ");
				nombre = entrada.next();
				System.out.println("Apellido Paterno: ");
				primerAp = entrada.next();
				System.out.println("Apellido Materno: ");
				segundoAP = entrada.next();
				System.out.println("Edad: ");
				edad = entrada.nextByte();
				System.out.println("Direccion: ");
				direccion = entrada.next();
				System.out.println("Telefono: ");
				telefono = entrada.next();
				
				System.out.println("Ingrese la Cantidad de Correos Electronicos: ");
				int numeroCorreos = entrada.nextInt();
				correosElectronicos = new String[numeroCorreos];
				for(int j = 0; j < correosElectronicos.length; j++) {
					System.out.println("Introduce Correo " + (j+1) + ": ");
					correosElectronicos[j] = entrada.next();
				}
				
				System.out.println("Ingrese la Cantidad de Redes Sociales: ");
				int numeroSociales = entrada.nextInt();
				redesSociales = new String[numeroSociales];
				for(int j = 0; j < redesSociales.length; j++) {
					System.out.println("Introduce Red Social " + (j+1) + ": ");
					redesSociales[j] = entrada.next();
				}
				
				System.out.println("Ingrese la Cantidad de Carreras de Interes: ");
				int numeroCarreras = entrada.nextInt();
				carrerasInteres = new String[numeroCarreras];
				for(int j = 0; j < carrerasInteres.length; j++) {
					System.out.println("Introduce Carrera " + (j+1) + ": ");
					carrerasInteres[j] = entrada.next();
				}
				
				System.out.println("Escuela de Procedencia: ");
				escuelaProcedencia = entrada.next();
				System.out.println("Bachillerato: ");
				bachillerato = entrada.next();
				Aspirante asp1 = new Aspirante(folio, nombre, primerAp, segundoAP, edad, direccion, telefono, correosElectronicos, redesSociales, carrerasInteres, escuelaProcedencia, bachillerato);
				ra.registrarAspirante(asp1, contFolio-1);
				break;
			case "2":
				System.out.println("\nIntroduce el Folio (Recuerda formato '00'): ");
				String folioBorrar = entrada.next();
				ra.eliminarAspirante(folioBorrar);
				break;
			case "3":
				ra.imprimirListaAspirantes();
				break;
			case "4":
				System.out.println("BYE BYE :3");
				break;
				
			default:
				break;
			}
		}while (opcion != "4");	
	}
}
