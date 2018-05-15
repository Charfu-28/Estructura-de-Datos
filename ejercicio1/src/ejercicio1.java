/*Una persona adquirio un producto para pagar en 24 meses. El primer mes pago $10, el segundo mes $20,
el tercero $40 y asi sucesivamente. Realice un algoritmo para determinar cuanto debe pagar mensualmente
y el total de lo que pagó después de los 24 meses.*/

public class ejercicio1 { 
    
    public static void main(String[] args) {
        int cont=10;
        int total=0;
        for(int i=1; i<=24; i++){
            System.out.print("Valor a pagar en el mes "+i);
            System.out.println(":  "+cont);
            cont = cont * 2;
        }
           System.out.println("El valor total pagado por el producto es de: "+cont);
    }    
} 
