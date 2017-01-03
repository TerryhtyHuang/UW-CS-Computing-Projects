
public class Song implements Comparable <Song>{

	private String Stitle;
	private String artist;
	private String genre;
	private int rating;
	private Time Stime;

	public Song (String Stitle, String artist, String genre, int rating, Time Stime){
		this.Stitle =Stitle;
		this.artist = artist;
		this.genre = genre;
		this.rating = rating;
		this.Stime = Stime;
	}

	//Methods return the private variables
	public String getStitle(){
		return Stitle;
	}
	public String getArtist(){
		return artist;
	}
	public String getGenre(){
		return genre;
	}
	public int getRating(){
		return rating;
	}
	public Time getStime(){
		return Stime;
	}

	//Methods to change private variables
	public void setStitle(String newtitle){
		Stitle = newtitle;
	}
	public void setArtist(String newArtist){
		artist = newArtist;
	}
	public void setGenre (String newGenre){
		genre = newGenre;
	}
	public void setRating (int newRating){
		rating = newRating;
	}
	public void setStime (Time newTime){
		Stime = newTime;
	}

	public void displayInformation(){
		System.out.println();
		System.out.println("Title: "+Stitle);
		System.out.println("Artist: "+artist);
		System.out.println("Genre: "+genre);
		System.out.println("Rating: "+rating);
		System.out.println("Time: "+Stime.printTime());
		
		
	}
	
	//Compare to method by title
	public int compareTo(Song s1){
		return this.Stitle.compareToIgnoreCase(s1.Stitle);
	}
}
