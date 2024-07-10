import java.io.*;
import java.util.StringTokenizer;
public class blockgame {
	public static void main(String[] args) throws IOException {
		String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		BufferedReader r = new BufferedReader(new FileReader("blocks.in"));
		PrintWriter pw = new PrintWriter("blocks.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int[] output = new int[26];
		int one = 0;
		int two = 0;
		int time = Integer.parseInt(st.nextToken());
		for (int a = 0;a<time;a++){
			pw.print("");
			String[] spl = r.readLine().split(" ",4);		
			for(int b = 0; b<26;b++){
				for(int d = 0; d<spl[0].length();d++){
					if((spl[0].charAt(d)+"").equals(alpha[b])){
						one+=1;
					}
				}
				for(int e = 0; e<spl[1].length();e++){
					if((spl[1].charAt(e)+"").equals(alpha[b])){
						two+=1;
					}
				}					
            	output[b] = output[b] + Math.max(one,two);
				one = 0;
				two = 0;
			}
		}
		for(int x = 0; x<25;x++){
			pw.println(output[x]);
		}
		pw.print(output[25]);
		pw.close();
	}
	}