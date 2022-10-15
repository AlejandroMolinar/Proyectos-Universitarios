package FarmaciaBBDD;

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
	
	JPanel panelTitulo, panelContenido;
	static Index visual;
	

	public static void main(String[] args) {
			
		visual=new Index();
		visual.setVisible(true);		
	}
	
	
	public Index(){
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
		setTitle("Farmacia");
		setBounds(400, 200, 600, 500);		
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		

// --------------------------------------------JPanel---------------------------------------------------------------------------------------------			
		panelTitulo= new JPanel();
		JLabel titulo= new JLabel("¿Que Quiere Hacer?", SwingConstants.CENTER); //para centrar el texto
		panelTitulo.add(titulo);
		
		panelContenido= new JPanel();
		panelContenido.setLayout(new GridLayout(13,0));
	// -------------------------------------------------------------------------------------------------------------------	
		JLabel espacio1= new JLabel();
		JLabel createT= new JLabel("Crear un elemento en la BBDD", SwingConstants.CENTER);
		JButton create= new JButton("Create");	
		
		create.addActionListener(new ActionListener() {				
			public void actionPerformed(ActionEvent e) {
				
				ActionCreate Acreate= new ActionCreate(); 
				Acreate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Acreate.setVisible(true);
				setVisible(false);
			}
		});
	// -------------------------------------------------------------------------------------------------------------------		
		JLabel espacio2= new JLabel();
		JLabel readT= new JLabel("Leer La BBDD", SwingConstants.CENTER);
		JButton read= new JButton("Read");			
		
		read.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				ActionRead Aread= new ActionRead();
				Aread.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Aread.setVisible(true);
				setVisible(false);
			}
		});
	// -------------------------------------------------------------------------------------------------------------------	
		JLabel espacio3= new JLabel();
		JLabel updateT= new JLabel("Actualizar la BBDD", SwingConstants.CENTER);
		JButton update= new JButton("Update");		
		
		update.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				ActionUpdate Aupdate= new ActionUpdate();
				Aupdate.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Aupdate.setVisible(true);
				setVisible(false);
			}
		});
	// -------------------------------------------------------------------------------------------------------------------	
		JLabel espacio4= new JLabel();
		JLabel deleteT= new JLabel("Eliminar elemento de BBDD", SwingConstants.CENTER);
		JButton delete= new JButton("Delete");				
		JLabel espacio5= new JLabel();
		
		delete.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				
				ActionDelete Adelete= new ActionDelete();
				Adelete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Adelete.setVisible(true);
				setVisible(false);
			}
		});
	// -------------------------------------------------------------------------------------------------------------------		
		panelContenido.add(espacio1);		panelContenido.add(createT);		panelContenido.add(create);
		panelContenido.add(espacio2);		panelContenido.add(readT);			panelContenido.add(read);
		panelContenido.add(espacio3);		panelContenido.add(updateT);		panelContenido.add(update);
		panelContenido.add(espacio4);		panelContenido.add(deleteT);		panelContenido.add(delete);
		panelContenido.add(espacio5);
// --------------------------------------------JFrame---------------------------------------------------------------------------------------------	
		add(panelTitulo, BorderLayout.NORTH);
		add(panelContenido, BorderLayout.CENTER);
		
	}


	
}
