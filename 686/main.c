#include <stdio.h>
#include <memory.h>

int main(int argc, char* argv[])
{
   int i, j, k, count;
   int prime[4000];
   int prime_len = 0;
   char prime_table[32768];

   for (i = 0; i < 32768; i++)
      prime_table[i] = (i % 2 != 0);

   for (i = 3; i * i < 32768; i += 2) {
      for (j = i, k = i * i; k < 32768; j += 2, k = i * j) {
         prime_table[k] = 0;
      }
   }

   prime_table[2] = 1;
   prime[prime_len++] = 2;
   for (i = 3; i < 32768; i += 2)
      if (prime_table[i]) prime[prime_len++] = i;

   while (scanf("%d", &k) == 1 && k != 0) {
      count = 0;
      for (i = 0; i < prime_len; i++) {
         if ((prime[i] * 2) > k) break;
         count += prime_table[(k - prime[i])];
      }
      printf("%d\n", count);
   }

   return 0;
}
