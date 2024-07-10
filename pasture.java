import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class pasture {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("square.in"));
		PrintWriter pw = new PrintWriter("square.out");
        StringTokenizer st = new StringTokenizer(r.readLine());

		pw.print("");
		int a = Integer.parseInt(st.nextToken());
		int aa = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int bb = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int c = Integer.parseInt(st.nextToken());
		int cc = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int dd = Integer.parseInt(st.nextToken());
		int[] arr = new int[8];
		arr[0] = Math.abs(a-b);
		arr[1] = Math.abs(aa-bb);
		arr[2] = Math.abs(c-d);
		arr[3] = Math.abs(cc-dd);
		arr[4] = Math.abs(b-c);
		arr[5] = Math.abs(aa-dd);
		arr[6] = Math.abs(a-d);
		arr[7] = Math.abs(bb-cc);
		Arrays.sort(arr);
		pw.print(arr[7]*arr[7]);
		pw.close();
	}
}
