import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         int d = Integer.parseInt(tokenizer.nextToken());
         int i = Integer.parseInt(tokenizer.nextToken());
         answer.append(Integer.toString(binarySearch((1<<d), 1, i)));
         answer.append('\n');
      }
      System.out.print(answer);
   }
   public static int binarySearch(int max, int n, int i) {
      int l, r;
      l = n * 2;
      r = l + 1;
      if (l < max && r < max) {
         if (i % 2 == 1) {
            n = binarySearch(max, l, (i / 2) + 1);
         } else {
            n = binarySearch(max, r, i / 2);
         }
      }
      return n;
   }
}
