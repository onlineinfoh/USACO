import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class diamondcounter {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("diamond.in"));
		PrintWriter pw = new PrintWriter("diamond.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());
		int difference = Integer.parseInt(st.nextToken());
		int[] input = new int[length];
		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			input[a] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		int res = 0;
		int left = 0;
		int right = 0;
		while(left < length){
			while(input[right] <= input[left] + difference){
				if(right<length-1){
					if(input[right+1] > input[left] + difference){
						break;
					}
					else{
						right++;
					}
				}
				else if(right == length-1){
					break;
				}
			}
			res = Math.max(res, right-left+1);
			left++;
		}
		pw.print(res);
		pw.close();
	}
}