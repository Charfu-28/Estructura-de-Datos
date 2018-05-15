
package listaenteros;

import java.util.*;

public class ListaEnteros {
    
    public static void main(String[] args) {
    Random r;
    int d;
    Lista lista;
    int k;
    r = new Random();        
    lista = new Lista();
    k = Math.abs(r.nextInt() % 55);
    for (; k > 0; k-- )
    {
        d = r.nextInt() % 99 ;
        lista.insertarCabezaLista(d);
    }
    System.out.println("Elementos de la lista: ");
    lista.visualizar(); 
    } 
}
