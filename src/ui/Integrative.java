package ui;
import model.*;
import java.util.Scanner;
public class Integrative{
private static final int total_labor=4880000;
 /**<b> Method main to declare the arrays and fill them</b><br>
 *<b> pre: </b> The methods used in this method must be created and have correct operation <br>
 *<b> pre: </b> The scanner sc must be iniatialized <br>
 *<b> pre: </b> The arrays name_material, amount_material, utililzation, homecenter, local_store  and hub_store must be  declared and initialilzed <br>
 *<b> pre: </b> The variable amount have to be an integer <br>
 *<b> pre: </b> The variable selection have to be an integer<br>
 *<b> pre: </b> The variable location have to be an string <br>
 *<b> pre: </b> The data entered in the name_material array must be only words <br>
 *<b> pre: </b> The integer introduced in the array utilization have to be only 1,2 o 3 <br>
 */

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
  /**<b> Method that shows to the user the data about materials after the relevant calculations </b><br>
  *<b> pre: </b> The arrays received per parameter must be declared and initialized <br>
  *<b> pre: </b> For every array the data inside of they must be of corresponding type<br>
	*<b> pre: </b> The array location have to be only the words requested from the user by a message of console <br>
	*<b> post: </b> Is necessary declare and initialize a new array where save the best prices for after use them in other method<br>
	*<b> post: </b> Is necessary declare and initialize a variable of integer type where save the total of the best prices for after use that total in other method<br>
	*<b> post: </b> This method does not return anything<br>
	*@param homecenter An array of integers <br>
	*@param local_store An array of integers <br>
	*@param hub_store An array of integers <br>
	*@param name_material An array of string <br>
	*@param amount An integer <br>
	*@param location A string <br>
	*@param utilization An array of integers <br>
	*/
	public static void showData(int[]homecenter,int[]local_store,int[]hub_store,String[]name_material,int amount,String location,int[] utilization){
	 System.out.println("Total cuenta en Home Center incluida mano de obra: " + Operations.total(homecenter)+total_labor);
	 System.out.println("Total cuenta en la Ferreteria del Barrio incluia mano de obra: " + Operations.total(local_store)+total_labor);
	 System.out.println("Total cuenta en la Ferreteria del Centro incluida mano de obra:" + Operations.total(hub_store)+total_labor);
	 System.out.println("Las mejores opciones para comprar son: ");
	 int[]best_prices= Operations.bestOption(homecenter,local_store,hub_store,amount);
	 for(int i=0;i<amount;i++){	   
		   System.out.println(name_material[i]+" a un precio de "+ Operations.bestOption(homecenter,local_store,hub_store,amount)[i]+" pesos en "+ Operations.stores(best_prices,homecenter,local_store,hub_store,amount)[i]);
		}
	 System.out.println("EL total de la cuenta con los mejores precios para cada producto incuida mano de obra es: " + Operations.total(best_prices) + " pesos");
	 System.out.println("La mano de obra total tiene un valor de: " + total_labor);
	 int total = Operations.total(best_prices);
	 System.out.println("El precio de transporte es: " + Operations.transport(total,location) + " pesos");
	 System.out.println("El precio final sumando los tres valores anteriores es: " + (Operations.total(best_prices)+total_labor+Operations.transport(total,location)));
	  
  }
	/** <b>Method that deploy a list with the material for the caterogy that the user selects </b><br>
	*<b> pre: </b> Scanner sc must be initialized<br>
	*<b> pre: </b> All the array received per parameter must be declared and initialized wit the corresponding data type <br>
	*<b> pre: </b> The integer selection must be a number between 1 and 3<br>
	*<b> post: </b>This method does not return anything<br>
	*<b> post: </b>Is necessary declare a<br>
	*@param sc A scanner <br>
	*@param name_material An array of string <br>
	*@param utilization An array of integers <br>
	*@param selection An integer <br>
	*/
	public static void categoryList (Scanner sc,String[]name_material,int[]utilization,int selection) {
	 int count=Operations.count(utilization,selection);
	 System.out.println("¿Cual lista desea desplegar?, precione 1 para Obra negra, 2 para Obra blanca y 3 para Pintura");
	 selection = sc.nextInt();
	 if(selection==1) {
	    for(int j=0;j<count;j++) {
	       System.out.println(Operations.CategoryConstruction(count,name_material,utilization,selection)[j]);
	    }
	  }
	 else if (selection==2) {
	    for(int j=0;j<count;j++) {
	       System.out.println(Operations.CategoryConstruction(count,name_material,utilization,selection)[j]);
	    }
	  }
	 else if (selection==3) {
	    for(int j=0;j<count;j++) {
	       System.out.println(Operations.CategoryConstruction(count,name_material,utilization,selection)[j]);
	    }
	  }
	}
}