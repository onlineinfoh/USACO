import java.io.*;
import java.util.StringTokenizer;
public class daisychain {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());

		int[] input = new int[length];

		for(int i = 0; i< length; i++){
			input[i] = Integer.parseInt(st.nextToken());
		}
		int result = 0;
		for(int a = 0; a< length; a++){
			for(int b = a; b< length; b++){
				int sum = 0;
				for(int c = a; c <= b; c++){
					sum += input[c];
				}
				int average = 0;
				if(sum % (b-a+1) == 0){
					average = sum/(b-a+1);
				}
				else{
					continue;
				}
				for(int d = a; d<=b; d++){
					if(average == input[d]){
						result++;
						break;
					}
				}
			}
		}
		pw.print(result);
		pw.close();
	}
}
