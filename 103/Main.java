import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      new Main().run();
   }

   public void run() throws IOException {
      String line;
      Box[] boxes = new Box[30];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int i = 0; i < boxes.length; i++) {
         boxes[i] = new Box();
      }

      while ((line = in.readLine()) != null) {
         int seq, dim;
         StringTokenizer tokenizer = new StringTokenizer(line);
         seq = Integer.parseInt(tokenizer.nextToken());
         dim = Integer.parseInt(tokenizer.nextToken());

         for (int i = 0; i < seq; i++) {
            boxes[i].dimension = dim;
            boxes[i].count = 1;
            boxes[i].number = i + 1;
            boxes[i].inside = null;
            tokenizer = new StringTokenizer(in.readLine());
            for (int d = 0; d < dim; d++) {
               boxes[i].dimensions[d] = Integer.parseInt(tokenizer.nextToken());
            }
            Arrays.sort(boxes[i].dimensions, 0, dim);
         }
         Arrays.sort(boxes, 0, seq);

         for (int i = 0; i < seq; i++) {
            for (int j = i + 1; j < seq; j++) {
               if (!boxes[i].nestTo(boxes[j]))
                  continue;
               if (boxes[i].count >= boxes[j].count) {
                  boxes[j].count = boxes[i].count + 1;
                  boxes[j].inside = boxes[i];
               }
            }
         }

         int maxCount = 0;
         Box longestNestingBox = null;

         for (int i = 0; i < seq; i++) {
            if (boxes[i].count > maxCount) {
               longestNestingBox = boxes[i];
               maxCount = boxes[i].count;
            }
         }

         System.out.println(longestNestingBox.count);
         longestNestingBox.dump();
         System.out.println();

      }
   }

   private class Box implements Comparable <Box> {
      int number;
      int dimension;
      int count;
      int[] dimensions = new int[10];
      Box inside;

      public void dump() {
         if (inside == null) {
            System.out.print(number);
         } else {
            inside.dump();
            System.out.print(" " + number);
         }
      }

      public int compareTo(Box box) {
         for (int i = 0; i < dimension; i++) {
            if (dimensions[i] > box.dimensions[i]) {
               return 1;
            }
            if (dimensions[i] < box.dimensions[i]) {
               return -1;
            }
         }
         return 0;
      }

      public boolean nestTo(Box box) {
         for (int i = 0; i < dimension; i++) {
            if (dimensions[i] >= box.dimensions[i])
               return false;
         }
         return true;
      }
   }
}
