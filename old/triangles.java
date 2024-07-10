import java.io.*;
import java.util.StringTokenizer;
public class triangles {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("triangles.in"));
		PrintWriter pw = new PrintWriter("triangles.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());
		int[][] input = new int[length][2];
		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			input[a][0] = Integer.parseInt(st.nextToken());
			input[a][1] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for(int i = 0; i < length; i++){
			int x1 = input[i][0];
			int y1 = input[i][1];
			for(int j = i+1; j< length; j++){
				int x2 = input[j][0];
				int y2 = input[j][1];
				for(int k = j+1; k< length; k++){
					int x3 = input[k][0];
					int y3 = input[k][1];
					boolean x1x2 = x1 == x2;
					boolean x1x3 = x1 == x3;
					boolean x2x3 = x2 == x3;
					boolean y1y2 = y1 == y2;
					boolean y1y3 = y1 == y3;
					boolean y2y3 = y2 == y3;
					int cur_area = 0;
					if (x1x2 && y1y2){
						cur_area = Math.abs((y1-y2) * (x1-x2));
					}
					else if(x1x2 && y1y3){
						cur_area = Math.abs((y1-y2)*(x1-x3));
					}
					else if(x1x2 && y2y3){
						cur_area = Math.abs((y1-y2)*(x2-x3));
					}
					else if (x1x3 && y1y2){
						cur_area = Math.abs((y1-y3) * (x1-x2));
					}
					else if(x1x3 && y1y3){
						cur_area = Math.abs((y1-y3)*(x1-x3));
					}
					else if(x1x3 && y2y3){
						cur_area = Math.abs((y1-y3)*(x2-x3));
					}
					else if (x2x3 && y1y2){
						cur_area = Math.abs((y2-y3) * (x1-x2));
					}
					else if(x2x3 && y1y3){
						cur_area = Math.abs((y2-y3)*(x1-x3));
					}
					else if(x2x3 && y2y3){
						cur_area = Math.abs((y2-y3)*(x2-x3));
					}
					max = Math.max(max, cur_area);
				}
			}
		}
		pw.print(max);
		pw.close();
	}
}
