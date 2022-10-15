package FarmaciaBBDD;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ActionDelete extends JFrame{
	
	private JLabel titulo;
	private JPanel panelCodigo, panelErr;
	private JButton enviarCont, regresarCont;
	private JTextField codigoFil;
	String codigoAct,  nombre, descripcionMed, laboratorio, proveedor, fecha;
	int codigo,  precio, IVA, stock;
	private Connection conexion;
	private Statement state;
	
	public ActionDelete() {
		
		setTitle("Eliminar Elementos");
		setBounds(400, 200, 600, 500);	
		Index index= new Index();
		index.setVisible(false);
		setLayout(new BorderLayout());
		
		panelCodigo= new JPanel();
		panelErr= new JPanel(new GridLayout(2,0));
		enviarCont= new JButton("Borrar");
		regresarCont= new JButton("Regresar");
		JLabel codigoL= new JLabel("Codigo");
		codigoFil= new JTextField(20);
		titulo= new JLabel("¿Cual Fila de Elementos Quiere Eliminar?", SwingConstants.CENTER);
		JLabel error= new JLabel("",SwingConstants.CENTER);
		
		
		enviarCont.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				codigoAct= codigoFil.getText();
				
				try {
					Connection conexion=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","");
					
					state= conexion.createStatement();
					int row=  state.executeUpdate("DELETE FROM medicamentos WHERE `Codigo`=" + codigoAct );
					
					if(row >= 1) {						
										
						error.setText("Se Elimino el elemento con el codigo "+ codigoAct);
						
					}else {
						
						error.setText("No se encontro el elemento que coincida con el codigo ingresado.");
					}
						
										
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
