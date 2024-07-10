import java.io.*;
import java.util.StringTokenizer;

public class measuringtraffic {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("traffic.in"));
		PrintWriter pw = new PrintWriter("traffic.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		boolean need = true;
		int mile = Integer.parseInt(st.nextToken());
		int[] on = {0,0};
		int[] off = {0,0};
		int[] rangebefore = {0,2147483647};
		int[] rangeafter = {0, 2147483647};
		int[] range = new int[2];
		for(int a = 0; a<mile; a++){
			st = new StringTokenizer(r.readLine());
			String info = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(need && info.equals("none")){
				range[0] = x;
				range[1] =y;
				need = false;
			}
			if(info.equals("on")){
				on[0] += y;
				on[1] += x;
				range[0] = range[0]+x;
				range[1] = range[1]+y;
			}
			else if(info.equals("off")){
				off[0] += y;
				off[1] += x;
				range[0] = range[0]-y;
				range[1] = range[1]-x;
			}
			else if(info.equals("none")){
				rangebefore[0] = Math.max(rangebefore[0], x-on[0]+off[1]);
				rangebefore[1] = Math.min(rangebefore[1], y-on[1]+off[0]);
				range[0] = Math.max(range[0], x);
				range[1] = Math.min(range[1], y);
			}
		}
		if(rangebefore[0]<0){
			rangebefore[0] = 0;
		}
		pw.println(rangebefore[0] +" "+ rangebefore[1]);
		if(range[0]<0){
			range[0] = 0;
		}
		pw.print(range[0] +" "+ range[1]);
		pw.close();
	}
}