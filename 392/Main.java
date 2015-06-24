import java.io.*;
import java.util.*;

public class Main {
   final static String[] x = {
      "x^8",
      "x^7",
      "x^6",
      "x^5",
      "x^4",
      "x^3",
      "x^2",
      "x",
      "",
   };
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int[] n = new int[9];
         boolean[] negative = new boolean[9];
         for (int i = 0; i < n.length; i++) {
            n[i] = Integer.parseInt(tokenizer.nextToken());
            negative[i] = (n[i] < 0);
            if (negative[i]) n[i] = -n[i];
         }
         int first = 0;
         while (first < (n.length - 1) && n[first] == 0) ++first;
         answer.append((negative[first]) ? "-" : "");
         if (!((n[first] == 1) && (first < (n.length - 1))))
            answer.append(Integer.toString(n[first]));
         answer.append(x[first]);
         for (int i = first + 1; i < n.length; i++) {
            if (n[i] == 0) continue;
            answer.append((negative[i]) ? " - " : " + ");
            if (!((n[i] == 1) && (i < (n.length - 1))))
               answer.append(Integer.toString(n[i]));
            answer.append(x[i]);
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
