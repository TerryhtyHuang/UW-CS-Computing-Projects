import java.io.*;
import java.util.*;

public class Driver
{
	public static ArrayList <CD> listCD = new ArrayList();//arraylist of CD

	public static void displayAll(){
		System.out.println();
		System.out.println("DisplayAllCD");
		for (int x=0;x<listCD.size();x++){
			System.out.println((x+1)+". "+listCD.get(x).getCDtitle());
		}
		System.out.println();
	}

	public static int displayMenu (int menuNum, BufferedReader stdIn) throws IOException
	{

		if (menuNum == 0)
		{
			System.out.println ("----------  MAIN MENU  -----------");
			System.out.println ("1) Accessing your list of CDs");
			System.out.println ("2) Accessing within a particular CD");
			System.out.println ("3) Exit");
			System.out.println ("----------------------------------");
		}
		else if (menuNum == 1)
		{
			System.out.println ("\n---------  SUB-MENU #1  ----------");
			System.out.println ("1) Display all of your CDs"); // Just the CD titles, numbered in order
			System.out.println ("2) Display information on a particular CD");
			System.out.println ("3) Add a CD"); // Adds a CD by reading from input file
			System.out.println ("4) Remove a CD");
			System.out.println ("5) Copy a CD");
			System.out.println ("6) Create a sub-CD");
			System.out.println ("7) List songs in common between two CDs");
			System.out.println ("8) Return back to main menu.");
			System.out.println ("----------------------------------");
		}
		else
		{
			System.out.println ("\n---------  SUB-MENU #2  ----------");
			System.out.println ("1) Display all songs (in the last sorted order) ");
			System.out.println ("2) Display info on a particular song ");
			System.out.println ("3) Add song");
			System.out.println ("4) Remove Song (4 options)");
			System.out.println ("5) Sort songs (3 options)");
			System.out.println ("6) Return back to main menu");
			System.out.println ("----------------------------------");
		}

		System.out.print ("\n\nPlease enter your choice:  ");

		int choice = Integer.parseInt (stdIn.readLine ());


		return choice;
	}



	public static void main (String[] args) throws IOException
	{
		boolean exit = true;

		//do{
		//readFile();
		//}while(exit);



		BufferedReader stdIn = new BufferedReader (new InputStreamReader (System.in));
		int mainMenuChoice, subMenuChoice;
		int CDchoice = -1;

		mainMenuChoice = displayMenu (0, stdIn);
		while(!(mainMenuChoice==3)){
			//return to Main menu
			if (mainMenuChoice == 0){
				mainMenuChoice = displayMenu (0, stdIn);
			}
			if (mainMenuChoice == 1){//Display a list of all your CDs
				subMenuChoice = displayMenu (1, stdIn);
				if (subMenuChoice == 1){
					displayAll();
					//subMenuChoice = displayMenu (1, stdIn);
				}
				else if (subMenuChoice == 2){//Display information on a particular CD
					int choice2 = -1;
					displayAll();
					System.out.println();
					System.out.print("Please Choose a CD:");
					choice2 = Integer.parseInt (stdIn.readLine ())-1;
					System.out.println("Title: "+listCD.get(choice2).getCDtitle());
					System.out.println("Nums of Songs: "+listCD.get(choice2).getCDnumS());
					System.out.println("Total Time: " + listCD.get(choice2).getCDtime().printTime());

				}
				else if (subMenuChoice == 3){//Add a CD

					readFile();
				}
				else if (subMenuChoice == 4){//Remove a CD
					displayAll();
					int choice4 =-1;
					choice4 = Integer.parseInt (stdIn.readLine ())-1;
					listCD.remove(listCD.get(choice4));
				}
				else if (subMenuChoice == 5){//Copy a CD (add the word "copy" to title
					displayAll();
					System.out.println();
					System.out.print("Choose a CD");
					int choice5 = Integer.parseInt (stdIn.readLine ())-1;
					CD copy = new CD("Copy-"+listCD.get(choice5).getCDtitle(),listCD.get(choice5).getCDnumS(),listCD.get(choice5).getlistSong(),listCD.get(choice5).getCDtime());
					listCD.add(copy);
					
				}
				else if (subMenuChoice == 6){//Create a Sub-CD (add the word "sub" to title)
					displayAll();
					System.out.println();
					System.out.print("Choose a CD: ");
					int choice6 = Integer.parseInt (stdIn.readLine ())-1;
					listCD.get(choice6).displayAllSong();
					System.out.println();
					System.out.print("Start from: ");
					int choice6S = Integer.parseInt (stdIn.readLine ())-1;
					System.out.print("End at: ");
					int choice6E = Integer.parseInt (stdIn.readLine ())-1;

					ArrayList <Song> sublist =  new ArrayList<Song>(listCD.get(choice6).getlistSong().subList(choice6S,choice6E+1));
					Time newTotal = new Time(calculateTotalTime(sublist));
					CD sub = new CD("Sub-"+listCD.get(choice6).getCDtitle(),sublist.size(),(sublist),newTotal);
					listCD.add(sub);
				}
				else if (subMenuChoice == 7){//List songs in common between 2 CDs
					ArrayList <Song> commonList  = new ArrayList();
					displayAll();
					System.out.println();
					System.out.print("Choose CD1: ");
					int choice71 = Integer.parseInt(stdIn.readLine())-1;
					System.out.print("Choose CD2: ");
					int choice72 = Integer.parseInt(stdIn.readLine())-1;
					System.out.println();
					for (int x=0;x<listCD.get(choice71).getlistSong().size();x++){
						for (int y=0;y<listCD.get(choice72).getlistSong().size();       y++){
							if (listCD.get(choice71).getlistSong().get(x).getStitle().equals(listCD.get(choice72).getlistSong().get(y).getStitle())){
								if (listCD.get(choice71).getlistSong().get(x).getArtist().equals(listCD.get(choice72).getlistSong().get(y).getArtist())){
									if (listCD.get(choice71).getlistSong().get(x).getGenre().equals(listCD.get(choice72).getlistSong().get(y).getGenre())){
										if (listCD.get(choice71).getlistSong().get(x).getRating()==(listCD.get(choice72).getlistSong().get(y).getRating())){
											if (listCD.get(choice71).getlistSong().get(x).getStime().compareTo(listCD.get(choice72).getlistSong().get(y).getStime()) == 0){
												commonList.add(listCD.get(choice71).getlistSong().get(x));
											}
										}
									}
								}
							}
						}
					}
					System.out.println("Common in 2 CDs");
					for (int z=0;z<commonList.size();z++){
						System.out.println(commonList.get(z).getStitle());
					}

				}
				else if (subMenuChoice == 8){//return to MainMenu
					mainMenuChoice = 0;

				}

			}
			else if (mainMenuChoice == 2){
				System.out.println("Please choose one below from below:");
				if (listCD.size()>0){
					displayAll();
					CDchoice = Integer.parseInt (stdIn.readLine ())-1;
				}
				while(mainMenuChoice!=0){
					subMenuChoice = displayMenu (2, stdIn);

					if (subMenuChoice == 1){//Display all songs (in the last sorted order)
						//System.out.println();
						listCD.get(CDchoice).displayAllSong();
					}
					else if (subMenuChoice == 2){//Display information on a particular song
						System.out.println();
						listCD.get(CDchoice).displayAllSong();
						System.out.println();
						System.out.println("Please choose a Song");
						int songChoice =  Integer.parseInt (stdIn.readLine ())-1;

						listCD.get(CDchoice).getlistSong().get(songChoice).displayInformation();
					}
					else if (subMenuChoice == 3){//Add a song
						System.out.println("Add a Song");
						System.out.print("Title input:");
						String titleInput = stdIn.readLine();
						System.out.print("Artist input:");
						String artistInput = stdIn.readLine();
						System.out.print("Genre input:");
						String genreInput = stdIn.readLine();
						System.out.print("Rating input:");
						int ratingInput = Integer.parseInt (stdIn.readLine ());
						System.out.println("Time input (Minutes):");
						int minutesInput = Integer.parseInt (stdIn.readLine ());
						System.out.println("Time input (Seconds):");
						int secondInput = Integer.parseInt (stdIn.readLine ());

						Song addSong = new Song(titleInput, artistInput, genreInput, ratingInput,new Time(minutesInput,secondInput));
						listCD.get(CDchoice).getlistSong().add(addSong);
					}
					else if (subMenuChoice == 4){//Remove a song(4 options)
						System.out.println("4 options:");
						System.out.println("1. Choosing from List");
						System.out.println("2. Search by song Title");
						System.out.println("3. Remove the First Song");
						System.out.println("4. Remove the last Song");
						System.out.print("Options:");
						int option4 =  Integer.parseInt (stdIn.readLine ());
						if (option4==1){
							listCD.get(CDchoice).displayAllSong();
							System.out.print("Choose a Song to REMOVE: ");
							int removeChoice = Integer.parseInt (stdIn.readLine ())-1;
							listCD.get(CDchoice).getlistSong().remove(removeChoice);

						}
						else if (option4 ==2){
							System.out.print("Input the title: ");
							String removeTitle = (stdIn.readLine()).trim();
							Song remove = new Song(removeTitle,null,null,0,new Time(0));
							int pot = 0;
							pot = Collections.binarySearch(listCD.get(CDchoice).getlistSong(),remove);

							if (pot>=0){
								listCD.get(CDchoice).getlistSong().remove(pot);
							}

						}
						else if (option4==3){
							listCD.get(CDchoice).getlistSong().remove(0);
						}
						else if (option4==4){
							listCD.get(CDchoice).getlistSong().remove(listCD.get(CDchoice).getlistSong().size()-1);
						}
						else{
							System.out.println("Wrong Input");
						}
					}
					else if (subMenuChoice == 5){//Sort songs (3 options)
						System.out.println("3 options:");
						System.out.println("1. Sort by Title");
						System.out.println("2. Sort by Artist");
						System.out.println("3. Sort by Time");
						System.out.print("Options:");
						int option3 =  Integer.parseInt (stdIn.readLine ());
						
						if (option3 == 1){
							Collections.sort(listCD.get(CDchoice).getlistSong());
						}
						else if (option3 == 2){
							Collections.sort(listCD.get(CDchoice).getlistSong(),new SortByArtist());
						}
						else if (option3 == 3){
							Collections.sort(listCD.get(CDchoice).getlistSong(),new SortByTime());
						}
						else{
							System.out.println("Wrong Input");
						}
					}
					else if (subMenuChoice == 6){//Return back to main menu
						mainMenuChoice = 0;
					}
				}
			}
		}
	}



	//Method: input
	public static void readFile(){
		try{


			Scanner fileName = new Scanner (new InputStreamReader(System.in));
			System.out.println("Please input the name of the CD file:");
			String filename = null;
			filename = fileName.nextLine();

			BufferedReader inFile = new BufferedReader (new FileReader(filename));
			String s="";
			String CDtitle = null;
			int numCD;
			int numSong=0;
			int num;
			String title = null;
			String artist = null;
			String genre = null;
			int rating = 0;
			String length = "";
			ArrayList<Song> listSS= new ArrayList();
			int totalsecond =0;

			s=inFile.readLine();
			if (s!=null){
				CDtitle = s;

			}
			s=inFile.readLine();
			if (s!=null){
				numSong= Integer.parseInt(s);

			}
			for (int x=0;x<numSong;x++){
				s=inFile.readLine();
				if (s!=null){
					title = s;

				}
				s=inFile.readLine();
				if (s!=null){
					artist = s;

				}
				s=inFile.readLine();
				if (s!=null){
					genre=s;

				}
				s=inFile.readLine();
				if (s!=null){
					rating = Integer.parseInt(s);

				}
				s=inFile.readLine();
				if (s!=null){
					length = s;

				}
				totalsecond = totalsecond + (Integer.parseInt(length.substring(0,length.indexOf(":")))*60+Integer.parseInt(length.substring(length.indexOf(":")+1)));
				Time thistime = new Time(Integer.parseInt(length.substring(0,length.indexOf(":")))*60+Integer.parseInt(length.substring(length.indexOf(":")+1)));
				listSS.add(new Song(title,artist,genre,rating,thistime));
			}
			listCD.add(new CD(CDtitle,numSong,listSS,new Time(totalsecond)));
			for (int x =0;x<listSS.size();x++){
				System.out.println(listSS.get(x).getStitle());
				System.out.println(listSS.get(x).getArtist());
				System.out.println(listSS.get(x).getGenre());
				System.out.println(listSS.get(x).getRating());
				System.out.println(listSS.get(x).getStime().printTime());


			}


			inFile.close();

		}
		catch(FileNotFoundException e){
			System.out.println("Not Found");
		}
		catch(IOException e){
			System.out.println("IO Exception");
		}
	}


	public static int calculateTotalTime(ArrayList<Song> list){
		int totaltotal = 0;
		for (int x=0;x<list.size();x++){
			totaltotal = totaltotal + list.get(x).getStime().getTime();
		}
		return totaltotal;
	}
}

