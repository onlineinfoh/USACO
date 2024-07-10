import java.io.*;
import java.util.StringTokenizer;
public class loadbalancing {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("balancing.in"));//InputStreamReader
		PrintWriter pw = new PrintWriter("balancing.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		int size = Integer.parseInt(st.nextToken());

		int[][] input = new int[length][2];

		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			input[a][0] = Integer.parseInt(st.nextToken());
			input[a][1] = Integer.parseInt(st.nextToken());
		}

		int output = Integer.MAX_VALUE;
		for(int i = 0; i< length; i++){
			for(int j = 0; j< length; j++){
				int xline = input[i][0] +1;
				int yline = input[j][1] + 1;
				int one = 0, two = 0, three = 0, four = 0;
				for(int b = 0; b< length; b++){
					if (input[b][0]>xline && input[b][1]>yline){
						one++;
					}
					else if(input[b][0]>xline && input[b][1]<yline){
						four++;
					}
					else if(input[b][0]<xline && input[b][1]<yline){
						three++;
					}
					else if(input[b][0]<xline && input[b][1]>yline){
						two++;
					}
				}
				int res = Math.max(one, Math.max(two, Math.max(three, four)));
				output = Math.min(output, res);
			}
		}
		pw.print(output);
		pw.close();
	}
}