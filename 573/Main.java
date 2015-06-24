import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int h = Integer.parseInt(tokenizer.nextToken());
         int u = Integer.parseInt(tokenizer.nextToken());
         int d = Integer.parseInt(tokenizer.nextToken());
         int f = Integer.parseInt(tokenizer.nextToken());
         if (h == 0 && u == 0 && d == 0 && f == 0)
            break;
         f = u * f;
         h *= 100;
         u *= 100;
         d *= 100;
         int day = 1;
         int climbed = u;
         while (climbed <= h) {
            climbed -= d;
            if (climbed < 0)
               break;
            if (f > u) {
               u = 0;
            } else {
               u -= f;
            }
            climbed += u;
            day++;
         }
         answer.append((climbed > 0) ? "success" : "failure");
         answer.append(" on day ");
         answer.append(Integer.toString(day));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
