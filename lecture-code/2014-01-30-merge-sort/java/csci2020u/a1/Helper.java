package csci2020u.a1;
import java.util.*;

public class Helper {
    static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static Random rand = new Random(0);
    static long timerStart = System.currentTimeMillis();

    static String randomString(int stringLength) {
        StringBuffer s = new StringBuffer();
        for(int i=0; i < stringLength; i++) {
            int c = rand.nextInt(26);
            s.append(alphabet.charAt(c));
        }
        return s.toString();
    }

    public static String[] makeArray(int stringLength, int arrayLength) {
        String[] strings = new String[arrayLength];
        for(int i=0; i < arrayLength; i++) {
            strings[i] = randomString(stringLength);
        }
        return strings;
    }

    public static void resetTimer() {
        Helper.timerStart = System.currentTimeMillis();
    }

    public static long readTimerMilliseconds() {
        return System.currentTimeMillis() - Helper.timerStart;
    }
}
