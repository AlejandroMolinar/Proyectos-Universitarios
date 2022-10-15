package Farmacia;

import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CargaContenido extends JFrame{
	
	JPanel panelCont, panelError, panelBotton;
	JButton enviarCont;
	int cont=1;
	ArrayList<Medicamentos> medicamentos;
	JTextField codigo, nombre, descripcionMed, laboratorio, proveedor, precio, IVA, stock, fechaDD, fechaMM, fechaYY;
	JLabel text1;
	
	public CargaContenido(int elementos) {
		setTitle("Farmacia");
		setBounds(300, 200, 600, 500);		
		
		
		medicamentos= new ArrayList<Medicamentos>(elementos);
		
		setLayout(new BorderLayout());	
		panelCont= new JPanel();	
		panelCont.setLayout(new GridLayout(12,2));	
		
		panelBotton= new JPanel(new GridLayout(2,0));
		JLabel casillaError= new JLabel();
			
		
		text1= new JLabel("Ingrese la Descripcion del Medicamento "+ cont, SwingConstants.CENTER);
		//El "SwingConstants.CENTER" es para centrarel Texto			
		
		enviarCont= new JButton("Enviar");		
		
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
		fechaDD= new JTextField(5);		
		fechaMM= new JTextField(5);		
		fechaYY= new JTextField(5);
		
		JPanel fecha= new JPanel();
		fecha.add(fechaDD);	fecha.add(fechaMM);	fecha.add(fechaYY);
		
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
					if (fechaDD.getText().equals("") || fechaMM.getText().equals("") || fechaYY.getText().equals("")) {
						fechaDD.setBackground(Color.RED);
						fechaMM.setBackground(Color.RED);
						fechaYY.setBackground(Color.RED);
						band=true;
					}
					
					
					if (band==false) {
						Guardar(elementos);
					
					}				
									
					
				} catch (Exception e2) {
					casillaError.setText("Ingreso invalido.\n\n no ponga letras en la casilla de numeros (Codigo, Precio, Iva, Stock y Fecha)");
					
					Guardar(elementos);
					
				}
				
				
				
			}
		});	
		
		panelBotton.add(casillaError);
		panelBotton.add(enviarCont);
		
		add(panelCont, BorderLayout.WEST);
		add(text1, BorderLayout.NORTH);
		add(panelBotton, BorderLayout.SOUTH);
		
	}
	
	public void Guardar(int elementos) {
		if(cont<elementos){	
			
			codigo.setBackground(Color.WHITE);
			nombre.setBackground(Color.WHITE);
			descripcionMed.setBackground(Color.WHITE);
			laboratorio.setBackground(Color.WHITE);
			proveedor.setBackground(Color.WHITE);
			precio.setBackground(Color.WHITE);
			IVA.setBackground(Color.WHITE);
			stock.setBackground(Color.WHITE);
			fechaDD.setBackground(Color.WHITE);
			fechaMM.setBackground(Color.WHITE);
			fechaYY.setBackground(Color.WHITE);	
			
			
			
			medicamentos.add(new Medicamentos(Integer.parseInt(codigo.getText()), nombre.getText(), descripcionMed.getText()
					, laboratorio.getText(), proveedor.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(IVA.getText()), Integer.parseInt(stock.getText())
					, Integer.parseInt(fechaDD.getText()), Integer.parseInt(fechaMM.getText()), 
					Integer.parseInt(fechaYY.getText())));
			
			cont++;					
			text1.setText("Ingrese la Descripcion del Medicamento "+ cont);
			
			codigo.setText("");
			nombre.setText("");
			descripcionMed.setText("");
			laboratorio.setText("");
			proveedor.setText("");
			precio.setText("");
			IVA.setText("");
			stock.setText("");
			fechaDD.setText("");
			fechaMM.setText("");
			fechaYY.setText("");
			
				
		}else if(cont==elementos){
			medicamentos.add(new Medicamentos(Integer.parseInt(codigo.getText()), nombre.getText(), descripcionMed.getText()
					, laboratorio.getText(), proveedor.getText(), Double.parseDouble(precio.getText()), Integer.parseInt(IVA.getText()), Integer.parseInt(stock.getText())
					, Integer.parseInt(fechaDD.getText()), Integer.parseInt(fechaMM.getText()), 
					Integer.parseInt(fechaYY.getText())));
			
			OrdenamientoBusqueda ordBus=new OrdenamientoBusqueda(medicamentos);
			ordBus.setVisible(true);
			ordBus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setVisible(false);
			dispose();
		}
	}	
}







