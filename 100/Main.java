import java.util.Scanner;

public class Main {
   static int[] table = new int[1000000];

   public static void main(String args[]) {
      int i, j, tmp, max;
      Scanner scan = new Scanner(System.in);

      while (scan.hasNext()) {
         i = scan.nextInt();
         j = scan.nextInt();

         System.out.printf("%d %d ", i, j);

         if (i > j) {
            tmp = i;
            i = j;
            j = tmp;
         }

         max = 0;
         while (i <= j) {
            tmp = _3n1CycleLength(i);
            if (tmp > max) max = tmp;
            ++i;
         }

         System.out.println(max);
      }
   }

   public static int _3n1CycleLength(int n) {
      int index = n;
      int length = 1;

      while (n != 1) {
         if (n < table.length) {
            if (table[n] > 0) {
               length += (table[n] - 1);
               break;
            }
         }
         n = ((n & 1) == 1) ? ((n << 1) + n + 1) : (n >> 1);
         ++length;
      }

      if (index < table.length) {
         table[index] = length;
      }

      return length;
   }
}
