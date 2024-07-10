import java.io.*;
import java.util.StringTokenizer;
public class bovineshuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter("shuffle.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int cownum = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int[] place = new int[cownum];
		int[] ID = new int[cownum];
		for(int a = 0; a< cownum; a++){
			place[a] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(r.readLine());
		for(int b = 0; b< cownum; b++){
			ID[b] = Integer.parseInt(st.nextToken());
		}
		int[] output1 = new int[cownum];
		for(int c = 0; c<cownum; c++){
			output1[c] = ID[place[c]-1];
		}
		int[] output2 = new int[cownum];

		for(int dd = 0; dd<cownum; dd++){
			output2[dd] = output1[place[dd]-1];
		}
		int[] output3 = new int[cownum];
		for(int e = 0; e<cownum; e++){
			output3[e] = output2[place[e]-1];
		}
		for(int d = 0; d<cownum; d++){
			if(d!=cownum-1){
				pw.println(output3[d]);
			}
			else{
				pw.print(output3[cownum-1]);
			}
		}
		pw.close();
	}
}