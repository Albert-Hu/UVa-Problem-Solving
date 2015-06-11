#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

int unit_count(int n, int* unit3, int* unit7, int* unit9)
{
   int odds, mod, divisor2 = 0;

   while (n > 1) {
      odds = (n / 2) + (n & 1);
      mod = odds % 5;
      if (mod >= 2) *unit3 = *unit3 + 1;
      if (mod >= 4) *unit7 = *unit7 + 1;
      odds /= 5;
      *unit3 = *unit3 + odds;
      *unit7 = *unit7 + odds;
      *unit9 = *unit9 + odds;
      n /= 2;
      divisor2 += n;
   }

   return divisor2;
}

int main(int argc, char* argv[])
{
   int n, i, odds, mod, tmp;
   int cycle2[4] = {6, 2, 4, 8};
   int cycle3[4] = {1, 3, 9, 7};
   int divisor2, unit3, unit5, unit7, unit9;

   while (scanf("%d", &n) == 1) {
      unit3 = unit5 = unit7 = unit9 = 0;

      divisor2 = unit_count(n, &unit3, &unit7, &unit9);

      tmp = n;
      while (tmp > 0) {
         odds = tmp / 5;
         unit_count(odds, &unit3, &unit7, &unit9);
         tmp /= 5;
         unit5 += tmp;
      }

      divisor2 -= unit5;
      unit3 -= unit7;
      unit3 += (unit9 * 2);

      if (n == 1) {
         mod = 1;
      } else {
         mod = cycle2[divisor2 % 4] * cycle3[unit3 % 4];
      }
      mod %= 10;
      printf("%5d -> %d\n", n, mod);
   }

   return 0;
}
