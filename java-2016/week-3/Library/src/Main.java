
public class Main {

	public static void main(String[] args) {
		
		// Main Title
		System.out.println("##############################");
		System.out.println("\tLibrary catalog");				
		System.out.println("##############################");
		
		// creating the library
		Library library = new Library();	
		
		// books
		Book b = new Novel("First novel", 132, "Mystery");
		Book b1 = new Album("My album", 40, "High");
		Book b3 = new Novel ("Another novel", 213,"Biography");
		Book b4 = new Novel ("Just a novel", 700, "Adventure");
		
		// working with methods
		library.addBook(b);
		library.addBook(b1);
		library.addBook(b3);
		library.deleteBook(b);
		library.addBook(b4);
		
		// list your library catalog
		for(int i = 0; i<library.getBooks().size(); i++){
			Book x = library.getBooks().get(i);
			
			if(x instanceof Novel){
				System.out.println(" \n[" + (i+1) + "]Novel");
				System.out.println("Title: " + x.getTitle());
				System.out.println("Page Number: " + x.getPageNo());
				System.out.println("Genre: " + ((Novel) x).getGenre());
			}else if(x instanceof Album){
				System.out.println(" \n[" + (i+1) + "]Album");
				System.out.println("Title: " + x.getTitle());
				System.out.println("Page Number: " + x.getPageNo());
				System.out.println("Paper Quality: " + ((Album) x).getPaperQuality());
			}
		}
		
        

	}

}
