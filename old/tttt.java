import java.io.*;
import java.util.StringTokenizer;
public class tttt {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("tttt.in"));
		PrintWriter pw = new PrintWriter("tttt.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		String input = "";
		input+=st.nextToken();
		st = new StringTokenizer(r.readLine());
		input+=st.nextToken();
		st = new StringTokenizer(r.readLine());
		input+=st.nextToken();
		String[] arr = new String[9];
		for (int a = 0; a<9; a++){
			arr[a] = input.charAt(a)+"";
		}
		int oneteam = 0;
		int twoteam = 0;
		String onecount = "";
		String twocount = "";
		if(arr[0].equals(arr[1]) || arr[1].equals(arr[2]) || arr[0].equals(arr[2])){
			if(arr[0].equals(arr[1]) && arr[1].equals(arr[2]) && arr[0].equals(arr[2])){
				if(onecount.indexOf(arr[1])==-1){
					oneteam++;
					onecount+=arr[1];
				}
			}
			else{
				if(arr[0].equals(arr[1])){
					if(twocount.indexOf(arr[0]+arr[2]) == -1 && twocount.indexOf(arr[2]+arr[0]) == -1){
						twocount += arr[0]+arr[2]+ " ";
						twocount += arr[2]+arr[0]+" ";
						twoteam++;
					}
				}
				if(arr[0].equals(arr[2])){
					if(twocount.indexOf(arr[1]+arr[2]) == -1 && twocount.indexOf(arr[2]+arr[1]) == -1){
						twocount += arr[1]+arr[2]+ " ";
						twocount += arr[2]+arr[1]+" ";
						twoteam++;
					}
				}
				if(arr[1].equals(arr[2])){
					if(twocount.indexOf(arr[1]+arr[0]) == -1 && twocount.indexOf(arr[0]+arr[1]) == -1){
						twocount += arr[1]+arr[0]+ " ";
						twocount += arr[0]+arr[1]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[0].equals(arr[3]) || arr[0].equals(arr[6]) || arr[3].equals(arr[6])){
			if(arr[0].equals(arr[3]) && arr[0].equals(arr[6]) && arr[3].equals(arr[6])){
				if(onecount.indexOf(arr[0])==-1){
					oneteam++;
					onecount+=arr[0];
				}
			}
			else{
				if(arr[0].equals(arr[3])){
					if(twocount.indexOf(arr[3]+arr[6]) == -1 && twocount.indexOf(arr[6]+arr[3]) == -1){
						twocount += arr[3]+arr[6]+ " ";
						twocount += arr[6]+arr[3]+" ";
						twoteam++;
					}
				}
				if(arr[0].equals(arr[6])){
					if(twocount.indexOf(arr[0]+arr[3]) == -1 && twocount.indexOf(arr[3]+arr[0]) == -1){
						twocount += arr[0]+arr[3]+ " ";
						twocount += arr[3]+arr[0]+" ";
						twoteam++;
					}
				}
				if(arr[3].equals(arr[6])){
					if(twocount.indexOf(arr[6]+arr[0]) == -1 && twocount.indexOf(arr[0]+arr[6]) == -1){
						twocount += arr[6]+arr[0]+ " ";
						twocount += arr[0]+arr[6]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[0].equals(arr[4]) || arr[0].equals(arr[8]) || arr[4].equals(arr[8])){
			if(arr[0].equals(arr[4]) && arr[0].equals(arr[8]) && arr[4].equals(arr[8])){
				if(onecount.indexOf(arr[0])==-1){
					oneteam++;
					onecount+=arr[0];
				}
			}
			else{
				if(arr[0].equals(arr[4])){
					if(twocount.indexOf(arr[4]+arr[8]) == -1 && twocount.indexOf(arr[8]+arr[4]) == -1){
						twocount += arr[4]+arr[8]+ " ";
						twocount += arr[8]+arr[4]+" ";
						twoteam++;
					}
				}
				if(arr[4].equals(arr[8])){
					if(twocount.indexOf(arr[0]+arr[8]) == -1 && twocount.indexOf(arr[8]+arr[0]) == -1){
						twocount += arr[0]+arr[8]+ " ";
						twocount += arr[8]+arr[0]+" ";
						twoteam++;
					}
				}
				if(arr[0].equals(arr[8])){
					if(twocount.indexOf(arr[4]+arr[0]) == -1 && twocount.indexOf(arr[0]+arr[4]) == -1){
						twocount += arr[4]+arr[0]+ " ";
						twocount += arr[0]+arr[4]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[1].equals(arr[4]) || arr[1].equals(arr[7]) || arr[4].equals(arr[7])){
			if(arr[1].equals(arr[4]) && arr[1].equals(arr[7]) && arr[4].equals(arr[7])){
				if(onecount.indexOf(arr[1])==-1){
					oneteam++;
					onecount+=arr[1];
				}
			}
			else{
				if(arr[1].equals(arr[4])){
					if(twocount.indexOf(arr[4]+arr[7]) == -1 && twocount.indexOf(arr[7]+arr[4]) == -1){
						twocount += arr[4]+arr[7]+ " ";
						twocount += arr[7]+arr[4]+" ";
						twoteam++;
					}
				}
				if(arr[4].equals(arr[7])){
					if(twocount.indexOf(arr[1]+arr[7]) == -1 && twocount.indexOf(arr[7]+arr[1]) == -1){
						twocount += arr[1]+arr[7]+ " ";
						twocount += arr[7]+arr[1]+" ";
						twoteam++;
					}
				}
				if(arr[1].equals(arr[7])){
					if(twocount.indexOf(arr[4]+arr[1]) == -1 && twocount.indexOf(arr[1]+arr[4]) == -1){
						twocount += arr[4]+arr[1]+ " ";
						twocount += arr[1]+arr[4]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[2].equals(arr[4]) || arr[2].equals(arr[6]) || arr[4].equals(arr[6])){
			if(arr[2].equals(arr[4]) && arr[2].equals(arr[6]) && arr[4].equals(arr[6])){
				if(onecount.indexOf(arr[2])==-1){
					oneteam++;
					onecount+=arr[2];
				}
			}
			else{
				if(arr[2].equals(arr[4])){
					if(twocount.indexOf(arr[4]+arr[6]) == -1 && twocount.indexOf(arr[6]+arr[4]) == -1){
						twocount += arr[4]+arr[6]+ " ";
						twocount += arr[6]+arr[4]+" ";
						twoteam++;
					}
				}
				if(arr[2].equals(arr[6])){
					if(twocount.indexOf(arr[2]+arr[4]) == -1 && twocount.indexOf(arr[4]+arr[2]) == -1){
						twocount += arr[2]+arr[4]+ " ";
						twocount += arr[4]+arr[2]+" ";
						twoteam++;
					}
				}
				if(arr[4].equals(arr[6])){
					if(twocount.indexOf(arr[2]+arr[6]) == -1 && twocount.indexOf(arr[6]+arr[2]) == -1){
						twocount += arr[2]+arr[6]+ " ";
						twocount += arr[6]+arr[2]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[2].equals(arr[5]) || arr[2].equals(arr[8]) || arr[5].equals(arr[8])){
			if(arr[2].equals(arr[5]) && arr[2].equals(arr[8]) && arr[5].equals(arr[8])){
				if(onecount.indexOf(arr[2])==-1){
					oneteam++;
					onecount+=arr[2];
				}
			}
			else{
				if(arr[2].equals(arr[5])){
					if(twocount.indexOf(arr[5]+arr[8]) == -1 && twocount.indexOf(arr[8]+arr[5]) == -1){
						twocount += arr[5]+arr[8]+ " ";
						twocount += arr[8]+arr[5]+" ";
						twoteam++;
					}
				}
				if(arr[2].equals(arr[8])){
					if(twocount.indexOf(arr[2]+arr[5]) == -1 && twocount.indexOf(arr[5]+arr[2]) == -1){
						twocount += arr[2]+arr[5]+ " ";
						twocount += arr[5]+arr[2]+" ";
						twoteam++;
					}
				}
				if(arr[5].equals(arr[8])){
					if(twocount.indexOf(arr[2]+arr[8]) == -1 && twocount.indexOf(arr[8]+arr[2]) == -1){
						twocount += arr[2]+arr[8]+ " ";
						twocount += arr[8]+arr[2]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[3].equals(arr[5]) || arr[3].equals(arr[4]) || arr[5].equals(arr[4])){
			if(arr[3].equals(arr[5]) && arr[3].equals(arr[4]) && arr[5].equals(arr[4])){
				if(onecount.indexOf(arr[3])==-1){
					oneteam++;
					onecount+=arr[3];
				}
			}
			else{
				if(arr[3].equals(arr[5])){
					if(twocount.indexOf(arr[4]+arr[5]) == -1 && twocount.indexOf(arr[5]+arr[4]) == -1){
						twocount += arr[4]+arr[5]+ " ";
						twocount += arr[5]+arr[4]+" ";
						twoteam++;
					}
				}
				if(arr[3].equals(arr[4])){
					if(twocount.indexOf(arr[3]+arr[5]) == -1 && twocount.indexOf(arr[5]+arr[3]) == -1){
						twocount += arr[3]+arr[5]+ " ";
						twocount += arr[5]+arr[3]+" ";
						twoteam++;
					}
				}
				if(arr[5].equals(arr[4])){
					if(twocount.indexOf(arr[3]+arr[4]) == -1 && twocount.indexOf(arr[4]+arr[3]) == -1){
						twocount += arr[3]+arr[4]+ " ";
						twocount += arr[4]+arr[3]+" ";
						twoteam++;
					}
				}
			}
		}
		if(arr[6].equals(arr[7]) || arr[6].equals(arr[8]) || arr[7].equals(arr[8])){
			if(arr[6].equals(arr[7]) && arr[6].equals(arr[7]) && arr[7].equals(arr[8])){
				if(onecount.indexOf(arr[6])==-1){
					oneteam++;
					onecount+=arr[6];
				}
			}
			else{
				if(arr[6].equals(arr[7])){
					if(twocount.indexOf(arr[8]+arr[7]) == -1 && twocount.indexOf(arr[7]+arr[8]) == -1){
						twocount += arr[8]+arr[7]+ " ";
						twocount += arr[7]+arr[8]+" ";
						twoteam++;
					}
				}
				if(arr[6].equals(arr[8])){
					if(twocount.indexOf(arr[6]+arr[7]) == -1 && twocount.indexOf(arr[7]+arr[6]) == -1){
						twocount += arr[6]+arr[7]+ " ";
						twocount += arr[7]+arr[6]+" ";
						twoteam++;
					}
				}
				if(arr[7].equals(arr[8])){
					if(twocount.indexOf(arr[6]+arr[8]) == -1 && twocount.indexOf(arr[8]+arr[6]) == -1){
						twocount += arr[6]+arr[8]+ " ";
						twocount += arr[8]+arr[6]+" ";
						twoteam++;
					}
				}
			}
		}
		pw.println(oneteam);
		pw.print(twoteam);
		pw.close();
	}
}