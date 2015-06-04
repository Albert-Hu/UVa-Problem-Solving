import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n;
         int length;
         tokenizer = new StringTokenizer(line);
         n = Integer.parseInt(tokenizer.nextToken());
         length = Integer.parseInt(tokenizer.nextToken());

         int[] m = new int[length];
         line = in.readLine();
         tokenizer = new StringTokenizer(line);
         for (int i = 0; i < length; i++) {
            m[i] = Integer.parseInt(tokenizer.nextToken());
         }
         System.out.println(n - count(n, 1, m, false));
      }
   }

   public static int count(int n, int lcm, int[] m, boolean reduce) {
      int count = 0;
      long tmp;

      for (int i = 0; i < m.length; i++) {
         tmp = least_common_multiple(lcm, m[i]);

         if (tmp > n) continue;

         count += (reduce == true) ? -(n / (int) tmp) : (n / (int) tmp);
         if ((m.length - 1 - i) > 0)
            count += count(n, (int) tmp, Arrays.copyOfRange(m, i + 1, m.length), !reduce);
      }

      return count;
   }

   public static long least_common_multiple(int a, int b) {
      int max, min, tmp;
      if (a < b) {
         max = b;
         min = a;
      } else {
         max = a;
         min = b;
      }
      while ((max % min) != 0) {
         tmp = min;
         min = max % min;
         max = tmp;
      }
      return ((long) a * (long) b) / (long) min;
   }
}
