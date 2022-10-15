package Universidad;

import java.util.Scanner;

public class Ordenamiento_Insercion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		int numeros[], elementos;
		int pos, aux;
		
		System.out.println("Introduzca los numeros que desea ordenar");
		elementos= entrada.nextInt();							//Guarda los elementos que seran ingresados
		
		numeros= new int[elementos];

		
		for (int i=0; i<elementos; i++) {
			System.out.println("Ingresar numero "+ (i+1));
			numeros[i]=entrada.nextInt();			
		}
		
		for (int i = 0; i < elementos; i++) {					//Este es el proceso para ordenar el un conjunto de numeros 
			pos=i;	aux= numeros[i];							//Guarda los valores de la posicion y el valor del numero en cuestión en el pos y aux
			
			while (pos>0 && numeros[pos-1]> aux) {				//Repite mientras se repite la condicion para ir ordenando de derecha a izquierda
				
				numeros[pos]= numeros[pos-1];
				pos--;
				
			}
			numeros[pos]=aux;
			
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
