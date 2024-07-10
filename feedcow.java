import java.io.*;
import java.util.StringTokenizer;

public class feedcow {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());
		int casenum = Integer.parseInt(st.nextToken());
		for(int a = 0; a<casenum; a++){
			int min = 0;
			String config = "";
			st = new StringTokenizer(r.readLine());
			int cownum = Integer.parseInt(st.nextToken());
			for(int b = 0; b<cownum; b++){
				config +=".";
			}
			int shift = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(r.readLine());
			String inputconfig = st.nextToken();

			int Gcover = -1;
			int Hcover = -1;
			for(int c = 0; c<inputconfig.length(); c++){
				if(inputconfig.equals("HG") || inputconfig.equals("GH")){
					config = "GH";
					min = 2;
				}
				else{
					if(c>Gcover && (inputconfig.charAt(c)+"").equals("G")){
						if((shift+c) > cownum-1){
							config = config.substring(0, c)+"G"+config.substring(c+1);
							Gcover = c+2*shift;
							min++;
						}
						else{
							config = config.substring(0, c+shift)+"G"+config.substring(c+shift+1);
							Gcover = c+2*shift;
							min++;
						}
					}
					else if(c>Hcover && (inputconfig.charAt(c)+"").equals("H")){
						if((shift+c) > cownum-1){
							config = config.substring(0, c)+"H"+config.substring(c+1);
							Hcover = c+2*shift;
							min++;
						}
						else{
							config = config.substring(0, c+shift)+"H"+config.substring(c+shift+1);
							Hcover = c+2*shift;
							min++;
						}
					}
				}
			}
			pw.println(min);
			if(a!=casenum-1){
				pw.println(config);
			}else{
				pw.print(config);
			}
		}

		
		pw.close();
	}
}