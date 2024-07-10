import java.io.*;
import java.util.StringTokenizer;
public class whereami {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("whereami.in"));
		PrintWriter pw = new PrintWriter("whereami.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		String boxes = st.nextToken();
		boolean valid = false;

		int searchlength = 0;

		while(!valid){
			valid = true;
			searchlength++;
			for(int a = 0; a<=length-searchlength; a++){
				String com = boxes.substring(a,a+searchlength);
				if(boxes.indexOf(com) != boxes.lastIndexOf(com)){
					valid = false;
					break;
				}
			}
		}
		pw.print(searchlength);
		pw.close();
	}
}
