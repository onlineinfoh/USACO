import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class speedingticket{
	public static void main(String[] args) throws IOException{
		int previousd = 0;
		int previousdb = 0;
		int seglimit = 0;
		int bessp = 0;
		int roadlimit = 0;
		int over = 0;
		int overtem = 0;
		int num = 0;
		ArrayList<Integer> arr = new ArrayList<>();
		BufferedReader r = new BufferedReader(new FileReader("speeding.in"));
		PrintWriter pw = new PrintWriter("speeding.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		pw.print("");
		int roadseg = Integer.parseInt(st.nextToken());
		int besseg = Integer.parseInt(st.nextToken());
		for (int a = 0; a<(roadseg+besseg);a++){

			st = new StringTokenizer(r.readLine());
			arr.add(Integer.parseInt(st.nextToken()));
			arr.add(Integer.parseInt(st.nextToken()));
		}
		int bes = 2*roadseg;
		for (int c = 0; c<101; c++){
			if (c>arr.get(bes)+previousdb){
				previousdb += arr.get(bes);
				bes+=2;
			}
			bessp = arr.get(bes+1);
				if (c>arr.get(num)+previousd){
					previousd += arr.get(num);
					num+=2;					
				}
				seglimit = arr.get(num+1);
				if (seglimit < bessp){
					overtem = bessp - seglimit;
				}
				if(overtem>over){
					over = overtem;
				}
		}
		pw.print(over);
		pw.close();
	} 
}