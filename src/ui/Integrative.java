package ui;
import model.*;
import java.util.Scanner;
public class Integrative{
//method main to fill the arrays 

 public static void main(String[]args){
	 Scanner sc = new Scanner(System.in);
	 int amount=0;
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
		
	 showData(homecenter,local_store,hub_store,name_material,amount,location);
		
  }
	
	public static void showData(int[]homecenter,int[]local_store,int[]hub_store,String[]name_material,int amount,String location){
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
}