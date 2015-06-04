import java.io.*;

public class Main {
   public static void main(String argv[]) throws IOException {
      String line;
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      while ((line = in.readLine()) != null) {
         int a = 2;
         int b = 1;
         int n = Integer.parseInt(line);
         int others = n;
         int triples = 0;
         boolean[] table = new boolean[1000001];
         do {
            while (((a * a) + (b * b)) <= n) {
               int aa = a * a;
               int bb = b * b;
               int x = aa - bb;
               int y = 2 * a * b;
               int z = aa + bb;
               if (gcd(x, y) == 1) ++triples;
               if (!table[x]) {table[x] = true; --others;}
               if (!table[y]) {table[y] = true; --others;}
               if (!table[z]) {table[z] = true; --others;}
               for (int i = 2; i * z <= n; i++) {
                  int index = x * i;
                  if (!table[index]) {table[index] = true; --others;}
                  index = y * i;
                  if (!table[index]) {table[index] = true; --others;}
                  index = z * i;
                  if (!table[index]) {table[index] = true; --others;}
               }
               ++a;
            }
            ++b;
            a = b + 1;
         } while ((a * a) + (b * b) <= n);
         System.out.println(triples + " " + others);
      }
   }

   public static int gcd(int a, int b) {
      int tmp;
      if (a < b) {
         tmp = a;
         a = b;
         b = tmp;
      }
      while ((a % b) > 0) {
         a %= b;
         tmp = a;
         a = b;
         b = tmp;
      }
      return b;
   }
}
