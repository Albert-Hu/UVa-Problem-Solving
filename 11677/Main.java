import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int h1 = Integer.parseInt(tokenizer.nextToken());
         int m1 = Integer.parseInt(tokenizer.nextToken());
         int h2 = Integer.parseInt(tokenizer.nextToken());
         int m2 = Integer.parseInt(tokenizer.nextToken());

         if (h1 == 0 && h2 == 0 && m1 == 0 && m2 == 0)
            break;

         m1 += (h1 * 60);
         m2 += (h2 * 60);
         if (m1 <= m2) {
            answer.append(Integer.toString(m2 - m1) + "\n");
         } else {
            m1 = (24 * 60) - m1;
            answer.append(Integer.toString(m1 + m2) + "\n");
         }
      }
      System.out.print(answer);
   }
}
