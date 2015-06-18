import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      String answer = "";
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0' && line.length() == 1)
            break;
         int sum_odd = 0, sum_even = 0;
         for (int i = 0; i < line.length(); i++) {
            if ((i % 2) != 0) {
               sum_odd += (line.charAt(i) - '0');
            } else {
               sum_even += (line.charAt(i) - '0');
            }
         }
         answer += (line + " is" + ((sum_odd - sum_even) % 11 == 0 ? " a multiple of 11.\n" : " not a multiple of 11.\n"));
      }
      System.out.print(answer);
   }
}
