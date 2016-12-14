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
    public static void InsertionSort(int[] data) {
	int j;
	for (int i = 1; i < data.length; i++) {
	    j = i-1;
	    while (data[j] > data[i] && j > 0) {
		j--;
	    }
	    if (j >= 0) {
	       swap(data,i,j);
	    }
	}
    }
	    //for (int i = data.length-1; i > 1; i--) {
	//  for (int j = i-1; j > 0; j--) {
	//	if (
    public static void main(String[] args) {
	int[] a = {6,3,1,7,5,9,4,0,2};
	InsertionSort(a);
	System.out.println(Arrays.toString(a));
	int[] b = {};
	InsertionSort(b);
	System.out.println(Arrays.toString(b));
	int[] c = {10};
	InsertionSort(c);
	System.out.println(Arrays.toString(c));
	int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	InsertionSort(d);
	System.out.println(Arrays.toString(d));
    }
}
	  
