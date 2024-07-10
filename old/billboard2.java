import java.io.*;
import java.util.StringTokenizer;
public class billboard2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter("billboard.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());
		int x_overlap = Math.max(0, Math.min(x2, x4) - Math.max(x1, x3));
		int y_overlap = Math.max(0, Math.min(y2, y4) - Math.max(y1, y3));
		int area = 0;
		if( (x3>x1 && x4<x2) || (y1<y3 && y4<y2) ){
			area = (y2-y1)*(x2-x1);
		}
		else if(x_overlap >= x2-x1){
			if(y_overlap<y2-y1){
				area = (x2-x1)*(y2-y1-y_overlap);
			}
		}
		else if(y_overlap>=y2-y1){
			area = (y2-y1)*(x2-x1-x_overlap);
		}
		else{
			area = (y2-y1)*(x2-x1);
		}
		pw.print(area);
		pw.close();
	}
}