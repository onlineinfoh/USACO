import java.io.*;
import java.util.StringTokenizer;
public class cownomics {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cownomics.in"));
		PrintWriter pw = new PrintWriter("cownomics.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int height = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());

		String[] arr1 = new String[height];
		String[] arr2 = new String[height];
		
		for(int i = 0; i< height; i++){
			st = new StringTokenizer(r.readLine());
			arr1[i] = st.nextToken();
		}
		for(int j = 0; j< height; j++){
			st = new StringTokenizer(r.readLine());
			arr2[j] = st.nextToken();
		}
		int positions = 0;
		for(int a = 0; a<length; a++){
			boolean valid = true;
			for(int b = 0; b<height; b++){
				String com = arr1[b].charAt(a)+"";
				for(int c = 0; c< height; c++){
					if((arr2[c].charAt(a)+"").equals(com)){
						valid = false;
					}
				}
			}
			if(valid){
				positions++;
			}
		}
		pw.print(positions);

		pw.close();
	}
}
