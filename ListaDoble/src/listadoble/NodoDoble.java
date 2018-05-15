package listadoble;

public class NodoDoble
{    
    public Object Id,nombre,apellido,edad,origen,destino;
    NodoDoble siguiente;
    NodoDoble anterior;
    //**************************************************************************************************************
    //Constructor Para cuando ya hay elementos en la lista
    public NodoDoble (Object d, Object n, Object ap, Object p, Object o, Object de, NodoDoble s, NodoDoble a)
    {        
        Id = d ;
        nombre = n;
        apellido = ap;
        edad = p;
        origen = o;
        destino = de;
        siguiente = null;
        anterior = null;
    }
    //************************************************************************************************************** 
}
