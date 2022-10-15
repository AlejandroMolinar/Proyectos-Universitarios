package Universidad;

import java.util.Scanner;

public class Ordenamiento_Burbuja {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		int numeros[], elementos;
		
		System.out.println("Introduzca los numeros que desea ordenar");
		elementos= entrada.nextInt();			//Guarda los elementos que seran ingresados
		
		numeros= new int[elementos];

		
		for (int i=0; i<elementos; i++) {
			System.out.println("Ingresar numero "+ (i+1));
			numeros[i]=entrada.nextInt();			
		}
		
		for (int i = 0; i < (elementos-1); i++) {					//Este es el proceso para ordenar el un conjunto de numeros 
			for (int j = 0; j < (elementos-1); j++) {				//Se pone (elemento-1) porque con 4 iteraciones es suficiente para ordenar el conjunto de numeros  
				if (numeros[j] > numeros[j+1]) {					//Si, numero actual > numero siguiente = Cambiar 
					
					int aux= numeros[j];
					numeros[j]= numeros[j+1];
					numeros[j+1]=aux;
				}													
			}
			
		}
		
		System.out.println("\nNumeros Ordenados:\n");
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.print(numeros[i]);
			
			if(numeros[i]<numeros[i+1]) {
				System.out.print(" , ");
			}
		}
		entrada.close();
		
	}

}
