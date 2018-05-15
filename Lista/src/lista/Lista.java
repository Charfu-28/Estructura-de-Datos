package lista;

import javax.swing.JOptionPane;

public class Lista {

    public static void main(String[] args) {
        lista listaAux = new lista();      
        int opcion=0,elem,recorrer;
        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar al Inicio de la Lista\n"
                         + "2. Agregar al Final de la Lista\n"
                         + "3. Mostrar datos de la Lista\n"
                         + "4. Eliminar Primer Elemento de la Lista\n"
                         + "5. Eliminar Ultimo Elemento de la Lista\n"
                         + "6. Eliminar Un Elemento de la Lista\n"
                         + "7. Buscar Un Elemento en la Lista\n"
                         + "8. Insertar Un Elemento en la Lista\n"
                         + "9. Insercion Con Ordenamiento\n"
                         + "10. Salir","Menú de Opciones",3));
                switch(opcion){
                    case 1:
                        try{
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento:","Insertando al inicio",3));
                            listaAux.AgregarInicio(elem);
                        }catch(NumberFormatException n){
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento:","Insertando al Final",3));
                            listaAux.AgregarFinal(elem);
                        }catch(NumberFormatException n){
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 3:
                        listaAux.MostrarLista();
                        break;
                    case 4:
                        elem = listaAux.EliminarDatoInicio();
                        JOptionPane.showMessageDialog(null,"El Elemento Eliminado es: " + elem, "Eliminando Nodo del Inicio",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        elem = listaAux.EliminarDatoFinal();
                        JOptionPane.showMessageDialog(null,"El Elemento Eliminado es: " + elem, "Eliminando Nodo del Final",JOptionPane.INFORMATION_MESSAGE); 
                        break;
                    case 6:
                        elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento a Eliminar:","Eliminando Datos",JOptionPane.INFORMATION_MESSAGE));
                        if(listaAux.EliminarDato(elem) == true){
                            JOptionPane.showMessageDialog(null,"El Elemento Eliminado es: " + elem, "Eliminando Dato",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,"El Elemento " + elem + " NO está en la Lista","Dato No encontrado",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:                        
                        elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento a Buscar:","Buscando Dato",JOptionPane.INFORMATION_MESSAGE));
                        if(listaAux.BuscarDato(elem) == true){                            
                            JOptionPane.showMessageDialog(null,"El Elemento " + elem + " SI está en la Lista","Dato Encontrado",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,"El Elemento " + elem + " NO está en la Lista","Dato No Encontrado",JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 8:                        
                        try{
                            recorrer = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Dato despues del cual desea Insertar:","Ingresando Dato",JOptionPane.INFORMATION_MESSAGE));
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento a Insertar:","Insertando Dato",3));
                                listaAux.InsertarDato(recorrer,elem);                                                                                                         
                        }catch(NumberFormatException n){
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 9:                    
                        try{
                            elem = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el Elemento:","Insertando Elemento",3));                           
                            listaAux.InsertarConOrdenamiento(elem);
                        }catch(NumberFormatException n){
                            JOptionPane.showMessageDialog(null, "Error" + n.getMessage());
                        }
                        break;
                    case 10:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción Incorrecta");
                }
            }catch (Exception e){ 
                JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
            }
        }while(opcion!=10);
    }
}
