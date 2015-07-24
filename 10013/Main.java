import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean newLine = false;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         if (newLine) answer.append('\n');
         else newLine = true;

         in.readLine();
         int m = Integer.parseInt(in.readLine());
         StringBuilder a = new StringBuilder();
         StringBuilder b = new StringBuilder();

         for (int i = 0; i < m; i++) {
            String line = in.readLine();
            a.append(line.charAt(0));
            b.append(line.charAt(2));
         }

         char[] sum = new char[m];
         boolean carry = false;
         for (int i = m - 1; i >= 0; i--) {
            int c = (a.charAt(i) - '0') + (b.charAt(i) - '0') + (carry ? 1 : 0);
            if (c > 9) {
               carry = true;
               c -= 10;
            } else {
               carry = false;
            }
            sum[i] = (char) (c + '0');
         }
         if (carry) answer.append('1');
         for (int i = 0; i < m; i++) {
            if (sum[i] != '0') {
               answer.append(Arrays.copyOfRange(sum, i, m));
               break;
            }
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
