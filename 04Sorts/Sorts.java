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
	    while (i < data.length) {
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
    public static void insert(int[] data, int moveEnd, int moveHere) {
	int temp = data[moveHere];
	int placeHolder;
	for (int i = moveHere+1; i <= moveEnd; i++) {
	    placeHolder = data[i];
	    data[i] = temp;
	    temp = placeHolder;	    
	}
	data[moveHere] = temp;
    }
    public static void InsertionSort(int[] data) {
	double time = System.currentTimeMillis();
	int j;
	for (int i = 1; i < data.length; i++) {
	    j = i-1;
	    while (j >= 0 && data[i] < data[j]) {
		j--;
	    }
	    if (j > -1) {
		insert(data,i,j+1);
	    }
	    else {
		insert(data,i,0);
	    }
	}
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
    /*public static void main(String[] args) {
	int[] z = new int[80000];
	int[] y = new int[80000];
	int[] x = new int[80000];
	int num;
      	for (int i = 0; i < z.length; i++) {
	    num = (int)(Math.random() * z.length);
	    x[i] = num;
	    y[i] = num;
	    z[i] = num;
	}
	SelectionSort(x);
	System.out.println(Arrays.toString(Arrays.copyOfRange(x,0,100)));
	InsertionSort(y);
	System.out.println(Arrays.toString(Arrays.copyOfRange(y,0,100)));
	BubbleSort(z);
	System.out.println(Arrays.toString(Arrays.copyOfRange(z,0,100)));
	//----------------------EMPTY ARRAY TESTS-----------------------
	int[] w = {};
	int[] v = {};
	int[] u = {};
	SelectionSort(w);
	System.out.println(Arrays.toString(w));
	InsertionSort(v);
	System.out.println(Arrays.toString(v));
	BubbleSort(u);
	System.out.println(Arrays.toString(u));
	System.out.println(Arrays.equals(z,x)&&(Arrays.equals(y,x))); 
    }*/
}
	  
