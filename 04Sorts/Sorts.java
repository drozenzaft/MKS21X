import java.util.ArrayList;
import java.util.Arrays;
public class Sorts {
    public static String name() {
	return "10.Rozenzaft.Daniel";
    }
    public static void swap(int[] array,int a, int b) {
	int temp = array[a];
	array[a] = array[b];
	array[b] = temp;
    }
    public static void SelectionSort(int[] data) {
	int temp;
	double time = System.currentTimeMillis();
     	for (int a = 0; a < data.length-1; a++) {
	    for (int i = a+1; i < data.length; i++) {
		if (data[i] < data[a]) {
		    temp = data[i];
		    swap(data,a,i);
		}
	    }
	}
	double deltaT = (System.currentTimeMillis() - time)/1000.0;
	System.out.println("SelectionSort Time: " + deltaT + " seconds");
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
	double time = System.currentTimeMillis();
	int j;
	for (int i = 1; i < data.length; i++) {
	    j=i-1;
	    if (data[i] < data[i-1]) {
		while (j >= 0 && data[i] < data[j]) {
		    j--;
		}
		if (data[i] < data[j+1]) {
		    if (j >= 0) {
						 insert(data,i,j+1);
		    }
		    else {
			insert(data,i,0);
		    }
		}
	    }
	}
	//System.out.println(i + ": " +Arrays.toString(data));
	double deltaT = (System.currentTimeMillis() - time)/1000.0;
	System.out.println("InsertionSort Time: " + deltaT + " seconds");
    }
    public static void BubbleSort(int[] data) {
	int i = 0;
	double time = System.currentTimeMillis();
	boolean swapped = true;
	while (i < data.length-1 && swapped) {
	    swapped = false;
	    for (int j = i+1; j < data.length; j++) {
		if (data[i] > data[j]) {
		    swap(data,i,j);
		    swapped = true;
		}
	    }
	    i++;
	}
	double deltaT = (System.currentTimeMillis() - time)/1000.0;
    System.out.println("BubbleSort Time: " + deltaT + " seconds");
    }
    public static void main(String[] args) {
	int[] z = new int[80000];
	int[] y = new int[80000];
	int[] x = new int[80000];
	int num;
      	for (int i = 0; i < z.length; i++) {
	    num = (int)(Math.random() * 80000);
	    // if (i < 20) {
	    //		System.out.println(num);
	    //}
	    x[i] = num;
	    y[i] = num;
	    z[i] = num;
	}
	SelectionSort(z);
	//System.out.println(Arrays.toString(Arrays.copyOfRange(z,0,100)));
	InsertionSort(y);
	//System.out.println(Arrays.toString(Arrays.copyOfRange(y,0,100)));
	BubbleSort(x);
	//System.out.println(Arrays.toString(Arrays.copyOfRange(x,0,100)));
	System.out.println(Arrays.equals(z,y)&&Arrays.equals(z,x)); 
    }
}
	  
