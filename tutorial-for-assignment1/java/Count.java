import java.io.*;
import java.util.*;

public class Count {
    static class ByValue implements Comparator<Map.Entry<String, Integer>> {
        public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
            // compare counts in reverse order
            return -1 * Integer.compare(a.getValue(), b.getValue());
        }
    }
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

        // get all the entries into a vector
        Vector<Map.Entry<String, Integer>> entries = new Vector<Map.Entry<String, Integer>>();
        entries.addAll(counts.entrySet());
        Collections.sort(entries, new ByValue());

        System.out.printf("There are %d distinct words.\n", counts.size());
        for(int i=0; i < 100; i ++) {
            Map.Entry<String, Integer> e = entries.get(i);
            System.out.printf("\"%s\" %d\n", e.getKey(), e.getValue());
        }
    }
}
