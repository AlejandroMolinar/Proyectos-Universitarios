package Universidad;

import java.util.Scanner;

public class Ordenamiento_Seleccion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		int numeros[], elementos;
		int aux, min;
		
		System.out.println("Introduzca los numeros que desea ordenar");
		elementos= entrada.nextInt();			//Guarda los elementos que seran ingresados
		
		numeros= new int[elementos];

		
		for (int i=0; i<elementos; i++) {
			System.out.println("Ingresar numero "+ (i+1));
			numeros[i]=entrada.nextInt();			
		}
		
		for (int i = 0; i < elementos; i++) {					//Este es el proceso para ordenar el un conjunto de numeros
			min = i;
			for (int j = i+1; j < elementos; j++) {				
				if (numeros[min] > numeros[j]) {				//Si, numero actual > numero siguiente = Cambiar 
					min = j;					
				}													
			}
			aux= numeros[i];
			numeros[i] =numeros[min];
			numeros[min]= aux; 
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
