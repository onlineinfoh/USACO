import java.io.*;
import java.util.StringTokenizer;
public class billboard {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("billboard.in"));
		PrintWriter pw = new PrintWriter("billboard.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int a1 = Integer.parseInt(st.nextToken());
		int a2 = Integer.parseInt(st.nextToken());
		int a3 = Integer.parseInt(st.nextToken());
		int a4 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int b1 = Integer.parseInt(st.nextToken());
		int b2 = Integer.parseInt(st.nextToken());
		int b3 = Integer.parseInt(st.nextToken());
		int b4 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int c1 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int c3 = Integer.parseInt(st.nextToken());
		int c4 = Integer.parseInt(st.nextToken());
		int width1 = 0;
		int height1 = 0;
		int width2 = 0;
		int height2 = 0;
		if(a3-c1<0){
			width1 = 0;
		}
		else if(c3-a1<0){
			width1 = 0;
		}
		else{
			width1 = Math.min(a3-a1, Math.min(c3-c1, Math.min(a3-c1, c3-a1)));
		}
		if(b3-c1<0){
			width2 = 0;
		}
		else if(c3-b1<0){
			width2 = 0;
		}
		else{
			width2 = Math.min(b3-b1, Math.min(c3-c1, Math.min(b3-c1, c3-b1)));
		}
		if(a4-c2<0){
			height1 = 0;
		}
		else if(c4-a2<0){
			height1 = 0;
		}
		else{
			height1 = Math.min(a4-a2, Math.min(c4-c2, Math.min(a4-c2, c4-a2)));
		}
		if(b4-c2<0){
			height2= 0;
		}
		else if(c4-b2<0){
			height2 = 0;
		}
		else{
			height2 = Math.min(b4-b2, Math.min(c4-c2, Math.min(b4-c2, c4-b2)));
		}
		pw.print((a3-a1)*(a4-a2)+(b3-b1)*(b4-b2)-height1*width1 - height2*width2);
		pw.close();
	}
}
