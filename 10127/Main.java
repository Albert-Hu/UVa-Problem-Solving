import java.io.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int x = 1;
         int t = 1;
         int n = Integer.parseInt(line);
         while ((x % n) != 0) {
            ++t;
            x = (x * 10 + 1) % n;
         }
         System.out.println(t);
      }
   }
}
