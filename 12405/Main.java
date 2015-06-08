import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int n;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      n = Integer.parseInt(in.readLine());
      for (int i = 1; i <= n; i++) {
         int flag = 0, count = 0;
         int m = Integer.parseInt(in.readLine());
         String line = in.readLine();

         for (int j = 0; j < line.length(); j++) {
            if (flag == 4 || flag == 5 || flag == 6 || flag == 7) {
               flag = 0;
               ++count;
            }
            flag = (flag << 1);
            if (line.charAt(j) == '.')
               flag |= 1;
         }
         if (flag != 0) ++count;
         System.out.println("Case " + i + ": " + count);
      }
   }
}
