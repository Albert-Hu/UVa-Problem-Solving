import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int sequence = 1;
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());
         int c = Integer.parseInt(tokenizer.nextToken());
         if (n == 0 && m == 0 && c == 0) break;

         int max = 0, consumed = 0;
         int[] consumption = new int[n + 1];
         boolean blown = false;
         boolean[] device = new boolean[n + 1];

         for (int i = 1; i <= n; i++) {
            consumption[i] = Integer.parseInt(in.readLine());
            device[i] = false;
         }

         while (m-- > 0) {
            int i = Integer.parseInt(in.readLine());
            device[i] = !device[i];
            if (device[i]) {
               consumed += consumption[i];
               if (consumed > max) max = consumed;
               if (consumed > c) blown = true;
            } else {
               consumed -= consumption[i];
            }
         }
         answer.append("Sequence " + Integer.toString(sequence) + "\n");
         if (blown) {
            answer.append("Fuse was blown.\n\n");
         } else {
            answer.append("Fuse was not blown.\n");
            answer.append("Maximal power consumption was " + Integer.toString(max) + " amperes.\n\n");
         }
         ++sequence;
      }
      System.out.print(answer);
   }
}
