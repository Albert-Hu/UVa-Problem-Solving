import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         long count = 0;
         char last = ' ';
         for (char c: line.toCharArray()) {
            if ((c>='a'&&c<='z')||(c>='A'&&c<='Z')) {
               if (!((last>='a'&&last<='z')||(last>='A'&&last<='Z'))) {
                  ++count;
               }
            }
            last = c;
         }
         System.out.println(count);
      }
   }
}
