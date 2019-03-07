
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
	static int costoMenor=2147483647;
 static int cosMen=0;
 
 public static int hayCaminoDFS(Digraph g, int v) {
        boolean[] visitados = new boolean[g.size()];
        hayCamino(g, v, visitados,e);
        return costoMenor;
 }

private static boolean hayCamino(Diagraph g, int v,boolean[] visitado, int e){
  boolean fin = true;
  boolean correcto=false;
  
  ArrayList<Integer> proximos=new ArrayList<>();
  ArrayList<Integer> proxVoraz=g.getSuccesors(e);
  for(int i=0;i<visitado.length();i++){
    if(visitado[i]==false && i != v){
      fin=false;
      break;
    }
  }
  proximos.add(proxVoraz.get(0));
  if(proxVoraz.size()<3){ 
    int s=g.getWeight(v,proxVoraz.get(1));
    if(s>proximos.get(0)){
      proximos.add(0,proxVoraz.get(1));
    }
  }else{
    for(int i=1;i<proxVoraz.size();i++){
      int s=g.getWeight(v,proxVoraz.get(i));
       if(s>proximos.get(0)){
          proximos.add(0,proxVoraz.get(i));
        }else{
        for(int h=i;h<proxVoraz.size();h++){
          if(s>proximos.get(h)){
            proximos.add(h,proxVoraz.get(i));
          }
        }
     }
    }
  }
  
  for(int i=0;i<proximos.size();i++){
    int proxVer=proximos.get(i);
    if(proxVer==v && fin){
      if(cosMen<costoMenor){
       costoMenor=cosMen;
      }
      return true;
    }
    if(visitado[proxVer]==false && proxVer != v){
      int costo=g.getWeigth(v,proxVer);
      cosMen+=costo;
      visitado[proxVer]=true;
      correcto=hayCamino(g,v,visitado,proxVer);
      if(!correcto){
        visitado[proxVer]=false;
        cosMen-=costo;
      }
    }
  }
 
  return false;
  
}

}
