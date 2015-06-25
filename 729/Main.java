import java.io.*;
import java.util.*;

public class Main {
   final static int[] bits = {
      0x0001, 0x0003, 0x0007, 0x000f,
      0x001f, 0x003f, 0x007f, 0x00ff,
      0x01ff, 0x03ff, 0x07ff, 0x0fff,
      0x1fff, 0x3fff, 0x7fff, 0xffff
   };

   public static void main(String args[]) throws IOException {
      int n = -1, m = -1;
      boolean newLine = false;
      StringTokenizer tokenizer = null;
      StringBuilder output = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int tests = Integer.parseInt(in.readLine());

      while (tests > 0) {
         tokenizer = new StringTokenizer(in.readLine());
         while (tokenizer.hasMoreTokens()) {
            if (n < 0) {
               n = Integer.parseInt(tokenizer.nextToken());
            } else if (m < 0) {
               m = Integer.parseInt(tokenizer.nextToken());
               if (newLine)
                  output.append('\n');
               else
                  newLine = true;
               answer(n, m, output);
               n = m = -1;
               --tests;
            }
         }
      }
      System.out.print(output);
   }

   public static void answer(int n, int m, StringBuilder output) {
      int start = bits[m - 1];
      int end = start << (n - m);
      while (start <= end) {
         if (countBits(start, n) == m)
            output.append(intToBinary(start, n));
         start++;
      }
   }

   public static String intToBinary(int i, int n) {
      char[] array = new char[n + 1];
      array[n] = '\n';
      for (int bit = 0; bit < n; bit++) {
         array[bit] = (char) (((i >> (n - (bit + 1))) & 1) + '0');
      }
      return new String(array);
   }

   public static int countBits(int i, int n) {
      int count = 0;
      while (n-- > 0) {
         if (((i >> n) & 1) == 1) ++count;
      }
      return count;
   }
}
