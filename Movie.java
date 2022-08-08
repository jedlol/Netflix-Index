// this is the Movie class, which extends the Media class
// this contains the toString for Movie and the methods to return specific fields
// James Brady

public class Movie extends Media {

	public Movie(String mediaType, String title, String Director, String Cast, String Country, String date,
			String release, String rating, String duration, String Listed, String Description) {
		super(mediaType, title, Director, Cast, Country, date, release, rating, duration, Listed, Description);
		
	}
	public String toString() { // toString which is what the user will see
		String str = "\n" + "(" + super.mediaType.replaceAll("^\"|\"$", "") + ")    " + super.title + "\n" + "Director:  " + 
					super.Director.replaceAll("^\"|\"$", "") + "\n" + 
					"Cast:      " + super.Cast.replaceAll("^\"|\"$", "") + "\n" + "Country:   " + 
					super.Country.replaceAll("^\"|\"$", "") + "\n" + "Release:   " + 
					super.release + "\n" + "Rating:    " + super.rating + "\n" + "Genre:     " + 
					 super.Listed.replaceAll("^\"|\"$", "") + "\n" +  "Runtime:   "+ super.duration +
					"\n" + "\n" + super.Description.replaceAll("^\"|\"$", "") + "\n" + "---";
		
		
		str = str.replace("\"\"", "\"");
		return str.toString();	
	}
	
	// return methods to get specifics
	public String getMediaType(){
		return mediaType;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDirector(){
		return Director;
	}
	
	public String getCast(){
		return Cast;
	}
	
	public String getCountry(){
		return Country;
	}
	
	public String getDate(){
		return date;
	}
	
	public String getRelease(){
		return release;
	}
	
	public String getRating(){
		return rating;
	}
	
	public String getDuration(){ // will exclude min from the string to get exact matches
		String o = duration;
		String [] arr = o.split(" ", 2);
		
		return arr[0];
	}
	
	public String getListed(){
		return Listed;
	}
	
	public String getDescription(){
		return Description;
	}

}
