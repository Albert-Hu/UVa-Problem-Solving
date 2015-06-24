import java.io.*;
import java.util.*;

public class Main {
   final static int CARRY = 1000000000;
   static int[][] number = new int[5001][120];
   static int[] length = new int[5001];

   public static void main(String args[]) throws IOException {
      String line;
      StringBuilder answer = new StringBuilder();
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      generateFibonacciNumber();

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         int i = length[n] - 1;
         answer.append("The Fibonacci number for ");
         answer.append(line);
         answer.append(" is ");
         answer.append(Integer.toString(number[n][i]));
         while (i-- > 0) {
            answer.append(String.format("%09d", number[n][i]));
         }
         answer.append("\n");
      }
      System.out.print(answer);
   }

   public static void generateFibonacciNumber() {
      number[0][0] = 0;
      number[1][0] = 1;
      length[0] = length[1] = 1;

      for (int n = 2; n < number.length; n++) {
         int carry = 0;
         int a = n - 2;
         int b = n - 1;
         length[n] = length[b];
         for (int i = 0; i < length[n]; i++) {
            number[n][i] = number[a][i] + number[b][i] + carry;
            if (number[n][i] >= CARRY) {
               carry = number[n][i] / CARRY;
               number[n][i] %= CARRY;
            } else {
               carry = 0;
            }
         }
         if (carry > 0) {
            number[n][length[n]] = carry;
            ++length[n];
         }
      }
   }
}
