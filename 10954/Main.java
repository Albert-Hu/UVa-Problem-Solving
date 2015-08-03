import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         long cost = 0;
         StringTokenizer tokenizer = new StringTokenizer(in.readLine());
         PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

         while (tokenizer.hasMoreTokens()) {
            queue.add(Integer.parseInt(tokenizer.nextToken()));
         }

         while (queue.size() > 1) {
            int sum = queue.poll() + queue.poll();
            queue.add(sum);
            cost += sum;
         }

         answer.append(Long.toString(cost));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
