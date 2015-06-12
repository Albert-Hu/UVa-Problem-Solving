import java.io.*;

public class Main {
   final static int CARRY = 1000000;

   static int[][] factorial = new int[1001][428];
   static int[] factorialLength = new int[1001];

   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      factorial[0][0] = factorial[1][0] = 1;
      factorialLength[0] = factorialLength[1] = 1;
      for (int i = 2; i <= 1000; i++) {
         int carry = 0;
         int length = factorialLength[i - 1];
         int[] prev = factorial[i - 1];
         int[] result = factorial[i];
         for (int j = 0; j < length; j++) {
            result[j] = prev[j] * i;
            result[j] = prev[j] * i;
            result[j] += carry;
            carry = result[j] / CARRY;
            result[j] %= CARRY;
         }
         if (carry != 0) {
            result[length] = carry;
            ++length;
         }
         factorialLength[i] = length;
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         int[] result = factorial[n];
         int length = factorialLength[n];
         String answer = "" + result[--length];
         while (length-- > 0) {
            answer += String.format("%06d", result[length]);
         }
         System.out.println(n + "!");
         System.out.println(answer);
      }
   }
}
