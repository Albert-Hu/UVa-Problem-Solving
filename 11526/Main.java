import java.io.*;
import java.lang.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int t = Integer.parseInt(in.readLine());

      while (t-- > 0) {
         long result = 0;
         int n = Integer.parseInt(in.readLine());
         int s = (int) Math.sqrt(n);
         for (int i = 1; i <= s; i++) {
            int b = n / i;
            int a = (b == i) ? b : (n / (i + 1));
            result = result + b + ((b - a) * i);
         }
         answer.append(Long.toString(result));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
