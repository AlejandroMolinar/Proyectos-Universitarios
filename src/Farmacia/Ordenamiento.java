package Farmacia;

import java.util.ArrayList;

public class Ordenamiento {	
	
	public Ordenamiento(ArrayList<Medicamentos> array, String decision) { 
		
		int[] codigo= new int[array.size()];
		
		for (int i = 0; i < array.size(); i++) {
			
			codigo[i]=array.get(i).getCodigo(); 
			
		}
		//System.out.println(codigo);
		
		switch (decision) {
		case "Burbuja":
			
			for (int i = 0; i < (codigo.length-1); i++) {					
				for (int j = 0; j < (codigo.length-1); j++) {				
					if (codigo[j] > codigo[j+1]) {					
						
						int aux= codigo[j];
						codigo[j]= codigo[j+1];
						codigo[j+1]=aux;
					}													
				}
				
			}
			
			break;			
		case "Insercion":
			
			for (int i = 0; i < codigo.length; i++) {					
				int pos=i;
				int aux= codigo[i];							
				
				while (pos>0 && codigo[pos-1]> aux) {				
					codigo[pos]= codigo[pos-1];
					pos--;
					
				}
				codigo[pos]=aux;
				
			}
			
			break;		
		case "Intercambio":
			int aux;
			for (int i = 0; i < (codigo.length); i++) {					
				for (int j = i+1; j <codigo.length; j++) {				  
					if (codigo[i] > codigo[j]) {					
						
						aux= codigo[i];
						codigo[i] =codigo[j];
						codigo[j]= aux; 
						
					}													
				}
				
			}
			
			break;
		case "MargeSort":
			abstract class Mergesort{
				
				public Mergesort() {
					mergesort(codigo, 0, codigo.length);
				}
				
				void mergesort(int arr[], int left, int right) {
					
					if(left < right){

					    //Encuentra el punto medio del vector.
					      int middle = (left + right) / 2;
					      
					    //Divide la primera y segunda mitad (llamada recursiva).
					      mergesort(codigo, left, middle);
					      mergesort(codigo, (middle+1), right);

					    //Une las mitades.
					      merge(codigo, left, middle, right);
					    }
				}
				
				void merge(int arr[], int left,int middle, int right) {
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
			
			break;
		case "QuickSort":
			
			abstract class QuickSort{
				public QuickSort() {
					quickSort(codigo, 0, codigo.length);
				}
				
				void quickSort(int numeros[], int izquierda, int derecha ) {
					
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
						quickSort(numeros, izquierda, der);
					}
					if (izq<derecha) { 	
						quickSort(numeros, izq, derecha);
					}
						
				}
			}
			
			
			break;
		case "Seleccion":
			int min;
			for (int i = 0; i < codigo.length; i++) {	
				min = i;
				for (int j = i+1; j < codigo.length; j++) {				
					if (codigo[min] > codigo[j]) {				
						min = j;					
					}													
				}
				aux= codigo[i];
				codigo[i] =codigo[min];
				codigo[min]= aux; 
			}
			
			break;
		default:
			System.out.println("Error: Seleccion Incorrecta");
			break;
		}
		
		ArrayList<Medicamentos> aux= new ArrayList<Medicamentos>();
		for (int i = 0; i < array.size(); i++) {
			for (int j = 0; j < array.size(); j++) {
				
				if(codigo[i]==array.get(j).getCodigo()) {
					
					aux.add(new Medicamentos((int)array.get(i).getCodigo(), array.get(i).getNombre(), array.get(i).getDescripcionMed()
							, array.get(i).getLaboratorio(), array.get(i).getProveedor(), (double)array.get(i).getPrecio(),(int)array.get(i).getIVA(), (int)array.get(i).getStock()
							, (int)array.get(i).getFechaDD(), (int)array.get(i).getFechaMM(), 
							(int)array.get(i).getFechaYY()));
					
					array.set(i, array.get(j));
					
					array.set(j, new Medicamentos((int)aux.get(i).getCodigo(), aux.get(i).getNombre(), aux.get(i).getDescripcionMed()
							, aux.get(i).getLaboratorio(), aux.get(i).getProveedor(), (double)aux.get(i).getPrecio(),(int)aux.get(i).getIVA(), (int)aux.get(i).getStock()
							, (int)aux.get(i).getFechaDD(), (int)aux.get(i).getFechaMM(), 
							(int)aux.get(i).getFechaYY()));
					
				}
			}
			
		}
				
	}
}
