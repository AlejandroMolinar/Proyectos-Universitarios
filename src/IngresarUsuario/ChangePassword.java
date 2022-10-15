package IngresarUsuario;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class ChangePassword extends JFrame{
	
	JPanel panelTitulo, panelContenido;
	static Index visual;
	private JPasswordField Password1, Password2;
	
	private String UserAdd;
	private String PasswordAdd1;
	private String PasswordAdd2;

	
	private Connection conexion;
	private ResultSet sql;
	private Statement state;
	
	JLabel casillaError;
	
	public ChangePassword(String User) {
	
			UserAdd=User;
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				setTitle("Cambiar Contraseña");
				setBounds(400, 200, 600, 500);		
				setLayout(new BorderLayout());		
				
				new Index().setVisible(false);
// --------------------------------------------JPanel---------------------------------------------------------------------------------------------			
				panelContenido= new JPanel();
				panelContenido.setLayout(new GridLayout(12,2));
				
				panelTitulo= new JPanel();
				JLabel titulo= new JLabel("Cambiar Contraseña", SwingConstants.CENTER); //para centrar el texto
				panelTitulo.add(titulo);
				
				JLabel passwordTxt1= new JLabel("Nueva Contraseña");
				Password1= new JPasswordField(20);
				
				JLabel passwordTxt2= new JLabel("Repetir Contraseña");
				Password2= new JPasswordField(20);
				
										
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
										
						
						char[] arrayC1 = Password1.getPassword();
						String passwordVal1 = new String(arrayC1);
						
						char[] arrayC2 = Password2.getPassword();
						String passwordVal2 = new String(arrayC2);
						
						actualizarBBDD(passwordVal1, passwordVal2);
										
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
				panelContenido.add(passwordTxt1);				panelContenido.add(Password1);
				panelContenido.add(passwordTxt2);				panelContenido.add(Password2);
						
				buttons.add(read);							buttons.add(create);	
				buttonsAll.add(casillaError);				buttonsAll.add(buttons);					
		// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
				add(panelTitulo, BorderLayout.NORTH);
				add(panelContenido, BorderLayout.CENTER);
				add(buttonsAll, BorderLayout.SOUTH);
				
			}

	private void actualizarBBDD(String passwordVal1, String passwordVal2) {
	
		if (passwordVal1.equals(passwordVal2)) {
			try {
				Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
				
				PreparedStatement sql= conexion.prepareStatement("UPDATE userprofile SET Password=? WHERE User=?");

				sql.setString(1, passwordVal1);
				sql.setString(2, UserAdd);
			
				sql.executeUpdate();			
				sql.close();
				
				Index index= new Index();
				index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				index.setVisible(true);
				setVisible(false);	
				index.casillaError.setText("Se Cambio la contraseña del Usuario en la Base de Datos.");
				
			} catch (SQLException e1) {
			
				casillaError.setText("Actualizacion Invalido.");
			}		
		}else {
			casillaError.setText("Las Contraseñas no Coinciden");
		}
					
				
				
	}

		
	
	

}
