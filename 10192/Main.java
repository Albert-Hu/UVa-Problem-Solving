import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      int test_case = 1;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.length() != 0) {
            if (line.charAt(0) == '#') {
               break;
            }
         }

         int left, lcs;
         int[] upper_row = new int[101];
         char[][] cities = new char[2][];

         left = lcs = 0;

         cities[0] = line.toCharArray();
         cities[1] = in.readLine().toCharArray();

         for (int i = 0; i < cities[0].length; i++) {
            for (int j = 0; j < cities[1].length; j++) {
               if (cities[0][i] == cities[1][j]) {
                  lcs = upper_row[j] + 1;
               } else {
                  lcs = Math.max(left, upper_row[j+1]);
               }
               upper_row[j] = left;
               left = lcs;
            }
            left = 0;
            upper_row[cities[1].length] = lcs;
         }

         System.out.println("Case #" + test_case + ": you can visit at most " + lcs + " cities.");
         ++test_case;
      }
   }
}
