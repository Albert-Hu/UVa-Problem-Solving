#include <stdio.h>

int main(int argc, char* argv[])
{
   int i, n, result;

   while (scanf("%d", &n) == 1 && n != 0) {
      if (n == 1) {
         puts("0");
         continue;
      }
      result = n;
      if (result % 2 == 0) {
         result -= (result / 2);
         while (n % 2 == 0) n /= 2;
      }
      for (i = 3; i * i <= n; i += 2) {
         if (n % i == 0) {
            result -= (result / i);
            while (n % i == 0) n /= i;
         }
      }
      if (n > 1) result -= (result / n);
      printf("%d\n", result);
   }

   return 0;
}
