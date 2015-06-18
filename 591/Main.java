import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int testCase = 1;
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         int n = Integer.parseInt(line);
         int total = 0;
         int average = 0;
         int[] height = new int[n];
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());

         for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(tokenizer.nextToken());
            average += height[i];
         }

         average /= n;
         for (int i = 0; i < n; i++) {
            if (height[i] > average) {
               total += (height[i] - average);
            }
         }

         System.out.println("Set #" + testCase);
         System.out.println("The minimum number of moves is " + total + ".\n");
         ++testCase;
      }
   }
}
