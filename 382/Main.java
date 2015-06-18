import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      String answer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      answer = "PERFECTION OUTPUT\n";
      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
            int n = Integer.parseInt(tokenizer.nextToken());
            int sum = 1;

            if (n == 0) break;
            if (n == 1) {
               answer += "    1  DEFICIENT\n";
               continue;
            }

            for (int i = 2; i * i <= n; i++) {
               if ((n % i) == 0) {
                  sum += i;
                  sum += (n / i);
               }
            }
            if (n < 10) {
               answer += "    ";
            } else if (n < 100) {
               answer += "   ";
            } else if (n < 1000) {
               answer += "  ";
            } else if (n < 10000) {
               answer += " ";
            }
            answer += Integer.toString(n);
            if (sum > n) {
               answer += "  ABUNDANT\n";
            } else if (sum < n) {
               answer += "  DEFICIENT\n";
            } else {
               answer += "  PERFECT\n";
            }
         }
      }
      answer += "END OF OUTPUT";
      System.out.println(answer);
   }
}
