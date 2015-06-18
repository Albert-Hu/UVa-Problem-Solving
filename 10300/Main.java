import java.io.*;
import java.util.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String answer = "";
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(in.readLine());
      while (n-- > 0) {
         double sum = 0;
         int m = Integer.parseInt(in.readLine());
         while (m-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(in.readLine());
            double a = Double.parseDouble(tokenizer.nextToken());
            double b = Double.parseDouble(tokenizer.nextToken());
            double c = Double.parseDouble(tokenizer.nextToken());
            sum += (((a / b) * c) * b);
         }
         answer += (Long.toString((long) sum) + "\n");
      }
      System.out.print(answer);
   }
}
