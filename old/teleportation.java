import java.io.*;
import java.util.StringTokenizer;
public class teleportation {
	public static void main(String[] args) throws IOException {
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new FileReader("teleport.in"));PrintWriter pw = new PrintWriter("teleport.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int a = Math.min(A, B);
		int b = Math.max(A, B);
		int c = Math.min(C, D);
		int d = Math.max(C, D);

		pw.print(Math.min(Math.abs(A-B), Math.abs(a-c)+ Math.abs(b-d)));
		
		pw.close();
	}
}
