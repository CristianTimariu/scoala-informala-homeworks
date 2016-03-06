
public class Novel extends Book {
	
	private String genre;

	public Novel(String title, int pageNo, String genre) {
		super(title, pageNo);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
		
}
