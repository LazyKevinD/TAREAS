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
class RegistroAspirantes {
	private ArrayList listaAspirantes;

	public RegistroAspirantes() {
		listaAspirantes = new ArrayList();
	}
	public void registrarAspirante(Aspirante a) {
		listaAspirantes.add(a);
		System.out.println("\n----Aspirante registrado correctamente----");
	}
	
	public void eliminarAspirante(String folio) {
		if(!(listaAspirantes.isEmpty())) {
			for (Object a : listaAspirantes) {
				if (((Aspirante)a).getFolio().equals(folio)) {
					listaAspirantes.remove(a);
					System.out.println("\n----Aspirante eliminado correctamente----");
					break;
				}
			}
		}
		else {
			System.out.println("\n----No Hay Aspirantes----");
		}
	}
	
	public String generarFolio() {
		String folio = "";
		if(listaAspirantes.isEmpty()) {
			folio = "00" + 1;
		} else {
			int folioAnterior = Integer.parseInt(((Aspirante)listaAspirantes.get(listaAspirantes.size()-1)).getFolio());
			if ((folioAnterior + 1) <= 9) {
				folio += "00" + (folioAnterior + 1);
			} else if ((folioAnterior + 1) >= 10 && (folioAnterior + 1)  <= 99) {
				folio += "0" + (folioAnterior + 1);
			} else {
				folio += (folioAnterior + 1);
			}
		}
		return folio;
	}
	
	public void imprimirListaAspirantes() {
		if(!(listaAspirantes.isEmpty())) {
			System.out.println("\n----Aspirantes----");
			for (Object a : listaAspirantes) {
				System.out.println(((Aspirante)a));
			}
		}else {
			System.out.println("\n----No Hay Aspirantes----");
		}	
	}
}
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------
public class P1_T1_A6 {
	public static void main(String[] args) {		
		Scanner entrada = new Scanner(System.in);
		RegistroAspirantes ra = new RegistroAspirantes();
		
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
				System.out.println("----INGRESE LOS DATOS----");
				System.out.println("Nombre: ");
				String nombre = entrada.next();
				
				System.out.println("Apellido Paterno: ");
				String primerAp = entrada.next();
				
				System.out.println("Apellido Materno: ");
				String segundoAp = entrada.next();
				
				System.out.println("Edad: ");
				byte edad = entrada.nextByte();
				
				System.out.println("Direccion: ");
				String direccion = entrada.next();
				
				System.out.println("Telefono: ");
				String telefono = entrada.next();
				//----------------------------------------------------------------------------
				System.out.println("Ingresa la Cantidad de Correos Electronicos: ");
				int numeroCorreos = entrada.nextInt();
				String []correosElectronicos = new String[numeroCorreos];
				for(int j = 0; j < correosElectronicos.length; j++) {
					System.out.println("Introduce correo " + (j+1) + ": ");
					correosElectronicos[j] = entrada.next();
				}
				//----------------------------------------------------------------------------
				System.out.println("Ingresa la Cantidad de Redes Sociales: ");
				int numeroSociales = entrada.nextInt();
				String []redesSociales = new String[numeroSociales];
				for(int j = 0; j < redesSociales.length; j++) {
					System.out.println("Introduce red social " + (j+1) + ": ");
					redesSociales[j] = entrada.next();
				}
				//----------------------------------------------------------------------------
				System.out.println("Ingresa la Cantidad de Carreras de Interes: ");
				int numeroCarreras = entrada.nextInt();
				String []carrerasInteres = new String[numeroCarreras];
				for(int j = 0; j < carrerasInteres.length; j++) {
					System.out.println("Introduce carrera " + (j+1) + ": ");
					carrerasInteres[j] = entrada.next();
				}
				//----------------------------------------------------------------------------
				System.out.println("Escuela de Procedencia: ");
				String escuelaProcedencia = entrada.next();
				//----------------------------------------------------------------------------
				System.out.println("Bachillerato: ");
				String bachillerato = entrada.next();
				String folio = ra.generarFolio();
				Aspirante asp1 = new Aspirante(folio, nombre, primerAp, segundoAp, edad, direccion, telefono, correosElectronicos, redesSociales, carrerasInteres, escuelaProcedencia, bachillerato);
				ra.registrarAspirante(asp1);
				break;
			case "2":
				System.out.println("\nIntroduce el Folio (Recuerda formato '000'): ");
				String folioBorrar = entrada.next();
				ra.eliminarAspirante(folioBorrar);
				break;
			case "3":
				ra.imprimirListaAspirantes();
				break;
			case "4":
				System.out.println("\n----BYE BYE :3----");
				break;
			default: System.out.println("\n----ESA NO ES UNA OPCION----");
				break;
			}
		}while (opcion != "4");
	}
}