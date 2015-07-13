import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         StringTokenizer tokenizer = new StringTokenizer(line);
         int k = Integer.parseInt(tokenizer.nextToken());
         int x = Integer.parseInt(tokenizer.nextToken());
         int y = Integer.parseInt(tokenizer.nextToken());
         if (k == 0 && x == 0 && y == 0)
            break;
         String result = Integer.toString(square(k, 1024, 1024, x, y));
         switch (result.length()) {
            case 1: answer.append(' ');
            case 2: answer.append(' ');
         }
         answer.append(result);
         answer.append('\n');
      }
      System.out.print(answer);
   }

   public static int square(int k, int pivot_x, int pivot_y, int x, int y) {
      int count = 0;

      if (k > 1) {
         count += square((k / 2), (pivot_x - k), (pivot_y - k), x, y);
         count += square((k / 2), (pivot_x + k), (pivot_y - k), x, y);
         count += square((k / 2), (pivot_x - k), (pivot_y + k), x, y);
         count += square((k / 2), (pivot_x + k), (pivot_y + k), x, y);
      }

      if (x >= (pivot_x - k) && x <= (pivot_x + k) && y >= (pivot_y - k) && y <= (pivot_y +k))
         ++count;

      return count;
   }
}
