import java.io.*;
import java.util.StringTokenizer;
public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter("lifeguards.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());

		int[][] input = new int[length][2];
		
		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			input[a][0] = Integer.parseInt(st.nextToken());
			input[a][1] = Integer.parseInt(st.nextToken());
		}
		int max = Integer.MIN_VALUE;
		for(int b = 0; b< length; b++){ // max after each eliminating case
			int curMax = 0;
			boolean[] days = new boolean[1000];
			for(int c = 0; c< length; c++){
				if(c == b){
					continue;
				}
				else{
					int first = input[c][0];
					int second = input[c][1];
					for(int d = first; d<=second -1; d++){
						days[d-1] = true;
					}
				}
			}
			for(int e = 0; e<1000-1; e++){
				if(days[e] == true){
					curMax++;
				}
			}
			max = Math.max(curMax, max);
		}
		pw.print(max);

		pw.close();
	}
}
