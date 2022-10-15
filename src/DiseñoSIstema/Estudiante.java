package DiseñoSIstema;

import java.util.ArrayList;

public class Estudiante {
	
	private String apellido;
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private String semestre;
	private String carrera;
	
	public Estudiante(String apellido, String nombre, String cedula, String telefono, String correo, String carrera, String semestre,  String eleccion) {
		
		this.apellido=apellido;
		this.nombre=nombre;
		this.cedula=cedula;
		this.telefono=telefono;
		this.correo=correo;
		this.semestre=semestre;
		this.carrera=carrera;		
		
		
		
		
	}
	public String Datos() {
		return "\n\nEstudiante: \n-apellido=" + apellido + "\n-nombre=" + nombre + "\n-cedula=" + cedula + "\n-telefono="
				+ telefono + "\n-correo=" + correo + "\n-semestre=" + semestre + "\n-carrera=" + carrera + "\n";
	}
	
	

}	
//----------------------------------------------------------------------------Class-------------------------------------------------------------------------------------------------
class Pregrado {	
	ArrayList<Estudiante> pregrado= new ArrayList<Estudiante>();
	boolean band=true;
	
	public  Pregrado() { 	
		
		if (band) {
			pregrado.add(new Estudiante("Marquez", "Alexander", "27834452", "04129543207", "alejanderMarquez@gmail.com", "Ingeniería Mecánica" ,"3", "Pregrado"));
			pregrado.add(new Estudiante("Peralez", "Pedro", "21679842", "04149533106", "PeralesPedro@gmail.com", "Ingeniería Civil" ,"5", "Pregrado"));
			band=false;
		}
		
	}

	public ArrayList<Estudiante> getPregrado() {
		return pregrado;
	}

	public void setPregrado(ArrayList<Estudiante> pregrado) {
		this.pregrado = pregrado;
	}

	
}	

class Postgrado {
	ArrayList<Estudiante> postgrado= new ArrayList<Estudiante>();
	ArrayList<Estudiante> postgrado2= new ArrayList<Estudiante>();
	boolean band;
	
	private String apellido;
	private String nombre;
	private String cedula;
	private String telefono;
	private String correo;
	private String semestre;
	private String carrera;
	private String eleccion;
	
	public void setPostgrado(String apellido, String nombre, String cedula, String telefono, String correo, String carrera, String semestre,  String eleccion) {
		
		this.apellido=apellido;
		this.nombre=nombre;
		this.cedula=cedula;
		this.telefono=telefono;
		this.correo=correo;
		this.semestre=semestre;
		this.carrera=carrera;	
		this.eleccion= eleccion;
		
	}
	
	public Postgrado() {	
		 band=true;
		if (band) {
			postgrado.add(new Estudiante("Medina", "Daniela", "16742712", "04245490207", "daniMedina@gmail.com", "Ingeniería Sistema" ,"2", "Postgrado"));
			postgrado.add(new Estudiante("Pimentel", "Barbara", "21745322", "04121465214", "BarbaraP@gmail.com", "Ingeniería Sistema" ,"6", "Postgrado"));
			band=false;
		}
				
		if (apellido!=null || nombre!=null || cedula!=null || telefono!=null || correo!=null || carrera!=null || semestre!=null ||eleccion!=null) {
			postgrado2.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));
			System.out.println("si 2 "+ postgrado2.size());
			
		}
			
	}

	
	
	

}

class Doctorado{
	ArrayList<Estudiante> doctorado= new ArrayList<Estudiante>();
	boolean band=true;
	
	public Doctorado() {	
		
		if (band) {
			doctorado.add(new Estudiante("Moreno", "Marta", "12632599", "04263259001", "MartaMRE@gmail.com", "Contaduría Pública" ,"8", "Doctorado"));
			doctorado.add(new Estudiante("Torres", "Gabriela", "22432566", "04143279045", "GabrielaAMT@gmail.com", "Ingeniería Electrónica" ,"9", "Doctorado"));
			band=false;
		}
			
	}
		
}
	
class Maestria {
	ArrayList<Estudiante> maestria= new ArrayList<Estudiante>();
	boolean band=true;
	
	public Maestria() {	
		
		if (band) {
			maestria.add(new Estudiante("Diaz", "Carlos", "12546658", "04164320011", "CarlosDiazTovar@gmail.com", "Derecho" ,"6", "Maestria"));
			maestria.add(new Estudiante("Salazar", "Melanny", "17546001", "04143214830", "MelannySalazar11@gmail.com", "Enfermería" ,"8", "Maestria"));
			band=false;
		}

	}
		
}







