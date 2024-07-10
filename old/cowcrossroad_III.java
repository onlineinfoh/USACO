import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class cowcrossroad_III {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cowqueue.in"));
		PrintWriter pw = new PrintWriter("cowqueue.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());

		int[][] input = new int[length][2];
		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			input[a][0] = Integer.parseInt(st.nextToken());
			input[a][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input, Comparator.comparingInt(b -> b[0]));

		int time = input[0][0]+ input[0][1];
		for (int c = 1; c< length; c++){
			if(time <= input[c][0]){
				time = input[c][0] + input[c][1];
			}
			else{
				time += input[c][1];
			}
		}
		pw.print(time);
		
		pw.close();
	}
}
