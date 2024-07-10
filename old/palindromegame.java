import java.io.*;
import java.util.StringTokenizer;
public class palindromegame {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());
		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			String num = st.nextToken();
			if((num.charAt(num.length()-1)+"").equals("0")){
				pw.println("E");
			}
			else{
				pw.println("B");
			}
		}
		pw.close();
	}
}