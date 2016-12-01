public class ReferenceBook extends LibraryBook {
    String collection;
    public ReferenceBook(String author, String title, String isbn, String callNumber, String collection) {
        super(author,title,isbn,callNumber);
	setCollection(collection);
	System.out.println(toString());
    }
    public void setCollection(String collection) {
	this.collection = collection;
    }
    public String getCollection() {
	return collection;
    }
    public void checkout(String patron, String due) {
	System.out.println("Cannot check out reference book");
    }
    public void returned() {
	System.out.println("Reference book could not have been checked out -- return impossible");
    }
    public String circulationStatus() {
	return "Non-circulating reference book";
    }
    public String toString() {
	return super.toString() + ", " + getCollection();
    }
}
