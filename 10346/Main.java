import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int k = Integer.parseInt(tokenizer.nextToken()) - 1;
         if ((n % k) == 0) {
            n = n + ((n / k) - 1);
         } else {
            n = n + (n / k);
         }
         System.out.println(n);
      }
   }
}
