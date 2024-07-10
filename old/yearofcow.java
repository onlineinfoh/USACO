import java.io.*;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class yearofcow {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(r.readLine());

		int length = Integer.parseInt(st.nextToken());
		
		HashMap <String, String[]> info = new HashMap<>();

		HashMap <String, Integer> cycle = new HashMap<>();
		cycle.put("Rat", 1);cycle.put("Ox", 2);cycle.put("Rabbit", 4);cycle.put("Dragon", 5);
		cycle.put("Tiger", 3);cycle.put("Snake", 6);cycle.put("Horse", 7);cycle.put("Goat", 8);
		cycle.put("Monkey", 9);cycle.put("Rooster", 10);cycle.put("Dog", 11);cycle.put("Pig", 12);

		HashMap <String, String[]> ans = new HashMap<>();
		ans.put("B", new String[]{"0", "Ox"});

		for(int a = 0; a< length; a++){
			st = new StringTokenizer(r.readLine());
			String name1 = st.nextToken().substring(0, 1);
			st.nextToken();st.nextToken();
			String direction = st.nextToken().substring(0, 1);
			String animal = st.nextToken();
			st.nextToken();st.nextToken();
			String name2 = st.nextToken().substring(0, 1);
			info.put(a+"", new String[] {name1, direction, animal, name2});
		}
		// take input

		while(!ans.containsKey("E")){
			for(Map.Entry<String, String[]> entry : info.entrySet()){
				String[] specific = entry.getValue();
				if(ans.containsKey(specific[3])){
					String[] reference = ans.get(specific[3]);
					if(specific[1].equals("p")){
						if(cycle.get(specific[2]) == cycle.get(reference[1])){
							ans.put(specific[0], new String[]{(-12+Integer.parseInt(reference[0]))+"", reference[1]});
						}
						else if(cycle.get(specific[2]) > cycle.get(reference[1])){
							int cur = cycle.get(reference[1]);
							int prev = cycle.get(specific[2]);
							ans.put(specific[0], new String[]{(Integer.parseInt(reference[0]) - (12-Math.abs(cur-prev)))+"", specific[2]});
						}
						else if(cycle.get(specific[2]) < cycle.get(reference[1])){
							int cur = cycle.get(reference[1]);
							int prev = cycle.get(specific[2]);
							ans.put(specific[0], new String[]{(Integer.parseInt(reference[0]) - (cur-prev))+"", specific[2]});
						}
					}
					else if(specific[1].equals("n")){
						if(cycle.get(specific[2]) == cycle.get(reference[1])){
							ans.put(specific[0], new String[]{(12+Integer.parseInt(reference[0]))+"", reference[1]});
						}
						else if(cycle.get(specific[2]) < cycle.get(reference[1])){
							int cur = cycle.get(reference[1]);
							int prev = cycle.get(specific[2]);
							ans.put(specific[0], new String[]{(Integer.parseInt(reference[0]) + (12-Math.abs(cur-prev)))+"", specific[2]});
						}
						else if(cycle.get(specific[2]) > cycle.get(reference[1])){
							int cur = cycle.get(reference[1]);
							int prev = cycle.get(specific[2]);
							ans.put(specific[0], new String[]{(Integer.parseInt(reference[0]) + (prev - cur))+"", specific[2]});
						}
					}
					String[] tem = info.get(entry.getKey());
					tem[1] = "o";
					info.put(entry.getKey(), tem);
				}
				else{
					continue;
				}
				
			}
		}
		pw.print(Math.abs(Integer.parseInt(ans.get("E")[0])));

		pw.close();
	}
}