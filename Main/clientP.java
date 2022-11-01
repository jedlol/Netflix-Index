// this is the main method/client program that runs the entire filter project
// this code allows the user to enter in different commands to add/remove/view the list of filters
// this code will also display the list of records
// James Brady
import java.util.ArrayList;
import java.util.Scanner;

public class clientP {

  public static void main(String[] argv) throws Exception { // main method
	  
	  ArrayList<Media> masterList = new ArrayList<Media>(); // arrayList for masterList
	  DataFileParser.readData(masterList); // calls the dataFileParser class with the read data method
	  ArrayList<Media> currentList = new ArrayList<Media>();// arrayList for current filtered list
	  
	  currentList = masterList; 
	  
	  // strings for desired filter and commands
	  String filterWord = "";
	  String commandCode = "";
	  String end = "q";
	  String filterCode = "a";
	  String removeCode = "r";
	  String printCode = "p";

	  Scanner scnr = new Scanner(System.in);
	  
	  while(!commandCode.equalsIgnoreCase(end)) { // while user does not enter end command
		  System.out.println("");
		  System.out.println("Current Filters" +"\n" + "---------------"); // display of current filters
		  
		  if(Filter.filterList.size() > 0) {
			  for(int i = 0; i < Filter.filterList.size(); i++) {
			  System.out.println(i+". "+Filter.filterList.get(i).filterWord);
			  }
		  }
		  System.out.println("");
		  System.out.println("(A)dd filter"  // display of user commands and # of records
				  				+ "\n" +  "(R)emove filter"
				  				+ "\n" + "(P)rint list, (" + currentList.size() + ") records"
				  				+ "\n" + "(Q)uit");
		  System.out.println("");
		  System.out.print("Enter a command: ");
		  commandCode = scnr.nextLine();
		  
		if(commandCode.equalsIgnoreCase(filterCode)) { // if user wants to add a filter
			System.out.print("Enter filter: ");
			@SuppressWarnings("resource")
			Scanner scnr2 = new Scanner(System.in);
			filterWord = scnr2.nextLine();
			Filter.addFilter(filterWord); // calls the filter class with addFilter method with user entered filter word
			
		for(int x = 0; x < Filter.filterList.size(); x++) { // goes throughe each filter word
			currentList = Filter.filterStuff(currentList, Filter.filterList.get(x).filterWord); //calls the Filter class with the fiterStuff method to get newly filtered list
		}
		}
		
		if(commandCode.equalsIgnoreCase(removeCode)) { // if user wants to remove a filter
			@SuppressWarnings("resource")
			Scanner fLNS = new Scanner(System.in);
			System.out.print("Enter filter number to remove filter: ");
			String i = fLNS.nextLine();
			Filter.removeFilter(i); // calls the filter class with the removeFilter method 
			currentList = masterList; // assigning filtered list to the full list
			for(int x = 0; x < Filter.filterList.size(); x++) { // goes through each filter word
			currentList = Filter.filterStuff(currentList, Filter.filterList.get(x).filterWord); // then calls the filter class with the filterStuff method to revert back
			}
		}
		
		if(commandCode.equalsIgnoreCase(printCode)) { // if user wants to print their current list
			for(int i = 0; i < currentList.size(); i++) {
			System.out.println(currentList.get(i));
			}
		}
	  }
	  
	  scnr.close();
	  System.out.println("\n" + "goodbye"); // end statement
  }

}
