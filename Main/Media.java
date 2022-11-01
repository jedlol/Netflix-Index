//this is the abstract media class
//it contains all of the variable spaces for each media object
// James Brady

abstract class Media { 
	
	String mediaType;
	String title;
	String Director;
	String Cast;
	String Country;
	String date;
	String release;
	String rating;
	String duration;
	String Listed;
	String Description;
	
	public Media(String mediaType, String title, String Director, String Cast, String Country,
			String date, String release, String rating, String duration, String Listed, String Description) {
		
		this.mediaType = mediaType;
		this.title = title;
		this.Director = Director;
		this.Cast = Cast;
		this.Country = Country;
		this.date = date;
		this.release = release;
		this.rating = rating;
		this.duration = duration;
		this.Listed = Listed;
		this.Description = Description;
		
	}

		// protected abstract methods to get each specific field
	protected abstract Object getMediaType();

	protected abstract Object getTitle();

	protected abstract Object getDirector();

	protected abstract Object getCast();

	protected abstract Object getCountry();

	protected abstract Object getDate();

	protected abstract Object getRelease();

	protected abstract Object getRating();

	protected abstract Object getDuration();

	protected abstract Object getListed();

	protected abstract Object getDescription();

}
