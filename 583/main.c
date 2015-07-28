#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int n, i, j, x;
   int prime_len;
   int prime[46340];
   char is_prime[46340];

   memset(is_prime, 1, sizeof(is_prime));

   for (i = 3; i * i < 46340; i += 2) {
      for (j = 3; i * j < 46340; j += 2) {
         is_prime[i * j] = 0;
      }
   }

   prime[0] = 2;
   prime_len = 1;
   for (i = 3; i < 46340; i += 2) {
      if (is_prime[i]) prime[prime_len++] = i;
   }

   while (scanf("%d", &n) == 1 && n != 0) {
      printf("%d =", n);
      x = 0;
      if (n < 0) {
         x = 1;
         n = -n;
         printf(" -1");
      }
      for (i = 0; i < prime_len; i++) {
         if (n < prime[i]) break;
         while (n % prime[i] == 0) {
            if (x) {
               printf(" x %d", prime[i]);
            } else {
               printf(" %d", prime[i]);
               x = 1;
            }
            n /= prime[i];
         }
      }
      if (n > 1) {
         if (x) {
            printf(" x %d", n);
         } else {
            printf(" %d", n);
         }
      }
      printf("\n");
   }

   return 0;
}
