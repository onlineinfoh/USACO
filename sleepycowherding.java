import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class sleepycowherding {
	public static void main(String[] args) throws IOException {
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new FileReader("herding.in"));PrintWriter pw = new PrintWriter("herding.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int[] arr = new int[3];
		arr[0] = Integer.parseInt(st.nextToken());
		arr[1] = Integer.parseInt(st.nextToken());
		arr[2] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);
		if(arr[0]+1 == arr[1] && arr[1]+1 == arr[2]){
			pw.println(0);
		}
		else{
			if(arr[2]-arr[1] == 2 || arr[1]-arr[0] == 2){
				pw.println(1);
			}
			else{
				pw.println(2);
			}
		}

		pw.print(Math.max(arr[2]-arr[1]-1, arr[1]-arr[0]-1));
		
		pw.close();
	}
}
