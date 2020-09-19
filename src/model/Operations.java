package model;
public class Operations{
	 private static final int total_work = 4880000;
	 
	//method to calculate the total material prices
	public static int total(int[] material_prices){
		int total=0;
		for(int i=0;i<material_prices.length;i++){
			total += material_prices[i]; 
		}
		return total;
	}
	//method to calculate the best material prices
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
	//method that defines which store the best prices belong to
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
	//method that defines the price of transport of materials
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
				 System.out.println("Error, por favor seleccione una ubicacion correcta");
			}
			return price_transport;
	}
	public static int countOnes (int[]utilization) {
		 int countOnes=0;
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==1) {
					   countOnes++;
				  }
		  }
			return countOnes;
	}
	public static int countTwos (int[]utilization) {
		 int countTwos=0;
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==2) {
					   countTwos++;
				  }
		  }
			return countTwos;
	}
	public static int countThrees (int[]utilization) {
		 int countThrees=0;
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==3) {
					   countThrees++;
				  }
		  }
			return countThrees;
	}
	public static String[] roughConstruction (int count,String[]name_material,int[]utilization) {
		 String[] roughConstruction = new String[count];
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==1) {
					   roughConstruction[i]=name_material[i];
				  }
		  }
			return roughConstruction;
	}
	public static String[] finalConstruction (int count,String[]name_material,int[]utilization) {
		 String[] finalConstruction = new String[count];
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==1) {
					   finalConstruction[i]=name_material[i];
				  }
		  }
			return finalConstruction;
	}
	public static String[] paint (int count,String[]name_material,int[]utilization) {
		 String[] paint = new String[count];
		 for(int i=0;i<utilization.length;i++) {
			   if(utilization[i]==1) {
					   paint[i]=name_material[i];
				  }
		  }
			return paint;
	}

} 