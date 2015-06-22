import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int testCase = 1;
      int[] table = new int[50001];
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int n = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());
         if (n == 0 && m == 0) break;

         for (int i = 1; i <= n; i++) {
            table[i] = i;
         }

         while (m-- > 0) {
            tokenizer = new StringTokenizer(in.readLine());
            int i = Integer.parseInt(tokenizer.nextToken());
            int j = Integer.parseInt(tokenizer.nextToken());
            if (table[i] == i) {
               while (table[j] != j) {
                  j = table[j];
               }
               table[i] = j;
            } else if (table[j] == j) {
               while (table[i] != i) {
                  i = table[i];
               }
               table[j] = i;
            } else {
               while (table[i] != i) {
                  i = table[i];
               }
               while (table[j] != j) {
                  int tmp = table[j];
                  table[j] = i;
                  j = tmp;
               }
               table[j] = i;
            }
         }
         int total = 0;
         for (int i = 1; i <= n; i++) {
            if (table[i] == i) {
               ++total;
            }
         }
         answer.append("Case ");
         answer.append(Integer.toString(testCase));
         answer.append(": ");
         answer.append(Integer.toString(total));
         answer.append('\n');
         ++testCase;
      }
      System.out.print(answer);
   }
}
