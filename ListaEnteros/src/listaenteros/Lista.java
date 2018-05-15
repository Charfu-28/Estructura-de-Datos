
package listaenteros;

public class Lista {
    
    private Nodo primero;
    
    public Lista()
    {
        primero = null;
    }
  
    public Lista insertarCabezaLista(int entrada)
    {
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        nuevo.enlace = primero; 
        primero = nuevo;
        return this;  
    }
    
    public void visualizar()
    {
        Nodo n;
        int k = 0;
        n = primero;
        while (n != null)
        {
            System.out.print(n.dato + "  ");
            n = n.enlace;
           
            
        }
    }
}
