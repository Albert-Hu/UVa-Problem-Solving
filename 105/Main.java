import java.io.*;
import java.util.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      int a, b, h;
      int[] height = new int[10001];
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         a = Integer.parseInt(tokenizer.nextToken());
         h = Integer.parseInt(tokenizer.nextToken());
         b = Integer.parseInt(tokenizer.nextToken());
         while (a < b) {
            if (height[a] < h) height[a] = h;
            ++a;
         }
      }

      for (a = b = h = 0; a < 10001; a++) {
         if (h != height[a]) {
            if (b != 0) System.out.print(' ');
            System.out.print(a + " " + height[a]);
            b = 1;
            h = height[a];
         }
      }
      System.out.println();
   }
}
