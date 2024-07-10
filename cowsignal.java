import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class cowsignal {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cowsignal.in"));
		PrintWriter pw = new PrintWriter("cowsignal.out");
        StringTokenizer st = new StringTokenizer(r.readLine());

		String lineholder = "";
		String wordholder = ""; 
		String input = "";
		String output = "";
		int counter = 0;
		pw.print("");

		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		int amp = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());

		for (int a = 0; a<height-1; a++){
			input += st.nextToken();
			st = new StringTokenizer(r.readLine());
		}
		input += st.nextToken();
		
		for(int b = 0; b<height*width; b++){
			wordholder = input.substring(b, b+1);
			for (int c = 0; c<amp; c++){
				lineholder+=wordholder;
			}
			counter++;
			if(counter == width){
				for(int d = 0; d<amp; d++){
					if(d == amp-1){
						output += lineholder;
						continue;
					}
					output += lineholder+"\n";
				}
				lineholder = "";
				if(b==height*width-1){
					continue;
				}
				output+="\n";
				counter = 0;
			}
		}

		pw.print(output);
		
		pw.close();
	}
}