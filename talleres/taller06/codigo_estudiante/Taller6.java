
/**
 * Clase en la cual se implementan los metodos del Taller 6
 * 
 * @author Mauricio Toro, Andres Paez
 */
public class Taller6 {

	/*Metodo que En el cual el usuario ingresa el monto de dinero a cambiar*/
	static String cambiost="";
    public static void ValorMonto(){
        int monto=0;
        int cambio=0;
        String cambiost="";
        Scanner teclado = new Scanner(System.in);
        System.out.println(" Digite monto a cambiar: ");
        monto = teclado.nextInt();
        RealizarCambio(monto,cambio);    
    }
    /*Metodo que cambia vorazmente el dinero del usuario con monedas*/
    public static void RealizarCambio(double monto,double cambio){    
        int[] monedas = {100,200,500,1000};
        while(cambio!=monto){
        int i=monedas.length-1;
        System.out.println("Para cambiar: " + monto + " Pesos, se necesita");
           while(i>=0){
            if((cambio+monedas[i])<=monto){
             cambio = cambio+monedas[i];
             cambiost = "\n Una moneda de : "+ monedas[i];
             System.out.println(cambiost);
            }
            else{
                i=i-1;
            }       
        }  
       }      
    }
    
    public static void main(String[] args){
        ValorMonto(); 
    }

//----------------------------------------------------------------------------------------------------------------
	/**
	* Metodo que recorre todo el grafo con la intencion de buscar un
	* camino que represente el menor costo pasando por todos los vertices exactamente
	* una vez y vuelva al nodo inicial
	* @param g grafo dado 
	* @return cual es el costo que tiene
	*/
	public static int recorrido(Digraph g) {
	
	}

}
