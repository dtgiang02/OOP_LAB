package aim;

import java.util.List;
import java.util.ArrayList;
public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private List<DigitalVideoDisc> itemsOrdered = new ArrayList<DigitalVideoDisc>();
	private int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(disc);
			qtyOrdered+=1;
		}
	
	}
	
	public float totalCost() {
		float sum=0;
		for (int i=1;i<= itemsOrdered.size(); i++) {
			sum+= itemsOrdered.get(i-1).getCost();
		}
		return sum;
	}
	public int removeDigitalVideoDisc() {
		int numremov;
		List<DigitalVideoDisc> newlist = new ArrayList<DigitalVideoDisc>();
		for(int i=0; i<=itemsOrdered.size()-2; i++) {
			int dup=0;
			for (int j=i+1; j<=itemsOrdered.size()-1; j++) {
				if (itemsOrdered.get(i).getTitle()==itemsOrdered.get(j).getTitle()) {
					dup+=1;
				}
			}
			if (dup==0) {
				newlist.add(itemsOrdered.get(i));
			}
		}
		numremov = itemsOrdered.size()-newlist.size()-1;
		return numremov;
	}
	//Overloading by differing types of parameter
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdlist) {
		for (int i=0; i<=dvdlist.length-1; i++) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(dvdlist[i]);
				qtyOrdered+=1;
			}
			else {
				break;
			}
			
		}
	
	
		
	
	}
	// Overloading by differing the number of parameters
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2, DigitalVideoDisc dvd3) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(dvd1);
			qtyOrdered+=1;
		}
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(dvd2);
			qtyOrdered+=1;
		}
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(dvd3);
			qtyOrdered+=1;
		}
	
	}
	public void printID() {
		System.out.println("***********************CART***********************");
		for (int i = 0; i < this.qtyOrdered; i++ ) {
			System.out.println(i+1 + ". " + itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("**************************************************");
	}
	public void searchTitle(String title) {
		int count = 0;
		for (int i=0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(title)==true) {
				count+=1;
			}
		}
		if (count == 0) {
			System.out.println("No match is found!");
		}
	}
	public void searchID(int id) {
		int count = 0;
		for (int i=0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(id)==true) {
				count+=1;
			}
		}
		if (count == 0) {
			System.out.println("No match is found!");
		}
	}
}
