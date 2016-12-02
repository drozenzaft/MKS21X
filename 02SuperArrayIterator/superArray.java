public class superArray{
	private String[] data;
	private int size;
	public superArray() {
		data = new String[10];
		size = 0;
	}
	public superArray(int initialCapacity) {
		if (initialCapacity < 0) {
			throw new IllegalArgumentException("Negative intialCapacity given: " + initialCapacity);
		}
		data = new String[initialCapacity];
		size = 0;
	}

	public int size(){
		return size;
	}
	public void setSize(int n) {
		size = n;
	}

		//1
		/**add the value n to the next available slot in the superArray.
		*this will change the size. This function should always work
		*And will resize the SuperArray if needed.*/
		public boolean add(String str){
			grow();
			set(size-1,str);
			return true;
		}

		//2
		/**Resize the data, by making a new array, then copying over elements, use this as your data.
		*/

		public String get(int index) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Index out of bounds: " + index);
			}
			return data[index];
		}

		private void grow(){
			String[] c = new String[size()+1];
			for (int i = 0; i < size(); i++) {
				c[i] = get(i);
			}
			data = c;
			setSize(size()+1);
		}
	
		//3
		/**format the super array like this :   [ 1, 3, 6, 8, 23, 99, -4, 5] 
			*commas between... square bracket start/end and no comma at end.*/
		public void clear() {
			String[] t = new String[0];
			data = t;
			size = 0;
		}
		public String set(int index, String element) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Index out of bounds: " + index);
			}
			data[index] = element;
			return element;
		}
		public boolean isEmpty() {
			return size == 0;
		}
		public String toString() {
			String ans = "[ ";
			for (int i = 0; i < size; i++) {
				ans += get(i);
				if (i < size-1) {
					ans += ", ";
				}
			}
			return ans + "]";
		}
		public String toStringDebug(){
			String ans = "[ ";
			for (int i = 0; i < data.length; i++) {
				if (i <= size-1) {
					ans += get(i);
				}
				if (i > size-1) {
					ans += "_";
				}
				if (i < data.length-1) {
					ans += ", ";			
				}
			}
			return ans + "]";
		}
		public void add(int index, String element) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Index out of bounds: " + index);
			}
			grow();
			String t = element;
			for (int i = index; i < size; i++) {
				element = get(i);
				set(i,t);
				t = element;
			}
		}
		public void remove(int index) {
			if (index < 0 || index >= size()) {
				throw new IndexOutOfBoundsException("Index out of bounds: " + index);
			}
			String[] temp = new String[size-1];
			for (int i = 0; i < temp.length; i++) {
				if (i < index) {
					temp[i] = get(i);
				}
				else {
					temp[i] = get(i+1);
				}
			}
			data = temp;
			size--;
		}
		public String[] toArray() {
			String[] ar = new String[size];
			for (int i = 0; i < ar.length; i++) {
				ar[i] = get(i);
			}
			return ar;
		}
		public int indexOf(String i) {
			int ans = -1;
			for (int j = 0; j < size; j++) {
				if (get(j).equals(i) && ans == -1) {
					ans = j;
				}
			}
			return ans;
		}
		public int lastIndexOf(String i) {
			int ind = -1;
			for (int j = size()-1; j >= 0; j--) {
				if (get(j).equals(i)) {
					ind = j;
					j = -100;
				}
			}
			return ind;
		}
		public void trimToSize() {
			String[] temp = new String[size];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = get(i);
			}
			data = temp;
		}
	}