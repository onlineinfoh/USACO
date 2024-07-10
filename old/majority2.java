import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;
public class majority2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int T = Integer.parseInt(st.nextToken());
		for(int a = 0; a< T; a++){
			ArrayList<Integer> output = new ArrayList<Integer>();
			st = new StringTokenizer(r.readLine());
			int length = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			int[] input = new int[length];
			for(int b = 0; b< length; b++){
				input[b] = Integer.parseInt(st.nextToken());
			}
			for (int c = 0; c< length; c++){
				int target = input[c];
				if(!(output.contains(target))){
					int thisNum = 0;
					int totalNum = 0;
					for(int d = c; d< length; d++){
						if(input[d] == target){
							thisNum++;
							totalNum++;
						}
						else {
							totalNum++;
						}
						if(thisNum>1 && thisNum > totalNum/2){
							output.add(target);
							break;
						}
					}
				}
			}
			Collections.sort(output);
			
				if(output.isEmpty()){
					pw.print(-1+"\n");
				}
				else{
					for(int i = 0; i< output.size(); i++){
						if(i == output.size()-1){
							pw.print(output.get(i)+"\n");
						}
						else{
							pw.print(output.get(i)+" ");
						}
					}
				}
		}
		pw.close();
	}
}