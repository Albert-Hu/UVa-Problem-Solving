import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int swap;
      int x = 8;
      int[] n = {1, 6};
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int line = 0; line < 10; line++) {
         answer.append(String.format("%10d%10d\n", n[1], x));
         swap = n[1];
         n[1] = 6 * n[1] - n[0];
         n[0] = swap;
         x = x + n[0] + n[1];
      }
      System.out.print(answer);
   }
}
