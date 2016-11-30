public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;
    public LibraryBook(String author, String title, String isbn, String callNumber) {
	super(author,title,isbn);
	setCallNumber(callNumber);
    }
    public String getCallNumber() {
	return callNumber;
    }
    public void setCallNumber(String newCallNumber) {
	callNumber = newCallNumber;
    }
    abstract void checkout(String patron, String due);
    abstract void returned();
    abstract String circulationStatus();
    public int compareTo(LibraryBook b) {
	return Integer.parseInt(getCallNumber()) -Integer.parseInt(b.getCallNumber());
    }
    public String toString() {
	return super.toString() + ", " + circulationStatus() + ", " + getCallNumber();
    }
}
