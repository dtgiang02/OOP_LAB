package hust.soict.dsai.aims.media;

import java.util.*;


public class CompactDisc extends Disc implements Playable{
	private ArrayList<Track> tracks = new ArrayList<Track>();
	private String artist;
	
	public CompactDisc(String title, String category, float cost, ArrayList<Track> tracks, String artist) {
		// TODO Auto-generated constructor stub
		super(title, category, cost);
		this.artist=artist;
		this.tracks=tracks;
	}

	public String getArtist() {
		return artist;
	}
	public void addTrack(Track track) {
		if (tracks.contains(track)==false){
			tracks.add(track);
		}
		else {
			System.out.println("The track you want to add was exist!");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)==true) {
			tracks.remove(track);
		}
		else {
			System.out.println("the track you want to remove was not exist!");
		}
	}
	
	public int getLength() {
		int sum=0;
		if (tracks==null) {
			sum=0;
		}
		else {
			for (int i=1;i<= tracks.size(); i++) {
				sum+= tracks.get(i-1).getLength();
			}
		}
		
		return sum;
	}
	
	public String toString() {
		String s = "";
		s+="CD - "+title+" - "+category+" - "+artist+" - "+getLength()+": "+cost+"$\n";
		if (tracks.size()==0) {
			s+="";
		}
		if (tracks==null) {
			s+="";
		}
		else {
			for(int i=0; i<tracks.size();i++) {
				s+=("/n    Track "+tracks.get(i).getTitle()+": "+tracks.get(i).getLength()+"\n");
			}
		}
		return s;
	}
	
	public void play() throws PlayerException{
		if (this.getLength() >0) {
			for (int i=1; i<=tracks.size(); i++) {
				tracks.get(i-1).play();
			}
			java.util.Iterator iter = tracks.iterator();
			Track nextTrack;
			while (iter.hasNext()) {
				nextTrack = (Track) iter.next();
				nextTrack.play();
			}
		}else {
			throw new PlayerException("ERROR: CD length is non-positive");
		}
		
	}

	public ArrayList<Track> getTracks() {
		return tracks;
	}

	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}
}