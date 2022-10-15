package Universidad;

import java.util.Scanner;

public class Ordenamiento_MargeSort {
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
		
		mergesort(numeros, 0, (numeros.length-1));
		
		System.out.println("\nNumeros Ordenados:\n");
		
		for (int i = 0; i < numeros.length; i++) {
			
			System.out.print(numeros[i]);
			
			if(numeros[i]<numeros[i+1]) {
				System.out.print(" , ");
			}
		}
		entrada.close();
		
	}
	
	public static void mergesort(int arr[], int left, int right){
	    if(left < right){

	    //Encuentra el punto medio del vector.
	      int middle = (left + right) / 2;
	      
	    //Divide la primera y segunda mitad (llamada recursiva).
	      mergesort(arr, left, middle);
	      mergesort(arr, (middle+1), right);

	    //Une las mitades.
	      merge(arr, left, middle, right);
	    }
	}
	
	
	public static void merge(int arr[], int left, int middle, int right) {
		  //Encuentra el tamaño de los sub-vectores para unirlos.
		  int n1 = middle - left + 1;
		  int n2 = right - middle;

		  //Vectores temporales.
		  int leftArray[] = new int [n1];
		  int rightArray[] = new int [n2];

		  //Copia los datos a los arrays temporales.
		  for (int i=0; i < n1; i++) {
		    leftArray[i] = arr[left + i];
		  }
		  for (int j=0; j < n2; j++) {
		    rightArray[j] = arr[middle + j + 1];
		  }
		  /* Une los vectorestemporales. */

		  //Índices inicial del primer y segundo sub-vector.
		  int i = 0, j = 0;

		  //Índice inicial del sub-vector arr[].
		  int k = left;

		  //Ordenamiento.
		  while (i < n1 && j < n2) {
		    if (leftArray[i] <= rightArray[j]) {
		      arr[k] = leftArray[i];
		      i++;
		    } else {
		        arr[k] = rightArray[j];
		        j++;
		    }
		    k++;
		  }//Fin del while.

		  /* Si quedan elementos por ordenar */
		  //Copiar los elementos restantes de leftArray[].
		  while (i < n1) {
		    arr[k] = leftArray[i];
		    i++;
		    k++;
		  }
		  //Copiar los elementos restantes de rightArray[].
		  while (j < n2) {
		    arr[k] = rightArray[j];
		    j++;
		    k++;
		  }
		}
}
