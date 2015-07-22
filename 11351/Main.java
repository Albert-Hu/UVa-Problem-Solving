import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int testCase = Integer.parseInt(in.readLine());

      for (int t = 1; t <= testCase; t++) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         int n = Integer.parseInt(tokenizer.nextToken());
         int k = Integer.parseInt(tokenizer.nextToken());
         int alive = 0;

         for (int i = 1; i <= n; i++) {
            alive = (alive + k) % i;
         }

         answer.append("Case ");
         answer.append(Integer.toString(t));
         answer.append(": ");
         answer.append(Integer.toString(alive + 1));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
