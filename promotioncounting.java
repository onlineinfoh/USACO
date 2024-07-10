import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class promotioncounting {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("promote.in"));
		PrintWriter pw = new PrintWriter("promote.out");
        StringTokenizer st = new StringTokenizer(r.readLine());

		int toSilver = 0;
		int toGold = 0;
		int toPlatinum = 0;

		pw.print("");
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		pw.print("");
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		pw.print("");
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		pw.print("");
		int d1 = Integer.parseInt(st.nextToken());
		int d2 = Integer.parseInt(st.nextToken());

		toPlatinum = d2-d1;
		toGold = c2-c1;
		toGold += d2-d1;
		toSilver = b2-b1+(c2-c1+d2-d1);

		pw.println(toSilver);
		pw.println(toGold);
		pw.print(toPlatinum);
		pw.close();
	}
}