package  com.dptns;


import java.util.LinkedList;
import java.util.List;


public class Book {
    @SuppressWarnings("unchecked")
    List l = new LinkedList();
    private String bookName;
    private Integer isbn;
	public Book(String name) {
	   this.bookName = name;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
