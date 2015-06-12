import java.io.*;
import java.util.*;

public class Main {
   final static int[][] answer = {
      {0, 0, 0, 0},
      {1, 1, 1, 1},
      {6, 2, 4, 8},
      {1, 3, 9, 7},
      {6, 4, 6, 4},
      {5, 5, 5, 5},
      {6, 6, 6, 6},
      {1, 7, 9, 3},
      {6, 8, 4, 2},
      {1, 9, 1, 9}
   };

   public static void main(String args[]) throws IOException {
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         String a = tokenizer.nextToken();
         String b = tokenizer.nextToken();
         if (b.equals("0")) {
            if (a.equals("0")) {
               break;
            } else {
               System.out.println("1");
               continue;
            }
         }
         int m = a.charAt(a.length() - 1) - '0';
         int n = b.charAt(b.length() - 1) - '0';
         if (b.length() > 1) {
            n += ((b.charAt(b.length() - 2) - '0') * 10);
         }
         System.out.println(answer[m][n % 4]);
      }
   }
}
