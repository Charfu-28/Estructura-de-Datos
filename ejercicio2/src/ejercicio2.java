/*un conductor de automovil se encuentra en el kilometro 70 de la autopista Pereira-Bogota, otro conductor
se encuentra en el kilometro 150 de la misma carretera, el primero viaja en direccion a Bogota, mientras 
que el segundo se dirige a Pereira, a la misma velocidad, realice un algoritmo para determinar en qué 
kilometro de esa carretera se encontrarán?*/

public class ejercicio2 {
    
    public static void main(String[] args) {
        int velocidad = 20;
        int acu1=0;
        int acu2=0;
        int x=70;
        int y=150;
        while(x != y){
            for(int t=1; t<180; t++){
                acu1 = velocidad * t;
                x = acu1;
            for (int j=1; j<180; j++){
                acu2 = velocidad * j;
                y = acu2;
            }
            }        
        }System.out.println(x);
    } 
}
