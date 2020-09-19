package ui;
import model.*;
import java.util.Scanner;
public class Integrative{
//method main to fill the arrays 

 public static void main(String[]args){
	 Scanner sc = new Scanner(System.in);
	 int amount=0;
	 int selection=0;
	 String location = "";
	 System.out.println("¿Cuantos materiales desea ingresar?:");
	 amount = sc.nextInt(); 
	 
   //arrays

	 String[] name_material = new String[amount];
	 double[] amount_material = new double[amount];
	 int[] utilization = new int[amount];
	 int[] homecenter = new int[amount];
	 int[] local_store = new int[amount];
	 int[] hub_store	 = new int[amount];

   //get data 
  
	 for(int i=0;i<amount;i++){
		 System.out.println("Ingrese el nombre del material: ");
		 name_material[i] = sc.next();
		 System.out.println("Ingrese la cantidad del material: ");
		 amount_material[i] = sc.nextDouble();
		 System.out.println("Por favor indique la utilizacion del anterior material, presione: 1 para obra negra, 2 para obra blanca, y 3 para pintura: ");
		 utilization[i]=sc.nextInt();
     System.out.print("Ingrese el precio del producto en Home Center: ");
		 homecenter[i]=sc.nextInt();
		 System.out.print("Ingrese el precio del producto en la Fereteria del Barrio: ");
		 local_store[i]=sc.nextInt();
		 System.out.print("Ingrese el precio del producto en la Ferreteria del Centro: ");
		 hub_store[i]=sc.nextInt();

		}
		
	 System.out.println("Ingrese por favor la ubicacion de su inmmueble, escriba norte, sur o centro");
	 location = sc.next();
	 
	 //call methods 
		
	 showData(homecenter,local_store,hub_store,name_material,amount,location,utilization);
	 categoryList(sc,name_material,utilization,selection);
		
  }
	
	public static void showData(int[]homecenter,int[]local_store,int[]hub_store,String[]name_material,int amount,String location,int[] utilization){
	 System.out.println("Total cuenta en Home Center incluida mano de obra: " + (Operations.total(homecenter)));
	 System.out.println("Total cuenta en la Ferreteria del Barrio incluia mano de obra: " + Operations.total(local_store));
	 System.out.println("Total cuenta en la Ferreteria del Centro incluida mano de obra:" + Operations.total(hub_store));
	 System.out.println("Las mejores opciones para comprar son: ");
	 int[]best_prices= Operations.bestOption(homecenter,local_store,hub_store,amount);
	 for(int i=0;i<amount;i++){	   
		   System.out.println(name_material[i]+" a un precio de "+ Operations.bestOption(homecenter,local_store,hub_store,amount)[i]+" pesos en "+ Operations.stores(best_prices,homecenter,local_store,hub_store,amount)[i]);
		}
	 System.out.println("EL total de la cuenta con los mejores precios para cada producto incuida mano de obra es: " + Operations.total(best_prices) + " pesos");
	 int total = Operations.total(best_prices);
	 System.out.println("El precio de transporte es: " + Operations.transport(total,location) + " pesos");
	  
  }
	public static void categoryList (Scanner sc,String[]name_material,int[]utilization,int selection) {
	 int countOnes=Operations.countOnes(utilization);
	 int countTwos=Operations.countTwos(utilization);
	 int countThrees=Operations.countThrees(utilization);
	 System.out.println("¿Cual lista desea desplegar?, precione 1 para Obra negra, 2 para Obra blanca y 3 para Pintura");
	 selection = sc.nextInt();
	 if(selection==1) {
	    for(int j=0;j<countOnes;j++) {
	       System.out.println(Operations.roughConstruction(countOnes,name_material,utilization)[j]);
	    }
	  }
	 else if (selection==2) {
	    for(int j=0;j<countTwos;j++) {
	       System.out.println(Operations.finalConstruction(countTwos,name_material,utilization)[j]);
	    }
	  }
	 else if (selection==3) {
	    for(int j=0;j<countThrees;j++) {
	       System.out.println(Operations.paint(countThrees,name_material,utilization)[j]);
	    }
	  }
	}
}