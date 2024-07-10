import java.io.*;
import java.util.StringTokenizer;
public class hoofpaperscissors {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter("hps.out");
		StringTokenizer st = new StringTokenizer(r.readLine());
		int turn = Integer.parseInt(st.nextToken());

            // Rock Paper Scissors
		int one123 = 0;
		int two123 = 0;
		int one213 = 0;
		int two213 = 0;
		int one132 = 0;
		int two132 = 0;
		int one321 = 0;
		int two321 = 0;

		for(int a = 0; a<turn; a++){
			st = new StringTokenizer(r.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			if(num1 == 1 && num2 == 2){two123++;one213++;one132++;one321++;}
			if(num1 == 2 && num2 == 1){one123++;two213++;two132++;two321++;}

			if(num1 == 2 && num2 == 3){two123++;one213++;one132++;one321++;}
			if(num1 == 3 && num2 == 2){one123++;two213++;two132++;two321++;}

			if(num1 == 1 && num2 == 3){one123++;two213++;two132++;two321++;}
			if(num1 == 3 && num2 == 1){two123++;one213++;one132++;one321++;}
		}

		pw.print(Math.max(two321, Math.max(one321, Math.max(two132, Math.max(one132, Math.max(two213, Math.max(one213, Math.max(one123, two123))))))));

		pw.close();
	}
}
