package lista;

public class Nodo {
    
    public int dato;
    public Nodo sig;                 //Puntero enlace
    
    public Nodo(int a)              // Constructor para insertar al final
    {
        this.dato = a;
        this.sig = null;
    }
    
    public Nodo(int a, Nodo n)      // Constructor para insertar al inicio
    {
        dato = a;
        sig = n;
    }
    
    public int getDato()
    {
        return dato;
    }
    public Nodo getEnlace()
    {
        return sig;
    }
    public void setEnlace(Nodo sig)
    {
        this.sig = sig;
    }
}
