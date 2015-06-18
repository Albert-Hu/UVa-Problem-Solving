import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         long n = Long.parseLong(line);
         if (n < 0) break;
         n = (((n + 1) * n) / 2) + 1;
         System.out.println(n);
      }
   }
}
