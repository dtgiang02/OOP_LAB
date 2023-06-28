package hust.soict.dsai.aims.media;

public class Track  implements Playable{
	private String title;
	private int length;
	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		}

	public boolean equals(Object o) {
		if ((((Track) o).getTitle()==this.title)&(((Track) o).getLength()==this.length)){
			return true;
		}
		else {
			return false;
		}
	}
}