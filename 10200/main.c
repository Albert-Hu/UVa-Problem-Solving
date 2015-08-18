#include <stdio.h>

#define MAX 10002

int main(int argc, char* argv[])
{
   int i, j, n;
   int prime[MAX];
   int prime_len;
   char is_prime[MAX];
   float result;

   for (i = 0; i < MAX; i++)
      is_prime[i] = (i & 1);

   is_prime[2] = 1;

   for (i = 3; i * i < MAX; i += 2) {
      for (j = i; j * i < MAX; j += 2) {
         is_prime[j * i] = 0;
      }
   }

   prime[0] = 2;
   prime_len = 1;
   for (i = 3; i < MAX; i += 2) {
      if (is_prime[i]) {
         prime[prime_len++] = i;
      }
   }

   for (i = 0; i < MAX; i++) {
      n = i * i + i + 41;
      if (n < MAX) {
         is_prime[i] = is_prime[n];
      } else {
         for (j = 0; j < prime_len; j++) {
            if (n < prime[j] || n % prime[j] == 0)
               break;
         }
         is_prime[i] = (j == prime_len || n == prime[j]);
      }
   }

   prime[0] = 1;
   for (i = 1; i < MAX; i++) {
      prime[i] = prime[i - 1] + is_prime[i];
   }

   while (scanf("%d%d", &i, &j) == 2) {
      result = (((prime[j] - prime[i]) + is_prime[i]) * 100.0) / (((j - i) + 1.0));
      printf("%.2f\n", result + 0.000001);
   }

   return 0;
}
