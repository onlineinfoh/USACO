import java.io.*;
import java.util.StringTokenizer;
public class evenmoreoddphotos {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int length = Integer.parseInt(st.nextToken());
		int odd = 0;
		int even = 0;
		st = new StringTokenizer(r.readLine());
		for(int a = 0; a< length; a++){
			int input = Integer.parseInt(st.nextToken());
			if(input%2 == 0){
				even++;
			}
			else{
				odd++;
			}
		}
		if (odd == even){
			pw.print(odd+even);
		}
		else if (even > odd){
			pw.print(odd*2+1);
		}
		else{
			while (true){
				if(odd> even){
					even +=1;
					odd-=2;
				}
				else if(odd == even){
					pw.print(odd+even);
					break;
				}
				else{
					pw.print(odd*2+1);
					break;
				}
			}
		}
		pw.close();
	}
}