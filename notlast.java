import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
public class notlast {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("notlast.in"));
		PrintWriter pw = new PrintWriter("notlast.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int cow = Integer.parseInt(st.nextToken());
		int Bessie = 0;
		int Maggie = 0;
		int Elsie = 0;
		int Henrietta = 0;
		int Gertie = 0;
		int Daisy = 0;
		int Annabelle = 0;
		
		for(int i = 0; i<cow;i++){
			st = new StringTokenizer(r.readLine());
			String name = st.nextToken();
			int num = Integer.parseInt(st.nextToken());
			if(name.equals("Bessie")){
				Bessie+=num;
			}
			else if(name.equals("Maggie")){
				Maggie+=num;
			}
			else if(name.equals("Elsie")){
				Elsie+=num;
			}
			else if(name.equals("Henrietta")){
				Henrietta+=num;
			}
			else if(name.equals("Gertie")){
				Gertie+=num;
			}
			else if(name.equals("Daisy")){
				Daisy+=num;
			}
			else if(name.equals("Annabelle")){
				Annabelle+=num;
			}
		}
		int[] arr = new int[7];
			arr[1] = Bessie;
			arr[2] = Maggie;
			arr[3] = Elsie;
			arr[4] = Henrietta;
			arr[5] = Gertie;
			arr[6] = Daisy;
			arr[0] = Annabelle;

			Arrays.sort(arr);

			int output = 0;
			int secondsmall = 0;
			for(int a = 0; a<6;a++){
				if(arr[a]<arr[a+1]){
					secondsmall = arr[a+1];
					if(a<=4){
						if(arr[a+1] == arr[a+2]){
							pw.print("Tie");
							break;
						}
						else{
							if(Bessie == secondsmall){pw.print("Bessie");break;}
							else if(Maggie == secondsmall){pw.print("Maggie");break;}
							else if(Elsie == secondsmall){pw.print("Elsie");break;}
							else if(Henrietta == secondsmall){pw.print("Henrietta");break;}
							else if(Gertie == secondsmall){pw.print("Gertie");break;}
							else if(Daisy == secondsmall){pw.print("Daisy");break;}
							else if(Annabelle == secondsmall){pw.print("Annabelle");break;}
						}
					}
					if(a == 5){
						if(Bessie == arr[6]){pw.print("Bessie");break;}
							else if(Maggie == arr[6]){pw.print("Maggie");break;}
							else if(Elsie == arr[6]){pw.print("Elsie");break;}
							else if(Henrietta == arr[6]){pw.print("Henrietta");break;}
							else if(Gertie == arr[6]){pw.print("Gertie");break;}
							else if(Daisy == arr[6]){pw.print("Daisy");break;}
							else if(Annabelle == arr[6]){pw.print("Annabelle");break;}
					}
				}
				else{
					if(a==5){
						pw.print("Tie");
						break;
					}
				}
			}
			
		
		pw.close();
	}
}