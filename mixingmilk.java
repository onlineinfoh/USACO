import java.io.*;
import java.util.StringTokenizer;

public class mixingmilk {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter pw = new PrintWriter("mixmilk.out");

		StringTokenizer st = new StringTokenizer(r.readLine());

		int c1 = Integer.parseInt(st.nextToken());
		int m1 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());		
		int c2 = Integer.parseInt(st.nextToken());
		int m2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		int c3 = Integer.parseInt(st.nextToken());
		int m3 = Integer.parseInt(st.nextToken());

		boolean one_two = true;
		boolean two_three = false;
		boolean three_one = false;

		for(int i = 0; i<100; i++){
			if(one_two){
				m2 += m1;
				m1 = 0;
				if(m2>c2){
					m1 = m2-c2;
					m2 = c2;
				}
				one_two = false;
				two_three = true;
				continue;
			}

			if(two_three){
				m3 += m2;
				m2 = 0;
				if (m3>c3){
					m2 = m3-c3;
					m3 = c3;
				}
				two_three = false;
				three_one = true;
				continue;
			}

			if(three_one){
				m1 += m3;
				m3 = 0;
				if(m1>c1){
					m3 = m1-c1;
					m1 = c1;
				}
				three_one = false;
				one_two = true;
				continue;
			}
		}
		pw.print(m1+"\n"+m2+"\n"+m3);
		pw.close();
	}
}
