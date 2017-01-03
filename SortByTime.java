import java.util.Comparator;


public class SortByTime implements Comparator <Song>{

	public int compare(Song s1,Song s2){

		return s1.getStime().getTime()-(s2.getStime().getTime());
	}
}
