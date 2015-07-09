import java.io.*;
import java.util.*;

public class Main {
   final static int INFINITE = 1000001;
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0' && line.length() == 1)
            break;
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());
         int[] route = new int[n + 1];
         int[][] matrix = new int[n + 1][n + 1];

         for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
               matrix[i][j] = (i == j) ? 0 : INFINITE;
            }
         }

         while (m-- > 0) {
            tokenizer = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            matrix[a][b] = matrix[b][a] = d;
         }

         findShortestPath(matrix, 2);
         route[2] = 1;
         answer.append(Integer.toString(dfs(matrix, route, 1)));
         answer.append('\n');
      }
      System.out.print(answer);
   }

   public static int dfs(int[][] matrix, int[] route, int src) {
      if (route[src] == 0) {
         for (int i = 1; i < matrix.length; i++) {
            if (matrix[src][i] != INFINITE && matrix[2][i] < matrix[2][src]) {
               route[src] += dfs(matrix, route, i);
            }
         }
      }
      return route[src];
   }

   public static void findShortestPath(int[][] matrix, int src) {
      boolean[] selected = new boolean[matrix.length];

      selected[src] = true;
      for (int i = 1; i < matrix.length; i++) {
         int k = 0;
         int d = INFINITE;
         for (int dest = 1; dest < matrix.length; dest++) {
            if (matrix[src][dest] < d && !selected[dest]) {
               d = matrix[src][dest];
               k = dest;
            }
         }
         selected[k] = true;
         for (int dest = 1; dest < matrix.length; dest++) {
            d = matrix[src][k] + matrix[k][dest];
            if (d < matrix[src][dest]) {
               matrix[src][dest] = d;
            }
         }
      }
   }
}
