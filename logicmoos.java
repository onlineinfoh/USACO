import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class logicmoos {
	public static ArrayList<String> input = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());


		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(r.readLine());

		for(int a = 0; a< num1; a++){
			input.add(st.nextToken());
		}

		String out = "";
		for(int b = 0; b< num2; b++){ 
			st = new StringTokenizer(r.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String bool = st.nextToken();
			
			if(replaceTrue(input, x, y).equals(bool) || replaceFalse(input, x, y).equals(bool)){
				out+="Y";
			}
			else{
				out+="N";
			}
		}
		pw.print(out);
		pw.close();
	}

	public static String replaceTrue(ArrayList<String> inp, int x, int y){
		ArrayList<String> input = new ArrayList<>(inp);

		for(int a = 0; a< y-x+1; a++){
			if(input.size() == 1){
				break;
			}
			input.remove(x-1);
		}
		if(input.size() == 1){
			input.set(0, "true");
		}
		else{
			input.add(x-1, "true");
		}

		while(input.contains("and")){
			for(int b = 0; b< input.size(); b++){
				if(input.get(b).equals("and")){
					String prev = input.get(b-1);
					String aft = input.get(b+1);
					if(prev.equals("true") && aft.equals("true")){
						input.set(b, "true");
						input.remove(b-1);
						input.remove(b);
						break;
					}
					else{
						input.set(b, "false");
						input.remove(b-1);
						input.remove(b);
						break;
					}
				}
			}
		}
		while(input.contains("or")){
			for(int c = 0; c< input.size(); c++){
				if(input.get(c).equals("or")){
					String prev = input.get(c-1);
					String aft = input.get(c+1);
					if(prev.equals("false") && aft.equals("false")){
						input.set(c, "false");
						input.remove(c+1);
						input.remove(c-1);
						break;
					}
					else{
						input.set(c, "true");
						input.remove(c+1);
						input.remove(c-1);
						break;
					}
				}
			}
		}
		return input.get(0);
	}
	public static String replaceFalse(ArrayList<String> inp, int x, int y){
		ArrayList<String> input = new ArrayList<>(inp);

		for(int a = 0; a< y-x+1; a++){
			if(input.size() == 1){
				break;
			}
			input.remove(x-1);
		}

		if(input.size() == 1){
			input.set(0, "false");
		}
		else{
			input.add(x-1, "false");
		}

		while(input.contains("and")){
			for(int b = 0; b< input.size(); b++){
				if(input.get(b).equals("and")){
					String prev = input.get(b-1);
					String aft = input.get(b+1);
					if(prev.equals("true") && aft.equals("true")){
						input.set(b, "true");
						input.remove(b-1);
						input.remove(b);
						break;
					}
					else{
						input.set(b, "false");
						input.remove(b-1);
						input.remove(b);
						break;
					}
				}
			}
		}
		while(input.contains("or")){
			for(int c = 0; c< input.size(); c++){
				if(input.get(c).equals("or")){
					String prev = input.get(c-1);
					String aft = input.get(c+1);
					if(prev.equals("false") && aft.equals("false")){
						input.set(c, "false");
						input.remove(c+1);
						input.remove(c-1);
						break;
					}
					else{
						input.set(c, "true");
						input.remove(c+1);
						input.remove(c-1);
						break;
					}
				}
			}
		}
		return input.get(0);
	}
}