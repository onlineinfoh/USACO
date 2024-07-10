import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class sleepycowsorting {
	public static void main(String[] args) throws IOException {
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new FileReader("sleepy.in"));PrintWriter pw = new PrintWriter("sleepy.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int len = Integer.parseInt(st.nextToken());
		int[] arr = new int[len];
		st = new StringTokenizer(r.readLine());
		for(int a =0; a< len; a++){
			arr[a] = Integer.parseInt(st.nextToken());
		}
		pw.print(getAns(arr, len));
		pw.close();
	}
	public static int getAns(int[] arr, int len){
		int ans = 0;
		for(int i = arr.length-1; i>= 0; i--){
			if(i == 0){
				return 0;
			}
			if(arr[i] < arr[i-1]){
				return i;
			}
		}
		return ans;
	}
}
