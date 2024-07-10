import java.io.*;
import java.util.StringTokenizer;
public class lostcow {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("lostcow.in"));
		PrintWriter pw = new PrintWriter("lostcow.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int dis = 0;
		int target = x;
		int direction = 1;
		int pow = 0;
		if(x<y){
			while (target<y){
				int holder = target;
				target = x + direction * (int)(Math.pow(2, pow));
				dis += Math.abs(holder-target);
				pow++;
				direction *= (-1);
			}
			dis = dis-(target-y);
			pw.print(dis);
		}
		if(x>y){
			while (target>y){
				int holder = target;
				target = x + direction * (int)(Math.pow(2, pow));
				dis += Math.abs(holder-target);
				pow++;
				direction *= (-1);
			}
			dis = dis-(Math.abs(target-y));
			pw.print(dis);
		}
		pw.close();
	}
}
