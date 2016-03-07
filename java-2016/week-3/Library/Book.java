
public abstract class Book {

		protected String title;
		protected int pageNo;
		
		public Book() {
		
		}

		public Book(String title, int pageNo) {
			super();
			this.title = title;
			this.pageNo = pageNo;
		}

		public String getTitle() {
			return title;
		}


		public void setTitle(String title) {
			this.title = title;
		}


		public int getPageNo() {
			return pageNo;
		}


		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}

		
}
