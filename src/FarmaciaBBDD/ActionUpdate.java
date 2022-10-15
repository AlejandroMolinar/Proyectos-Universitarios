package FarmaciaBBDD;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ActionUpdate extends JFrame{
	
	private JLabel titulo;
	private JPanel panelCodigo, panelErr;
	private JButton enviarCont, regresarCont;
	private JTextField codigoFil;
	String codigoAct,  nombre, descripcionMed, laboratorio, proveedor, fecha;
	int codigo,  precio, IVA, stock;
	private Connection conexion;
	private ResultSet sql;
	private Statement state;
	
	public ActionUpdate() {
		
		setTitle("Actualizar Elementos");
		setBounds(400, 200, 600, 500);	
		Index index= new Index();
		index.setVisible(false);
		setLayout(new BorderLayout());
		
		panelCodigo= new JPanel();
		panelErr= new JPanel(new GridLayout(2,0));
		enviarCont= new JButton("Enviar");
		regresarCont= new JButton("Regresar");
		JLabel codigoL= new JLabel("Codigo");
		codigoFil= new JTextField(20);
		titulo= new JLabel("¿Cual Fila de Elementos Quiere Modificar?", SwingConstants.CENTER);
		JLabel error= new JLabel("",SwingConstants.CENTER);
		
		
		enviarCont.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				codigoAct= codigoFil.getText();
				
				try {
					Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
					
					state= conexion.createStatement();
					sql= state.executeQuery("SELECT Codigo, Nombre, DescripcionMedicamento, Laboratorio, Proveedor, Precio, IVA, Stock, Fecha FROM medicamentos WHERE `Codigo`=" + codigoAct );
					
					if(sql.next()) {						
										
						sql.beforeFirst(); //Regresa al primer puntero 
						while (sql.next()) {
							
							codigo= sql.getInt("Codigo");
							nombre= sql.getString("Nombre");
							descripcionMed= sql.getString("DescripcionMedicamento");
							laboratorio= sql.getString("Laboratorio");
							proveedor= sql.getString("Proveedor");
							precio= sql.getInt("Precio");
							IVA= sql.getInt("IVA");
							stock= sql.getInt("Stock");
							fecha= sql.getString("Fecha");

						}	
						
						ActionAct act= new ActionAct(codigo, nombre, descripcionMed, laboratorio, proveedor, precio, IVA, stock, fecha);
						act.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						act.setVisible(true);
						setVisible(false);
						
					}else {
						
						error.setText("No se encontro el elemento que coincida con el codigo ingresado.");
					}
						
																			
					
					sql.close();
					
				} catch (SQLException e1) {
					
					error.setText("No se encontro el elemento que coincida con el codigo ingresado.");
					
					
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
		
		
		JPanel panelBt= new JPanel();
		 
		panelBt.add(regresarCont);		panelBt.add(enviarCont);
		
		panelCodigo.add(codigoL);		panelCodigo.add(codigoFil);
		panelErr.add(error);			panelErr.add(panelBt);
		
		add(titulo, BorderLayout.NORTH);
		add(panelCodigo, BorderLayout.CENTER);
		add(panelErr, BorderLayout.SOUTH);
		
	}
	
	

}

class ActionAct extends JFrame{
	
	private JPanel panelCont, panelError, panelBotton, panelBottonTotal;
	private JButton enviarCont, regresarCont;
	private JTextField codigo, nombre, descripcionMed, laboratorio, proveedor, precio, IVA, stock, fecha;
	private JLabel text1;
	
	public ActionAct(int codigos, String nombres, String descripcionMeds, String laboratorios, String proveedors, int precios, int IVAs, int stocks, String fechas) {
		
		setTitle("Actualizar Elementos");
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
		codigo.setText(""+codigos);
		codigo.setEditable(false);
		
		JLabel nombreTxt= new JLabel("Nombre");
		nombre= new JTextField(20);
		nombre.setText(""+nombres);
		
		JLabel descripcionMedTxt= new JLabel("Descripcion Medicamento");
		descripcionMed= new JTextField(20);
		descripcionMed.setText(""+descripcionMeds);
		
		JLabel laboratorioTxt= new JLabel("Laboratorio");
		laboratorio= new JTextField(20);
		laboratorio.setText(""+laboratorios);
		
		JLabel proveedorTxt= new JLabel("Proveedor");
		proveedor= new JTextField(20);
		proveedor.setText(""+proveedors);
		
		JLabel precioTxt= new JLabel("Precio");
		precio= new JTextField(20);
		precio.setText(""+precios);
		
		JLabel IVATxt= new JLabel("%IVA");
		IVA= new JTextField(20);
		IVA.setText(""+IVAs);
		
		JLabel stockTxt= new JLabel("Stock");
		stock= new JTextField(20);
		stock.setText(""+stocks);
		
		JLabel fechaTxt= new JLabel("Fecha");
		fecha= new JTextField(20);	
		fecha.setText(""+fechas);
		
				
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
						casillaError.setText("Se Actualizo el Medicamento en la Base de Datos.");
						
										
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
			
			PreparedStatement sql= conexion.prepareStatement("UPDATE `medicamentos` SET `Nombre`=?,"
					+ "`DescripcionMedicamento`=?,`Laboratorio`=?,`Proveedor`=?,`Precio`=?,`IVA`=?,`Stock`=?,`Fecha`=?  WHERE `Codigo`=" + codigo.getText());
			
			sql.setString(1, nombre.getText());
			sql.setString(2, descripcionMed.getText());
			sql.setString(3, laboratorio.getText());
			sql.setString(4, proveedor.getText());
			sql.setString(5, precio.getText());
			sql.setString(6, IVA.getText());
			sql.setString(7, stock.getText());
			sql.setString(8, fecha.getText());
			
			sql.executeUpdate();			
			sql.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}			
	}

}

