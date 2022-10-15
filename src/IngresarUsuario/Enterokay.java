package IngresarUsuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Enterokay extends JFrame{
	
	JPanel panelTitulo, panelContenido;
	static Index visual;
	private JTextField User;
	private JPasswordField Password;
	
	private String UserAdd;
	private String PasswordAdd;
	private String LastNameAdd;
	private String FirstNameAdd;
	private String IdentificationAdd;
	private String PhoneAdd;
	private String EmailAdd;
	private String CareerAdd;
	private String SemesterAdd;
	private String PaisAdd;
	
	private Connection conexion;
	private ResultSet sql;
	private Statement state;
	
	JLabel casillaError;
	


	
	
	public Enterokay() {
	
			
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				setTitle("Ingresar");
				setBounds(400, 200, 600, 500);		
				setLayout(new BorderLayout());		
				
				new Index().setVisible(false);
// --------------------------------------------JPanel---------------------------------------------------------------------------------------------			
				panelContenido= new JPanel();
				panelContenido.setLayout(new GridLayout(12,2));
				
				panelTitulo= new JPanel();
				JLabel titulo= new JLabel("Ingrese el Usuario", SwingConstants.CENTER); //para centrar el texto
				panelTitulo.add(titulo);
				
				JLabel UserTxt= new JLabel("Usuario");
				User= new JTextField(20);
				
				JLabel passwordTxt= new JLabel("Contraseña");
				Password= new JPasswordField(20);
				
										
	// -------------------------------------------------------------------------------------------------------------------	
				JPanel buttonsAll= new JPanel();
				buttonsAll.setLayout(new GridLayout(2,0));
				
				JPanel buttons= new JPanel();
				casillaError= new JLabel("" , SwingConstants.CENTER);
				
				JButton create= new JButton("Ingresar");	
				JButton read= new JButton("Regresar");	
				
	// --------------------------------------Action-----------------------------------------------------------------------------		
						
				create.addActionListener(new ActionListener() {				
					public void actionPerformed(ActionEvent e) {
										
						
						String userVal= User.getText();
						
						char[] arrayC = Password.getPassword();
						String passwordVal = new String(arrayC);
						
						connectionBBDD(userVal, passwordVal);
										
					}
				});
				
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
				panelContenido.add(passwordTxt);			panelContenido.add(Password);
						
				buttons.add(read);							buttons.add(create);	
				buttonsAll.add(casillaError);				buttonsAll.add(buttons);					
		// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				add(panelTitulo, BorderLayout.NORTH);
				add(panelContenido, BorderLayout.CENTER);
				add(buttonsAll, BorderLayout.SOUTH);
				
			}

	
	public void connectionBBDD(String userVal, String passwordVal) {
		try {
			
			Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
			
			PreparedStatement rs= conexion.prepareStatement("SELECT * FROM `userprofile` WHERE `User`=?");
			
			rs.setString(1, userVal);
			
			ResultSet sql=rs.executeQuery();
			
			if(sql.next()) {						
								
				sql.beforeFirst(); //Regresa al primer puntero 
				while (sql.next()) {
					
					UserAdd= sql.getString("User");
					PasswordAdd= sql.getString("Password");
					LastNameAdd= sql.getString("LastName");
					FirstNameAdd= sql.getString("FirstName");
					IdentificationAdd= sql.getString("Identification");
					PhoneAdd= sql.getString("Phone");
					EmailAdd= sql.getString("Email");
					CareerAdd= sql.getString("Career");
					SemesterAdd= sql.getString("Semester");
					PaisAdd= sql.getString("Pais");
					
					if (userVal.equals(UserAdd) && passwordVal.equals(PasswordAdd)) {
						
						ProfileUser profile= new ProfileUser(UserAdd, LastNameAdd, FirstNameAdd, IdentificationAdd, PhoneAdd, EmailAdd, CareerAdd, SemesterAdd, PaisAdd);
						profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						profile.setVisible(true);
						setVisible(false);
						
						
					}else {
						casillaError.setText("Ingreso Invalido");

					}
				sql.close();
				}
			}
			else {
				casillaError.setText("Usuario o Contraseña no Registrado");
			}
			
		} catch (Exception e) {
			casillaError.setText("Usuario o Contraseña no Registrado");
			
		}
		
			 
		
	}
}
