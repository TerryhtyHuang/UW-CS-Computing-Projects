import java.util.*;


public class CD implements Comparable <CD>{
	
	private String CDtitle;
	private int CDnumS;
	private ArrayList <Song> listSong = new ArrayList();
	private Time CDtime;
	
	public CD (String CDtitle, int CDnumS, ArrayList listSong, Time CDtime){
		
		this.CDtitle = CDtitle;
		this.CDnumS = CDnumS;
		this.listSong = listSong;
		this.CDtime =CDtime;
	}
	
	//Methods to return the private variables
	public String getCDtitle(){
		return CDtitle;
	}
	public int getCDnumS(){
		return CDnumS;
	}
	public ArrayList<Song> getlistSong(){
		return listSong;
	}
	public Time getCDtime(){
		return CDtime;
	}
	
	//Method to change the private variables
	public void setCDtitle(String newtitle){
		CDtitle = newtitle;
	}
	public void setCDnumS(int newCDnumS){
		CDnumS = newCDnumS;
	}
	public void setlistSong(ArrayList<Song> newlist){
		listSong = newlist;
	}
	public void setCDtime(Time newtime){
		CDtime = newtime;
	}
	
	//Compare to method by title
	public int compareTo(CD CD1){
		return this.CDtitle.compareToIgnoreCase(CD1.CDtitle);
	}
	
	//Display all Songs
	//Method: display all songs in a CD
	//para:nothing
	//return: System.out.println the list of Songs in a CD
	public void displayAllSong(){
		System.out.println("List of Songs of "+this.CDtitle+" :");
		
		for (int x =0;x<listSong.size();x++){
			System.out.println ((x+1)+". "+listSong.get(x).getStitle());
		}
	}
	
	
	
}
