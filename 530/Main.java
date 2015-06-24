import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());
         long result = 1;
         if (n == 0 && m == 0) break;

         if ((n - m) < m) m = n - m;
         for (int i = 0; i < m; i++) {
            result = result * (n - i) / (i + 1);
         }
         System.out.println(result);
      }
   }
}
