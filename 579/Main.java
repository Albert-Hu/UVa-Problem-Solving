import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line, ":");
         int h = Integer.parseInt(tokenizer.nextToken());
         int m = Integer.parseInt(tokenizer.nextToken());

         if (h == 0 && m == 0)
            break;

         double d = (((h * 30) % 360) + ((m / 60.0) * 30)) - (m * 6.0);
         if (d < 0) d = -d;
         if (d > 180) d = 360 - d;
         answer.append(String.format("%.03f\n", d));
      }
      System.out.print(answer);
   }
}
