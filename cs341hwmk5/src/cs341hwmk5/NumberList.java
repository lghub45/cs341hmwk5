package cs341hwmk5;
import java.util.LinkedList;


public class NumberList {
	
	public LinkedList <String> nums;
	
	public NumberList() {
		nums = new <String> LinkedList();
	}
	
	public void addToList(String num) {
		//add our number in the form of a string (it'll come from a txt file)
		//this loop double checks our num is an actual number and has no letters
		for (int i=0; i<num.length();i++) {
			if (num.charAt(i)<48||num.charAt(i)>57) { //if the ascii value is lower than 0 or greater than 9 it's not a number
				if (num.charAt(i)!=46&& num.charAt(i)!=44) //46=. & 44=, 
				{return;} //also double check the character isn't just a . or a ,
			}
		}
		int j=0;
		while(num.charAt(j)==48 &&num!="0") { //this makes sure we get 7 instead of 007 by removing zeroes in the front
			num=num.substring(j+1,num.length());	
		}
		int i=0;
		num=num.replaceAll(",",""); //removes all the commas 
		
		nums.add(num);
	}
	
	public String printList() {
		String result="";
		for (int i=0; i<nums.size();i++) {
			result+= nums.get(i)+"\n";
		}
		return result;
	}
	
	public String getNum(int index) {
		return nums.get(index);
	}
	
	public double meanMaker() {
		double sum=0;
		for (int i=0; i<nums.size();i++) { //loop will add all the nums up to sum
		sum+= Double.parseDouble(nums.get(i)); 
		}
		
		double result = sum/nums.size(); //sum of nums /number of nums
		return result;
		}
	
	//note: uses population mean
	public double stnDev(double mean) {
		//stndev = sum of (num-mean)^2 / number of nums  all under square root
		double stndev=0; //this will be returned 
		double sum=0;
		for (int i=0; i<nums.size();i++) {
			sum+= (Double.parseDouble(nums.get(i))-mean)*(Double.parseDouble(nums.get(i))-mean);
		}	//gives us the sum of (num-mean)^2
	stndev = sum/nums.size();   //that sum /num
	return Math.sqrt(stndev);  //square root is our result
	}
}

