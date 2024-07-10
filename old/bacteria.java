import java.io.*;
import java.util.StringTokenizer;
public class bacteria {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		long[] input = new long[length];
		for(int i = 0; i< length; i++){
			input[i] = Long.parseLong(st.nextToken());
		}
		long result = 0;
		long cowpassed = 0;

		for(int a = 0; a< length; a++){
			long change = input[a] * (-1);
			result += Math.abs(input[a]);
			for(int b = a+1; b < length; b++){
				input[b] += change * (b+1-cowpassed);
			}
			cowpassed++;
		}
		pw.print(result);
		pw.close();
	}
}
