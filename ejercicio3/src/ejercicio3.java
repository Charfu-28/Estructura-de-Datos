/*Ejercicio 3: Se requiere un algoritmo para obtener un vector (C) de N elementos que contenga
la suma de los elementos correspondientes de otros dos vectores (A y B).*/

import java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) {
        int valor = 0;
        int t = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño de los vectores a sumar:");
        t = sc.nextInt();
        int[] vectA = new int[t];   // vector A con entrada por teclado
        int[] vectB = new int[t];   // vector B con entrada por teclado
        int[] vectC = new int[t];   // Vector que devuelve la suma de A y B
        
        for(int i=0; i<vectA.length; i++){ //Captura de elementos vector A
            System.out.print("Vector A: Ingrese numero: ");
            valor = sc.nextInt();
            vectA[i] = valor;
	}
        
        for(int i=0; i<vectB.length; i++){ // Captura de lementod vector B
            System.out.print("Vector B: Ingrese numero: ");
            valor = sc.nextInt();
            vectB[i] = valor;
	}
        
        System.out.print("Vector A: ");
        for(int i: vectA){              //imprimo datos del vector A
            System.out.print(i + " ");
        }
        
        System.out.println(" ");
        System.out.print("Vector B: ");
        for(int i: vectB){              //imprimo datos del vector B
            System.out.print(i + " ");
        }
        
        System.out.println(" ");
        System.out.print("La suma de los vectores A y B es: ");  
        for(int i=0; i<vectC.length; i++){  // Suma de los elementos de los vectores A y B en el vector C               
            vectC[i] = vectA[i]+vectB[i];
	}
        
        System.out.print("Vector C: ");
        for(int i: vectC){              //imprimo datos del vector C
            System.out.print(i + " ");
        }
    }   
}
