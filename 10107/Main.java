import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(10);
      PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>(10, Collections.reverseOrder());
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line.trim());
         maxQueue.add(n);
         if ((maxQueue.size() - minQueue.size()) > 1) {
            minQueue.add(maxQueue.poll());
         }
         if (minQueue.size() > 0 && maxQueue.peek() < minQueue.peek()) {
            maxQueue.add(minQueue.poll());
            minQueue.add(maxQueue.poll());
         }
         if (maxQueue.size() == minQueue.size()) {
            answer.append(Integer.toString((maxQueue.peek() + minQueue.peek()) / 2));
         } else {
            answer.append(Integer.toString(maxQueue.peek()));
         }
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
