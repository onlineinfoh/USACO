import java.io.*;
import java.util.StringTokenizer;
public class maximizingproductivity {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[] closeTime = new int[length];
		int[] baseTime = new int[length];
		int[] time =  new int[1000001];
		for(int aa = 0; aa<=1000000; aa++){
			time[aa] = 0;
		}


		st = new StringTokenizer(r.readLine());
		for(int a = 0; a< length; a++){
			closeTime[a] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(r.readLine());
		for(int b = 0; b< length; b++){
			baseTime[b] = Integer.parseInt(st.nextToken());
		}
		for(int c = 0; c< length; c++){
			int index = closeTime[c] - baseTime[c]-1;
			if(index >= 0){
				time[index]++;
			}
		}
		for(int d = 999999; d>=0; d--){
			time[d] += time[d+1];
		}

		for(int e = 0; e< Q; e++){
			st = new StringTokenizer(r.readLine());
			int want = Integer.parseInt(st.nextToken());
			int input = Integer.parseInt(st.nextToken());
			if(time[input]>=want){
				pw.println("YES");
			}
			else{
				pw.println("NO");
			}
		}

		pw.close();
	}
}