
package tipopila;

public class PilaLista {
    
    private NodoPila cima;
    
    public PilaLista()
    {
        cima = null;
    }

    public boolean PilaVacia()
    {
        return cima == null;
    }

    public void Insertar(int elemento) throws Exception
    {
        NodoPila nuevo;
        nuevo = new NodoPila(elemento);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public int Eliminar() throws Exception
    {
        if(PilaVacia())
            throw new Exception ("Pila vacia,no se puede entraer elementos");
        int aux = cima.elemento;
        cima = cima.siguiente;
        return aux;
    }

    public int CimaPila() throws Exception
    {
        if (PilaVacia())
            throw new Exception ("Pila Vacia , No se puede leer");
        return cima.elemento;
    }
    
    public void Visualizar() throws Exception
    {
        if (PilaVacia())
            throw new Exception ("Pila Vacia no hay elementos");
        NodoPila n;
        n = cima;
        while (n != null)
        {
            System.out.println(n.elemento + " ");
            n = n.siguiente;
        }
    }
    
}
