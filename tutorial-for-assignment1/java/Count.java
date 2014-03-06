import java.io.*;
import java.util.*;

public class Count {
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        Map<String, Integer> counts = new TreeMap<String, Integer>();

        BufferedReader reader = new BufferedReader(
            new InputStreamReader(
                new FileInputStream(filename)));

        String line = reader.readLine();
        while(line != null) {
            String[] words = line.split("\\s+");
            for(String w : words) {
                if(counts.containsKey(w)) {
                    counts.put(w, counts.get(w)+1);
                } else {
                    counts.put(w, 1);
                }
            }
            line = reader.readLine();
        }
        reader.close();

        System.out.printf("There are %d distinct words.\n", counts.size());
    }
}
