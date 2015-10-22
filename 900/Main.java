import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      long[] fibonacci = new long[51];
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      fibonacci[0] = fibonacci[1] = 1;
      for (int i = 2; i < fibonacci.length; ++i) {
         fibonacci[i] = fibonacci[i - 2] + fibonacci[i - 1];
      }

      while ((line = in.readLine()) != null) {
         int length = Integer.parseInt(line);
         if (length == 0)
            break;
         answer.append(Long.toString(fibonacci[length]));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
