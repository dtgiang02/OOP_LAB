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

}