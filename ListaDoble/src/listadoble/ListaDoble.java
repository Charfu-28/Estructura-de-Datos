package listadoble;

import javax.swing.JOptionPane;

public class ListaDoble {

    public static void main(String[] args) {
       
        DobleLista lista = new DobleLista();
        int op=0;
        Object elem0,elem1,elem2,elem3,elem4,elem5;
        do{
            try
            {
                op = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "                  MENU DE OPCIONES\n\n"+
                        "Que Operacion desea Realizar ?\n\n"+
                        "1. Registro de Usuario (Inicio de la Lista)\n"+
                        "2. Registro de Usuario (Final de la Lista)\n" +
                        "3. Visualizar Usuarios Registrados en la Lista\n" +
                        "4. Eliminar Usuario Por el Inicio de la Lista\n" +
                        "5. Eliminar Usuario Por el Final de la Lista\n" +
                        "6. Buscar Usuario en la Lista\n" +
                        "7. Eliminar Cualquier Usuario de la Lista\n" +
                        "8. Salir" ,
                        "LISTA DE PASAJEROS", JOptionPane.INFORMATION_MESSAGE));
                switch(op)
                {
                    case 1:                        
                        elem0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Número de Identificacion: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem1 = (JOptionPane.showInputDialog(null, "Ingrese Apellidos: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem2 = (JOptionPane.showInputDialog(null, "Ingrese Nombres: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su Edad: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem4 = (JOptionPane.showInputDialog(null, "Origen: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem5 = (JOptionPane.showInputDialog(null, "Destino: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        lista.InsertarInicio(elem0,elem1,elem2,elem3,elem4,elem5);
                        break;
                    case 2: 
                        elem0 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese Número de Identificacion: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem1 = (JOptionPane.showInputDialog(null, "Ingrese Apellidos: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem2 = (JOptionPane.showInputDialog(null, "Ingrese Nombres: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem3 = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese su Edad: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem4 = (JOptionPane.showInputDialog(null, "Origen: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        elem5 = (JOptionPane.showInputDialog(null, "Destino: ", "Registro de Usuario", JOptionPane.INFORMATION_MESSAGE));
                        lista.InsertarFinal(elem0,elem1,elem2,elem3,elem4,elem5);
                        break;
                    case 3: 
                        if(!lista.EstadoLista())
                        {
                            lista.VisualizarLista();
                        }else
                        {
                            JOptionPane.showMessageDialog(null,"No hay Usuarios Registrados","Lista Vacía",JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 4: 
                        if(!lista.EstadoLista())
                        {
                            elem0 = lista.EliminarNodoInicio();
                            JOptionPane.showMessageDialog(null,"Se Eliminó el Registro de Usuario Identificado con CC: "+ elem0,"Eliminando Registro de Usuario de la Lista",JOptionPane.INFORMATION_MESSAGE);
                        }else
                        {
                            JOptionPane.showMessageDialog(null,"No hay Usuarios En Lista","Lista Vacía",JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 5: 
                        if(!lista.EstadoLista())
                        {
                            //lista.EliminarNodoFin();
                            JOptionPane.showMessageDialog(null,"Se Eliminó el Registro de Usuario. ","Eliminando Registro de Usuario de la Lista",JOptionPane.INFORMATION_MESSAGE);
                        }else
                        {
                            JOptionPane.showMessageDialog(null,"No hay Usuarios En Lista","Lista Vacía",JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 6: 
                        if(!lista.EstadoLista())
                        {
                            elem0 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese la Cc del Usuario a Buscar:","Buscando Usuario por ID",JOptionPane.INFORMATION_MESSAGE));
                            if(lista.BuscarAux(elem0) != null){                            
                                JOptionPane.showMessageDialog(null,"El Usuario con Cc: " + elem0 + " SI está en la Lista","Usuario Encontrado",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null,"El Usuario con Cc: " + elem0 + " NO está en la Lista","Usuario No Encontrado",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else
                        {
                            JOptionPane.showMessageDialog(null,"No hay Usuarios En Lista","Lista Vacía",JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 7:
                        if(!lista.EstadoLista())
                        {
                            elem0 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese Cc de Usuario a Eliminar:","Eliminando Datos de Usuario",JOptionPane.INFORMATION_MESSAGE));
                            if(lista.Buscar(elem0) != null){
                                lista.EliminarDato(elem0);
                                JOptionPane.showMessageDialog(null,"El Usuario Con Cc: " + elem0 + " Se Eliminó de la Lista", "Eliminando Datos de usuario",JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                JOptionPane.showMessageDialog(null,"El Usuario Con Cc: " + elem0 + " NO está en la Lista","Usuario No Registrado",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }else
                        {
                            JOptionPane.showMessageDialog(null,"No hay Usuarios En Lista","Lista Vacía",JOptionPane.INFORMATION_MESSAGE);
                        } 
                        break;
                    case 8: 
                        break;                        
                    default:
                        JOptionPane.showMessageDialog(null,"La Opcion es Incorrecta","Error",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            catch(NumberFormatException n)
            {
                JOptionPane.showMessageDialog(null, "Error" + n);
            }            
        }while(op != 8);
    }    
}
