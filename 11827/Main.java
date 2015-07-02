import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         ArrayList<Integer> list = new ArrayList<Integer>();

         while (tokenizer.hasMoreTokens()) {
            list.add(Integer.parseInt(tokenizer.nextToken()));
         }

         int max = 1;
         for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
               int g = gcd(list.get(i), list.get(j));
               if (g > max) max = g;
            }
         }
         answer.append(Integer.toString(max));
         answer.append('\n');
      }
      System.out.print(answer);
   }

   public static int gcd(int a, int b) {
      int tmp;

      do {
         tmp = b;
         b = a % b;
         a = tmp;
      } while (b != 0);

      return a;
   }
}
