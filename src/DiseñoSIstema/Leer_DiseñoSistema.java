package DiseñoSIstema;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Leer_DiseñoSistema extends JFrame{

	private JPanel lamina;
	private JButton regresar, enviar;
	private String pregrado="Pregrado", postgrado= "Postgrado", doctorado="Doctorado", maestria="Maestria"; 
	private JTextArea areaEstudiante;
	
	public Leer_DiseñoSistema(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Leer Elementos");
		setBounds(400, 200, 700, 500);	
		Index index= new Index();
		index.setVisible(false);
		setLayout(new BorderLayout());
		
		JComboBox<String> eleccion= new JComboBox<String>();
		eleccion.addItem(pregrado);		eleccion.addItem(postgrado);		eleccion.addItem(doctorado);		eleccion.addItem(maestria);
		
		areaEstudiante= new JTextArea();
		areaEstudiante.setEditable(false);
		
		JScrollPane panel= new JScrollPane(areaEstudiante);
		
		lamina= new JPanel(new GridLayout(0,2));
		enviar= new JButton("Enviar");
		regresar= new JButton("Regresar");
		
	
	//-------------------------------------------------------Action---------------------------------------------------------------------------------------------------------------
		regresar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				index.setVisible(true);
				setVisible(false);
			}
		});
	
		enviar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				String eleccions=(String)eleccion.getSelectedItem();								
				areaEstudiante.setText("");
				
				if(eleccions.equalsIgnoreCase("Pregrado")) {	
				
				ArrayList<Estudiante> arrayPre= new Pregrado().pregrado;	
				
				
					for(Estudiante er: arrayPre) {
						areaEstudiante.append(er.Datos());
					}
				
					
				}else if(eleccions.equalsIgnoreCase("Postgrado")) {	

					ArrayList<Estudiante> arrayPre= new Postgrado().postgrado;
					
					for(Estudiante er: arrayPre) {
						areaEstudiante.append(er.Datos());
					}
					
					
					ArrayList<Estudiante> arrayPreg= new Add().array;
					System.out.println("si 2 "+ arrayPreg.size());
					
					for(Estudiante err: arrayPreg) {
						areaEstudiante.append(err.Datos());
					}
					
					
				}else if(eleccions.equalsIgnoreCase("Doctorado")) {	
					ArrayList<Estudiante> arrayPre= new Doctorado().doctorado;	
					
					
					for(Estudiante er: arrayPre) {
						areaEstudiante.append(er.Datos());
					}
					
					
				}else if(eleccions.equalsIgnoreCase("Maestria")) {	
					ArrayList<Estudiante> arrayPre= new Maestria().maestria;
					
					for(Estudiante er: arrayPre) {
						areaEstudiante.append(er.Datos());
					}
					
					
				}
				
				
			}
		});
		lamina.add(regresar);
		lamina.add(enviar);
		
		add(eleccion, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		add(lamina, BorderLayout.SOUTH);
		
		
	}
	
	
}

class Add{
	ArrayList<Estudiante> array= new ArrayList<Estudiante>();
	
	public ArrayList<Estudiante> Adds(String apellido, String nombre, String cedula, String telefono, String correo, String carrera, String semestre,  String eleccion) {
		array.add(new Estudiante(apellido, nombre, cedula, telefono, correo, carrera, semestre, eleccion));
		System.out.println("si 1 "+ array.size());
		return array;
	}
}






