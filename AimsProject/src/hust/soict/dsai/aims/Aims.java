package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.CompactDisc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.disc.Track;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public class Aims {

	public static void main(String[] args) throws LimitExceededException, PlayerException {
		MemoryDaemon md = new MemoryDaemon();
		Store store = new Store();
		Cart cart = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		DigitalVideoDisc dvd0 = new DigitalVideoDisc("The Lion King",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd0);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alain",
				"Animation", 18.99f);
		store.addMedia(dvd3);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin",
				"Animation", 18.99f);
		store.addMedia(dvd4);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladn",
				"Animation", 18.99f);
		store.addMedia(dvd5);
		
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("The Harry",
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd6);
		
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("Harry Porter",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd7);
		
		List<String> authors = new ArrayList<String>();
		String content1 = "Toi la cuong. Chao cac ban";
		String content2 = "Calculus is the easiest subject in the world. Everyone can learn calculus easily";
		String content3 = "Algebra is the second. Algebra is very easy. You can't fail it";
		Book b1 = new Book("Calculus 1","maths",15.55f, authors, content1);
		Book b2 = new Book("Calculus 1","maths",15.55f, authors, content2);
		Book b3 = new Book("Algebra","maths",15.55f, authors, content3);
		b1.addAuthor("Bui");
		b2.addAuthor("Manh");
		b3.addAuthor("Cuong");
		b1.setContent(content1);
		b2.setContent(content2);
		b3.setContent(content3);
		
		ArrayList<Track> tracks = new ArrayList<Track>();
		CompactDisc cd1 = new CompactDisc("ST list", "vpop", 12.22f, tracks, "Son Tuong mtp");
		Track t1 = new Track("Em cua..", 240);
		Track t2 = new Track("Em cua..", 240);
		Track t3 = new Track("Chung ta..", 240);
		Track t4 = new Track("Muon roi..", 260);
		cd1.addTrack(t1);
		cd1.addTrack(t2);
		cd1.addTrack(t3);
		cd1.addTrack(t4);
		
		ArrayList<Track> tracks1 = new ArrayList<Track>();
		CompactDisc cd2 = new CompactDisc("Big bang", "kpop", 12.22f, tracks1, "g rong");
		store.addMedia(cd1);
		store.addMedia(b1);
		store.addMedia(b2);
		store.addMedia(b3);
		store.addMedia(cd2);
		showMenu(store, cart);
		md.run();
	}
	
	public static void showMenu(Store store, Cart cart) throws LimitExceededException, PlayerException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int a = scanner.nextInt();
		switch(a) {
		case 0:
			System.out.println("Exit!");
			break;
		case 1:
			storeMenu(store, cart);
			break;
		case 2:
			String title;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the title of Media you want to remove:");
			title = sc.nextLine();
			int count = 0;
			for (int i=0; i<store.size(); i++) {
				if (store.get(i).isMatch(title)==true) {
					count+=1;
					store.removeMedia(store.get(i));
				}
			}
			if (count==0) {
				System.out.println("No Media has this title!");
			}
			if (count>0) {
				System.out.println("The Media has removed!");
			}
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int n = scanner.nextInt();
			showMenu(store, cart);
			break;
		case 3:
			cartMenu(store, cart);
			break;
		}
	}
	
	public static void storeMenu(Store store, Cart cart) throws LimitExceededException, PlayerException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a Media's details");
		System.out.println("2. Add a Media to cart");
		System.out.println("3. See current cart");
		System.out.println("4. Play media");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int b = scanner.nextInt();
		switch(b) {
		case 0:
			showMenu(store, cart);
			break;
		case 1:
			store.printStore();
			
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int c = scanner.nextInt();
			storeMenu(store, cart);
			break;
		case 2:
			String title;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the title of Media you choose: ");
			title = sc.nextLine();
			int inisize = cart.size();
			int count = 0;
			for (int i=0; i<store.size(); i++) {
				if (store.get(i).isMatch(title)==true) {
					count+=1;
					cart.addMedia(store.get(i));
					store.removeMedia(store.get(i));
				}
			}
			if (count==0) {
				System.out.println("No Media has this title!");
			}
			if ((count>0 )&(cart.size()!=inisize)) {
				System.out.println("The Media has added!");
			}
			System.out.println("The number of Medias in the cart: "+cart.size());
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int d = sc.nextInt();
			storeMenu(store, cart);
			break;
		case 3:
			cart.print();
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int e = scanner.nextInt();
			storeMenu(store, cart);
			break;
		case 4:
			String tit;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the title of Media you choose: ");
			tit = s.nextLine();
			int coun = 0;
			for (int i=0; i<store.size(); i++) {
				if (store.get(i).isMatch(tit)==true) {
					coun+=1;
					if ((store.get(i) instanceof DigitalVideoDisc)) {
						((DigitalVideoDisc) store.get(i)).play();
					}
					if ((store.get(i) instanceof CompactDisc)) {
						((CompactDisc) store.get(i)).play();
					}
				}
			}
			if (coun==0) {
				System.out.println("No Media has this title!");
			}
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int z = s.nextInt();
			storeMenu(store, cart);
			break;
			
		}
	}
	public static void cartMenu(Store store, Cart cart) throws LimitExceededException, PlayerException {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter Medias in cart");
		System.out.println("2. Sort Medias in cart");
		System.out.println("3. Remove Media from cart");
		System.out.println("4. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		Scanner scanner = new Scanner(System.in);
		int f = scanner.nextInt();
		switch(f) {
		case 0:
			showMenu(store, cart);
			break;
		case 1:
			System.out.println("Press 1 to sort by ID or Press 2 to sort by title:");
			int g = scanner.nextInt();
			switch(g) {
			case 1:
				cart.sortID();
				break;
			case 2:
				cart.sortTitle();
				break;
			}
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int h = scanner.nextInt();
			cartMenu(store, cart);
			break;
		case 2:
			System.out.println("Press 1 to sort by title or Press 2 to sort by cost:");
			int i = scanner.nextInt();
			switch(i) {
			case 1:
				cart.sortTitle();
				break;
			case 2:
				cart.sortCost();
				break;
			}
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int k = scanner.nextInt();
			cartMenu(store, cart);
			break;
		case 3:
			System.out.println("Enter the title of Media you want to remove:");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the title of Media you want to remove:");
			String title = sc.nextLine();
			for (int j=0; j<store.size(); j++) {
				if (store.get(j).isMatch(title)==true) {
					store.addMedia(store.get(j));
					cart.removeMedia(store.get(j));
				}
			}
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int l = scanner.nextInt();
			cartMenu(store, cart);
			break;
		case 4:
			System.out.println("An order is created!");
			if (cart.size()>=5) {
				Media media = cart.getLuckyItem();
				System.out.println("The lucky item: "+media.toString());
				System.out.println("Total cost: "+(cart.totalCost()-media.getCost())+" $");
			}
			else {
				System.out.println("Total cost: "+cart.totalCost()+" $");
			}
			cart = new Cart();
			System.out.println("--------------------------------");
			System.out.println("press 1 to back");
			int m = scanner.nextInt();
			cartMenu(store, cart);
			break;
		}
	}
	
}