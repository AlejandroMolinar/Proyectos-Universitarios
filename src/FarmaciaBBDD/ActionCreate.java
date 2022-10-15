package FarmaciaBBDD;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ActionCreate extends JFrame{
	
	private JPanel panelCont, panelError, panelBotton, panelBottonTotal;
	private JButton enviarCont, regresarCont;
	private JTextField codigo, nombre, descripcionMed, laboratorio, proveedor, precio, IVA, stock, fecha;
	private JLabel text1;
	
	public ActionCreate() {
		setTitle("Crear Elemento");
		setBounds(400, 200, 600, 500);		
		
			
		setLayout(new BorderLayout());	
		panelCont= new JPanel();	
		panelCont.setLayout(new GridLayout(12,2));	
		
		panelBottonTotal= new JPanel(new GridLayout(2,0));
		panelBotton= new JPanel(new GridLayout(0,2));
		JLabel casillaError= new JLabel("" , SwingConstants.CENTER);
			
		
		text1= new JLabel("Ingrese la Descripcion del Medicamento ", SwingConstants.CENTER);
		//El "SwingConstants.CENTER" es para centrarel Texto			
		
		enviarCont= new JButton("Enviar");		
		regresarCont= new JButton("Regresar");		
		
		
		JLabel codigoTxt= new JLabel("Codigo");
		codigo= new JTextField(20);
		
		JLabel nombreTxt= new JLabel("Nombre");
		nombre= new JTextField(20);
		
		JLabel descripcionMedTxt= new JLabel("Descripcion Medicamento");
		descripcionMed= new JTextField(20);
		
		JLabel laboratorioTxt= new JLabel("Laboratorio");
		laboratorio= new JTextField(20);
		
		JLabel proveedorTxt= new JLabel("Proveedor");
		proveedor= new JTextField(20);
		
		JLabel precioTxt= new JLabel("Precio");
		precio= new JTextField(20);
		
		JLabel IVATxt= new JLabel("%IVA");
		IVA= new JTextField(20);
		
		JLabel stockTxt= new JLabel("Stock");
		stock= new JTextField(20);
		
		JLabel fechaTxt= new JLabel("Fecha");
		fecha= new JTextField(20);				
		
				
		panelCont.add(codigoTxt);			panelCont.add(codigo);
		panelCont.add(nombreTxt);			panelCont.add(nombre);
		panelCont.add(descripcionMedTxt);	panelCont.add(descripcionMed);
		panelCont.add(laboratorioTxt);		panelCont.add(laboratorio);
		panelCont.add(proveedorTxt);		panelCont.add(proveedor);
		panelCont.add(precioTxt);			panelCont.add(precio);
		panelCont.add(IVATxt);				panelCont.add(IVA);
		panelCont.add(stockTxt);			panelCont.add(stock);
		panelCont.add(fechaTxt);			panelCont.add(fecha);
		
		
		panelError= new JPanel(new GridLayout(11,0));
		JLabel error1= new JLabel();						panelError.add(error1);	
		JLabel error2= new JLabel();						panelError.add(error2);
		JLabel error3= new JLabel();						panelError.add(error3);
		JLabel error4= new JLabel();						panelError.add(error4);
		JLabel error5= new JLabel();						panelError.add(error5);
		JLabel error6= new JLabel();						panelError.add(error6);
		JLabel error7= new JLabel();						panelError.add(error7);
		JLabel error8= new JLabel();						panelError.add(error8);
		JLabel error9= new JLabel();						panelError.add(error9);
		
		
		enviarCont.addActionListener(new ActionListener() {	
			
			public void actionPerformed(ActionEvent e) {
				
				boolean band=false; 
				try {				
																	
					if (codigo.getText().equals("")) {
						codigo.setBackground(Color.RED);
						band=true;
					} 
					if (nombre.getText().equals("")) {
						nombre.setBackground(Color.RED);
						band=true;
					}
					if (descripcionMed.getText().equals("")) {
						descripcionMed.setBackground(Color.RED);
						band=true;
					}
					if (laboratorio.getText().equals("")) {
						laboratorio.setBackground(Color.RED);
						band=true;
					}
					if (proveedor.getText().equals("")) {
						proveedor.setBackground(Color.RED);
						band=true;
					}
					if (precio.getText().equals("")) {
						precio.setBackground(Color.RED);
						band=true;
					}
					if (IVA.getText().equals("")) {
						IVA.setBackground(Color.RED);
						band=true;
					}
					if (stock.getText().equals("")) {
						stock.setBackground(Color.RED);
						band=true;
					}
					if (fecha.getText().equals("") ) {
						fecha.setBackground(Color.RED);
						band=true;
					}
					
					
					if (band==false) {
						
						conexionBBDD();
						casillaError.setText("Se inserto el Medicamento en la Base de Datos.");
						
						codigo.setText("");
						nombre.setText("");
						descripcionMed.setText("");
						laboratorio.setText("");
						proveedor.setText("");
						precio.setText("");
						IVA.setText("");
						stock.setText("");
						fecha.setText("");
					
					}				
									
					
				} catch (Exception e2) {
					casillaError.setText("Ingreso invalido.\n\n no ponga letras en la casilla de numeros (Codigo, Precio, Iva, Stock y Fecha)");
					
										
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
	
	public void conexionBBDD() {
		
		try {
			Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
			
			PreparedStatement sql= conexion.prepareStatement("INSERT INTO medicamentos (Codigo, Nombre, DescripcionMedicamento, Laboratorio, Proveedor, Precio, IVA, Stock, Fecha)"
					+ " VALUES (?,?,?,?,?,?,?,?,?)");
			
			sql.setString(1, codigo.getText());
			sql.setString(2, nombre.getText());
			sql.setString(3, descripcionMed.getText());
			sql.setString(4, laboratorio.getText());
			sql.setString(5, proveedor.getText());
			sql.setString(6, precio.getText());
			sql.setString(7, IVA.getText());
			sql.setString(8, stock.getText());
			sql.setString(9, fecha.getText());
			
			sql.executeUpdate();			
			sql.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}			
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
