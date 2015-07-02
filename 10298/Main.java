import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String input;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((input = in.readLine()) != null) {
         if (input.length() == 1 && input.charAt(0) == '.')
            break;

         StringTokenizer tokenizer = new StringTokenizer(input);
         StringBuilder line = new StringBuilder();
         ArrayList<Integer> segment = new ArrayList<Integer>();

         while (tokenizer.hasMoreTokens()) {
            line.append(tokenizer.nextToken());
         }

         segment.add(1);
         int length = line.length();
         for (int i = 2; i * i <= length; i++) {
            if (length % i == 0) {
               int s = length / i;
               if (s != i) segment.add(s);
               segment.add(i);
            }
         }
         Collections.sort(segment);

         int found = 0;
         for (int i = 0; i < segment.size() && found == 0; i++) {
            int next = found = segment.get(i);
            String s1 = line.substring(0, found);
            while (next < line.length() && found != 0) {
               String s2 = line.substring(next, next + found);
               if (!s1.equals(s2)) {
                  found = 0;
                  break;
               }
               next += found;
            }
         }
         answer.append((found == 0) ? "1" : Integer.toString(line.length()/found));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
