import java.io.*;

public class Main {
   final static int[] base3 = {
            3,         9,        27,        81,       243,       729,
         2187,      6561,     19683,     59049,    177147,    531441,
      1594323,   4782969,  14348907,  43046721, 129140163, 387420489
   };

   public static void main(String args[]) throws IOException {
      int n;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((n = Integer.parseInt(in.readLine())) >= 0) {
         int index;
         for (index = 0;index < base3.length; index++) {
            if (n < base3[index]) break;
         }
         while (index-- > 0) {
            if (n >= base3[index]) {
               answer.append((char) ((n / base3[index]) + '0'));
               n %= base3[index];
            } else {
               answer.append('0');
            }
         }
         answer.append((char) (n + '0'));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
