package hust.soict.dsai.aims.media;

public abstract class Disc extends Media {
	protected int length;
	protected String director;
	public Disc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.length = length;
		this.director = director;
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, String category, float cost) {
		super(title, category, cost);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	public Disc(String title, float cost) {
		super(title, cost);
		// TODO Auto-generated constructor stub
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

}