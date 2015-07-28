#include <stdio.h>

int main(int argc, char* argv[])
{
   int n, i, j, count;
   int prime_len;
   int prime[100000];
   char prime_table[1000000];

   for (i = 3; i < 1000000; i += 2) {
      prime_table[i] = 1;
   }

   for (i = 3; i * i < 1000000; i += 2) {
      for (j = 3; j * i < 1000000; j += 2) {
         prime_table[i * j] = 0;
      }
   }

   prime[0] = 2;
   prime_len = 1;
   for (i = 3; i < 1000000; i += 2) {
      if (prime_table[i]) prime[prime_len++] = i;
   }

   while (scanf("%d", &n) == 1 && n != 0) {
      printf("%d : ", n);
      count = 0;
      for (i = 0; i < prime_len; i++) {
         if (n < prime[i]) break;
         if (n % prime[i] == 0) {
            n /= prime[i];
            ++count;
         }
      }
      printf("%d\n", count);
   }
   return 0;
}
