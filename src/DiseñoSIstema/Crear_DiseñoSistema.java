package DiseñoSIstema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Crear_DiseñoSistema extends JFrame{
	
	private JPanel panelCont, panelError, panelBotton, panelBottonTotal;
	private JButton enviarCont, regresarCont;
	private JTextField apellido, nombre, cedula, semestre, carrera, telefono, correo;
	private JLabel text1;
	private String pregradoS="Pregrado", postgradoS= "Postgrado", doctoradoS="Doctorado", maestriaS="Maestria"; 
	private String eleccion;
	private JComboBox<String> tipo;
	
	ArrayList<Estudiante> pregrado= new ArrayList<Estudiante>();
	ArrayList<Estudiante> postgrado= new ArrayList<Estudiante>();
	ArrayList<Estudiante> doctorado= new ArrayList<Estudiante>();
	ArrayList<Estudiante> maestria= new ArrayList<Estudiante>();

	
	public Crear_DiseñoSistema() {
		setTitle("Crear Elemento");
		setBounds(400, 200, 600, 500);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		setLayout(new BorderLayout());	
		panelCont= new JPanel();	
		panelCont.setLayout(new GridLayout(12,2));	
		
		panelBottonTotal= new JPanel(new GridLayout(2,0));
		panelBotton= new JPanel(new GridLayout(0,2));
		JLabel casillaError= new JLabel("" , SwingConstants.CENTER);
		JLabel espacio= new JLabel("" , SwingConstants.CENTER);
			
		
		text1= new JLabel("Ingrese los Datos del Estudiante", SwingConstants.CENTER);
		//El "SwingConstants.CENTER" es para centrarel Texto			
		
		enviarCont= new JButton("Enviar");		
		regresarCont= new JButton("Regresar");		
		
		
		JLabel apellidoTxt= new JLabel("Apellidos Completo");
		apellido= new JTextField(20);
		
		JLabel nombreTxt= new JLabel("Nombres Completo");
		nombre= new JTextField(20);
		
		JLabel cedulaTxt= new JLabel("Cédula");
		cedula= new JTextField(20);
		
		JLabel telefonoTxt= new JLabel("N° de Teléfono");
		telefono= new JTextField(20);
		
		JLabel correoTxt= new JLabel("Correo");
		correo= new JTextField(20);
						
		JLabel carreraTxt= new JLabel("Carrera");
		carrera= new JTextField(20);
		
		JLabel semestreTxt= new JLabel("Semestre");
		semestre= new JTextField(20);
		
		
			
		JLabel tipoTxt= new JLabel("Tipo de Inscripcion");
		tipo= new JComboBox<String>();
		tipo.addItem(pregradoS);		tipo.addItem(postgradoS);		tipo.addItem(doctoradoS);		tipo.addItem(maestriaS);
				
		
		panelCont.add(apellidoTxt);			panelCont.add(apellido);
		panelCont.add(nombreTxt);			panelCont.add(nombre);
		panelCont.add(cedulaTxt);			panelCont.add(cedula);
		panelCont.add(telefonoTxt);			panelCont.add(telefono);
		panelCont.add(correoTxt);			panelCont.add(correo);
		panelCont.add(carreraTxt);			panelCont.add(carrera);
		panelCont.add(semestreTxt);			panelCont.add(semestre);		
		panelCont.add(tipoTxt);				panelCont.add(tipo);
		
		
		panelError= new JPanel(new GridLayout(11,0));
		JLabel error1= new JLabel();						panelError.add(error1);	
		JLabel error2= new JLabel();						panelError.add(error2);
		JLabel error3= new JLabel();						panelError.add(error3);
		JLabel error4= new JLabel();						panelError.add(error4);
		JLabel error5= new JLabel();						panelError.add(error5);
		JLabel error6= new JLabel();						panelError.add(error6);
		JLabel error7= new JLabel();						panelError.add(error7);
		
		
		enviarCont.addActionListener(new ActionListener() {	
			
			public void actionPerformed(ActionEvent e) {
				
				boolean band=false; 
				
				try {				
																	
					if (apellido.getText().equals("")) {
						apellido.setBackground(Color.RED);
						band=true;
					} 
					if (nombre.getText().equals("")) {
						nombre.setBackground(Color.RED);
						band=true;
					}
					if (cedula.getText().equals("")) {
						cedula.setBackground(Color.RED);
						band=true;
					}
					if (telefono.getText().equals("")) {
						telefono.setBackground(Color.RED);
						band=true;
					}
					if (correo.getText().equals("")) {
						correo.setBackground(Color.RED);
						band=true;
					}
					if (semestre.getText().equals("")) {
						semestre.setBackground(Color.RED);
						band=true;
					}
					if (carrera.getText().equals("")) {
						carrera.setBackground(Color.RED);
						band=true;
					}
					
					
					if (band==false) {
						
						Agregar();
						
						casillaError.setText("Se inserto el Estudiante en la Base de Datos.");
						
						apellido.setText("");
						nombre.setText("");
						cedula.setText("");
						telefono.setText("");
						correo.setText("");
						semestre.setText("");
						carrera.setText("");
						
					}				
									
					
				} catch (Exception e2) {
					casillaError.setText("Ingreso invalido.");
					
										
				}
				
				
				
			}
		});	
		
		regresarCont.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Index visual=new Index();
				visual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				visual.setVisible(true);
				setVisible(false);
			}
		});
		
		panelBotton.add(regresarCont);		
		panelBotton.add(enviarCont);
		
		
		panelBottonTotal.add(casillaError);
		panelBottonTotal.add(panelBotton);
		
		add(panelCont, BorderLayout.WEST);
		add(text1, BorderLayout.NORTH);
		
		add(panelBottonTotal, BorderLayout.SOUTH);
		
	}
	
	 public void Agregar() {
		
		eleccion=(String)tipo.getSelectedItem();	
		
		String apellidoAdd= apellido.getText();
		String nombreAdd= nombre.getText();
		String cedulaAdd= cedula.getText();
		String telefonoAdd= telefono.getText();
		String correoAdd= correo.getText();
		String semestreAdd= semestre.getText();
		String carreraAdd= carrera.getText();
		
		pregrado= new ArrayList<Estudiante>();
		postgrado= new ArrayList<Estudiante>();
		doctorado= new ArrayList<Estudiante>();
		maestria= new ArrayList<Estudiante>();
		
		if(eleccion.equalsIgnoreCase("Pregrado")) {	
			
			pregrado= new AddArray().AddArrays(apellidoAdd, nombreAdd, cedulaAdd, telefonoAdd, correoAdd, carreraAdd, semestreAdd, eleccion);
			
		}else if(eleccion.equalsIgnoreCase("Postgrado")) {	
			
			postgrado= new AddArray().AddArrays(apellidoAdd, nombreAdd, cedulaAdd, telefonoAdd, correoAdd, carreraAdd, semestreAdd, eleccion);
			new Add().Adds(apellidoAdd, nombreAdd, cedulaAdd, telefonoAdd, correoAdd, carreraAdd, semestreAdd, eleccion);
			
		}else if(eleccion.equalsIgnoreCase("Doctorado")) {	

			doctorado= new AddArray().AddArrays(apellidoAdd, nombreAdd, cedulaAdd, telefonoAdd, correoAdd, carreraAdd, semestreAdd, eleccion);
			
		}else if(eleccion.equalsIgnoreCase("Maestria")) {	
			maestria= new AddArray().AddArrays(apellidoAdd, nombreAdd, cedulaAdd, telefonoAdd, correoAdd, carreraAdd, semestreAdd, eleccion);
			
		}
		
		
	}	
}

class AddArray{
	public ArrayList<Estudiante> AddArrays(String apellido, String nombre, String cedula, String telefono, String correo, String carrera, String semestre,  String eleccion) {
		
		ArrayList<Estudiante> pregrado= new ArrayList<Estudiante>();
		ArrayList<Estudiante> postgrado= new ArrayList<Estudiante>();
		ArrayList<Estudiante> doctorado= new ArrayList<Estudiante>();
		ArrayList<Estudiante> maestria= new ArrayList<Estudiante>();

				
		if(eleccion.equalsIgnoreCase("Pregrado")) {	
			
			pregrado.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));
			
			return pregrado;
		}else if(eleccion.equalsIgnoreCase("Postgrado")) {	
			
			postgrado.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));

			return postgrado;
		}else if(eleccion.equalsIgnoreCase("Doctorado")) {	

			doctorado.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));
			
			return doctorado;
		}else if(eleccion.equalsIgnoreCase("Maestria")) {	
				
			maestria.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));	
			
			return maestria;
		}else {
			return null;
		}
	
	
	
	
	}
}
























