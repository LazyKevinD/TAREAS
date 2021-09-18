import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

class Alumno{
	private String nombre;
	private int edad;
	private String carrera;
	private String fecha;
	
	public Alumno(String nombre, int edad, String carrera, String fecha) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", carrera=" + carrera + ", fecha=" + fecha + "]";
	}
}

public class P1_T1_A7 {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		HashMap<Integer, Alumno> mapAlumnos = new HashMap<>();

		String opcion;
		
		do {
			System.out.println("----SELECCIONE UNA OPCION----");
			System.out.println("1) Llenar Lista");
			System.out.println("2) Vaciar Lista");
			System.out.println("3) Mostrar los Alumnos por Carrera");
			System.out.println("4) Calcular Promedio de Edades");
			System.out.println("5) Mostrar los Alumnos que se Inscribieron Después de la Fecha Indicada (10/08/2016)");
			System.out.println("6) Salir");
			System.out.print("Ingrese su Opcion: ");
			opcion = entrada.next();
			
			switch (opcion) {
			case "1":
				for (int i = 0; i < 3; i++) {
					System.out.println("Introduce Datos del Alumno " + (mapAlumnos.size()+1) + ": ");
					System.out.println("Nombre: ");
					String nombre = entrada.next();
					System.out.println("Edad: ");
					int edad = entrada.nextInt();
					System.out.println("Carrera: ");
					String carrera = entrada.next().toUpperCase();
					System.out.println("Fecha de Inscripcion (formato: dd/mm/aaaa): ");
					String fecha = entrada.next();
					mapAlumnos.put(mapAlumnos.size()+1, new Alumno(nombre, edad, carrera, fecha)); 
				}
				break;
			case "2":
				mapAlumnos.clear();
				System.out.println("----SE VACIO LA LISTA CORRECTAMENTE----");
				break;
			case "3":
				System.out.println("Introduce Carrera a Mostrar: ");
				String carreraRequerida = entrada.next().toUpperCase();
				if (mapAlumnos.isEmpty()) {
					System.out.println("----NO HAY ALUMNOS REGISTRADOS----");
				}else {
					System.out.println("Alumnos de la Carrera " + carreraRequerida + ": ");
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
						String carreraMostrar = ((Alumno)alumno.getValue()).getCarrera();
						if (carreraMostrar.equals(carreraRequerida)) {
							System.out.println(alumno.getValue());
						}
					}
				}
				break;
			case "4":
				int suma = 0;
				if (mapAlumnos.isEmpty()) {
					System.out.println("----NO HAY ALUMNOS REGISTRADOS----");
				}else {
					
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
					    suma += (alumno.getValue()).getEdad();
					}
					System.out.println("Promedio de edades: " + (suma/mapAlumnos.size()));
				}
				break;
			case "5":
				if (mapAlumnos.isEmpty()) {
					System.out.println("----NO HAY ALUMNOS REGISTRADOS----");
				}else {
					System.out.println("Alumnos Registrados Despues de --10/08/2016--: ");
					int dia = 10, mes = 8, año = 2016;
					for (Entry<Integer, Alumno> alumno : mapAlumnos.entrySet()) {
					    String [] fechaStrings = (alumno.getValue()).getFecha().split("/");
					    int diaAlumno = Integer.parseInt(fechaStrings[0]);
					    int mesAlumno = Integer.parseInt(fechaStrings[1]);
					    int anoAlumno = Integer.parseInt(fechaStrings[2]);
					    
					    if (anoAlumno > año) {
					    	System.out.println(alumno.getValue());
					    	continue;
					    } 
					    else if (anoAlumno < año){
					    	continue;
					    }
					    
					    if (mesAlumno > mes) {
					    	System.out.println(alumno.getValue());
					    	continue;
					    } 
					    else if (mesAlumno < mes) {
					    	continue;
					    }
					    
					    if (diaAlumno > dia) {
					    	System.out.println(alumno.getValue());
					    }
					    else {}
					}
				}
				break;
			case "6":
				System.out.println("BYE BYE :3");
				break;
			default:
				System.out.println("----ESA NO ES UNA OPCION SELECCIONE OTRA----");
				break;
			}
		}while(opcion != "6");
	}
}