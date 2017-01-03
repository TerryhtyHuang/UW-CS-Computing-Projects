import java.util.Comparator;


public class SortByArtist implements Comparator <Song>{

	public int compare(Song s1,Song s2){
		
		return s1.getArtist().compareToIgnoreCase(s2.getArtist());
	}
	
}
