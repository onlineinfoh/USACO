import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class cowcollege{
	public static void main(String[] args)throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		long price = 0;
		long profitcom = 0;
		long profit = 0;
		long cowcounter = 0;
		long maxcow = 0;
		long opprice = 0;
		pw.print("");
		int size = Integer.parseInt(st.nextToken());
		long[] arr = new long[size];
		st = new StringTokenizer(r.readLine());
		pw.print("");
		for (int i=0; i<size;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		for (int a = size-1; a>=0;a--){
			long profith = arr[a]*(size-a);
			if(profith>=profit){
				price = arr[a];
				profit=profith;
			}
		}
		pw.print(profit+" "+price);
		pw.close();
	}
}