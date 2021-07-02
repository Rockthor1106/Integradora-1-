package model;
public class Operations{
	 
  /**<b> Method to calculate the total material prices </b><br>
	*<b> pre: </b> The array matererial_prices must be declared and initialized <br>
	*<b> pre: </b> The array material_prices have to be an array of integers <br>
	*<b> pre: </b> The integers inside of array have to be the price of each material <br>
	*<b> post: </b> The variable total must be declared and initialized <br>
	*<b> post: </b> returns an integer with the total price of materials <br>
	*@param material_prices An array of integers <br>
	*/
	public static int total(int[] material_prices){
		int total=0;
		for(int i=0;i<material_prices.length;i++){
			total += material_prices[i]; 
		}
		return total;
	}
	/**<b> Method to calculate the best material prices </b><br>
	*<b> pre: </b> The arrays received per parameter must be declared and initialized <br>
	*<b> pre: </b> Every array have to be of integers <br>
	*<b> pre: </b> The integers inside of every array have to be the price of materials for each store<br>
	*<b> post: </b> The array best_prices must be declared and initialized <br>
	*<b> post: </b> returns an array of integers with the best prices of materials <br>
	*@param homecenter An array of integers <br>
	*@param local_store An array of integers <br>
	*@param hub_store An array of integers <br>
	*@param amount An integer <br>
	*/
	public static int[] bestOption(int[]homecenter,int[]local_store,int[]hub_store,int amount){
		int[] best_prices=new int[amount];
	  for(int i=0;i<amount;i++) {
       if(homecenter[i]<local_store[i]) {
				 best_prices[i]=homecenter[i];
			 }
			 else if(local_store[i]<hub_store[i]) {
				 best_prices[i]=local_store[i];
			 }
			 else {
				 best_prices[i]=hub_store[i];
			 }
	  }
		return best_prices;
	}
	/**<b> Method that defines which store the best prices belong to </b><br>
	*<b> pre: </b> The arrays received per parameter must be declared and initialized <br>
	*<b> pre: </b> Every array have to be of integers <br>
	*<b> pre: </b> The integers inside of every array have to be the price of materials for each store<br>
	*<b> post: </b> The array best_prices must be declared and initialized <br>
	*<b> post: </b> returns an array of integers with the best prices of materials <br>
	*@param best_prices An array of integers <br>
	*@param homecenter An array of integers <br>
	*@param local_store An array of integers <br>
	*@param hub_store An array of integers <br>
	*@param amount An integer <br>
	*/
	public static String[] stores(int[]best_prices,int[]homecenter,int[]local_store,int[]hub_store,int amount){
		String[] stores = new String[amount];
		for(int i=0;i<amount;i++){
		  if(best_prices[i]==homecenter[i]) {
			   stores[i]="Homecenter";
			}
		  else if(best_prices[i]==local_store[i]) {
				 stores[i]="Ferreteria del barrio";
			}
			else {
				 stores[i]="Ferreteria del centro";
			}
		}
		return stores;
	}
	/**<b> Method that defines the price of transport of materials for each location depending on the total of the account </b><br>
	*<b> pre: </b> The arrays received per parameter must be declared and initialized <br>
	*<b> pre: </b> The integer total have to be the total price of materials without labor <br>
	*<b> pre: </b> The array location have to be only the words requested from the user by a message of console <br>
	*<b> post: </b> The variable price_transport must be declared and initialized <br>
	*<b> post: </b> returns an integer with the price of transport of materials<br>
	*@param total An integer <br>
	*@param location An array of string <br>
	*/
	public static int transport (int total,String location) {
		 int price_transport=0;
		 if(location.equalsIgnoreCase("norte") && total < 80000){
			   price_transport = 120000;
		  }
			else if(location.equalsIgnoreCase("norte") && total < 300000) {
				 price_transport = 28000;
			}
			else if(location.equalsIgnoreCase("norte") && total >= 300000) {
				price_transport = 0;
			}
			else if(location.equalsIgnoreCase("sur") && total < 80000){
			   price_transport = 120000;
		  }
			else if(location.equalsIgnoreCase("sur") && total < 300000) {
				 price_transport = 55000;
			}
			else if(location.equalsIgnoreCase("sur") && total >= 300000) {
				price_transport = 0;
			}
			else if(location.equalsIgnoreCase("centro") && total < 80000){
			   price_transport = 50000;
		  }
			else if(location.equalsIgnoreCase("centro") && total < 300000) {
				 price_transport = 0;
			}
			else if(location.equalsIgnoreCase("centro") && total >= 300000) {
				price_transport = 0;
			}
			else {
				 System.out.println("Error, por favor ingrese una ubicacion correcta");
			}
			return price_transport;
	}
	/**<b> Method that counts the numbers that belong to the user selection </b><br>
	*<b> pre: </b> The arrays and variables received per parameter must be declared and initialized <br>
	*<b> pre: </b> The integer selection have to be a number between 1 and 3 <br>
	*<b> post: </b> Is necessary declare and initialize a variable count <br>
	*<b> post: </b> Returns a integer with the amount of numbers that belong to user selection, example amount of numbers one in the array utilization <br>
	*@param utilization An array of integers <br>
	*@param selection An integer <br>
	*/
	public static int[] count (int[]utilization,int selection) {
		 int[] count = new int[3];
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==selection) {
				   count[selection-1]++;
			   }
		 }
		 return count;
	}
	/**<b> Method that creates an array where save the materials that belong to selection of user2 </b><br>
	*<b> pre: </b> The arrays and variables received per parameter must be declared and initialized <br>
	*<b> pre: </b> Selection have to be a number between 1 and 3 <br>
	*<b> post: </b> Is necessary declare an array of string type for save the names of materials that belong to user selection <br>
	*<b> post: </b> Returns an array with the materials that belong to selection of user<br>
	*@param count An integer <br>
	*@param name_material An array of string <br>
	*@param utilization An array of integers <br>
	*@param selection An integer <br>
	*/
	public static String[] CategoryConstruction (int count,String[]name_material,int[]utilization,int selection) {
		 String[] CategoryConstruction = new String[count];
		 for(int i=0;i<count;i++) {
			 CategoryConstruction[i]=name_material[i];
		 }
		 return CategoryConstruction;
	}
}