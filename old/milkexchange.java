import java.io.*;
import java.util.StringTokenizer;
public class milkexchange {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());
		
		String[] direction = new String[length]; // letter

		long[] amount = new long[length]; // value

		String input = st.nextToken();

		st = new StringTokenizer(r.readLine());
		long origin = 0;
		String tem = "";
		for (int b = 0; b< length; b++){
			amount[b] = Long.parseLong(st.nextToken());
			origin+=amount[b];
			tem+=amount[b]+"";
		}

		if(input.indexOf("LR") == -1 && !((input.charAt(0)+"").equals("R") && (input.charAt(input.length()-1)+"").equals("L"))){
			pw.print(origin);
		}
		else{
			if(!((input.charAt(0)+"").equals("R") && (input.charAt(input.length()-1)+"").equals("L"))){
				input = input.substring(input.indexOf("LR")+1) + input.substring(0, input.indexOf("LR")+1);
				tem = tem.substring(input.indexOf("LR")+1) + tem.substring(0, input.indexOf("LR")+1);
			}
			for(int a = 0; a< length; a++){
				direction[a] = input.charAt(a)+"";
			}
			long loss = 0;

			for(int c = 0; c< length; c++){
				amount[c] = Integer.parseInt(tem.charAt(c)+"");
			}

			int cur = 0;
			int left_cur = 0;
			for(int i = 0; i< length-1; i++){
				if(direction[i].equals("R") && direction[i+1].equals("L")){
					i++;
					loss += Math.min(cur, time);
					cur = 0;
				}
				else if(direction[i].equals("L")){
					left_cur+= amount[i];
				}
				else{
					loss += Math.min(left_cur, time);
					left_cur = 0;
					cur += amount[i];
				}
			}
			pw.print(origin - loss);
		}

		
		pw.close();
	}
}