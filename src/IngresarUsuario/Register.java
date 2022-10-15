package IngresarUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class Register extends JFrame{
		JPanel panelTitulo, panelContenido;
		private JTextField  User, LastName, FirstName, Identification ,Phone, Email,  Career, Semester;
		private JPasswordField password;
		private JComboBox<String> Pais;		
		private String paises[]= {"Venezuela", "Colombia", "Chile", "Peru", "España"};
		
		private String passwordVal;
		
		public Register() {
			// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
					setTitle("Registrar");
					setBounds(400, 200, 600, 500);		
					setLayout(new BorderLayout());
										

			// --------------------------------------------JPanel---------------------------------------------------------------------------------------------			
					panelContenido= new JPanel();
					panelContenido.setLayout(new GridLayout(12,2));
					
					panelTitulo= new JPanel();
					JLabel titulo= new JLabel("Ingresa los Datos Solicitados", SwingConstants.CENTER); //para centrar el texto
					panelTitulo.add(titulo);
					
					JLabel UserTxt= new JLabel("Usuario");
					User= new JTextField(20);
					
					JLabel passwordTxt= new JLabel("Contraseña");
					password= new JPasswordField(20);
					
					JLabel LastNameTxt= new JLabel("Apellidos Completo");
					LastName= new JTextField(20);
					
					JLabel FirstNameTxt= new JLabel("Nombres Completo");
					FirstName= new JTextField(20);
					
					JLabel IdentificationTxt= new JLabel("Cédula");
					Identification= new JTextField(20);
					
					JLabel PhoneTxt= new JLabel("N° de Teléfono");
					Phone= new JTextField(20);
					
					JLabel EmailTxt= new JLabel("Correo");
					Email= new JTextField(20);
									
					JLabel CareerTxt= new JLabel("Carrera");
					Career= new JTextField(20);
					
					JLabel SemesterTxt= new JLabel("Semestre");
					Semester= new JTextField(20);
					
					JLabel PaisTxt= new JLabel("Pais");
					Pais= new JComboBox<String>(paises);
					
					JPanel buttonsAll= new JPanel();
					buttonsAll.setLayout(new GridLayout(2,0));
					
					JPanel buttons= new JPanel();
					JLabel casillaError= new JLabel("" , SwingConstants.CENTER);
				// -------------------------------------------------------------------------------------------------------------------	
					
					JButton create= new JButton("Ingresar");	
					
					create.addActionListener(new ActionListener() {				
						public void actionPerformed(ActionEvent e) {
							
							boolean band=false; 
							
							try {				
								
								if (User.getText().equals("")) {
									User.setBackground(Color.RED);
									password.setBackground(Color.RED);
									band=true;
								}
														
								if (LastName.getText().equals("")) {
									LastName.setBackground(Color.RED);
									band=true;
								}
								if (FirstName.getText().equals("")) {
									FirstName.setBackground(Color.RED);
									band=true;
								} 
								if (Identification.getText().equals("")) {
									Identification.setBackground(Color.RED);
									band=true;
								}
								if (Phone.getText().equals("")) {
									Phone.setBackground(Color.RED);
									band=true;
								}
								if (Email.getText().equals("")) {
									Email.setBackground(Color.RED);
									band=true;
								}
								if (Career.getText().equals("")) {
									Career.setBackground(Color.RED);
									band=true;
								}
								if (Semester.getText().equals("")) {
									Semester.setBackground(Color.RED);
									band=true;
								}
								
								
								if (band==false) {
									
									char[] arrayC = password.getPassword();
									passwordVal= new String(arrayC);
									
									connectionBBDD();
									
									casillaError.setText("Se inserto el Usuario en la Base de Datos.");
									
									User.setText("");
									password.setText("");									
									LastName.setText("");
									FirstName.setText("");
									Identification.setText("");
									Phone.setText("");
									Email.setText("");
									Career.setText("");
									Semester.setText("");
									
								} else {
									casillaError.setText("Ingreso invalido.");
								}
												
								
							} catch (Exception e2) {
								casillaError.setText("Ingreso invalido.");						
													
							}
							
						}
					});
				// -------------------------------------------------------------------------------------------------------------------		
					JButton read= new JButton("Regresar");			
					
					read.addActionListener(new ActionListener() {			
						public void actionPerformed(ActionEvent e) {
							Index index= new Index();
							index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							index.setVisible(true);
							setVisible(false);
							
						}
					});
				
				// -----------------------------------------Add Panel--------------------------------------------------------------------------		
					panelContenido.add(UserTxt);				panelContenido.add(User);
					panelContenido.add(passwordTxt);			panelContenido.add(password);
					panelContenido.add(LastNameTxt);			panelContenido.add(LastName);
					panelContenido.add(FirstNameTxt);			panelContenido.add(FirstName);
					panelContenido.add(IdentificationTxt);		panelContenido.add(Identification);
					panelContenido.add(PhoneTxt);				panelContenido.add(Phone);
					panelContenido.add(EmailTxt);				panelContenido.add(Email);
					panelContenido.add(CareerTxt);				panelContenido.add(Career);
					panelContenido.add(SemesterTxt);			panelContenido.add(Semester);	
					panelContenido.add(PaisTxt);				panelContenido.add(Pais);	
					
					
					buttons.add(read);							buttons.add(create);	
					buttonsAll.add(casillaError);				buttonsAll.add(buttons);
					
			// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
					add(panelTitulo, BorderLayout.NORTH);
					add(panelContenido, BorderLayout.CENTER);					
					add(buttonsAll, BorderLayout.SOUTH);
			
		}
		
		public void connectionBBDD() {
			
			try {
				Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
				
				PreparedStatement sql= conexion.prepareStatement("INSERT INTO userprofile(User, Password, LastName, FirstName, Identification, Phone, Email, Career, Semester, Pais)"
						+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
				
				sql.setString(1, User.getText());
				sql.setString(2, passwordVal);
				sql.setString(3, LastName.getText());
				sql.setString(4, FirstName.getText());
				sql.setString(5, Identification.getText());
				sql.setString(6, Phone.getText());
				sql.setString(7, Email.getText());
				sql.setString(8, Career.getText());
				sql.setString(9, Semester.getText());
				sql.setString(10, Pais.getSelectedItem().toString());
				
				
				
				sql.executeUpdate();			
				sql.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}			
			
			
			
		}
	
}
