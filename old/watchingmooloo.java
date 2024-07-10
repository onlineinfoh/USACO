import java.io.*;
import java.util.StringTokenizer;
public class watchingmooloo {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		long fee = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());

		long[] input = new long[length];

		for(int a = 0; a< length; a++){
			input[a] = Long.parseLong(st.nextToken());
		}

		long money = 1+fee;

		for(int left = 0; left< length-1; left++){
			int right = left + 1;
			money += Math.min(1+fee, input[right]-input[left]);
		}
		pw.print(money);
		pw.close();
	}
}
