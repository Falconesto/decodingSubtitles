import java.io.*;
import java.util.*;
import java.nio.charset.StandardCharsets;

    public class Main {
        BufferedReader br, brDict;
        PrintWriter out;

        public static void main(String[] args) throws IOException {
            new Main().run();
        }

    public void run() {
        try {
            br = new BufferedReader(new FileReader("4_3en.srt", StandardCharsets.UTF_8));
            out = new PrintWriter("4_3enFixed.srt", StandardCharsets.UTF_8);
            solve();

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void solve() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            char[] chLine = line.toCharArray();
            if ((chLine.length != 0) && (chLine[0] == '0') && (chLine[1] == '0')) {
                int num11 = Character.getNumericValue(chLine[6]);
                int num12 = Character.getNumericValue(chLine[7]);
                int num21 = Character.getNumericValue(chLine[23]);
                int num22 = Character.getNumericValue(chLine[24]);
                int num1 = num11 * 10 + num12 + 5;
                int num2 = num21 * 10 + num22 + 5;

                if (num1 > 59) {
                    int num13 = Character.getNumericValue(chLine[4]);
                    num13++;
                    String strMinReplacement = String.valueOf(num13);
                    char chMinReplacement = strMinReplacement.charAt(0);
                    chLine[4] = chMinReplacement;
                    num1 -= 60;
                }
                String strSec11Replacement = String.valueOf(num1 / 10);
                String strSec12Replacement = String.valueOf(num1 % 10);
                char chSec11Replacement = strSec11Replacement.charAt(0);
                char chSec12Replacement = strSec12Replacement.charAt(0);
                chLine[6] = chSec11Replacement;
                chLine[7] = chSec12Replacement;

                if (num2 > 59) {
                    int num23 = Character.getNumericValue(chLine[21]);
                    num23++;
                    String strMinReplacement = String.valueOf(num23);
                    char chMinReplacement = strMinReplacement.charAt(0);
                    chLine[21] = chMinReplacement;
                    num2 -= 60;
                }
                String strSec21Replacement = String.valueOf(num2 / 10);
                String strSec22Replacement = String.valueOf(num2 % 10);
                char chSec21Replacement = strSec21Replacement.charAt(0);
                char chSec22Replacement = strSec22Replacement.charAt(0);
                chLine[23] = chSec21Replacement;
                chLine[24] = chSec22Replacement;
            }
            String newStr = new String(chLine);
            out.println(newStr);
        }

    }
}