package aim;

import java.util.ArrayList;
import java.util.List;
public class Store {

	private List<DigitalVideoDisc> itemsInStore = new ArrayList<DigitalVideoDisc>();
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore.add(disc);
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		itemsInStore.remove(disc);
	}
	
	public void printStore() {
		for (int i=0; i<itemsInStore.size();i++) {
			System.out.println(itemsInStore.get(i).toString());
		}
	}


}