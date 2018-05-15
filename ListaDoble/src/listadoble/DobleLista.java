
package listadoble;

public class DobleLista {
    
    private NodoDoble inicio;
    private NodoDoble fin;
    //**************************************************************************************************************
    //Constructor Por defecto inicializa la Lista
    public DobleLista ()
    {
        inicio = null;
        fin = null;
    }
    //**************************************************************************************************************
    //Metodo para saber estado de la lista    
    public boolean EstadoLista()
    {
        return inicio == null;
    }
    //**************************************************************************************************************
    //Metodo para Insertar Elementos al final de la Lista
    public DobleLista InsertarFinal(Object d, Object n, Object ap, Object p, Object o, Object de)
    {
        NodoDoble nuevo;
        nuevo = new NodoDoble(d,n,ap,p,o,de,null,fin);
        if (inicio == null)
        {
            inicio = nuevo;
        }
        else
        {
            NodoDoble aux = inicio;
            while(aux.siguiente != null)
            {
                aux = aux.siguiente;
            }
            if(aux.siguiente == null)
            {
                aux.siguiente = nuevo;
            }
        }
        return this;        
    }
    //**************************************************************************************************************
    //Metodo para Insertar Elementos al inicio de la Lista
    public DobleLista InsertarInicio(Object d, Object n, Object ap, Object p, Object o, Object de)
    {
        NodoDoble nuevo;
        nuevo = new NodoDoble(d,n,ap,p,o,de,inicio,null);
        nuevo.siguiente = inicio;
        if (inicio != null)
            inicio.anterior = nuevo;
        inicio = nuevo;
        return this;       
    }
    //**************************************************************************************************************
    //Metodo para Visualizar Elementos de la Lista
    public void VisualizarLista()
    {            
        NodoDoble recorrer = inicio;
        System.out.println();
            System.out.println("[No. Identifiacion]"+"\t\t"+"[Nombres]"+"\t\t\t"+"[Apellidos]"+"\t\t"+"[Edad]"+"\t\t"+"[Lugar De Origen]"+"\t"+"[Lugar de Destino]"+"\n");
        while(recorrer != null)
        {
            System.out.print("["+recorrer.Id+"\t\t\t"+recorrer.nombre+"\t\t\t"+recorrer.apellido+"\t\t"+recorrer.edad+"\t\t"+recorrer.origen+"\t\t\t"+recorrer.destino+"]\n");
            recorrer = recorrer.siguiente;
        }             
    }
    //**************************************************************************************************************
   //Metodo para Eliminar Elementos del Inicio de la Lista
    public Object  EliminarNodoInicio()
    {
        Object elem = inicio.Id;
        if(inicio == fin)
        {
            inicio = fin = null;
        }
        else
        {
            inicio = inicio.siguiente;
        }
        return elem;
    }
    //**************************************************************************************************************
    /*Metodo para Eliminar Elementos del final de la Lista
    public void EliminarNodoFin()
    {
        NodoDoble temp = fin;
        if(temp == inicio)
        {
            inicio = fin = null;
        }
        else
        {
            fin = temp.anterior;
            temp.siguiente = null;
        }
        
    }*/
    //**************************************************************************************************************
    //Metodo para Eliminar Elementos del final de la Lista
    public Object  Buscar(Object destino)
    {
        NodoDoble recorrer;
        for (recorrer = inicio; recorrer!= null; recorrer = recorrer.siguiente)
        {
            if(destino.equals(recorrer.Id))
                return recorrer;
             
        }
        return null;
    }
    //**************************************************************************************************************
    //Metodo para Eliminar Elementos del final de la Lista
    public Object  BuscarAux(Object destino)
    {
        NodoDoble recorrer;
        for (recorrer = inicio; recorrer!= null; recorrer = recorrer.siguiente)
        {
            if(destino.equals(recorrer.Id))
            {
                System.out.print("["+recorrer.Id+"\t\t\t"+recorrer.nombre+"\t\t\t"+recorrer.apellido+"\t\t"+recorrer.edad+"\t\t"+recorrer.origen+"\t\t\t"+recorrer.destino+"]\n");
                return recorrer;
            }                 
        }
        return null;
    }
    //**************************************************************************************************************
    //Metodo para Eliminar Elementos  de la Lista
    public void EliminarDato (Object entrada)
    {
        NodoDoble actual = inicio;
        NodoDoble atras = inicio.anterior;
        while(actual != null)
        {
            if (entrada.equals(actual.Id))
            {
                if(actual == inicio)                
                {
                    inicio = inicio.siguiente;
                    //inicio.anterior = null;
                }
                else
                {
                    atras.siguiente = actual.siguiente;
                    //actual.siguiente.anterior = actual.anterior;
                }
            }
            atras = actual;
            actual = actual.siguiente;
        }
    }           
}
