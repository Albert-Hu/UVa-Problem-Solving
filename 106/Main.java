import java.io.*;
import java.util.*;

public class Main {
   final static int MAX = 1000001;
   public static void main(String argv[]) throws IOException {
      int a, aa, b, bb;
      int x, xx, y, yy, z, zz;
      int[] used = new int[MAX];
      int[] triple = new int[MAX];
      int[] remain = new int[MAX];
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      Arrays.fill(used, Integer.MAX_VALUE);

      a = 2;
      aa = 4;
      b = 1;
      bb = 1;
      x = 3;
      y = 4;
      z = 5;
      while (z < MAX) {
         while (z < MAX) {
            if (gcd(a, b) == 1) {
               ++triple[z];
               xx = x;
               yy = y;
               zz = z;
               while (zz < MAX) {
                  if (used[xx] > zz) used[xx] = zz;
                  if (used[yy] > zz) used[yy] = zz;
                  if (used[zz] > zz) used[zz] = zz;
                  xx += x;
                  yy += y;
                  zz += z;
               }
            }
            a += 2;
            aa = a * a;
            x = aa - bb;
            y = 2 * a * b;
            z = aa + bb;
         }
         ++b;
         a = b + 1;
         aa = a * a;
         bb = b * b;
         x = aa - bb;
         y = 2 * a * b;
         z = aa + bb;
      }

      for (int i = 3; i < MAX; i++) {
         if (used[i] < Integer.MAX_VALUE)
            ++remain[used[i]];
      }

      for (int i = 3; i < MAX; i++) {
         triple[i] += triple[i - 1];
         remain[i] += remain[i - 1];
      }

      while ((line = in.readLine()) != null) {
         int n = Integer.parseInt(line);
         System.out.println(triple[n] + " " + (n - remain[n]));
      }
   }

   public static int gcd(int min, int max) {
      int tmp;

      do {
         tmp = min;
         min = max % min;
         max = tmp;
      } while (min > 0);

      return max;
   }
}
