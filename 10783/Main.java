import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(in.readLine());

      for (int t = 1; t <= n; t++) {
         int a = Integer.parseInt(in.readLine());
         int b = Integer.parseInt(in.readLine());
         if (a % 2 == 0 && a == b) {
            answer.append("Case ");
            answer.append(Integer.toString(t));
            answer.append(": 0\n");
         } else {
            if (a % 2 == 0) ++a;
            if (b % 2 == 0) --b;
            answer.append("Case ");
            answer.append(Integer.toString(t));
            answer.append(": ");
            answer.append(Integer.toString(((a + b) * (((b - a) / 2) + 1)) / 2));
            answer.append('\n');
         }
      }
      System.out.print(answer);
   }
}
