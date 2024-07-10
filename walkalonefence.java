import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class walkalonefence {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B= Integer.parseInt(st.nextToken());

		int[][] post = new int[B][2];
		int[][] cow = new int[A][4];
		for(int a = 0; a< B; a++){
			st = new StringTokenizer(r.readLine());
			post[a][0] = Integer.parseInt(st.nextToken());
			post[a][1] = Integer.parseInt(st.nextToken());
		}
		for(int b = 0; b< A; b++){
			st = new StringTokenizer(r.readLine());
			cow[b][0] = Integer.parseInt(st.nextToken());
			cow[b][1] = Integer.parseInt(st.nextToken());
			cow[b][2] = Integer.parseInt(st.nextToken());
			cow[b][3] = Integer.parseInt(st.nextToken());
		}

		ArrayList<String> ans = new ArrayList<>();

		ans.add(post[0][0]+"_"+post[0][1]);
		for(int c=1; c<B; c++){
			if(post[c][0] == post[c-1][0]){
				if(post[c][1] > post[c-1][1]){
					for(int a = 1; a<= post[c][1] - post[c-1][1]; a++){
						ans.add(post[c][0]+"_"+(post[c-1][1]+a));
					}
				}
				else{
					for(int b = 1; b<= Math.abs(post[c][1] - post[c-1][1]); b++){
						ans.add(post[c][0]+"_"+(post[c-1][1]-b));
					}
				}
			}
			else if(post[c][1] == post[c][1]){
				if(post[c][0] > post[c-1][0]){
					for(int x = 1; x<= post[c][0] - post[c-1][0]; x++){
						ans.add((post[c-1][0]+x)+"_"+post[c][1]);
					}
				}
				else{
					for(int y = 1; y<= post[c-1][0] - post[c][0]; y++){
						ans.add((post[c-1][0]-y)+"_"+post[c][1]);
					}
				}
			}
		}

		if(post[0][1] == post[post.length-1][1]){
			if(post[post.length-1][0] > post[0][0]){
				for(int i = 1; i< post[post.length-1][0] - post[0][0]; i++){
					ans.add((post[post.length-1][0]-i)+"_"+post[0][1]);
				}
			}
			else{
				for(int ii = 1; ii<post[0][0] - post[post.length-1][0]; ii++){
					ans.add((post[post.length-1][0]+ii)+"_"+post[0][1]);
				}
			}
		}
		else{
			if(post[post.length-1][1] > post[0][1]){
				for(int j = 1; j< post[post.length-1][1] - post[0][1]; j++){
					ans.add(post[post.length-1][0]+"_"+(post[post.length-1][1]-j));
				}
			}
			else{
				for(int jj = 1; jj< post[0][1] - post[post.length-1][1]; jj++){
					ans.add(post[post.length-1][0]+"_"+(post[post.length-1][1]+jj));
				}
			}
		}

		for(int z = 0; z< A; z++){
			String s1 = cow[z][0]+"_"+cow[z][1];
			int s1_in = 0;
			String s2 = cow[z][2]+"_"+cow[z][3];
			int s2_in = 0;
			for(int index = 0; index< ans.size(); index++){
				if(ans.get(index).equals(s1)){
					s1_in = index;
				}
				if(ans.get(index).equals(s2)){
					s2_in = index;
				}
			}
			pw.println(Math.min(ans.size()-Math.abs(s1_in-s2_in), Math.abs(s1_in-s2_in)));
		}
		pw.close();
	}
}
