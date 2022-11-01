// this class will parse the dataFile and will assign each result into a media object
// James Brady

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

public class DataFileParser {
	// method to read data
	public static ArrayList<Media> readData(ArrayList<Media> masterList) throws IOException {
		String line; // original string to add the file to a single string
		String line2 = "";
		String line3 = "";
		String mediaType = "";
		
		  @SuppressWarnings("resource") // buffered reader assigning each line into a string
		BufferedReader br = new BufferedReader(new FileReader("netflix_titles.txt"));
		  br.readLine(); // skipping first line
	      while ((line = br.readLine()) != null) {
	          line2 = line; 
	          line3 += line2 + "\n";
	      }
	      
	      ArrayList<String> result = new ArrayList<String>();
	      int start = 0;
	      boolean inQuotes = false; // will remove un-needed quotes
	      for (int current = 0; current < line3.length(); current++) {
	          if (line3.charAt(current) == '\"') inQuotes = !inQuotes;
	          else if (line3.charAt(current) == ',' && !inQuotes) {
	              result.add(line3.substring(start, current));
	              start = current + 1;
	          }
	          else if(line3.charAt(current) == '\n' && !inQuotes) {
	        	  result.add(line3.substring(start, current));
	              start = current + 1;
	          }

	      }

	     
	      // using a listIterator to go through the cleaned arrayList
	      ListIterator<String> li = result.listIterator();
	      
	      while(li.hasNext()) { 
	    	  String item = li.next(); 
	    	  if(item.equals ("Movie")) { // if item equals movie will create a movie object with the next catagories
	    		  mediaType = item;
	    		  String title = li.next();
	    		  String Director = li.next();
	    		  String Cast = li.next();
	    		  String Country = li.next();
	    		  String date = li.next();
	    		  String release = li.next();
	    		  String rating = li.next();
	    		  String duration = li.next();
	    		  String Listed = li.next();
	    		  String Description = li.next();
	    		  
	    		  Movie mT = new Movie(mediaType, title, Director, Cast, Country, date, release, rating, duration, Listed, Description);
	    		  masterList.add(mT); // adding new movie object to masterList
	    	  }
	    	  else if(item.equals("TV Show")) { // if item equals TV Show will create new series object with the following catagories
	    		  String series = "Series";
	    		  mediaType = item;
	    		  mediaType = series;
	    		  String title = li.next();
	    		  String Director = li.next();
	    		  String Cast = li.next();
	    		  String Country = li.next();
	    		  String date = li.next();
	    		  String release = li.next();
	    		  String rating = li.next();
	    		  String duration = li.next();
	    		  String Listed = li.next();
	    		  String Description = li.next();
	    		  
	    		  Series sT = new Series(mediaType, title, Director, Cast, Country, date, release, rating, duration, Listed, Description);
	    		  masterList.add(sT); // will add the new series object to the masterList
	    	  }
	      }
			return masterList; // returns finished list
		}
}