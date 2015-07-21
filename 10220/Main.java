import java.io.*;
import java.math.*;

public class Main {
   public static void main(String args[]) throws IOException {
      int[] sum = new int[1000];
      String line;
      StringBuilder answer = new StringBuilder();
      BigInteger[] number = new BigInteger[1000];
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      number[0] = new BigInteger("1");
      for (int i = 1; i < number.length; i++) {
         number[i] = new BigInteger(Integer.toString(i + 1)).multiply(number[i - 1]);
      }
      for (int i = 0; i < sum.length; i++) {
         String s = number[i].toString();
         for (int j = 0; j < s.length(); j++) {
            sum[i] += (s.charAt(j) - '0');
         }
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         answer.append(Integer.toString(sum[n - 1]));
         answer.append('\n');
      }
      System.out.print(answer);
   }
}
