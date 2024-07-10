import java.io.*;
import java.util.StringTokenizer;
public class cowgym {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("gymnastics.in"));
		PrintWriter pw = new PrintWriter("gymnastics.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int session = Integer.parseInt(st.nextToken());
		int cownum = Integer.parseInt(st.nextToken());
		String[][] input = new String[session][session*cownum];
		int c = 0;
		String[] firstline = new String[cownum];
		for(int a  = 0; a< session*cownum; a++){
			if(a%cownum == 0 ){
				st = new StringTokenizer(r.readLine());
			}
			String thingtoadd = st.nextToken();
			if(a<=cownum-1){
				firstline[a] = thingtoadd;
			}
			if(a%cownum ==cownum-1){
				if(a>cownum-1){
				input[c][a%(cownum)] = thingtoadd;
				}
				else{
					input[c][a] = thingtoadd;
				}
				c++;
				continue;
			}
			if(a>cownum-1){
				input[c][a%(cownum)] = thingtoadd;
			}
			else{
				input[c][a] = thingtoadd;
			}
		}
		int pairs = 0;
		for(int e = 0; e<firstline.length; e++){
			for(int d = e+1; d<firstline.length; d++){
				String first = firstline[e];
				String second = firstline[d]; 
				boolean consistent = true;
				for(int i = 1; i<session; i++){
					String[] com = input[i];
					if(indexOf(com, first) < indexOf(com, second)){
						consistent = true;
					}
					else{
						consistent = false;
						break;
					}
				}
				if(consistent){
					pairs++;
				}
			}
		}
		pw.print(pairs);
		pw.close();
	}
	static int indexOf(String[] arr, String find){
		for (int z = 0; z<arr.length; z++){
			if (arr[z].equals(find)){
				return z;
			}
		}
		return 0;
	}
}