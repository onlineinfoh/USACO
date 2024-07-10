import java.io.*;
import java.util.StringTokenizer;
public class mowing {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("mowing.in"));
		PrintWriter pw = new PrintWriter("mowing.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] loc = new int[1001][2];
		int x = 0;
		int y = 0;
		loc[0][0] = x;
		loc[0][1] = y;
		int counter = 0;
		int time = 2147483647;
		for(int A = 0; A<N; A++){
			st = new StringTokenizer(r.readLine());
			String letter = st.nextToken();
			int unit = Integer.parseInt(st.nextToken());

			if(letter.equals("N")){
				for(int a = 1; a<=unit; a++){
					y+=1;
					loc[counter+a][0] = x;
					loc[counter+a][1] = y;
					for(int aa = 0; aa<counter+a; aa++){
						if(loc[aa][0] == x && loc[aa][1] == y){
							time = Math.min(time, a+counter-aa);
						}
					}
				}
				counter+=unit;
			}
			else if(letter.equals("S")){
				for(int b = 1; b<=unit; b++){
					y-=1;
					loc[counter+b][0] = x;
					loc[counter+b][1] = y;
					for(int bb = 0; bb<counter+b; bb++){
						if(loc[bb][0] == x && loc[bb][1] == y){
							time = Math.min(time, b+counter-bb);
						}
					}
				}
				counter+=unit;
			}
			else if(letter.equals("E")){
				for(int c = 1; c<=unit; c++){
					x+=1;
					loc[counter+c][0] = x;
					loc[counter+c][1] = y;
					for(int cc = 0; cc<counter+c; cc++){
						if(loc[cc][0] == x && loc[cc][1] == y){
							time = Math.min(time, c+counter-cc);
						}
					}
				}
				counter+=unit;
			}
			else if(letter.equals("W")){
				for(int d = 1; d<=unit; d++){
					x-=1;
					loc[counter+d][0] = x;
					loc[counter+d][1] = y;
					for(int dd = 0; dd<counter+d; dd++){
						if(loc[dd][0] == x && loc[dd][1] == y){
							time = Math.min(time, d+counter-dd);
						}
					}
				}
				counter+=unit;
			}
		}
		if(time == 2147483647){
			time = -1;
		}
		pw.print(time);
		pw.close();
	}
}