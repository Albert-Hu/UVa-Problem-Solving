import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int year = Integer.parseInt(line);
         if (year < 0) break;
         long a = 0, b = 1;
         long n = 0, m = 1;
         while (year-- > 0) {
            n = n + m;
            m = n - m;
            a = a + n;
         }
         b = a + n + m;
         answer.append(Long.toString(a));
         answer.append(' ');
         answer.append(Long.toString(b));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
