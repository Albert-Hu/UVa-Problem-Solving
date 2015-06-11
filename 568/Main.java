import java.io.*;

public class Main {
   final static int[] cycle2 = {6, 2, 4, 8};
   final static int[] cycle3 = {1, 3, 9, 7};

   public static void main(String args[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int[] unit = new int[10];
         int tmp, mod, odds, divisor2;
         int n = Integer.parseInt(line);

         divisor2 = countUnit(n, unit);
         tmp = n;
         while (tmp > 0) {
            odds = tmp / 5;
            countUnit(odds, unit);
            tmp /= 5;
            unit[5] += tmp;
         }

         divisor2 -= unit[5];
         unit[3] -= unit[7];
         unit[3] += (unit[9] * 2);

         if (n == 1) {
            mod = 1;
         } else {
            mod = cycle2[divisor2 % 4] * cycle3[unit[3] % 4];
         }
         mod %= 10;
         System.out.printf("%5d -> %d\n", n, mod);
      }
   }

   public static int countUnit(int n, int[] unit) {
      int odds, mod, divisor2 = 0;

      while (n > 1) {
         odds = (n / 2) + (n & 1);
         mod = odds % 5;
         if (mod >= 2) ++unit[3];
         if (mod >= 4) ++unit[7];
         odds /= 5;
         unit[3] += odds;
         unit[7] += odds;
         unit[9] += odds;
         n /= 2;
         divisor2 += n;
      }

      return divisor2;
   }
}
