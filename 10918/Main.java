import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int[] tiles = new int[16];
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      tiles[0] = 1;
      tiles[1] = 3;
      for (int i = 2; i < tiles.length; ++i)
         tiles[i] = (tiles[i - 1] * 4) - (tiles[i - 2]);

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         if (n == -1) break;
         answer.append(Integer.toString((n % 2 == 0) ? tiles[n / 2] : 0));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
