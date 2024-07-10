import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class findtheliar {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());

		int[][] input = new int[length][2];

		int[] value = new int[length];

		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			String info = st.nextToken();
			if(info.equals("L")){
				input[a][0] = 1;
			}
			else{
				input[a][0] = 2;
			}
			int val = Integer.parseInt(st.nextToken());
			input[a][1] = val;
			value[a] = val;
		}
		Arrays.sort(value);
		int maxnum = value[length-1];
		int res = Integer.MAX_VALUE;
		for(int b = 0; b<=maxnum; b++){
			int tem = 0;
			for(int c = 0; c< length; c++){
				if(input[c][0] == 1){
					if(b>input[c][1]){
						tem++;
					}
				}
				else{
					if(b<input[c][1]){
						tem++;
					}
				}
			}
			res = Math.min(res, tem);
		}
		pw.print(res);
		pw.close();
	}
}
