package tipocola;

public class ColaLista {
    //Declaro dos nodos para el frente y fin de la Cola
    protected NodoCola frente;
    protected NodoCola fin;
    // Constructor que crea la cola vacia
    public ColaLista()  
    {
        frente = null;
        fin = null;
    }
    //Metod Para saber el estado de la Cola 
    public boolean EstadoCola()
    {
        return frente == null;
    }
    //Metodo para insertar elementos por el final de la cola
    public void Insertar (Object elem)
    {
        NodoCola nuevo = new NodoCola(elem);
        if(EstadoCola())
        {
            frente = nuevo;
        }
        else
        {
            fin.sig = nuevo;
        }
        fin = nuevo;
    }
    //Metodo Para Quitar Elementos de La Cola....Siempre sale el elmento Frente
    public Object QuitarElemento() throws Exception
    {
        Object temp;
        if(!EstadoCola())
        {
            temp = frente.elem;
            frente = frente.sig;
        }
        else
        {
            throw new Exception("Error: No hay Elementos Para Quitar...COLA VACIA");
        }
        return temp;
    }
    //Metodo Para Liberar Todos Los Elementos de la Cola
    public void LiberarCola()
    {
        while(frente != null)
        {
            frente = frente.sig;
        }
        frente = fin = null;
    }
    //Metodo Para Acceder al Primer Elemento de la Cola
    public Object FrenteCola() throws Exception
    {
        if(EstadoCola())
        {
            throw new Exception("Error: La Cola Está Vacḯa.");
        }
        else
        {
           return frente.elem; 
        }
    }
    //Metodo Para Mostrar los Elementos de la Cola
     public void Visualizar() throws Exception
    {
        if (EstadoCola())
            throw new Exception ("Cola Vacia no hay elementos");
        NodoCola n;
        n = frente;
        while (n != null)
        {
            System.out.println(n.elem + " ");
            n = n.sig;
        }
    }    
}
