import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int index = 0;
      int[] array = null;
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
            if (array == null) {
               int n = Integer.parseInt(tokenizer.nextToken());
               if (n == 0) break;
               index = 0;
               array = new int[n];
            } else {
               if (index < array.length) {
                  array[index++] = Integer.parseInt(tokenizer.nextToken());
               } else {
                  int max = array[0];
                  for (int i = 1; i < array.length; i++) {
                     if ((array[i] + array[i - 1]) > array[i]) {
                        array[i] += array[i - 1];
                     }
                     if (max < array[i]) max = array[i];
                  }
                  if (max > 0) {
                     answer.append("The maximum winning streak is ");
                     answer.append(Integer.toString(max));
                     answer.append(".\n");
                  } else {
                     answer.append("Losing streak.\n");
                  }
                  array = null;
               }
            }
         }
      }
      System.out.print(answer);
   }
}
