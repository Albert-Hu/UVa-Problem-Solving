import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int a = Integer.parseInt(tokenizer.nextToken());
         int b = Integer.parseInt(tokenizer.nextToken());

         if (a == 0 && b == 0) break;

         int sum = a + b;
         int carry = 0;
         boolean isCarry = false;
         String[] str = new String[2];

         str[0] = Integer.toString(sum);
         str[1] = Integer.toString((a > b) ? a : b);

         int i = str[0].length() - 1;
         int j = str[1].length() - 1;

         while (j >= 0) {
            if (str[0].charAt(i) < str[1].charAt(j)) {
               isCarry = true;
               ++carry;
            } else if (str[0].charAt(i) == str[1].charAt(j) && isCarry) {
              ++carry;
            } else {
               isCarry = false;
            }
            --i;
            --j;
         }
         if (carry > 0) {
            answer.append(Integer.toString(carry));
            answer.append(" carry ");
            answer.append((carry == 1) ? "operation.\n" : "operations.\n");
         } else {
            answer.append("No carry operation.\n");
         }
      }
      System.out.print(answer);
   }
}
