package  com.dptns;

import com.common.interate.Aggregate;
import com.common.interate.Interator;

public class BookShelter implements Aggregate {

    private Book[] books;
    private int length = 0;

    public BookShelter(int maxLength) {
        this.books = new Book[maxLength];
    }

    @Override
    public Interator interator() {
        // TODO Auto-generated method stub
        return new BookInterator(this);
    }

    public Book getIndexAt(int i) {
        return books[i <= length ? i : length];
    }

    public void appendBook(Book book) {
        books[length] = book;
        length++;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static void main(String args[]) {
        BookShelter bs = new BookShelter(30);
        for (int i = 0; i < 26; i++) {
            bs.appendBook(new Book("" + (char) ('a' + i)));
        }
        Interator itor = bs.interator();
        while (itor.hasNext()) {
            Book book = (Book) itor.next();
            System.out.println(book.getBookName());
        }
    }
}
