package Farmacia;

import javax.swing.JFrame; 
import javax.swing.JOptionPane;

public class index {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int elementos=Integer.parseInt(JOptionPane.showInputDialog("Diga cuantos Medicamentos desea Ingresar:"));
			
			CargaContenido visual= new CargaContenido(elementos);
			visual.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			visual.setVisible(true);
			
		} catch (Exception e) {
			System.out.println("Error.");
			//e.printStackTrace();
			
		}
		
	}

}
