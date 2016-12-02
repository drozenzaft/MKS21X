import java.util.Iterator;
import java.util.NoSuchElementException;
public class superArrayIterator implements Iterator<String> {
    private int start;
    private superArray superArray;
    public superArrayIterator(superArray SuperArray) {
        start = 0;
	superArray = SuperArray;
    }
    public String next() {
	if (hasNext()) {
	    start++;
	    return superArray.get(start-1);
	}
        else {
	    throw new NoSuchElementException();
	}
    }
    public boolean hasNext() {
	return start < superArray.size()-1;
    }
    public void remove() {
	throw new UnsupportedOperationException();
    }
}
