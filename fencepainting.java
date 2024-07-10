import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class fencepainting {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("paint.in"));
		PrintWriter pw = new PrintWriter("paint.out");
        StringTokenizer st = new StringTokenizer(r.readLine());

		pw.print("");
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		pw.print("");
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());

		int overlap = 0;

		for(int i = 1; i<=100; i++){
			if (i>a1 && i<=a2){
				overlap++;
				continue;
			}
			if (i > b1 && i <= b2){
				overlap++;
				continue;
			}
		}

		pw.print(overlap);
		pw.close();
	}
}
