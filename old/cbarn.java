import java.io.*;
import java.util.StringTokenizer;
public class cbarn {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cbarn.in"));
		PrintWriter pw = new PrintWriter("cbarn.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int room = Integer.parseInt(st.nextToken());
		int[] input = new int[room];
		for(int a = 0; a<room; a++){
			st = new StringTokenizer(r.readLine());
			input[a] = Integer.parseInt(st.nextToken());
		}
		int min = 2147483647;
		for(int b = 0; b<room; b++){
			int sum = 0;
			for(int c = 0; c<room; c++){
				if(c-b<0){
					sum += input[c]*(c+room-b);
				}
				else{
					sum+= input[c]* (c-b);
				}
			}
			min = Math.min(min, sum);
		}
		pw.print(min);
		pw.close();
	}
}
