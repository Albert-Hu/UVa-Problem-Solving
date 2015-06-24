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
         System.out.println(((n - 1) + (n * (m - 1))));
      }
   }
}
