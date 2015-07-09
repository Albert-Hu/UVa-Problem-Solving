import java.io.*;

public class Main {
   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         if (line.charAt(0) == '0') break;
         int n = Integer.parseInt(line);
         answer.append("f91(");
         answer.append(Integer.toString(n));
         answer.append(") = ");
         answer.append(Integer.toString((n <= 100) ? 91 : (n - 10)));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
