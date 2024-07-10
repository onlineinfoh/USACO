import java.util.HashMap;
import java.io.*;
import java.util.StringTokenizer;
public class citiesandstates {
	public static void main(String[] args) throws IOException {
		//BufferedReader r = new BufferedReader(new InputStreamReader(System.in));PrintWriter pw = new PrintWriter(System.out);
		BufferedReader r = new BufferedReader(new FileReader("citystate.in"));PrintWriter pw = new PrintWriter("citystate.out");
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		HashMap <String, Integer> map = new HashMap<>();
		String[][] arr = new String[length][2];

		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			String first = st.nextToken().substring(0, 2);
			String last = st.nextToken();
			arr[a][0] = first; 
			arr[a][1] = last;
			String s =  first + last;
			if(!first.equals(last)){
			if(map.containsKey(s)){
				int original = map.get(s);
				map.put(s, original+1);
			}
			else{
				map.put(s, 1);
			}
			}
		}
		int output = 0;
		
		for (String key: map.keySet()){
			output += map.getOrDefault(key.substring(2)+key.substring(0,2), 0) * map.getOrDefault(key.substring(0,2)+key.substring(2), 0);
		}

		pw.print(output / 2);

		pw.close();
	}
}