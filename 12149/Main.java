import java.io.*;

public class Main {
   public static void main(String[] args) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int answer = 1;
         int n = Integer.parseInt(line);
         if (n == 0) break;
         while (n > 1) {
            answer += (n * n);
            --n;
         }
         System.out.println(answer);
      }
   }
}
