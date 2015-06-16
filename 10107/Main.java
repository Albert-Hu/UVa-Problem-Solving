import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int count = 0;
      int[] array = new int[10000];
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line.trim());
         int start, middle, end;
         start = 0;
         end = count;
         while (start != end) {
            middle = (end - start) / 2;
            if (array[start + middle] < n) {
               start = start + middle + 1;
            } else {
               end = start + middle;
            }
         }
         for (int i = count; i > start; i--)
            array[i] = array[i - 1];
         array[start] = n;
         ++count;
         if ((count % 2) == 1) {
            System.out.println(array[count/2]);
         } else {
            System.out.println(((array[count/2]+array[(count/2)-1])/2));
         }
      }
   }
}
