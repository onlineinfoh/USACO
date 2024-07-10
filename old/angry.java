import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class angry {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter("angry.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int cownum = Integer.parseInt(st.nextToken());
		int[] input = new int[cownum];
		for(int a = 0; a<cownum; a++){
			st = new StringTokenizer(r.readLine());
			input[a] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int output = 0;
		for(int b = 0; b<cownum; b++){
			int influence = 0;
			int radius = 1;
			for(int c = b; c<cownum; c++){
				if(c!=cownum-1){
					if(input[c] + radius >= input[c+1]){
						if(c<cownum-2){
							if(input[c]+radius<input[c+2]){
								radius++;
								influence++;
							}
							else if (input[c]+radius>input[c+2]){
								influence++;
							}
						}
						else{
							radius++;
							influence++;
						}
					}
					else{
						break;
					}
				}
			}
			radius = 1;
			for(int d = b; d>=0; d--){
				if(d!=0){
					if(input[d]-radius<=input[d-1]){
						if(d>1){
							if(input[d]-radius>input[d-2]){
								radius++;
								influence++;
							}
							else if (input[d]-radius<input[d-2]){
								influence++;
							}
						}
						else{
							radius++;
							influence++;
						}
					}
					else{
						break;
					}
				}
			}
			influence++;
			output = Math.max(output, influence);
		}
		pw.print(output);
		pw.close();
	}
}