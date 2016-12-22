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
	int temp,i,ind;
	double time = System.currentTimeMillis();
     	for (int a = 0; a < data.length-1; a++) {
	    i = a+1;
	    temp = data[a];
	    ind = a;
	    while (i < data.length-1) {
		if (temp > data[i]) {
		    temp = data[i];
		    ind = i;
		}
		i++;
	    }
	    swap(data,a,ind);
	}
	double deltaT = (System.currentTimeMillis() - time)/1000.0;
	System.out.println("SelectionSort Time: " + deltaT + " seconds");
    }
    public static void insert(int[] data, int insertThis, int putHere) {
	int put = data[insertThis];
	int j = putHere;
	if (insertThis < putHere) {
	    while (data[j] >= insertThis) {
		j--;
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
      	for (int i = 0; i < 80000; i++) {
	    num = (int)(Math.random() * 80000);
	    x[i] = num;
	}
	//System.out.println(Arrays.toString(z));
	InsertionSort(x);
	System.out.println(Arrays.toString(Arrays.copyOfRange(x,0,100)));
	//InsertionSort(y);
	//	System.out.println(Arrays.toString(Arrays.copyOfRange(y,0,100)));
	//BubbleSort(x);
	//System.out.println(Arrays.toString(Arrays.copyOfRange(x,0,100)));
	//	System.out.println(Arrays.equals(z,y)&&Arrays.equals(z,x)); 
    }
}
	  
