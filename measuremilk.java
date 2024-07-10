import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;
public class measuremilk {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("measurement.in"));
		PrintWriter pw = new PrintWriter("measurement.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int num = Integer.parseInt(st.nextToken());
		
		int[] day = new int[num];
		int[] change = new int[num];
		String[] name = new String[num];
		for(int a = 0; a<num; a++ ){
			st = new StringTokenizer(r.readLine());
			day[a] = Integer.parseInt(st.nextToken());
			name[a] = st.nextToken();
			change[a] = Integer.parseInt(st.nextToken());
		}

		boolean Bessie_first = true, Elsie_first = true, Mildred_first = true;
		int Bessie = 0, Elsie = 0, Mildred = 0, update = 0;

		for(int b = 1; b<= 100; b++){
			for(int c = 0; c<num; c++){
				if(day[c] == b){
					if(name[c].equals("Bessie")){
						Bessie+=change[c];
					}
					if(name[c].equals("Elsie")){
						Elsie+=change[c];
					}
					if(name[c].equals("Mildred")){
						Mildred+=change[c];
					}
				}
			}
			int highest = Math.max(Bessie, Math.max(Elsie, Mildred));
			boolean Bessie_cur = highest == Bessie;
			boolean Elsie_cur = highest == Elsie;
			boolean Mildred_cur = highest == Mildred;
			if(!(Bessie_cur == Bessie_first) || !(Elsie_cur == Elsie_first) || !(Mildred_cur == Mildred_first)){
				update++;
				Bessie_first = Bessie_cur;
				Elsie_first = Elsie_cur;
				Mildred_first = Mildred_cur;
			}
		}
		pw.print(update);
		pw.close();
	}
}