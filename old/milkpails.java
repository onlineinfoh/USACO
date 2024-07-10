import java.io.*;
import java.util.StringTokenizer;
public class milkpails {
	public static void main(String[] args) throws IOException {
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		//PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new FileReader("pails.in"));
		PrintWriter pw = new PrintWriter("pails.out");

		StringTokenizer st = new StringTokenizer(r.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int X_num = M/X;

		int max_out = 0;

		for (int a = 0; a<= X_num; a++){
			int out = a*X + (M-a*X) / Y * Y;
			max_out = Math.max(max_out, out);
		}

		pw.print(max_out);
		
		// 17 25 77
		pw.close();
	}
}
