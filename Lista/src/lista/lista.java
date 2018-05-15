package lista;
    //**********************************************************************************************************
public class lista {
    
    private Nodo inicio;            // Punteros
    private Nodo fin;               // Punteros
    //*************************************************************************************************************  
    public lista()
    {
        inicio = null;              //Inicializo punteros a null
        fin = null;
    }
    //*************************************************************************************************************
    public boolean EstadoLista()        //Comprueba si la lista esta vacia 
    {
        if(inicio == null){
            return true;
        }else{
            return false;
        }
    }
    //*************************************************************************************************************
     //Metodo para agregar un Nodo al final de la lista
    public void AgregarFinal(int elemento)
    {
        if(!EstadoLista()){
            fin.sig = new Nodo(elemento);
            fin = fin.sig;
        }else{
            inicio = new Nodo(elemento);
            fin = new Nodo(elemento);
        }
    }
    //************************************************************************************************************* 
    //Metodo para agregar un Nodo al inicio de la lista
    public void AgregarInicio(int elemento)
    {
        //creando al Nodo
        inicio = new Nodo(elemento, inicio);
        if(fin == null){
            fin = inicio;
        }
    }
    //*************************************************************************************************************
    //Metodo para mostrar los datos
    public void MostrarLista()
    {
        Nodo recorrer = inicio;  // CREO UN nODO AUXILIAR PARA RECORRER LÑA LISTA
        System.out.println();
        while(recorrer != null)
        {
            System.out.print("[" + recorrer.dato + "]-->");
            recorrer = recorrer.sig;
        }
    }
    //*************************************************************************************************************
    //Metodo para eliminar dato al inicio de la Lista
    public int EliminarDatoInicio()
    {
        int elemento = inicio.dato;
        if(inicio == fin){
            inicio = null;
            fin = null;
        }else{
            inicio = inicio.sig;
        }
        return elemento;
    }
    //*************************************************************************************************************
    //Metodo para eliminar dato al inicio de la Lista
    public int EliminarDatoFinal()
    {
        int elemento = fin.dato;
        if(inicio == fin){
            inicio = null;
            fin = null;
        }else{
            Nodo temp = inicio;
            while(temp.sig != fin){
                temp = temp.sig;
            }
            fin = temp;
            fin.sig = null;
        }
        return elemento;
    }
    //*************************************************************************************************************
    //Metodo para eliminar dato en cualquier posicion de la Lista
    public boolean EliminarDato(int elemento)
    {
        if(!EstadoLista()){
            if(inicio == fin && elemento == inicio.dato){
                inicio = null;
                fin = null;
            }else if(elemento == inicio.dato){
                inicio = inicio.sig;
            }else{
                Nodo ant = inicio;
                Nodo temp = inicio.sig;
                while(temp != null && temp.dato != elemento){
                    ant = ant.sig;
                    temp = temp.sig;    
                }
                if(temp != null){
                    ant.sig = temp.sig;
                    if(temp == fin){
                        fin = ant;
                    }
                }   
            }  
        }
        return (!EstadoLista());   
    }
    //*************************************************************************************************************
    // Metodo para buscar un Elemento en la Lista
    public boolean BuscarDato (int elemento)
    {
        Nodo temp = inicio;
        while(temp != null && temp.dato != elemento){
            temp = temp.sig;
        }
        return temp != null;
    }
    //*************************************************************************************************************
    // Metodo para buscar un Elemento en la Lista
    public Nodo BuscarDato2 (int elemento)
    {
        Nodo temp;
        for (temp = inicio; temp != null; temp = temp.sig)
            if(elemento == temp.dato)
                return temp;
        return null;
    }
    //*************************************************************************************************************
    // Metodo para Insertar un Elemento en la Lista
    public void InsertarDato(int parada, int elemento)
    {
        Nodo nuevo, anterior; 
        anterior = BuscarDato2 (parada);
        if (anterior != null){
            nuevo = new Nodo(elemento);
            nuevo.sig = anterior.sig;
            anterior.sig = nuevo;
        }
        //return this;
    }
    //*************************************************************************************************************
    //Metodo para Ordenar la Lista Intento Numero 1
    /*public void OrdenarLista()
    {   
        int aux=0;
        Nodo recorrer = inicio;  // CREO UN nODO AUXILIAR PARA RECORRER LÑA LISTA
        System.out.println();
        while(recorrer != null)
        {
            if (recorrer.dato > recorrer.sig.dato){
                aux = recorrer.dato;
                recorrer.dato = recorrer.sig.dato;
                recorrer.sig.dato = aux;
            }
            System.out.print("[" + recorrer.sig.dato + "]-->");
            recorrer = recorrer.sig;
        }
    }*/
    //**************************************************************************************************************    
    // Metodo para Insertar con ordenamiento  elementos a la lista     
    public lista InsertarConOrdenamiento(int elemento)
    {
        Nodo nuevo;
        nuevo = new Nodo(elemento);
        if(inicio == null)
            inicio = nuevo;
        else if (elemento < inicio.getDato())
        {
            nuevo.setEnlace(inicio);
            inicio = nuevo;
        }
        else
        {
            Nodo anterior = inicio;
            Nodo actual = inicio;
            while((actual.getEnlace() != null) && (elemento > actual.getDato()))
            {
                anterior = actual;
                actual = actual.getEnlace();
            }
            if (elemento > actual.getDato())
            {
                anterior = actual;
            }
            nuevo.setEnlace(anterior.getEnlace());
            anterior.setEnlace(nuevo);                    
        }
        return this; 
    }
}
