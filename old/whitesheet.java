import java.io.*;
import java.util.StringTokenizer;
public class whitesheet {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		double x1 = Integer.parseInt(st.nextToken());
		double y1 = Integer.parseInt(st.nextToken());
		double x2 = Integer.parseInt(st.nextToken());
		double y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		double x3 = Integer.parseInt(st.nextToken());
		double y3 = Integer.parseInt(st.nextToken());
		double x4 = Integer.parseInt(st.nextToken());
		double y4 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		double x5 = Integer.parseInt(st.nextToken());
		double y5 = Integer.parseInt(st.nextToken());
		double x6 = Integer.parseInt(st.nextToken());
		double y6 = Integer.parseInt(st.nextToken());
		String output = "NO";
		for(double a = x1; a<=x2; a+=0.1){
			if((a<=x4 && a>=x3) || (a>=x5 && a<=x6) && (a<=y4 && a>=y3) || (a>=y5 && a<=y6)){
				;
			}
			else{
				output = "YES";
			}
		}
		for(double b = y1; b<=y2; b+=0.1){
			if((b<=y4 && b>=y3) || (b>=y5 && b<=y6) && (b<=x4 && b>=x3) || (b>=x5 && b<=x6)){
				;
			}
			else{
				output = "YES";
			}
		}
		pw.print(output);
		pw.close();
	}
}