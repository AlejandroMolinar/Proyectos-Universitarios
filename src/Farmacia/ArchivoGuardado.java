package Farmacia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchivoGuardado {
	
	public ArchivoGuardado(ArrayList<Medicamentos> medicamentos) {
		
		File txt= null;
		
		try {
			
			txt= new File("medicamentos.txt"); 				
			
			if (txt.exists()) {
				txt.delete();
			}
			
			txt.createNewFile();	
			
			FileWriter escritura= new FileWriter(txt.getAbsolutePath()); 
			BufferedWriter escritura2= new BufferedWriter(escritura);
			
			for (Medicamentos medicamentos2 : medicamentos) {			
				
				escritura2.write(medicamentos2.toString());			
								
			}
			escritura2.close();
			
		} catch (Exception e) {
			
		}
		
		
		
		
	}
	
	
	
}
