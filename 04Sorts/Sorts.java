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
    public static void insert(int[] data, int insertThis, int putHere) {
	if (insertThis < putHere) {
	    for (int j = putHere; j >= insertThis; j--) {
		swap(data,j,putHere);
	    }
	}
	else {
	    for (int i = insertThis-1; i >= putHere; i--) {
		swap(data,i,i+1);
	    }
	}
    }
    public static void InsertionSort(int[] data) {
	//System.out.println(0+","+Arrays.toString(data));
	int j;
	for (int i = 1; i < data.length; i++) {
	    j = i-1;
	    while (j > 0 && data[i] < data[j]) {
		j--;
	    }
	    if (j > 0) {
		j++;
	    }
	    if (j > 0 || data[i] < data[j] && (j != i-1 || i == 1)) {
		insert(data,i,j);
	    }
	    //System.out.println(i+","+data[i]+","+data[j]);
	    //System.out.println(i+","+j+","+Arrays.toString(data));
	}
    }
    public static void main(String[] args) {
	//int[] a = {6,3,1,7,5,9,4,0,2};
	//insert(a,3,7);
	//System.out.println(Arrays.toString(a));
	//insert(a,7,3);
	//System.out.println(Arrays.toString(a));
	//InsertionSort(a);
	//System.out.println(Arrays.toString(a));
	//int[] b = {};
	//InsertionSort(b);
	//System.out.println(Arrays.toString(b));
	//int[] c = {10};
	//InsertionSort(c);
	//System.out.println(Arrays.toString(c));
	//int[] d = {400,303,1500,1759,1618,13,11,1436,2168,1172,5280,2016,38387};
	//InsertionSort(d);
	//System.out.println(Arrays.toString(d));
    }
}
	  
