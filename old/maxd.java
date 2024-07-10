import java.io.*;
import java.util.StringTokenizer;

public class maxd {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int num = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int[] xpts =  new int[num];
		int[] ypts = new int[num];
		for (int a = 0; a<num; a++){
			xpts[a] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(r.readLine());
		for(int b = 0; b<num; b++){
			ypts[b] = Integer.parseInt(st.nextToken());
		}
		double maxd = 0;
		for(int x = 0; x< num; x++){
			for(int y = x+1; y< num; y++){
				maxd = Math.max(maxd, Math.pow(xpts[x]-xpts[y], 2)+ Math.pow(ypts[x]-ypts[y], 2));
			}
		}		
		
		pw.print((int)(maxd));
		
		pw.close();
	}
}
