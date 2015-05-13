import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int index = 0;
      int test_case = 1;
      int[] values = new int[2];
      boolean isTree = true;
      String line;
      StringTokenizer tokenizer;
      Hashtable<Integer, Integer> table = new Hashtable<Integer, Integer>();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         tokenizer = new StringTokenizer(line);
         while (tokenizer.hasMoreTokens()) {
            values[index] = Integer.parseInt(tokenizer.nextToken());
            ++index;
            if (index < 2) continue;
            index = 0;

            if (values[0] > 0 && values[1] > 0) {
               if (!isTree) continue;

               if (table.containsKey(values[1])) {
                  isTree = false;
               } else {
                  table.put(values[1], values[0]);
                  Integer parent = table.get(values[0]);
                  while (parent != null) {
                     if (parent.intValue() == values[1]) {
                        isTree = false;
                        break;
                     }
                     parent = table.get(parent.intValue());
                  }
               }
            } else if (values[0] == 0 && values[1] == 0) {
               int root = -1;
               for (int v : table.values()) {
                  if (table.get(v) != null) {
                     continue;
                  }
                  if (root < 0) {
                     root = v;
                  } else if (root != v) {
                     isTree = false;
                     break;
                  }
               }
               System.out.print("Case ");
               System.out.print(test_case);
               System.out.print(" is");
               System.out.print((isTree) ? " " : " not ");
               System.out.println("a tree.");
               ++test_case;
               isTree = true;
               table.clear();
            }
         }
      }
   }
}
