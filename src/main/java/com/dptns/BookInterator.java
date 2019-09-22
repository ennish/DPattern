package  com.dptns;


import com.common.interate.Interator;

//interator
public class BookInterator implements Interator {

	private  BookShelter bookShelter;
	private int index = 0;

	public BookInterator( BookShelter bookShelter) {
		this.bookShelter = bookShelter;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return index < bookShelter.getLength();
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		return bookShelter.getIndexAt(index++);
	}
}
