#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, k;

   while (scanf("%d%d", &n, &k) == 2) {
      --k;
      if ((n % k) == 0) {
         n = n + ((n / k) - 1);
      } else {
         n = n + (n / k);
      }
      printf("%d\n", n);
   }

   return 0;
}
