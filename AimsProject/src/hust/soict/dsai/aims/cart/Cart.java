package hust.soict.dsai.aims.cart;
import java.util.*;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private int qtyOrdered = 0;
	private ObservableList<Media> itemsOrdered = 
    		FXCollections.observableArrayList();
	//add 1 media to cart
	public void addMedia(Media media) throws LimitExceededException{
		int count = 0;
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			for (int i=1; i<=itemsOrdered.size(); i++) {
				if (media.getTitle().equals(itemsOrdered.get(i-1).getTitle())==true) {
					count+=1;
				}
			}
			if (count==0) {
				itemsOrdered.add(media);
			}
			else {
				System.out.println("The media you want to add was exist!");
			}
			qtyOrdered+=1;
		}
		else {
			throw new LimitExceededException("ERROR: The number of"
					+"media has reached its limit");
		}
	
	}
	
	//add Media List to cart
		public void addMedia(Media [] medialist) {
			for (int i=0; i<=medialist.length-1; i++) {
				if (qtyOrdered < MAX_NUMBERS_ORDERED) {
					int count = 0;
					for (int j=1; j<=itemsOrdered.size(); j++) {
						if (medialist[i].getTitle().equals(itemsOrdered.get(j-1).getTitle())==true) {
							count+=1;
						}
					}
					if (count==0) {
						itemsOrdered.add(medialist[i]);
						qtyOrdered+=1;
					}
					else {
						System.out.println("The media you want to add was exist!");
					}
				}
				else {
					break;
				}
				
			}
			
		}
		
		// add 2 media to cart
		public void addMedia(Media md1, Media md2) {
			int count = 0;
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				for (int i=1; i<=itemsOrdered.size(); i++) {
					if (md1.getTitle().equals(itemsOrdered.get(i-1).getTitle())==true) {
						count+=1;
					}
				}
				if (count==0) {
					itemsOrdered.add(md1);
				}
				else {
					System.out.println("The media you want to add was exist!");
				}
				qtyOrdered+=1;
			}
			
			int cou = 0;
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				for (int i=1; i<=itemsOrdered.size(); i++) {
					if (md2.getTitle().equals(itemsOrdered.get(i-1).getTitle())==true) {
						cou+=1;
					}
				}
				if (cou==0) {
					itemsOrdered.add(md2);
				}
				else {
					System.out.println("The media you want to add was exist!");
				}
				qtyOrdered+=1;
			}
		
		}
		
	//calculate total cost
	public float totalCost() {
		float sum=0;
		for (int i=1;i<= itemsOrdered.size(); i++) {
			sum+= itemsOrdered.get(i-1).getCost();
		}
		
		return sum;
	}
	

	//remove duplicate Media
	public int removeMedia() {
		int numremov;
		List<Media> newlist = new ArrayList<Media>();
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
	
	//remove a media
	public void removeMedia(Media md) {
		int count = 0;
		for (int i=1; i<=itemsOrdered.size(); i++) {
			if (md.getTitle().equals(itemsOrdered.get(i-1).getTitle())) {
				count+=1;
				itemsOrdered.remove(i-1);
			}
		}
		if (count==0) {
			System.out.println("The media you want to remove was not exist!");
		}
	}
	
	public void sortTitle() {
		Comparator<Media> printComparator = 
				Comparator.comparing(Media::getTitle)
				.thenComparing(Comparator.comparing(Media::getCost).reversed());
		Collections.sort(itemsOrdered, printComparator);
		System.out.println("sort Cart by Title: ");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println("ID "+itemsOrdered.get(i).toString());
		}
		
	}
	public void sortCost() {
		Comparator<Media> printComparator = 
				Comparator.comparing(Media::getCost).reversed()
				.thenComparing(Media::getTitle);
		Collections.sort(itemsOrdered, printComparator);
		
		System.out.println("sort Cart by Cost: ");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println("ID "+itemsOrdered.get(i).toString());
		}
		
	}
	
	public void sortID() {
		Collections.sort(itemsOrdered, new Comparator<Media>() {

			@Override
			public int compare(Media o1, Media o2) {
				int result = 0;
				if (o1.getId()==o2.getId()) {
					result = 0;
				}
				if (o1.getId()<o2.getId()) {
					result = -1;
				}
				if (o1.getId()>o2.getId()) {
					result = 1;
				}
				return result;
				
			}
			
		});
		
		System.out.println("sort Cart by ID: ");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println("ID "+itemsOrdered.get(i).getId()+": "+itemsOrdered.get(i).toString());
		}
		
	}
	
	public void findID() {
		int ID;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the ID: ");
		ID = scanner.nextInt();
		if ((ID>itemsOrdered.size())||(ID<=0)) {
			System.out.println("there is no dvd sastified in the cart!");
		}
		else {
			for (int i=0; i<itemsOrdered.size(); i++) {
				if (itemsOrdered.get(i).getId()==ID) {
					System.out.println(itemsOrdered.get(i).toString());
					break;
				}
			}
		}
	}
	public void print() {
		Comparator<Media> printComparator = 
				Comparator.comparing(Media::getTitle)
				.thenComparing(Comparator.comparing(Media::getCost).reversed());
		Collections.sort(itemsOrdered, printComparator);
		
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (int i=0; i<itemsOrdered.size(); i++) {
			System.out.println((i+1)+". "+itemsOrdered.get(i).toString());
		}
		System.out.println("Total cost: "+totalCost()+" $");
		System.out.println("***************************************************");
		
	}
	
	public void findbyTitle(String tit) {
		int count = 0;
		for (int i=0; i<itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).isMatch(tit)==true) {
				count+=1;
				System.out.println(itemsOrdered.get(i).toString());
			}
		}
		if (count == 0) {
			System.out.println("No match is found!");
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return itemsOrdered.size();
	}
	
	public Media getLuckyItem() {
		int rand = (int)(Math.random()*(itemsOrdered.size()));
		Media media = itemsOrdered.get(rand);
		return media;
	}

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	
}