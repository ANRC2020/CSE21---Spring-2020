import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Match {

	public static int topscore;
	public static int bestmatch;
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Student[] Students = new Student[100];
		
		Scanner kbd = new Scanner(System.in); 

		System.out.print("Enter the name of file to open: ");
		String filename = kbd.next(); 
		kbd.close();
		System.out.println("=====================================================");
		
		Scanner input = new Scanner(new FileReader(filename)); 
		
		int counter = 0;
		while(input.hasNextLine()) { 
			
			Scanner line = new Scanner(input.nextLine()); 	
			line.useDelimiter("[:\t\r]");
			String name = line.next();
			String gender = line.next();
			String date = line.next();
			
			Scanner bday = new Scanner(date);
			bday.useDelimiter("-");
			int month = bday.nextInt();
			int day = bday.nextInt();
			int year = bday.nextInt();
			
			int quiettime = line.nextInt();
			int music = line.nextInt();
			int reading = line.nextInt();
			int chatting = line.nextInt();
			
			Date birthday = new Date(month, day, year);
			Preference pref = new Preference(quiettime, music, reading, chatting);
			Student newstudent = new Student(name, gender.charAt(0), birthday, pref);
			Students[counter] = newstudent;
			
			counter++;
			
		}
		
		//Start comparing the Students' Scores
		//System.out.println(Students[1].compare(Students[2]));
		//System.out.println(Students[1].compare(Students[20]));
		for(int i = 0; i < counter; i++) {
			//Students[i] is the current student
			if(Students[i].getmatch() == true) {
				continue;
			}
			int topscore = 0;
			int index = 0;
			
			for(int j = 0; j < counter; j++ ) {
				if(Students[i].getname() == Students[j].getname() || Students[j].getmatch() == true) {
					continue;
				}
				if(Students[i].compare(Students[j]) > topscore) {
					topscore = Students[i].compare(Students[j]);
					index = j;
					Students[i].setmatch(true);
				}
				//System.out.println("Student 1: " + Students[i].getname() + " , Student 2; " + Students[j].getname());
			}
			
			if(Students[i].getmatch() == true) {
				Students[index].setmatch(true);
				System.out.println(Students[i].getname() + " matched with " + Students[index].getname() + " with a score of " + topscore);
			} else {
				System.out.println(Students[i].getname() + " has no matches.");
			}
			
			
		}
		
		
		
	}
	
}