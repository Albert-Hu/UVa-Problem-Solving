import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int n, order;
      int[][] table;
      int[][] events;
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(in.readLine());
      table = new int[n+1][n+1];
      events = new int[2][n];

      line = in.readLine();
      readEvents(events[0], line);

      while ((line = in.readLine()) != null) {
         readEvents(events[1], line);

         int score = 0;
         for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
               if (events[0][i] == events[1][j]) {
                  table[i+1][j+1] = table[i][j] + 1;
               } else {
                  table[i+1][j+1] = Math.max(table[i][j+1], table[i+1][j]);
               }
               score = table[i+1][j+1];
            }
         }
         System.out.println(score);
      }
   }

   private static void readEvents(int[] events, String sequence) {
      int order;
      int index = 1;
      StringTokenizer tokenizer = new StringTokenizer(sequence);

      while (tokenizer.hasMoreTokens()) {
         order = Integer.parseInt(tokenizer.nextToken());
         events[order-1] = index;
         ++index;
      }
   }
}
