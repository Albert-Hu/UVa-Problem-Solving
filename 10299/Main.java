import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         int result = n;

         if (n == 0) break;

         if (n == 1) {
            answer.append("0\n");
            continue;
         }

         if (n % 2 == 0) {
            result -= (result / 2);
            while (n % 2 == 0) n /= 2;
         }
         for (int i = 3; i * i <= n; i+= 2) {
            if (n % i == 0) {
               result -= (result / i);
               while (n % i == 0) n /= i;
            }
         }
         if (n > 1) result -= (result / n);
         answer.append(Integer.toString(result));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
