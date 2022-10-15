package IngresarUsuario;

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
	
	static Index visual;
	static Enterokay enter;
	static Register register;
	JPanel panelTitulo, panelContenido;
	JLabel casillaError;
	
	public static void main(String[] args) {
			
		visual=new Index();
		visual.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		visual.setVisible(true);		
	}
	
	
	public Index(){
		
		
		// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				setTitle("Inicio");
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
				
				JLabel espacio1= new JLabel();
				JLabel createT= new JLabel("Ingresar Usuario", SwingConstants.CENTER);
				JButton create= new JButton("Ingresar");	
				
				JLabel espacio2= new JLabel();
				JLabel readT= new JLabel("Registrar Usuario", SwingConstants.CENTER);
				JButton read= new JButton("Registrar");			
				casillaError= new JLabel("" , SwingConstants.CENTER);
			// ---------------------------------------------Action----------------------------------------------------------------------		
				create.addActionListener(new ActionListener() {				
					public void actionPerformed(ActionEvent e) {
						
						enter= new Enterokay();
						enter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						enter.setVisible(true);
						
						setVisible(false);
					}
				});
				
				read.addActionListener(new ActionListener() {			
					public void actionPerformed(ActionEvent e) {
						
						register= new Register();
						register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						register.setVisible(true);						
						setVisible(false);
					}
				});
			
			// -------------------------------------------------------------------------------------------------------------------		
				panelContenido.add(espacio1);		panelContenido.add(createT);		panelContenido.add(create);
				panelContenido.add(espacio2);		panelContenido.add(readT);			panelContenido.add(read);
			
		// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				add(panelTitulo, BorderLayout.NORTH);
				add(panelContenido, BorderLayout.CENTER);
				add(casillaError, BorderLayout.SOUTH);

	4564343
//	
	
	}
	
	
	
	
}

