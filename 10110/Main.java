import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         long n = Long.parseLong(line);
         double s = Math.sqrt(n);
         if (((long) s * (long) s) == n) {
            System.out.println("yes");
         } else {
            System.out.println("no");
         }
      }
   }
}
