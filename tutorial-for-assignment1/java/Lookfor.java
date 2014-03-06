import java.io.*;

public class Lookfor {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Usage: <filename> <keyword>");
            System.exit(0);
        }

        String filename = args[0];
        String keyword  = args[1];

        InputStream in;
        try {
            in = new FileInputStream(filename);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = reader.readLine();
            long start = System.currentTimeMillis();
            int count = 0;
            while(line != null) {
                if(line.contains(keyword)) {
                    System.out.println(line);
                    count += 1;
                }
                line = reader.readLine();
            }
            float dur = (System.currentTimeMillis() - start) / 1000f;
            System.out.printf("Found %d instances in %.4f seconds\n",
                count,
                dur);
            reader.close();
        } catch(Exception e) {
            System.out.printf("Cannot open file \"%s\"\n", filename);
            System.exit(0);
        }

    }
}
