package hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.id = ++nbDigitalVideoDiscs;	
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;	
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.id = ++nbDigitalVideoDiscs;	
	}

	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String toString(){
		return ("DVD - " + this.title + " - " + this.category + " - " + this.director+ " - " + this.length + ": " + this.cost + "$");
	}
	public boolean isMatch(String title) {
		return this.title == title;
	}
	public boolean isMatch(int id) {
		return this.id == id;
	}
}