
package arbolbianrio0;

public class NodoArbol {
    int dato;
    NodoArbol izdo; 
    NodoArbol dcho; 
    
    public NodoArbol(int valor)
    { 
        dato = valor;
        izdo = dcho = null;
    }
    
    public void ramaIzdo(NodoArbol n)
    {
        izdo = n;
    }
    
    public void ramaDcho(NodoArbol n)
    {
        dcho = n; 
    }
    
    public void visitar()
    {
        System.out.print(dato + " ");
    }
    
    public NodoArbol SAI()  //Subarbol Izquierdo
    {
        return izdo;
    }
    public NodoArbol SAD()  //Subarbol Derecho
    {
        return dcho;
    }

    public void Mostrar(NodoArbol r)
    {
        if (r != null)
        {
            r.visitar();														
            Mostrar(r.SAI());
            Mostrar(r.SAD());
        }
    }
}
