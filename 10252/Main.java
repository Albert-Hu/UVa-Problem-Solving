import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int[][] letters = new int[2][26];

         for (char c: line.toCharArray())
            ++letters[0][c - 'a'];
         for (char c: in.readLine().toCharArray())
            ++letters[1][c - 'a'];

         for (int i = 0; i < 26; i++) {
            if (letters[0][i] == 0 || letters[1][i] == 0)
               continue;
            char c = (char) (i + 'a');
            int min = Math.min(letters[0][i], letters[1][i]);
            while (min-- > 0)
               System.out.print(c);
         }
         System.out.print("\n");
      }
   }
}
