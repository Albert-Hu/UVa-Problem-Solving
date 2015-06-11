#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

#define N         101
#define PRIME_LEN 25

static const char prime[PRIME_LEN] = {
    2,  3,  5,  7, 11,
   13, 17, 19, 23, 29,
   31, 37, 41, 43, 47,
   53, 59, 61, 67, 71,
   73, 79, 83, 89, 97
};

int main(int argc, char* argv[])
{
   int n, i, number;
   char table[N][PRIME_LEN];

   memset(table, 0, sizeof(table));

   for (n = 2; n < N; n++) {
      number = n;
      for (i = 0; i < PRIME_LEN; i++) {
         if (prime[i] > number) break;
         while ((number % prime[i]) == 0) {
            number /= prime[i];
            ++table[n][i];
         }
      }
      for (i = 0; i < PRIME_LEN; i++) {
         table[n][i] += table[n - 1][i];
      }
   }

   while (scanf("%d", &n) == 1 && n != 0) {
      printf("%3d! =", n);
      for (i = 0; i < PRIME_LEN; i++) {
         if (table[n][i] == 0) break;
         printf("%3d", table[n][i]);
         if ((i == 14) && table[n][15] != 0)
            printf("\n      ");
      }
      printf("\n");
   }

   return 0;
}
