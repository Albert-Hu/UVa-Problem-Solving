import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         if (n == 0)
            break;
         int[] cycles = new int[n];
         int[] positions = new int[n];
         String[] numbers = in.readLine().split(" ");
         for (int i = 0; i < n; ++i) {
            positions[i] = Integer.parseInt(numbers[i]) - 1;
         }
         for (int i = 0; i < n; ++i) {
            int p = positions[positions[i]];
            cycles[i] = 1;
            while (p != positions[i]) {
               ++cycles[i];
               p = positions[p];
            }
         }

         while ((line = in.readLine()) != null) {
            int space = line.indexOf(" ");
            if (space == -1)
               break;
            int k = Integer.parseInt(line.substring(0, space)) - 1;
            char[] output = new char[n];
            Arrays.fill(output, ' ');
            line = line.substring(space + 1);
            for (int i = 0; i < line.length(); ++i) {
               int p = positions[i];
               for (int times = k % cycles[i]; times > 0; --times) {
                  p = positions[p];
               }
               output[p] = line.charAt(i);
            }
            answer.append(output);
            answer.append('\n');
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
