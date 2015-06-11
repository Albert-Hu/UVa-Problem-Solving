import java.io.*;

public class Main {
   final static int N = 101;

   final static int[] prime = {
       2,  3,  5,  7, 11,
      13, 17, 19, 23, 29,
      31, 37, 41, 43, 47,
      53, 59, 61, 67, 71,
      73, 79, 83, 89, 97
   };

   public static void main(String args[]) throws IOException {
      int[][] table = new int[101][prime.length];
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      for (int n = 2; n < N; n++) {
         int number = n;
         for (int i = 0; i < prime.length; i++) {
            if (prime[i] > number) break;
            while ((number % prime[i]) == 0) {
               number /= prime[i];
               ++table[n][i];
            }
         }
         for (int i = 0; i < prime.length; i++) {
            table[n][i] += table[n - 1][i];
         }
      }

      while ((line = in.readLine()) != null && line.charAt(0) != '0') {
         int n = Integer.parseInt(line);
         System.out.printf("%3d! =", n);
         for (int i = 0; i < prime.length; i++) {
            if (table[n][i] == 0) break;
            System.out.printf("%3d", table[n][i]);
            if ((i == 14) && table[n][15] != 0)
               System.out.printf("\n      ");
         }
         System.out.printf("\n");
      }
   }
}
