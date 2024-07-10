import java.io.*;
import java.util.StringTokenizer;
public class photoshoot {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(r.readLine());
		String s = st.nextToken();

		String word = "";

		for(int a = 0; a< length; a+=2){
			if((s.charAt(a)+""+(s.charAt(a+1))).equals("GH")){word+="1";}
			else if ((s.charAt(a)+""+(s.charAt(a+1))).equals("HG")){word+="0";}
		}

		String[] arr = new String[word.length()];

		for(int b = 0; b< word.length(); b++){
			arr[b] = word.charAt(b)+"";
		}
		String str = word.charAt(0)+"";
		for(int c = 1; c< word.length(); c++){
			if(!arr[c].equals(arr[c-1])){
				str+= arr[c];
			}
		}
		if((str.charAt(str.length()-1)+"").equals("0")){
			str = str.substring(0, str.length()-1);
		}

		pw.print(str.length());

		pw.close();
	}
}