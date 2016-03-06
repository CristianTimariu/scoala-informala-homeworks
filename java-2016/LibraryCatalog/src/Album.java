
public class Album extends Book {
	private String paperQuality;

	public Album(String title, int pageNo, String paperQuality) {
		super(title, pageNo);
		this.paperQuality = paperQuality;
	}

	public String getPaperQuality() {
		return paperQuality;
	}

	public void setPaperQuality(String paperQuality) {
		this.paperQuality = paperQuality;
	}
	
	
}
