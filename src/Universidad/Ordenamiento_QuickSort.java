package Universidad;

import java.util.Scanner;

public class Ordenamiento_QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner entrada= new Scanner(System.in);
		
		int numeros[], elementos;
		
		
		System.out.println("Introduzca los numeros que desea ordenar");
		elementos= entrada.nextInt();							//Guarda los elementos que seran ingresados
		
		numeros= new int[elementos];

		
		for (int i=0; i<elementos; i++) {
			System.out.println("Ingresar numero "+ (i+1));
			numeros[i]=entrada.nextInt();			
		}
		
		QuickSort(numeros, 0, numeros.length-1);
		
		System.out.println("\nNumeros Ordenados:\n");
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.print(numeros[i]);
			
			if(numeros[i]<numeros[i+1]) {
				System.out.print(" , ");
			}
		}
		entrada.close();
		
	}
	public static void QuickSort(int numeros[], int izquierda, int derecha ) {
		
		
		int izq=izquierda;		int der=derecha;
		int pivote;				int aux;
		
		pivote= numeros[(izq+der)/2];
		
		while (izq<=der) {
			
			while (numeros[der] > pivote) {
				der--;				
			}			
			while (numeros[izq] < pivote) {
				izq++;
			}
			
			if (izq<=der) {
				aux= numeros[der];
				numeros[der] =numeros[izq];
				numeros[izq]= aux;
				izq++;
				der--;
			}			
			
		}
		
		if (izquierda<der) {
			QuickSort(numeros, izquierda, der);
		}
		if (izq<derecha) { 	
			QuickSort(numeros, izq, derecha);
		}
			
	}

}
