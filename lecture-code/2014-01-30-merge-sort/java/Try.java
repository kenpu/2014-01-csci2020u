import csci2020u.a1.Helper;
import helpers.Mergesort;

public class Try {
    public static void main(String[] args) throws Exception {
        if(args.length != 2) {
            System.out.println("Usage: <strlen> <arrlen>");
            System.exit(0);
        }

        int strlen = Integer.parseInt(args[0]);
        int arrlen = Integer.parseInt(args[1]);
        
        String[] data = Helper.makeArray(strlen, arrlen);

        Helper.resetTimer();
        String[] sorted = new Mergesort(data).sorted();
        long t = Helper.readTimerMilliseconds();

        for(String line : sorted) {
            System.out.println(line);
        }
        System.out.printf("Took: %d milliseconds.\n", t);
    }
}
