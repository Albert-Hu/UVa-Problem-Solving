import java.io.*;
import java.util.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      int a, b, h, min, max;
      int[] height = new int[10001];
      String line;
      StringTokenizer tokenizer;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      max = 0;
      min = 0x7FFFFFFF;
      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         a = Integer.parseInt(tokenizer.nextToken());
         h = Integer.parseInt(tokenizer.nextToken());
         b = Integer.parseInt(tokenizer.nextToken());
         if (a < min) min = a;
         if (b > max) max = b;
         while (a < b) {
            if (height[a] < h) height[a] = h;
            ++a;
         }
      }

      System.out.print(min + " " + height[min]);
      while (min <= max) {
         ++min;
         if (height[min] != height[min - 1])
            System.out.print(" " + min + " " + height[min]);
      }
      System.out.println();
   }
}
