import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      boolean start = false, newLine = false;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '_') {
            if (start) {
               if (newLine)
                  System.out.println();
               start = false;
               newLine = true;
            } else {
               start = true;
            }
         } else {
            int c = 0;
            for (int i = 1; i < 10; i++) {
               if (i == 6) continue;
               c = c << 1;
               if (line.charAt(i) == 'o') c |= 1;
            }
            System.out.print((char) c);
         }
      }
   }
}
