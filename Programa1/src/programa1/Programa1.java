package programa1;

import java.util.Scanner;

public class Programa1 {
    
    public static void Costo (int cant){
        Scanner sc = new Scanner(System.in);
        int n;
        int ResInd; //resultado individual 
        int ResGrp;//resultdo grupal
        int ValorFijo=400000;
        
        System.out.println("Ingrese la cantiddad de Personas que desean viajar: ");
        n = sc.nextInt();
        if (n>=100)
        {
            ResGrp = n * 6500;
            ResInd = (ResGrp / n);
            System.out.println("El valor total a pagar es de : $" + ResGrp );
            System.out.println("El valor a pagar por cada Persona es de :  $" + ResInd);
        }
        else if (n>=50 && n<=99)
	{
            ResGrp = n * 7000;
            ResInd = (ResGrp / n);
            System.out.println("El valor total a pagar es de : $" + ResGrp );
            System.out.println("El valor a pagar por cada Persona es de : $" + ResInd);
	}
	else if (n>=30 && n<=49)
	{
            ResGrp = n * 9500;
            ResInd = (ResGrp / n);
            System.out.println("El valor total a pagar es de : $" + ResGrp );
            System.out.println("El valor a pagar por cada Persona es de : $" + ResInd);
	}
	else{
            ResInd = (ValorFijo / n);
            System.out.println("El valor total a pagar es de : $" + ValorFijo );
            System.out.println("El valor a pagar por cada Persona es de : $" + ResInd);
	}
    }
    
    public static void main(String[] args) {
        System.out.println("\nVIAJE DE ESTUDIOS\n");
        Costo(1);      
    }   
}
