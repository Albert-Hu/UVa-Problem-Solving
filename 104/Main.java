import java.io.*;
import java.util.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         double[][][] profit = new double[n][n][n];
         for (int i = 0; i < n; i++) {
            line = in.readLine();
            tokenizer = new StringTokenizer(line);
            for (int j = 0; j < n; j++) {
               if (i == j) {
                  profit[0][i][j] = 1.0;
               } else {
                  profit[0][i][j] = Double.parseDouble(tokenizer.nextToken());
               }
            }
         }
         findArbitrageSequence(profit);
      }
   }

   public static void findArbitrageSequence(double[][][] profit) {
      int n = profit.length;
      int[][][] path = new int[n][n][n];

      for (int i = 0; i < n; i++) {
         for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
               path[k][i][j] = j;
            }
         }
      }

      for (int m = 1; m < n; m++) {
         for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                  double best = profit[m-1][i][k] * profit[0][k][j];
                  if (best > profit[m][i][j]) {
                     profit[m][i][j] = best;
                     path[m][i][j] = k;
                  }
               }
            }
         }
      }

      int steps = 0;
      for (int i = 1; i < n; i++) {
         for (int j = 0; j < n; j++) {
            if (profit[i][j][j] >= 1.01) {
               n = j;
               steps = i;
            }
         }
      }
      if (steps > 0) {
         int start = n, end = n;
         int[] step = new int[steps + 1];
         for (int s = steps; s >= 0; s--) {
            step[s] = start + 1;
            start = path[s][end][start];
         }
         for (int i = 0; i < step.length; i++)
            System.out.print(step[i] + " ");
         System.out.println(start + 1);
      } else {
         System.out.println("no arbitrage sequence exists");
      }
   }
}
