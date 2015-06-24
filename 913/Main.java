import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         long n = Long.parseLong(line);
         n = ((n + 1) * ((n + 1) / 2)) - 1;
         n = (n * 3) - 6;
         answer.append(Long.toString(n) + "\n");
      }
      System.out.print(answer);
   }
}
