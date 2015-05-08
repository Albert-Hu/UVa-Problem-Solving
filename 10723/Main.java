import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int test_case;
      char[][] genes = new char[2][];
      int[][] lcs = new int[31][31];
      int[][] cyborg = new int[31][31];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < 31; i++) {
         cyborg[i][0] = cyborg[0][i] = 1;
      }

      test_case = Integer.parseInt(in.readLine());
      for (int n = 1; n <= test_case; n++) {
         genes[0] = in.readLine().toCharArray();
         genes[1] = in.readLine().toCharArray();
         for (int i = 0; i < genes[0].length; i++) {
            for (int j = 0; j < genes[1].length; j++) {
               if (genes[0][i] == genes[1][j]) {
                  lcs[i+1][j+1] = lcs[i][j] + 1;
                  cyborg[i+1][j+1] = cyborg[i][j];
               } else {
                  lcs[i+1][j+1] = Math.max(lcs[i][j+1], lcs[i+1][j]);
                  if (lcs[i][j+1] > lcs[i+1][j]) {
                     cyborg[i+1][j+1] = cyborg[i][j+1];
                  } else if (lcs[i][j+1] < lcs[i+1][j]) {
                     cyborg[i+1][j+1] = cyborg[i+1][j];
                  } else {
                     cyborg[i+1][j+1] = cyborg[i][j+1] + cyborg[i+1][j];
                  }
               }
            }
         }
         int i, j;
         i = genes[0].length;
         j = genes[1].length;
         System.out.print("Case #" + n + ": ");
         System.out.print(((i+j)-lcs[i][j]) + " ");
         System.out.println(cyborg[i][j]);
      }
   }
}
