import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      boolean newLine = false;
      String line;
      String[] output = new String[6];
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         tokenizer = new StringTokenizer(line);
         int k = Integer.parseInt(tokenizer.nextToken());
         String[] number = new String[k];

         for (int i = 0; i < k; i++) {
            number[i] = tokenizer.nextToken();
         }
         StringBuilder answer = new StringBuilder();
         if (newLine) {
            answer.append('\n');
         } else {
            newLine = true;
         }
         dump(number, 0, output, 0, answer);
         System.out.print(answer);
      }
   }

   public static void dump(String[] number, int start, String[] output, int k, StringBuilder answer) {
      if (k < 6) {
         for (int i = start; i < number.length; i++) {
            output[k] = number[i];
            dump(number, (i + 1), output, (k + 1), answer);
         }
      } else {
         answer.append(output[0]);
         answer.append(" " + output[1]);
         answer.append(" " + output[2]);
         answer.append(" " + output[3]);
         answer.append(" " + output[4]);
         answer.append(" " + output[5]);
         answer.append('\n');
      }
   }
}
