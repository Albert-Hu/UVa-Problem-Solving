import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         int middle, min = 0;
         int r = Integer.parseInt(tokenizer.nextToken());
         int[] n = new int[r];
         for (int i = 0; i < r; i++) {
            n[i] = Integer.parseInt(tokenizer.nextToken());
         }
         Arrays.sort(n);
         middle = r / 2;
         for (int i = 0; i < r; i++) {
            if (i == middle) continue;
            min += (n[i] > n[middle]) ? (n[i] - n[middle]) : (n[middle] - n[i]);
         }
         answer.append(Integer.toString(min));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
