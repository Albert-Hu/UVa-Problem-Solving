import java.io.*;
import java.util.*;

public class Main {
   static boolean newLine = false;

   public static void main(String args[]) throws IOException {
      int index = 0, n = 0;
      String line;
      String[] number = null;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
            if (n == 0) {
               index = 0;
               n = Integer.parseInt(tokenizer.nextToken());
               number = new String[n];
            } else {
               if (index < n) {
                  number[index] = tokenizer.nextToken();
                  ++index;
               } else {
                  answer(number);
                  n = 0;
               }
            }
         }
      }
   }

   public static void answer(String[] number) {
      for (int i = 0; i < number.length; i++) {
         int max = 0;
         for (int j = 0; j < number.length; j++) {
            if (number[j] != null) {
               max = j;
               break;
            }
         }
         for (int j = 0; j < number.length; j++) {
            if (number[j] == null) continue;
            if (compare(number[j], number[max]) > 0)
               max = j;
         }
         System.out.print(number[max]);
         number[max] = null;
      }
      System.out.println();
   }

   public static int compare(String a, String b) {
      String ab, ba;
      int abIndex, baIndex, totalLength;

      ab = a;
      ba = b;
      abIndex = baIndex = 0;
      totalLength = a.length() + b.length();

      while (totalLength-- > 0) {
         if (abIndex == a.length() && ab == a) {
            ab = b;
            abIndex = 0;
         }
         if (baIndex == b.length() && ba == b) {
            ba = a;
            baIndex = 0;
         }
         if (ab.charAt(abIndex) > ba.charAt(baIndex))
            return 1;
         else if (ab.charAt(abIndex) < ba.charAt(baIndex))
            return -1;
         ++abIndex;
         ++baIndex;
      }

      return 0;
   }
}
