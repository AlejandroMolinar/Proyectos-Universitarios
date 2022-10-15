package Farmacia;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OrdenamientoBusqueda  extends JFrame{
	
	JButton enviarbusq,enviarOrd; 
	ButtonGroup Grupo1;
	JTextField busqCont;
	JPanel panelMed, panelOrd;
	
	public OrdenamientoBusqueda(ArrayList<Medicamentos> array) {		
	
			setTitle("Farmacia");
			setBounds(300, 200, 800, 600);		
			setBackground(new Color(255, 122, 93));
			
			setLayout(new BorderLayout());
			JLabel x= new JLabel("Muestra del Contenido", SwingConstants.CENTER);
			JButton actualizar= new JButton("Actualizar");
			JButton guardarArch= new JButton("Guardar en Archivo");
			
			panelMed= new JPanel();
			panelOrd= new JPanel();	
			
				
			JPanel PanelBot= new JPanel(new GridLayout(2,2));	
			JPanel panelBusq= new JPanel();	
			JPanel orden= new JPanel(new GridLayout(8,0));
			JPanel busqueda= new JPanel(new GridLayout(6,0));
			
			JPanel ordBusq= new JPanel(new GridLayout(2,0));			
		
			Impresion(array, panelMed);
			
			JLabel aviso= new JLabel("", SwingConstants.CENTER);
			
//---------------------------Ordenamiento-------------------------------------------------------------------------	
			JLabel textOrd= new JLabel("Ordenar", SwingConstants.CENTER);							orden.add(textOrd);
			Grupo1= new ButtonGroup();
			
			JRadioButton Bo1= new JRadioButton("Burbuja", false);			Grupo1.add(Bo1);		orden.add(Bo1);
			JRadioButton Bo2= new JRadioButton("Insercion", true);			Grupo1.add(Bo2);		orden.add(Bo2);
			JRadioButton Bo3= new JRadioButton("Intercambio", false);		Grupo1.add(Bo3);		orden.add(Bo3);
			JRadioButton Bo4= new JRadioButton("MargeSort", false);			Grupo1.add(Bo4);		orden.add(Bo4);
			JRadioButton Bo5= new JRadioButton("QuickSort", false);			Grupo1.add(Bo5);		orden.add(Bo5);
			JRadioButton Bo6= new JRadioButton("Seleccion", false);			Grupo1.add(Bo6);		orden.add(Bo6);
			enviarOrd= new JButton("Ordenar");														orden.add(enviarOrd);
			
//---------------------------Busqueda------------------------------------------------------------------------				
			JLabel textBusq= new JLabel("Buscar", SwingConstants.CENTER);				busqueda.add(textBusq);
			busqCont= new JTextField(20);												busqueda.add(busqCont);
			enviarbusq= new JButton("Buscar");											busqueda.add(enviarbusq);
			
			ordBusq.add(busqueda);	ordBusq.add(orden);
		
//---------------------------Evento Boton-------------------------------------------------------------------------		
			enviarbusq.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String busqueda= busqCont.getText();
					
					BusquedaMed(array, busqueda);
					
				}
			});
			
			enviarOrd.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String decision="";
										
					if(Bo1.isSelected()) decision= "Burbuja";
					else if(Bo2.isSelected()) decision= "Insercion";
					else if(Bo3.isSelected()) decision= "Intercambio";
					else if(Bo4.isSelected()) decision= "MargeSort";
					else if(Bo5.isSelected()) decision= "QuickSort";
					else if(Bo6.isSelected()) decision= "Seleccion";
					
					new Ordenamiento(array, decision); 
					
					
					if(panelMed.isVisible()) {
						panelOrd.setVisible(true);
						panelOrd.removeAll();
						panelMed.setVisible(false);
						Impresion(array, panelOrd);
					}
					
				}
			});
			
			actualizar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					if (panelOrd.isVisible()) {
						panelOrd.setVisible(false);
						panelMed.setVisible(true);
						panelOrd.removeAll();
					}
				}
			});
			
			guardarArch.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					ArchivoGuardado txt= new ArchivoGuardado(array); 
					aviso.setText("Archivo Guardado");
					
					
				}
			});
			
			
			
			
			PanelBot.add(actualizar);	PanelBot.add(guardarArch);
			PanelBot.add(aviso);
			
			add(x, BorderLayout.NORTH);			
			add(ordBusq, BorderLayout.EAST);
			add(panelMed, BorderLayout.WEST);
			add(panelOrd, BorderLayout.CENTER);
			add(PanelBot, BorderLayout.SOUTH);
			
			
		}
	
	private void Impresion(ArrayList<Medicamentos> array, JPanel panelNew) {
		
			
		for (int i = 0; i < array.size(); i++) {
			
			JTextArea sas= new JTextArea("");
			sas.setText(""+array.get(i));
			sas.setEditable(false);
			panelNew.add(sas);
			
		}
		
	}
	
//---------------------------Proceso de Busqueda-------------------------------------------------------------------------	
	public void BusquedaMed(ArrayList<Medicamentos> array, String busqueda) {
		
		boolean band=false;
		
		if(panelMed.isVisible()) {
			panelOrd.setVisible(true);
			panelMed.setVisible(false);
			panelOrd.removeAll();
		}
		
		for (int i = 0; i < array.size(); i++) {
			
			if(busqueda.equalsIgnoreCase(array.get(i).getNombre())) {
				
				JTextArea sas= new JTextArea("");
				sas.setText(""+array.get(i));
				sas.setEditable(false);
				panelOrd.add(sas);
				
				band=true;
				
			}			
			
		}
		
		if (band==false) {
			JLabel error= new JLabel("No se Encontro Elementos que Coincidan con la Buqueda", SwingConstants.CENTER);
			panelOrd.add(error);
		}
		
	}
	
	
	
}