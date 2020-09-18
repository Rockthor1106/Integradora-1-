package model;
public class Operations{
	private static final int black_work = 1300000;
	private static final int white_work = 2600000;
	private static final int paint = 980000; 
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
} 