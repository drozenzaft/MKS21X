public class CirculatingBook extends LibraryBook {
    String currentHolder,dueDate;
    public CirculatingBook(String author, String title, String isbn, String callNumber) {
	super(author,title,isbn,callNumber);
	currentHolder = null;
	dueDate = null;
    }
    public void setCurrentHolder(String currentHolder) {
	this.currentHolder = currentHolder;
    }
    public void setDueDate(String dueDate) {
	this.dueDate = dueDate;
    }
    public String getCurrentHolder() {
	return currentHolder;
    }
    public String getDueDate() {
	return dueDate;
    }
    public void checkout(String patron, String due) {
	currentHolder = patron;
	dueDate = due;
    }
    public void returned() {
	currentHolder = null;
	dueDate = null;
    }
    public String circulationStatus() {
	if (currentHolder != null) {
	    return currentHolder + ", " + dueDate;
	}
	else {
	    return "Book available on shelves";
	}
    }
    /*public String toString() {
	return super.toString();
	}*/
}
