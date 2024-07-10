import java.io.*;
import java.util.StringTokenizer;
public class bounce2 {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		int position = Integer.parseInt(st.nextToken());

		int[][] input = new int[length][2];
		boolean[] broken = new boolean[length];

		for(int a = 0; a< length; a++){
			broken[a] = true;
		}
		for(int b = 0; b< length; b++){
			st = new StringTokenizer(r.readLine());
			input[b][0] = Integer.parseInt(st.nextToken());
			input[b][1] = Integer.parseInt(st.nextToken());
		}

		int result = 0;
		int power = 1;
		int direction = 1;

		int counter = 0;
		
		while (position <= length && position >= 1 && position != 0){
			if(input[position-1][0] == 1){
				if(power >= input[position-1][1] && broken[position-1] == true){
					result++;
					broken[position-1] = false;
					position += direction* power;
				}
				else if(broken[position-1] == false){
					position += direction * power;
				}
				else if(power < input[position-1][1]){
					position += direction * power;
				}
			}
			else if(input[position-1][0] == 0){
				power += input[position-1][1];
				direction *= -1;
				position += direction * power;
			}
			counter++;
			if(counter > 1000000){
				break;
			}
		}
		pw.print(result);
		
		pw.close();
	}
}