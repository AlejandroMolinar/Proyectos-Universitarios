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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;



public class ProfileUser extends JFrame{
	
	JPanel panelTitulo, panelContenido;
	private JTextField  User, LastName, FirstName, Identification ,Phone, Email,  Career, Semester;
	private String seleccionAdd[] = {"Cerrar Sesion", "Actualizar", "Borrar Cuenta", "Cambiar Contraseña"};
	JComboBox<String> seleccion;
	private Connection conexion;
	private ResultSet sql;
	private Statement state;
	
	JLabel casillaError;
	
	private JButton guardar, update;
	private JComboBox<String> Pais;		
	private String paises[]= {"Venezuela", "Colombia", "Chile", "Peru", "España"};
	
	private String UserAdd;
	private String LastNameAdd;
	private String FirstNameAdd;
	private String IdentificationAdd;
	private String PhoneAdd;
	private String EmailAdd;
	private String CareerAdd;
	private String SemesterAdd;
	private String PaisAdd;
	
	public ProfileUser(String userAdd, String lastNameAdd, String firstNameAdd, String identificationAdd, String phoneAdd, String emailAdd, String careerAdd, String semesterAdd, String paisAdd) {
		UserAdd = userAdd;
		LastNameAdd = lastNameAdd;
		FirstNameAdd = firstNameAdd;
		IdentificationAdd = identificationAdd;
		PhoneAdd = phoneAdd;
		EmailAdd = emailAdd;
		CareerAdd = careerAdd;
		SemesterAdd = semesterAdd;
		PaisAdd = paisAdd;		
	
// -----------------------------------------JFrame--------------------------------------------------------------------------		
		setTitle("Usuario: " + UserAdd);
		setBounds(400, 200, 600, 500);		
		getContentPane().setLayout(new BorderLayout());
		
// -----------------------------------------Content--------------------------------------------------------------------------		
		JLabel txtStart= new JLabel("Hola "+ FirstNameAdd +" "+ LastNameAdd, SwingConstants.CENTER);
		
		panelContenido= new JPanel();
		panelContenido.setLayout(new GridLayout(12,2));
		casillaError= new JLabel("" , SwingConstants.CENTER);
		
		JLabel UserTxt= new JLabel("Usuario");
		User= new JTextField(20);
		User.setEditable(false);
		User.setText(UserAdd);
		
		JLabel LastNameTxt= new JLabel("Apellidos");
		LastName= new JTextField(20);
		LastName.setEditable(false);
		LastName.setText(LastNameAdd);
		
		JLabel FirstNameTxt= new JLabel("Nombres");
		FirstName= new JTextField(20);
		FirstName.setEditable(false);
		FirstName.setText(FirstNameAdd);
		
		JLabel IdentificationTxt= new JLabel("Cédula");
		Identification= new JTextField(20);
		Identification.setEditable(false);
		Identification.setText(IdentificationAdd);
		
		JLabel PhoneTxt= new JLabel("N° de Teléfono");
		Phone= new JTextField(20);
		Phone.setEditable(false);
		Phone.setText(PhoneAdd);
		
		JLabel EmailTxt= new JLabel("Correo");
		Email= new JTextField(20);
		Email.setEditable(false);
		Email.setText(EmailAdd);		
		
		JLabel CareerTxt= new JLabel("Carrera");
		Career= new JTextField(20);
		Career.setEditable(false);
		Career.setText(CareerAdd);
		
		JLabel SemesterTxt= new JLabel("Semestre");
		Semester= new JTextField(20);
		Semester.setEditable(false);
		Semester.setText(SemesterAdd);
		
		JLabel PaisTxt= new JLabel("Pais");
		Pais= new JComboBox<String>(paises);
		Pais.setEnabled(false);

		if (paisAdd.equals("Venezuela")) {
			Pais.setSelectedIndex(0);
		}else if (paisAdd.equals("Colombia")) {
			Pais.setSelectedIndex(1);
		} else if (paisAdd.equals("Chile")) {
			Pais.setSelectedIndex(2);
		} else if (paisAdd.equals("Peru")) {
			Pais.setSelectedIndex(3);
		} else if (paisAdd.equals("España")) {
			Pais.setSelectedIndex(4);
		}
		
		
// -----------------------------------------Action--------------------------------------------------------------------------		
		JPanel buttons= new JPanel();
		
		seleccion= new JComboBox<String>(seleccionAdd);
		update= new JButton("Enter");
		guardar= new JButton("Guardar");
		guardar.setVisible(false);
		
		update.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				String selec= seleccion.getSelectedItem().toString();
				
				if (selec.equals("Cerrar Sesion")) {
					Index index= new Index();
					index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					index.setVisible(true);
					setVisible(false);					
					
				} else if (selec.equals("Actualizar")) {
					update.setVisible(false);
					guardar.setVisible(true);
					seleccion.setVisible(false);
					actualizarBBDD();
					
					
					
				} else if (selec.equals("Borrar Cuenta")) {
					BorrarBBDD();
					
				} else if (selec.equals("Cambiar Contraseña")) {
					
					ChangePassword ChPass= new ChangePassword(UserAdd);
					ChPass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					ChPass.setVisible(true);
					setVisible(false);
				}
				

			}
		});
		
		
		
// -----------------------------------------Add Panel--------------------------------------------------------------------------		
		panelContenido.add(UserTxt);				panelContenido.add(User);
		panelContenido.add(LastNameTxt);			panelContenido.add(LastName);
		panelContenido.add(FirstNameTxt);			panelContenido.add(FirstName);
		panelContenido.add(IdentificationTxt);		panelContenido.add(Identification);
		panelContenido.add(PhoneTxt);				panelContenido.add(Phone);
		panelContenido.add(EmailTxt);				panelContenido.add(Email);
		panelContenido.add(CareerTxt);				panelContenido.add(Career);
		panelContenido.add(SemesterTxt);			panelContenido.add(Semester);		
		panelContenido.add(PaisTxt);				panelContenido.add(Pais);		

		buttons.add(casillaError);					buttons.add(seleccion);						buttons.add(update);				buttons.add(guardar);
// --------------------------------------------Add---------------------------------------------------------------------------------------------	
		
		getContentPane().add(buttons, BorderLayout.SOUTH);
		getContentPane().add(txtStart, BorderLayout.NORTH);
		getContentPane().add(panelContenido, BorderLayout.CENTER);	
		
		
	}

	
	private void actualizarBBDD() {
		
		User.setEditable(true);
		LastName.setEditable(true);
		FirstName.setEditable(true);
		Identification.setEditable(true);
		Phone.setEditable(true);
		Email.setEditable(true);
		Career.setEditable(true);
		Semester.setEditable(true);	
		Pais.setEnabled(true);

		
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
					
					PreparedStatement sql= conexion.prepareStatement("UPDATE userprofile SET User=?, LastName=?, "
							+ "FirstName=?, Identification=?, Phone=?, Email=?, Career=?, Semester=?, Pais=?  WHERE User=?");
					
					sql.setString(1, User.getText());
					sql.setString(2, LastName.getText());
					sql.setString(3, FirstName.getText());
					sql.setString(4, Identification.getText());
					sql.setString(5, Phone.getText());
					sql.setString(6, Email.getText());
					sql.setString(7, Career.getText());
					sql.setString(8, Semester.getText());
					sql.setString(9, Pais.getSelectedItem().toString());
					sql.setString(10,User.getText());
					
					sql.executeUpdate();			
					sql.close();
					
					User.setEditable(false);
					LastName.setEditable(false);
					FirstName.setEditable(false);
					Identification.setEditable(false);
					Phone.setEditable(false);
					Email.setEditable(false);
					Career.setEditable(false);
					Semester.setEditable(false);	
					Pais.setEnabled(false);
					
					update.setVisible(true);
					guardar.setVisible(false);
					seleccion.setVisible(true);
					
					casillaError.setText("Se Actualizo el Usuario en la Base de Datos.");
					
				} catch (SQLException e1) {
				
					casillaError.setText("Actualizacion Invalido.");
				}			
			
				
				
				
			}
		});
		
	}
	
	private void BorrarBBDD() {
		

		try {
			Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
			
			PreparedStatement sql= conexion.prepareStatement("DELETE FROM userprofile WHERE User=?");
			sql.setString(1, User.getText());
			
			Boolean row= sql.execute();	
			
			if(row==false) {						
								
				Index index= new Index();
				index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				index.setVisible(true);
				setVisible(false);	
				index.casillaError.setText("Se Elimino el elemento con el codigo "+  User.getText());
				
			}else {
				
				casillaError.setText("No se encontro el elemento que coincida con el codigo ingresado.");
			}
				
								
		} catch (SQLException e1) {
			
			casillaError.setText("No se encontro el elemento que coincida con el codigo ingresado.");
			
			
		}			
	}
	
}

