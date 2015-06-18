#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, i, sum;

   printf("PERFECTION OUTPUT\n");
   while (scanf("%d", &n) == 1 && n > 0) {
      if (n == 1) {
         printf("%5d  DEFICIENT\n", n);
         continue;
      }
      sum = 1;
      for (i = 2; i * i <= n; i++) {
         if ((n % i) == 0) {
            sum += i;
            sum += (n / i);
         }
      }
      if (sum > n) {
         printf("%5d  ABUNDANT\n", n);
      } else if (sum < n) {
         printf("%5d  DEFICIENT\n", n);
      } else {
         printf("%5d  PERFECT\n", n);
      }
   }
   printf("END OF OUTPUT\n");

   return 0;
}
