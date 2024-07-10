import java.io.*;
import java.util.StringTokenizer;
public class outofplace {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("outofplace.in"));
		PrintWriter pw = new PrintWriter("outofplace.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());

		int[] arr = new int[length];
		

		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			arr[a] = Integer.parseInt(st.nextToken());
		}
		pw.print(output(arr, length));
		
		pw.close();
	}
	public static int output(int[] arr, int length){
		int ans = 0;
		int index = 0;

		boolean inPlace = true;

		int biggest = arr[0];
		for(int b = 1; b< length; b++){
			if(arr[b] < biggest){
				index = b;
				inPlace = false;
				break;
			}
			else{
				biggest = arr[b];
			}
		}

		int minus = 0;

		int i1 = 0;
		int i2 = 0;
		int tofind = arr[index];

		for(int i = 0; i< length; i++){
			if(arr[i] == tofind){
				i1 = i;
			}
		}
		for(int j = length-1; j>= 0; j--){
			if(arr[j] == tofind){
				i2 = j;
			}
		}

		if(!(i1 == i2)){
			minus  =1;
		}

		if(inPlace){
			return 0;
		}

		while(!inPlace){
			int largest = arr[index];
			int toChange = index;

			boolean happened = false;

			for(int c = index-1; c>=0; c--){
				if(arr[c] >= largest){
					largest = arr[c];
					toChange = c;
					happened = true;
				}
			}
			if(!happened){
				break;
			}
			int holder = arr[index];
			arr[index] = arr[toChange];
			arr[toChange] = holder;
			index = toChange;
			ans++;
		}
		return ans-minus;
	}
}