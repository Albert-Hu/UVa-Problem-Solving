import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int testCase = 1;
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '-') break;

         int s = Integer.parseInt(line);
         int[] need = new int[12];
         int[] produce = new int[12];
         StringTokenizer tokenizer;

         tokenizer = new StringTokenizer(in.readLine());
         for (int i = 0; i < 12; i++)
            produce[i] = Integer.parseInt(tokenizer.nextToken());

         tokenizer = new StringTokenizer(in.readLine());
         for (int i = 0; i < 12; i++)
            need[i] = Integer.parseInt(tokenizer.nextToken());

         System.out.println("Case " + testCase + ":");
         for (int i = 0; i < 12; i++) {
            if (i > 0)
               s += produce[i - 1];
            if (s >= need[i]) {
               s -= need[i];
               System.out.println("No problem! :D");
            } else {
               System.out.println("No problem. :(");
            }
         }
         ++testCase;
      }
   }
}
