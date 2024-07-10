import java.io.*;
import java.util.StringTokenizer;
public class cowtip {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("cowtip.in"));
		PrintWriter pw = new PrintWriter("cowtip.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int counter = 0;
		int size = Integer.parseInt(st.nextToken());
		String input = "";
		for(int a=0; a<size; a++){
			st = new StringTokenizer(r.readLine());
			input += st.nextToken();
		}
		for(int b = input.length()-1; b>=0; b--){
			if(Integer.parseInt(input.charAt(b)+"") == 1){
				//
				if((b+1)%size == 0){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"") == 1){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//
				if((b+1)%size == 1){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//2
				if((b+1)%size == 2){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//3
				if((b+1)%size == 3){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//4
				if((b+1)%size == 4){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//5
				if((b+1)%size == 5){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4||Integer.parseInt(input.charAt(c)+"")%size == 5){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//6
				if((b+1)%size == 6){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4||Integer.parseInt(input.charAt(c)+"")%size == 5||Integer.parseInt(input.charAt(c)+"")%size == 6){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//7
				if((b+1)%size == 7){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4||Integer.parseInt(input.charAt(c)+"")%size == 5||Integer.parseInt(input.charAt(c)+"")%size == 6||Integer.parseInt(input.charAt(c)+"")%size == 7){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//8
				if((b+1)%size == 8){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4||Integer.parseInt(input.charAt(c)+"")%size == 5||Integer.parseInt(input.charAt(c)+"")%size == 6||Integer.parseInt(input.charAt(c)+"")%size == 7||Integer.parseInt(input.charAt(c)+"")%size == 8){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//9
				if((b+1)%size == 9){
				String toAdd = "";
				for(int c = b;c>=0; c--){
					if(Integer.parseInt(input.charAt(c)+"")%size == 1||Integer.parseInt(input.charAt(c)+"")%size == 2||Integer.parseInt(input.charAt(c)+"")%size == 3||Integer.parseInt(input.charAt(c)+"")%size == 4||Integer.parseInt(input.charAt(c)+"")%size == 5||Integer.parseInt(input.charAt(c)+"")%size == 6||Integer.parseInt(input.charAt(c)+"")%size == 7||Integer.parseInt(input.charAt(c)+"")%size == 8||Integer.parseInt(input.charAt(c)+"")%size == 9){
						toAdd = "0"+toAdd;
					}
					else{
						toAdd = "1"+toAdd;
					}
				}
				input = toAdd+input.substring(b+1);
				counter++;
			    }
				//
			}
		}
		pw.print(counter);
		pw.close();
	}
}
