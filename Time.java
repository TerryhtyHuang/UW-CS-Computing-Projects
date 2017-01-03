
public class Time implements Comparable <Time>{

	private int time;
	
	public Time (String input){
		int index = input.indexOf(":");
		int minute=0;
		int second = 0;
		
		if (input==null){
			time = 0;
		}
		else{
			if (index >0){
				minute = Integer.parseInt(input.substring(0,index));
				second = Integer.parseInt(input.substring(index+1));
				time = minute*60+second;
			}
			if (index==-1){
				time = Integer.parseInt(input);
			}
			else
				time = 0;
		}
		
	}
	
	public Time (int minutes,int second){
		time = 60*minutes+second;
	}
	public Time (int second){
		time = second;
	}
	
	public int getTime(){
		return time;
	}
	
	public String printTime(){
		return time/60 + " minutes "+ (time-time/60*60) + " seconds";
	}
	
	//set time by second
	public void setTime(int second){
		time = second;
	}
	//set time by minutes and second
	public void setTime(int minutes, int second){
		time = minutes*60+second;
	}
	
	public int compareTo(Time t1){
		return this.time-(t1.time);
	}
}
