import java.io.*;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class majority2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for (int a = 0; a < T; a++) {
            HashSet<Integer> output = new HashSet<Integer>();
            st = new StringTokenizer(r.readLine());
            int length = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            int[] input = new int[length];
            
            for (int b = 0; b < length; b++) {
                input[b] = Integer.parseInt(st.nextToken());
            }
            
            for (int c = 0; c < length; c++) {
                int target = input[c];
                if (!output.contains(target)) {
                    int thisNum = 0;
                    int totalNum = 0;
                    
                    for (int d = c; d < length; d++) {
                        if (input[d] == target) {
                            thisNum++;
                            totalNum++;
                        } else {
                            totalNum++;
                        }
                        
                        if (thisNum > 1 && thisNum > totalNum / 2) {
                            output.add(target);
                            break;
                        }
                    }
                }
            }
            
            if (output.isEmpty()) {
                pw.print(-1 + "\n");
            } else {
                // Convert HashSet to a List and sort it
                ArrayList<Integer> sortedOutput = new ArrayList<>(output);
                Collections.sort(sortedOutput);
                
                for (int i = 0; i < sortedOutput.size(); i++) {
                    if (i == sortedOutput.size() - 1) {
                        pw.print(sortedOutput.get(i) + "\n");
                    } else {
                        pw.print(sortedOutput.get(i) + " ");
                    }
                }
            }
        }
        pw.close();
    }
}
