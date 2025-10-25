package tester;
import cs341hwmk5.NumberList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class MainTester {

	//this file helped test the standard dev, mean, and any NumberList related stuff 
	
	public static void main(String[] args) {
		NumberList list = new NumberList();
		String two = "2";
		String onepone = "1.1";
		String thousand = "1,000";
		String bond = "0000000.007";
		String dubdigit = "10";
		String ezasABC = "123";
		String noletters="1A"; //shouldn't be in the list
		
		list.addToList(two);
		list.addToList(onepone);
		list.addToList(thousand);
		list.addToList(bond);
		list.addToList(dubdigit);
		list.addToList(ezasABC);
		list.addToList(noletters);
		
		System.out.println(list.printList());
		System.out.println("mean: "+list.meanMaker());
		
		NumberList list2 = new NumberList(); //this is for testing stndev with easier numbers
		String uno = "1";
		String dos = "2";
		String tres = "3";
		list2.addToList(uno);
		list2.addToList(dos);
		list2.addToList(tres);
		
		System.out.println("stan dev list 2:"+list2.stnDev(list2.meanMaker()));
		
		//file reading test
		Scanner scan;
		try {
			scan = new Scanner(new File("test.txt"));
			while (scan.hasNextLine()) {
				System.out.println("Reading line: "+scan.nextLine());
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" File not found");
		}
		
	}

}
