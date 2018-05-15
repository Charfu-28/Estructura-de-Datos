
package tipopila;

import java.util.*;

public class TipoPila {

    
    public static void main(String[] args)  throws Exception 
    {
        
        PilaLista pila = new PilaLista();
        
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
        System.out.println("Elementos de la pila");
        pila.Visualizar();

        System.out.println("Eliminar Elementos de la Pila");
        while(!pila.PilaVacia())
        {
            int d;
            d = (int)pila.Eliminar();
            if (d>0)
            {
                System.out.println(" De la Pila " +"Eliminando " + d);                    
            }               
        }
        System.out.println("Elemenetos Actuales de la Pila");
        pila.Visualizar();
        }
        catch (Exception e)
        {
            System.out.println("\n Error en el proceso ... " + e);
            e.getStackTrace();
        }
    }  
}
