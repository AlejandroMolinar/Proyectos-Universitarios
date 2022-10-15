package DiseñoSIstema;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Index extends JFrame{
	
	JPanel panelTitulo, panelContenido;
	static Index visual;
	

	public static void main(String[] args) {
			
		visual=new Index();
		visual.setVisible(true);		
	}
	
	
	public Index(){
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
		setTitle("Inscripciones");
		setBounds(400, 200, 600, 500);		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		

// --------------------------------------------JPanel---------------------------------------------------------------------------------------------			
		panelTitulo= new JPanel();
		JLabel titulo= new JLabel("¿Que Quiere Hacer?", SwingConstants.CENTER); //para centrar el texto
		panelTitulo.add(titulo);
		
		panelContenido= new JPanel();
		panelContenido.setLayout(new GridLayout(13,0));
	// -------------------------------------------------------------------------------------------------------------------	
		JLabel espacio1= new JLabel();
		JLabel createT= new JLabel("Insertar un Estudiante", SwingConstants.CENTER);
		JButton create= new JButton("Crear");	
		
		create.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				
				Crear_DiseñoSistema Acreate= new Crear_DiseñoSistema(); 
				Acreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Acreate.setVisible(true);
				setVisible(false);
			}
		});
	// -------------------------------------------------------------------------------------------------------------------		
		JLabel espacio2= new JLabel();
		JLabel readT= new JLabel("Leer los estudiantes", SwingConstants.CENTER);
		JButton read= new JButton("Leer");			
		
		read.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				Leer_DiseñoSistema Aread= new Leer_DiseñoSistema();
				Aread.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Aread.setVisible(true);
				setVisible(false);
			}
		});
	
	// -------------------------------------------------------------------------------------------------------------------		
		panelContenido.add(espacio1);		panelContenido.add(createT);		panelContenido.add(create);
		panelContenido.add(espacio2);		panelContenido.add(readT);			panelContenido.add(read);
	
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
		add(panelTitulo, BorderLayout.NORTH);
		add(panelContenido, BorderLayout.CENTER);
		
	}


	
}
