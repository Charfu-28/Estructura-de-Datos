package tipocola;

import java.util.Scanner;

public class TipoCola {

    public static void main(String[] args) {
        
        ColaLista pila = new ColaLista();
        
        int x;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite Numero de elementos: ");
        
        try 
        {
        x = entrada.nextInt();        
        for (int j=1; j<=x; j++)
        {
            System.out.println("Digite " + j +" elemento: ");
            int d;
            d = entrada.nextInt();
            pila.Insertar(d);
        }
        System.out.println("Elementos de la Cola");
        pila.Visualizar();

        System.out.println("Eliminar Elementos de la Cola");
        while(!pila.EstadoCola())
        {
            int d;
            d = (int)pila.QuitarElemento();
            if (d>0)
            {
                System.out.println(" De la Cola " +"Eliminando " + d);                    
            }               
        }
        System.out.println("Elemenetos Actuales de la Cola");
        pila.Visualizar();
        }
        catch (Exception e)
        {
            System.out.println("\n Error en el proceso ... " + e);
            e.getStackTrace();
        }
    }
    
}
