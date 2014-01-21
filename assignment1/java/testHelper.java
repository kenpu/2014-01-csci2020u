import csci2020u.a1.Helper;
import java.util.Arrays;

class testHelper {
    public static void main(String[] args) {
        int stringLen = Integer.parseInt(args[0]);
        int arrayLen = Integer.parseInt(args[1]);

        Helper.resetTimer();        
        String[] strings = Helper.makeArray(stringLen, arrayLen);
        System.out.println(Arrays.deepToString(strings));
        System.out.printf("took: %.3f seconds\n", 
            Helper.readTimerMilliseconds() / 1000.0f);
    }
}
