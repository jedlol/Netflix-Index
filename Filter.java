// this is the Filter class, this class will add filters to filter list,
// remove filters from filter list, and will compare the filters to the master/current list
// James Brady

import java.io.IOException;
import java.util.ArrayList;


public class Filter{
	
	ArrayList<Media> compareList = new ArrayList<Media>();
	public static ArrayList<Filter> filterList = new ArrayList<Filter>();

	
	// method to remove a filter from the filterList
	public static ArrayList<Filter> removeFilter(String i){
		
		if(filterList.size() == 0) {
			System.out.println("Currently No Active Filters");
			return filterList;
		}
		
		try{
		    Integer.parseInt(i); // trys parsing scanner input to check if number
		}catch (NumberFormatException ex) { 
		    System.out.println("ERROR: numbers only when removing filter"); // error if not a number
		    return filterList;
		}
		
		if(Integer.parseInt(i) > filterList.size()-1 || Integer.parseInt(i) <= -1) { // if the user enters a number that does not exist 
			System.out.println("ERROR: not a current filter number");
			return filterList;
		}	

		filterList.remove(Integer.parseInt(i));
	
		return filterList;
	}
	
	// method to add a filter to the filter list
	public static ArrayList<Filter> addFilter(String filterWord){
		
		Filter fT = new Filter(filterWord);
		for(int i = 0; i < filterList.size(); i++) { // will check for duplicate filters
			if(filterList.get(i).filterWord.equalsIgnoreCase(filterWord)) {
				System.out.println("");
				System.out.println("ERROR: duplicate filter not allowed >;(");
				System.out.println("");
				return filterList;
			}
		}
		 filterList.add(fT);
		  
		return filterList;
		
	}
	
	// method to compare filters to list to filter list, called with the currentList of media items, and a filter word
	public static ArrayList<Media> filterStuff(ArrayList<Media> currentList, String filterWord) throws IOException {
		
		ArrayList<Media> compareList = new ArrayList<Media>();
		filterWord = filterWord.toLowerCase();
		
		if(filterWord.contains("movie")) { // if filter contains movie ____
			 if(filterWord.equalsIgnoreCase("Movie")){ // if only movie is entered
				 for(int i = 0; i < currentList.size(); i++) {
						if(filterWord.equalsIgnoreCase((String) currentList.get(i).getMediaType())){
						 compareList.add(currentList.get(i));
						 }
					}
				 currentList = compareList;
				 return currentList;
			 }
			 String o = filterWord;
			 try { // will try to split movie from rest of filter
			 String [] arr = o.split(" ", 2);
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) { // will compare the movie title to list
					 if(((String) currentList.get(i).getTitle()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // if user enters anything that includes movie, ex. moviepulpfiction
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		
		if(filterWord.contains("series")) { // if filter word contains series ___
			 if(filterWord.equalsIgnoreCase("Series")){ // if user just enters series
				 for(int i = 0; i < currentList.size(); i++) {
						if(filterWord.equalsIgnoreCase((String) currentList.get(i).getMediaType())){
						 compareList.add(currentList.get(i));
						 }
					}
				 currentList = compareList;
				 return currentList;
			 }
			 String o = filterWord;
			 try { // will try to split series from the filter word
			 String [] arr = o.split(" ", 2);
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getTitle()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
		}
			 catch (ArrayIndexOutOfBoundsException e) { // will catch
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("title")) { // if user filter contains title ___
			if(filterWord.equals("title")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // will split title from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getTitle()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("director")) { // if user enters director ____
			if(filterWord.equals("director")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // will split director from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getDirector()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("cast")) { // if user filters contains cast
			if(filterWord.equals("cast")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // will split cast from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getCast()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("genre")) { // if user filter contains genre
			if(filterWord.equals("genre")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // will split genre from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getListed()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("country")) { // if user filter contains country
			if(filterWord.equals("country")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // will try to split country from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getCountry()).toLowerCase().contains(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("rating")) {  // if user filter contains rating
			if(filterWord.equals("rating")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 try {
			 String [] arr = o.split(" ", 2); // try to split rating from filter
			 if(arr.length > 0){ 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(((String) currentList.get(i).getRating()).toLowerCase().equals(arr[1])){
						 compareList.add(currentList.get(i));
					 }
				 }
				 currentList = compareList;
				 return currentList;
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if cannot
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("year")) { // if user filter contains year
			if(filterWord.equals("year")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 String less = "<";
			 String great = ">";
			 String lequal = "<=";
			 String gequal = ">=";
			 String equal = "=";
			 
			 String [] arr = o.split(" ", 3); // will split year and comparable and the filter word
			 // if year does not have > < >= or <= after it will return error
			 try {
			 if(arr[1].equals(equal) || arr[1].equals(gequal) || arr[1].equals(lequal) || arr[1].equals(great) || arr[1].equals(less)) {
				 arr[1] = arr[1];
			 }
			 }
			 catch(ArrayIndexOutOfBoundsException e) {
				 System.out.println("ERROR: must use <,>,<=,>= when using year");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
			 if(filterWord.equals("year >") || filterWord.equals("year <") ||
					 filterWord.equals("year <=") || filterWord.equals("year >=") ||
					 filterWord.equals("year =")){
				 System.out.println("ERROR: a number must follow when comparing a year");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
			 
			 try { // checking to see if user entered a number after year > ____
				   Integer.parseInt(arr[2]);
				} catch (NumberFormatException e) {
				    System.out.println("ERROR: Input String cannot be parsed to Integer.");
				    filterList.remove(filterList.size()-1);
				    return currentList;
				}
			 try {
			 if(arr.length > 0){ 
				 if(arr[1].equals(less)) { // if user number is less
				 for(int i = 0; i < currentList.size(); i++) {
					 if(Integer.parseInt((String) currentList.get(i).getRelease()) < Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
				 } 
				 }
				 if(arr[1].equals(great)) { // if user number is greater
				 for(int i = 0; i < currentList.size(); i++) {
					 if(Integer.parseInt((String) currentList.get(i).getRelease()) > Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
				 } 
				 }
				 if(arr[1].equals(lequal)) { // if user number is less than or equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(Integer.parseInt((String) currentList.get(i).getRelease()) <= Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
				 } 
				 }
				 if(arr[1].equals(gequal)) { // if user number is greater than or equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(Integer.parseInt((String) currentList.get(i).getRelease()) >= Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
				 } 
				 }
				 if(arr[1].equals(equal)) { // if userNumber is equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(Integer.parseInt((String) currentList.get(i).getRelease()) == Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
				 } 
				 }
				 currentList = compareList;
				 return currentList;
				 
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if user miss types something
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		if(filterWord.contains("runtime")) { // if user enters filterWord runtime
			if(filterWord.equals("runtime")) {
				for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
						 		compareList.add(currentList.get(i));	
					 }	
			}
				currentList = compareList;
				return currentList;
		}
			 String o = filterWord;
			 String less = "<";
			 String great = ">";
			 String lequal = "<=";
			 String gequal = ">=";
			 String equal = "=";
			 
			 String [] arr = o.split(" ", 3); // will split the 3 parts
			 try {
			 // if user does not use a comparable will return with error
			 if(arr[1].equals(equal) || arr[1].equals(gequal) || arr[1].equals(lequal) || arr[1].equals(great) || arr[1].equals(less)) {
				 arr[1] = arr[1];
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) {
				 System.out.println("ERROR: must use <,>,<=,>= when using year");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
			 if(filterWord.equals("runtime >") || filterWord.equals("runtime <") ||
					 filterWord.equals("runtime <=") || filterWord.equals("runtime >=") ||
					 filterWord.equals("runtime =")){
				 System.out.println("ERROR: a number must follow when comparing a runtime");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
			 
			 try { // checking to see if user entered a number
				   Integer.parseInt(arr[2]);
				} catch (NumberFormatException e) {
				    System.out.println("ERROR: Input String cannot be parsed to Integer.");
				    filterList.remove(filterList.size()-1);
				    return currentList;
				}
			 try {
			 if(arr.length > 0){ 
				 if(arr[1].equals(less)) { // user number is less than 
				 for(int i = 0; i < currentList.size(); i++) {
					 if(currentList.get(i).getMediaType().equals("Movie")) {
					 if(Integer.parseInt((String) currentList.get(i).getDuration()) < Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
					 }
				 } 
				 }
				 if(arr[1].equals(great)) { // user number is greater than
				 for(int i = 0; i < currentList.size(); i++) {
					 if(currentList.get(i).getMediaType().equals("Movie")) {
					 if(Integer.parseInt((String) currentList.get(i).getDuration()) > Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
					 }
				 } 
				 }
				 if(arr[1].equals(lequal)) { // user number is less than or equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(currentList.get(i).getMediaType().equals("Movie")) {
					 if(Integer.parseInt((String) currentList.get(i).getDuration()) <= Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
					 }
				 } 
				 }
				 if(arr[1].equals(gequal)) { // user number is greater than or equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(currentList.get(i).getMediaType().equals("Movie")) {
					 if(Integer.parseInt((String) currentList.get(i).getDuration()) >= Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
					 }
				 } 
				 }
				 if(arr[1].equals(equal)) { // user number is equal
				 for(int i = 0; i < currentList.size(); i++) {
					 if(currentList.get(i).getMediaType().equals("Movie")) {
					 if(Integer.parseInt((String) currentList.get(i).getDuration()) == Integer.parseInt(arr[2])){
						 compareList.add(currentList.get(i));
					 }
					 }
				 } 
				 }

				 currentList = compareList;
				 return currentList;
				 
			 }
			 }
			 catch (ArrayIndexOutOfBoundsException e) { // will catch if user miss types
				 System.out.println("ERROR: input a different filter name");
				 filterList.remove(filterList.size()-1);
				 return currentList;
			 }
		 }
		
		else { // if the user does not enter a specific category, will search list to see if it contains the filter word
			  for(int i = 0; i < currentList.size(); i++) {
					 if(
						(((String) currentList.get(i).getRating()).toLowerCase().equals(filterWord)) ||
						(((String) currentList.get(i).getDuration()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getRelease()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCountry()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDirector()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getCast()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getTitle()).toLowerCase().contains(filterWord)) ||
						(((String) currentList.get(i).getDescription()).toLowerCase().contains(filterWord))) {
			 
			 	compareList.add(currentList.get(i));	
		  }	 
	}

		  currentList = compareList;
		
		return currentList;
	}
 
		return currentList;

}

	String filterWord;
	public Filter(String filterWord) {
		this.filterWord = filterWord;
	}
}
