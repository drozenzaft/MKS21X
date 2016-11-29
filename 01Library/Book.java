public class Book {
    private String author,title,isbn;
    public Book {
	setAuthor("Niccolò Machiavelli");
	setTitle = ("The Prince");
	setISBN("1513");
    }
    public Book(String author, String title, String isbn) {
	setAuthor(author);
	setTitle(title);
	setISBN(isbn);
    }
    public String getAuthor() {
	return author;
    }
    public String getTitle() {
	return title;
    }
    public String getISBN() {
	return isbn;
    }
    public void setAuthor(String newAuthor) {
	author = newAuthor;
    }
    public void setTitle(String newTitle) {
	title = newTitle;
    }
    public void setISBN(String newISBN) {
	isbn = newISBN;
    }
}
