import java.io.*;
import java.util.StringTokenizer;

public class circlecross {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter pw = new PrintWriter("circlecross.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		String input = st.nextToken();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int res = 0;
		for(int a = 0; a<26; a++){
			for(int b = a+1; b<26; b++){
				if((input.indexOf(alphabet.charAt(a)+"")< input.indexOf(alphabet.charAt(b)+"") && input.indexOf(alphabet.charAt(b)+"") < input.lastIndexOf(alphabet.charAt(a)+"")) && !(input.indexOf(alphabet.charAt(a)+"")< input.lastIndexOf(alphabet.charAt(b)+"") && input.lastIndexOf(alphabet.charAt(b)+"") < input.lastIndexOf(alphabet.charAt(a)+"")) 
				 || (!(input.indexOf(alphabet.charAt(a)+"")< input.indexOf(alphabet.charAt(b)+"") && input.indexOf(alphabet.charAt(b)+"") < input.lastIndexOf(alphabet.charAt(a)+"")) && (input.indexOf(alphabet.charAt(a)+"")< input.lastIndexOf(alphabet.charAt(b)+"") && input.lastIndexOf(alphabet.charAt(b)+"") < input.lastIndexOf(alphabet.charAt(a)+"")))){
					res ++;
				}
			}
		}
		pw.print(res);
		pw.close();
	}
}
