import java.util.ArrayList;
import java.util.Arrays;
public class Sorts {
    public static String name() {
	return "10.Rozenzaft.Daniel";
    }
    public static boolean swap(int[] array,int a, int b) {
	int temp = array[a];
	array[a] = array[b];
	array[b] = temp;
	return true;
    }
    public static void SelectionSort(int[] data) {
	int temp;
	for (int a = 0; a < data.length-1; a++) {
	    for (int i = a+1; i < data.length; i++) {
		if (data[i] < data[a]) {
		    temp = data[i];
		    swap(data,a,i);
		}
	    }
	}
    }
    /*public static void main(String[] args) {
	int[] a = {6,3,1,7,5,9,4,0,2};
	SelectionSort(a);
	System.out.println(Arrays.toString(a));
	int[] b = {};
	SelectionSort(b);
	System.out.println(Arrays.toString(b));
	int[] c = {10};
	SelectionSort(c);
	System.out.println(Arrays.toString(c));
	int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	SelectionSort(d);
	System.out.println(Arrays.toString(d));
	}*/
}
	  
