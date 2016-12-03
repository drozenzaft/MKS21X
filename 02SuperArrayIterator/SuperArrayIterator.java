import java.util.Iterator;
import java.util.NoSuchElementException;
public class SuperArrayIterator implements Iterator<String> {
    private int start;
    private SuperArray superArray;
    public SuperArrayIterator(SuperArray superArray) {
        start = 0;
	this.superArray = superArray;
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
	return start < superArray.size();
    }
    public void remove() {
	throw new UnsupportedOperationException();
    }
}
