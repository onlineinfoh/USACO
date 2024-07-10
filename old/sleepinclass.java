import java.io.*;
import java.util.StringTokenizer;
public class sleepinclass {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int casenum = Integer.parseInt(st.nextToken());
		for(int a = 0; a< casenum; a++){
			st = new StringTokenizer(r.readLine());
			int length = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			int[] input =  new int[length];
			int sum = 0;
			for(int b = 0; b< length; b++){
				input[b] = Integer.parseInt(st.nextToken());
				sum += input[b];
			}
			int group = 0;
			for(int c = length; c>= 1; c--){
				group = c;
				if(sum%group == 0){
					int target_cur_sum =  sum / group;
					int cur_sum = 0;
					boolean valid = true;
					for(int d = 0; d< length; d++){
						cur_sum += input[d];
						if(cur_sum == target_cur_sum){
							cur_sum = 0;
						}
						else if(cur_sum > target_cur_sum){
							valid = false;
							break;
						}
					}
					if(valid){
						break;
					}
				}
			}
			int merge_time = length - group;
			if(a != casenum-1){
				pw.println(merge_time);
			}
			else{
				pw.print(merge_time);
			}
		}
		pw.close();
	}
}